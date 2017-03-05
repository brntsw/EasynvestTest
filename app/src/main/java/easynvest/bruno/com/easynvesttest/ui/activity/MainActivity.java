package easynvest.bruno.com.easynvesttest.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import easynvest.bruno.com.easynvesttest.R;
import easynvest.bruno.com.easynvesttest.ui.adapter.TabsPagerAdapter;
import easynvest.bruno.com.easynvesttest.utils.AppConstants;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.sliding_tabs)
    TabLayout tabLayout;

    @BindView(R.id.pager)
    ViewPager viewPager;

    TabsPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mAdapter = new TabsPagerAdapter(this, getSupportFragmentManager());

        viewPager.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void setSucessoPager(){
        onResume();

        mAdapter = new TabsPagerAdapter(this, getSupportFragmentManager());

        viewPager.setAdapter(null);
        viewPager.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(AppConstants.TAB_CONTATO);
    }

    protected void attachBaseContext(Context newBase){
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
