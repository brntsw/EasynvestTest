package easynvest.bruno.com.easynvesttest.ui.base;

import android.support.v4.app.Fragment;

import butterknife.Unbinder;

/**
 * Created by Bruno on 05/03/2017.
 */

public abstract class BaseFragment extends Fragment {

    private Unbinder mUnBinder;

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    @Override
    public void onDestroy() {
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }

    protected abstract void createLayout();

}
