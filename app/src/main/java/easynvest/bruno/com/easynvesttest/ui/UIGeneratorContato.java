package easynvest.bruno.com.easynvesttest.ui;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import easynvest.bruno.com.easynvesttest.R;
import easynvest.bruno.com.easynvesttest.modelo.Cell;

/**
 * Created by Bruno on 04/03/2017.
 */

public class UIGeneratorContato {



    public static TextInputLayout getTextInputLayout(Context context, Cell cell){
        LinearLayout.LayoutParams editParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        editParams.setMargins(0, (int)cell.getTopSpacing(), 0, 0);
        EditText editText = new EditText(context);
        editText.setId(cell.getId());
        if(cell.getTypeField().equals("telnumber")){
            editText.setInputType(InputType.TYPE_CLASS_PHONE);
        }
        else{
            editText.setInputType(Integer.parseInt(cell.getTypeField()));
        }
        editText.setTextColor(ContextCompat.getColor(context, R.color.black));
        editText.setHint(cell.getMessage());
        editText.setLayoutParams(editParams);
        if(cell.isHidden()){
            editText.setVisibility(View.GONE);
        }
        else{
            editText.setVisibility(View.VISIBLE);
        }

        LinearLayout.LayoutParams inputParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        TextInputLayout textInputLayout = new TextInputLayout(context);
        textInputLayout.setLayoutParams(inputParams);
        textInputLayout.addView(editText);

        return textInputLayout;
    }

    public static CheckBox getCheckBox(Context context, Cell cell){
        LinearLayout.LayoutParams checkBoxParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        checkBoxParams.setMargins(0, (int)cell.getTopSpacing(), 0, 0);
        CheckBox checkBox = new CheckBox(context);
        checkBox.setId(cell.getId());
        checkBox.setLayoutParams(checkBoxParams);
        checkBox.setText(cell.getMessage());
        checkBox.setTextColor(ContextCompat.getColor(context, R.color.text_color_hint));
        if(cell.isHidden()){
            checkBox.setVisibility(View.GONE);
        }
        else{
            checkBox.setVisibility(View.VISIBLE);
        }

        return checkBox;
    }

    public static ImageView getImageView(Context context, Cell cell){
        LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        imageParams.setMargins(0, (int)cell.getTopSpacing(), 0, 0);
        ImageView imageView = new ImageView(context);
        imageView.setBackground(ContextCompat.getDrawable(context, R.drawable.naodisponivel));
        imageView.setLayoutParams(imageParams);

        return imageView;
    }

    public static Button getButton(Context context, Cell cell){
        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        buttonParams.setMargins(0, (int)cell.getTopSpacing(), 0, 0);
        Button button = new Button(context);
        button.setId(cell.getId());
        button.setLayoutParams(buttonParams);
        button.setBackground(ContextCompat.getDrawable(context, R.drawable.button_selector));
        button.setText(cell.getMessage());
        button.setTextColor(ContextCompat.getColor(context, R.color.white));
        if(cell.isHidden()){
            button.setVisibility(View.GONE);
        }
        else{
            button.setVisibility(View.VISIBLE);
        }

        return button;
    }

}
