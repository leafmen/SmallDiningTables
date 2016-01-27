package leafmen.tsz.com.smalldiningtables.Activitys;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import leafmen.tsz.com.smalldiningtables.ConentFrament.DeliciousFoodFrament;
import leafmen.tsz.com.smalldiningtables.ConentFrament.FocusFrament;
import leafmen.tsz.com.smalldiningtables.ConentFrament.SchoolChoiceFrament;
import leafmen.tsz.com.smalldiningtables.ConentFrament.TopFrament;
import leafmen.tsz.com.smalldiningtables.R;
import leafmen.tsz.com.smalldiningtables.Utils.CommonUtil;
import leafmen.tsz.com.smalldiningtables.Viewpager.ContentViewPager;


public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private ContentViewPager contentViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkNetState();
        initData();
        initView();
    }

    private List<Fragment> content_list = null;

    private void initData() {
        content_list = new ArrayList<>();
        content_list.add(new TopFrament());
        content_list.add(new FocusFrament());
        content_list.add(new SchoolChoiceFrament());
        content_list.add(new DeliciousFoodFrament());
    }

    private void initView() {
        contentViewPager = (ContentViewPager) findViewById(R.id.content_viewpager);
        contentViewPager.setOffscreenPageLimit(3);
        contentViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return content_list.get(i);
            }

            @Override
            public int getCount() {
                return content_list.size();
            }
        });
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(new rdOnCheckedChangeListener());
        
    }

    protected class rdOnCheckedChangeListener implements OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rb_focus:
                    contentViewPager.setCurrentItem(0);
                    break;
                case R.id.rb_classroom:
                    contentViewPager.setCurrentItem(1);
                    break;
                case R.id.rb_schoolchoice:
                    contentViewPager.setCurrentItem(2);
                    break;
                case R.id.rb_deliciousfood:
                    contentViewPager.setCurrentItem(3);
                    break;
                case R.id.rb_setting:
                    contentViewPager.setCurrentItem(4);
                    break;
                default:
                    contentViewPager.setCurrentItem(0);
                    break;
            }
        }
    }

    /**
     * 检查网络是否连接
     */
    private void checkNetState() {
        if (!CommonUtil.isNetWork(this)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("网络状态提醒");
            builder.setMessage("当前网络不可用，是否打开网络设置?");
            builder.setNeutralButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (android.os.Build.VERSION.SDK_INT > 10) {
                        startActivity(new Intent(android.provider.Settings.ACTION_SETTINGS));
                    } else {
                        startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
                    }
                }
            });
            builder.create().show();
        }
    }


    private long timeMillis;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - timeMillis) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次将退出程序", Toast.LENGTH_SHORT).show();
                timeMillis = System.currentTimeMillis();
            } else {
                SharedPreferences lzs = getSharedPreferences("lzs", MODE_PRIVATE);
                SharedPreferences.Editor editor = lzs.edit();
                editor.remove("isFrist");
                editor.commit();
                finish();
                System.exit(0);
            }
            return true;

        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        System.out.println("onDestroy()");
        super.onDestroy();

    }
}
