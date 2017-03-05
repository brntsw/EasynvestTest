package easynvest.bruno.com.easynvesttest.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import easynvest.bruno.com.easynvesttest.R;
import easynvest.bruno.com.easynvesttest.data.prefs.AppPreferencesHelper;
import easynvest.bruno.com.easynvesttest.ui.activity.MainActivity;

/**
 * Created by Bruno on 05/03/2017.
 */

public class FragmentSucesso extends Fragment {

    @BindView(R.id.enviar_nova)
    TextView textNova;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_sucesso, container, false);

        ButterKnife.bind(this, rootView);

        textNova.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppPreferencesHelper helper = new AppPreferencesHelper(getActivity());
                helper.setSucessoCurrentPage(false);

                ((MainActivity)getActivity()).setSucessoPager();
            }
        });

        return rootView;
    }

}
