package appraise.dragon.com.appraise;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private AppraisalListFragment appraisalListFragment;
    private VehiclesListFragment vehiclesListFragment;
    private VhcListFragment vhcListFragment;
    private MoreFragment moreFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);

        appraisalListFragment = new AppraisalListFragment();
        vehiclesListFragment = new VehiclesListFragment();
        vhcListFragment = new VhcListFragment();
        moreFragment = new MoreFragment();

        setFragment(appraisalListFragment);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_appraisals:
                        setFragment(appraisalListFragment);
                        return true;

                    case R.id.nav_vehicles:
                        setFragment(vehiclesListFragment);
                        return true;

                    case R.id.nav_vhc:
                        setFragment(vhcListFragment);
                        return true;

                    case R.id.nav_more:
                        setFragment(moreFragment);
                        return true;

                        default:
                            return true;

                }
            }

        });
    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();

    }
}
