package easynvest.bruno.com.easynvesttest.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import easynvest.bruno.com.easynvesttest.R;
import easynvest.bruno.com.easynvesttest.modelo.Cell;
import easynvest.bruno.com.easynvesttest.modelo.ListCell;
import easynvest.bruno.com.easynvesttest.ui.UIGeneratorContato;
import easynvest.bruno.com.easynvesttest.utils.AppConstants;

/**
 * Created by Bruno on 04/03/2017.
 */

public class FragmentContato extends Fragment {

    @BindView(R.id.root)
    LinearLayout linearLayout;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_contato, container, false);
        ButterKnife.bind(this, rootView);

        createLayout();

        return rootView;
    }

    void createLayout(){
        ObjectMapper mapper = new ObjectMapper();

        try {
            ListCell cells = mapper.readValue(getActivity().getAssets().open("cells.json"), ListCell.class);

            for(Cell cell : cells.getListCells()){
                if(cell.getType() == AppConstants.EDITTEXT_TYPE){
                    linearLayout.addView(UIGeneratorContato.getTextInputLayout(getActivity(), cell));
                }
            }

            for(Cell cell : cells.getListCells()){
                if(cell.getType() == AppConstants.IMAGEVIEW_TYPE){
                    linearLayout.addView(UIGeneratorContato.getImageView(getActivity(), cell));
                }
            }

            for(Cell cell : cells.getListCells()){
                if(cell.getType() == AppConstants.CHECKBOX_TYPE){
                    linearLayout.addView(UIGeneratorContato.getCheckBox(getActivity(), cell));
                }
            }

            for(Cell cell : cells.getListCells()){
                if(cell.getType() == AppConstants.BUTTON_TYPE){
                    linearLayout.addView(UIGeneratorContato.getButton(getActivity(), cell));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
