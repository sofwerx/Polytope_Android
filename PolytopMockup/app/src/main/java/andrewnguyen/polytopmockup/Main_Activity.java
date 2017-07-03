package andrewnguyen.polytopmockup;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import andrewnguyen.polytopmockup.Adapters.FragmentAdapter;
import andrewnguyen.polytopmockup.Tab_Fragments.TabFragmentOne;
import andrewnguyen.polytopmockup.Tab_Fragments.TabFragmentTwo;

public class Main_Activity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private int[] tabIcons = {R.drawable.my_icon, R.drawable.my_icon2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewpager_setup();
    }
    private void viewpager_setup(){
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
    }
    private void setupViewPager(ViewPager viewPager) {
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        adapter.addFragment(TabFragmentOne.newInstance("Frag: Fragment 1"), "Frag 1 Created");
        adapter.addFragment(TabFragmentTwo.newInstance("Frag: Fragment 2"), "Frag 2 Created");
        viewPager.setAdapter(adapter);
    }
    @Override
    public void onBackPressed() {
    }

    public void addNewDevice(View view){
        Intent i = new Intent(this, New_Device.class);
        startActivity(i);
        finish();
    }
}
