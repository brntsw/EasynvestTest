package easynvest.bruno.com.easynvesttest.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import easynvest.bruno.com.easynvesttest.R;
import easynvest.bruno.com.easynvesttest.data.prefs.AppPreferencesHelper;
import easynvest.bruno.com.easynvesttest.modelo.Cell;
import easynvest.bruno.com.easynvesttest.modelo.ListCell;
import easynvest.bruno.com.easynvesttest.ui.UIGeneratorContato;
import easynvest.bruno.com.easynvesttest.ui.activity.MainActivity;
import easynvest.bruno.com.easynvesttest.ui.base.BaseFragment;
import easynvest.bruno.com.easynvesttest.utils.AppConstants;
import easynvest.bruno.com.easynvesttest.utils.UIValidationUtils;

/**
 * Created by Bruno on 04/03/2017.
 */

public class FragmentContato extends BaseFragment {

    @BindView(R.id.coordinator_layout)
    CoordinatorLayout coordinatorLayout;

    @BindView(R.id.root)
    LinearLayout linearLayout;

    List<EditText> editTexts;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_contato, container, false);
        editTexts = new ArrayList<>();

        setUnBinder(ButterKnife.bind(this, rootView));

        createLayout();

        return rootView;
    }


    @Override
    protected void createLayout() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            ListCell cells = mapper.readValue(getActivity().getAssets().open("cells.json"), ListCell.class);

            for(Cell cell : cells.getListCells()){
                if(cell.getType() == AppConstants.TEXTVIEW_TYPE){
                    linearLayout.addView(UIGeneratorContato.getTextView(getActivity(), cell));
                }
            }

            for(Cell cell : cells.getListCells()){
                if(cell.getType() == AppConstants.EDITTEXT_TYPE){
                    TextInputLayout textInputLayout = UIGeneratorContato.getTextInputLayout(getActivity(), cell);
                    final EditText editText = (EditText) ((FrameLayout)textInputLayout.getChildAt(0)).getChildAt(0);

                    editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                        @Override
                        public void onFocusChange(View v, boolean hasFocus) {
                            if(!hasFocus){
                                UIValidationUtils.validateSingleEditText(getActivity(), editText);
                            }
                        }
                    });

                    editTexts.add(editText);
                    linearLayout.addView(textInputLayout);
                }
            }

            for(Cell cell : cells.getListCells()){
                if(cell.getType() == AppConstants.IMAGEVIEW_TYPE){
                    linearLayout.addView(UIGeneratorContato.getImageView(getActivity(), cell));
                }
            }

            for(Cell cell : cells.getListCells()){
                if(cell.getType() == AppConstants.CHECKBOX_TYPE){
                    final AppCompatCheckBox checkBox = UIGeneratorContato.getCheckBox(getActivity(), cell);

                    checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            EditText editText = (EditText) linearLayout.findViewById((int)checkBox.getTag());
                            FrameLayout frameLayout = (FrameLayout) editText.getParent();
                            TextInputLayout til = (TextInputLayout) frameLayout.getParent();

                            if(isChecked){
                                editText.setVisibility(View.VISIBLE);
                                frameLayout.setVisibility(View.VISIBLE);
                                til.setVisibility(View.VISIBLE);
                            }
                            else{
                                editText.setVisibility(View.GONE);
                                frameLayout.setVisibility(View.GONE);
                                til.setVisibility(View.GONE);
                            }
                        }
                    });

                    linearLayout.addView(checkBox);
                }
            }

            for(Cell cell : cells.getListCells()){
                if(cell.getType() == AppConstants.BUTTON_TYPE){
                    Button button = UIGeneratorContato.getButton(getActivity(), cell);

                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(UIValidationUtils.validateEditTexts(getActivity(), coordinatorLayout, editTexts)){
                                AppPreferencesHelper helper = new AppPreferencesHelper(getActivity());
                                helper.setSucessoCurrentPage(true);

                                ((MainActivity)getActivity()).setSucessoPager();

                            }
                        }
                    });

                    linearLayout.addView(button);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
