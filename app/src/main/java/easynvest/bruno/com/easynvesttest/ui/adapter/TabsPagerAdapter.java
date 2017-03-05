package easynvest.bruno.com.easynvesttest.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import easynvest.bruno.com.easynvesttest.data.prefs.AppPreferencesHelper;
import easynvest.bruno.com.easynvesttest.ui.fragment.FragmentContato;
import easynvest.bruno.com.easynvesttest.ui.fragment.FragmentInvestimento;
import easynvest.bruno.com.easynvesttest.ui.fragment.FragmentSucesso;
import easynvest.bruno.com.easynvesttest.utils.AppConstants;

/**
 * Created by Bruno on 04/03/2017.
 */

public class TabsPagerAdapter extends FragmentPagerAdapter {
    private final int TAB_COUNT = 2;
    private String tabTitles[] = new String[]{"Investimento", "Contato"};
    private Context context;

    public TabsPagerAdapter(Context context, FragmentManager fm){
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case AppConstants.TAB_INVESTIMENTO:
                return new FragmentInvestimento();
            case AppConstants.TAB_CONTATO:
                AppPreferencesHelper helper = new AppPreferencesHelper(context);
                if(helper.isSucessoCurrentPage()){
                    return new FragmentSucesso();
                }
                else{
                    return new FragmentContato();
                }
        }

        return null;
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
