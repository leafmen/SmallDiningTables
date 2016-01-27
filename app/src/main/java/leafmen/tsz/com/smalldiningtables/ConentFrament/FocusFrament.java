package leafmen.tsz.com.smalldiningtables.ConentFrament;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

import leafmen.tsz.com.smalldiningtables.R;
import leafmen.tsz.com.smalldiningtables.Viewpager.FocusFragmentPager;
import leafmen.tsz.com.smalldiningtables.Viewpager.FocusFragmentPagerAdapter;

/**
 * Created by LiQiang on 2016/1/6.
 * 焦点
 */
public class FocusFrament extends Fragment implements View.OnClickListener {
    private ArrayList<Fragment> fragmentList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        initData();
        super.onCreate(savedInstanceState);
    }

    private void initData() {
        fragmentList = new ArrayList<Fragment>();

        FocusFragmentPager foucs_rb1_Fragment = new FocusFragmentPager();
        Bundle bundle_foucs_rb1 = new Bundle();
        bundle_foucs_rb1.putString("gourl", "foucs_rb1");
        foucs_rb1_Fragment.setArguments(bundle_foucs_rb1);
        fragmentList.add(foucs_rb1_Fragment);

        FocusFragmentPager foucs_rb2_Fragment = new FocusFragmentPager();
        Bundle bundle_foucs_rb2 = new Bundle();
        bundle_foucs_rb2.putString("gourl", "foucs_rb2");
        foucs_rb2_Fragment.setArguments(bundle_foucs_rb2);
        fragmentList.add(foucs_rb2_Fragment);

        FocusFragmentPager foucs_rb3_Fragment = new FocusFragmentPager();
        Bundle bundle_foucs_rb3 = new Bundle();
        bundle_foucs_rb3.putString("gourl", "foucs_rb3");
        foucs_rb3_Fragment.setArguments(bundle_foucs_rb3);
        fragmentList.add(foucs_rb3_Fragment);

        FocusFragmentPager foucs_rb4_Fragment = new FocusFragmentPager();
        Bundle bundle_foucs_rb4 = new Bundle();
        bundle_foucs_rb4.putString("gourl", "foucs_rb4");
        foucs_rb4_Fragment.setArguments(bundle_foucs_rb4);
        fragmentList.add(foucs_rb4_Fragment);

        FocusFragmentPager foucs_rb5_Fragment = new FocusFragmentPager();
        Bundle bundle_foucs_rb5 = new Bundle();
        bundle_foucs_rb5.putString("gourl", "foucs_rb5");
        foucs_rb5_Fragment.setArguments(bundle_foucs_rb5);
        fragmentList.add(foucs_rb5_Fragment);

        FocusFragmentPager foucs_rb6_Fragment = new FocusFragmentPager();
        Bundle bundle_foucs_rb6 = new Bundle();
        bundle_foucs_rb6.putString("gourl", "foucs_rb6");
        foucs_rb6_Fragment.setArguments(bundle_foucs_rb6);
        fragmentList.add(foucs_rb6_Fragment);

        FocusFragmentPager foucs_rb7_Fragment = new FocusFragmentPager();
        Bundle bundle_foucs_rb7 = new Bundle();
        bundle_foucs_rb7.putString("gourl", "foucs_rb7");
        foucs_rb5_Fragment.setArguments(bundle_foucs_rb7);
        fragmentList.add(foucs_rb7_Fragment);
    }

    private View focusview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (focusview == null) {
            focusview = initView(inflater);
        }

        return focusview;
    }

    private ImageButton btn_right;
    private RadioGroup focus_radiogroup;
    private ViewPager foucs_viewpager;
    private View winpop;

    private View initView(LayoutInflater inflater) {
        final View view = inflater.inflate(R.layout.fragment_focus_main, null, false);
        //加载winpop
        winpop = View.inflate(getActivity(), R.layout.winpop_view, null);

        btn_right = (ImageButton) view.findViewById(R.id.btn_right);
        btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow(v);
            }
        });

        FocusFragmentPagerAdapter myPagerAdapter = new FocusFragmentPagerAdapter(getFragmentManager(), fragmentList);
        foucs_viewpager = (ViewPager) view.findViewById(R.id.foucs_viewpager);
        foucs_viewpager.setAdapter(myPagerAdapter);
        foucs_viewpager.setCurrentItem(0);

        focus_radiogroup = (RadioGroup) view.findViewById(R.id.focus_radiogroup);
        focus_radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //选中的RadioButton播放动画
                ScaleAnimation sAnim = new ScaleAnimation(1, 1.1f, 1, 1.1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                sAnim.setDuration(500);
                sAnim.setFillAfter(true);
                //遍历所有的RadioButton
                for (int i = 0; i < group.getChildCount(); i++) {
                    RadioButton radioBtn = (RadioButton) group.getChildAt(i);
                    if (radioBtn.isChecked()) {
                        radioBtn.startAnimation(sAnim);
                    } else {
                        radioBtn.clearAnimation();
                    }
                }

                switch (checkedId) {
                    case R.id.foucs_rb1:
                        foucs_viewpager.setCurrentItem(0);
                        break;
                    case R.id.foucs_rb2:
                        foucs_viewpager.setCurrentItem(1);
                        break;
                    case R.id.foucs_rb3:
                        foucs_viewpager.setCurrentItem(2);
                        break;
                    case R.id.foucs_rb4:
                        foucs_viewpager.setCurrentItem(3);
                        break;
                    case R.id.foucs_rb5:
                        foucs_viewpager.setCurrentItem(4);
                        break;
                    default:
                        foucs_viewpager.setCurrentItem(0);
                        break;
                }

            }
        });

        return view;
    }

    PopupWindow popupWindow;

    private void showPopupWindow(View view) {
        if (getActivity() != null) {
            int width = getActivity().getWindowManager().getDefaultDisplay().getWidth();
            int height = getActivity().getWindowManager().getDefaultDisplay().getHeight();
            popupWindow = new PopupWindow(width, height - 150);
            popupWindow.setAnimationStyle(R.style.AnimationFade);
            popupWindow.setContentView(winpop);
            //点击空白区关闭窗口
            popupWindow.setFocusable(true);
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
            popupWindow.showAsDropDown(view, 0, 0);
        }
    }

    @Override
    public void onClick(View v) {

    }
}
