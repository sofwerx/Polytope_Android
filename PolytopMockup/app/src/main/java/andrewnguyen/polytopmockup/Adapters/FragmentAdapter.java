package andrewnguyen.polytopmockup.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class FragmentAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> mFragmentList = new ArrayList<>();
    private ArrayList<String> mFragmentListTitles = new ArrayList<>();

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment, String title){
        mFragmentList.add(fragment);
        mFragmentListTitles.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // return mFragmentListTitles.get(position);
        return null;
    }
}
