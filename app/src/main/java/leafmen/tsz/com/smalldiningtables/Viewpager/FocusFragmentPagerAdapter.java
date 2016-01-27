package leafmen.tsz.com.smalldiningtables.Viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by LiQiang on 2016/1/13.
 */
public class FocusFragmentPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragmentLists;

    public FocusFragmentPagerAdapter(FragmentManager fm,ArrayList<Fragment> fragmentList) {
        super(fm);
        this.fragmentLists = fragmentList;
    }

    public FocusFragmentPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragmentLists.get(position);
    }

    @Override
    public int getCount() {
        return this.fragmentLists.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }
}
