package easynvest.bruno.com.easynvesttest.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.text.util.Linkify;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

import easynvest.bruno.com.easynvesttest.R;
import easynvest.bruno.com.easynvesttest.modelo.screen.DownInfo;
import easynvest.bruno.com.easynvesttest.modelo.screen.Info;

/**
 * Created by Bruno on 05/03/2017.
 */

public class UIGeneratorInvestimento {

    public static void createGraph(LineChart lineChart, List<Double> cdiPoints, List<Double> fundPoints, List<String> xPoints){
        ArrayList<Entry> entriesCdi = new ArrayList<>();

        entriesCdi.add(new Entry());

        for(int i = 0; i < cdiPoints.size(); i++){
            entriesCdi.add(new Entry(i, Float.valueOf(String.valueOf(cdiPoints.get(i)))));
        }

        ArrayList<Entry> entriesFund = new ArrayList<>();

        for(int i = 0; i < fundPoints.size(); i++){
            entriesFund.add(new Entry(i, Float.valueOf(String.valueOf(fundPoints.get(i)))));
        }

        LineDataSet dataSetCdi = new LineDataSet(entriesCdi, "CDI");
        dataSetCdi.setColor(R.color.colorPrimary);
        dataSetCdi.setFillColor(R.color.colorPrimary);
        LineDataSet dataSetFund = new LineDataSet(entriesFund, "Fund");
        dataSetFund.setColor(R.color.black);
        dataSetFund.setFillColor(R.color.black);

        ArrayList<String> labels = new ArrayList<>();

        for(String x : xPoints){
            labels.add(x);
        }

        LineData data = new LineData(dataSetCdi, dataSetFund);

        lineChart.setData(data);
        lineChart.animateY(5000);
    }

    public static void setGrauRisco(LinearLayout linearGrausRisco, int risk){
        View view = linearGrausRisco.getChildAt(risk - 1);
        view.getLayoutParams().height = 60;
    }

    public static void createInfoLayout(Context context, LinearLayout linearInfo, List<Info> infos, List<DownInfo> downInfos){
        LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        RelativeLayout.LayoutParams relativeParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        relativeParams.setMargins(0, 0, 0, 20);

        RelativeLayout.LayoutParams textNameParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textNameParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        RelativeLayout.LayoutParams textDataParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textDataParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        Typeface face = Typeface.createFromAsset(context.getAssets(), "fonts/DINEngschriftStd.otf");

        for(Info info : infos){
            RelativeLayout relativeLayout = new RelativeLayout(context);
            relativeLayout.setLayoutParams(relativeParams);

            TextView textViewName = new TextView(context);
            textViewName.setTypeface(face);
            textViewName.setTextColor(ContextCompat.getColor(context, R.color.text_investimento));
            textViewName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            textViewName.setLayoutParams(textNameParams);
            textViewName.setText(info.getName());

            relativeLayout.addView(textViewName);

            textDataParams.addRule(RelativeLayout.RIGHT_OF, textViewName.getId());
            TextView textViewData = new TextView(context);
            textViewData.setTypeface(face);
            textViewData.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            textViewData.setLayoutParams(textDataParams);
            textViewData.setText(info.getData());
            textViewData.setGravity(Gravity.END);

            relativeLayout.addView(textViewData);

            linearInfo.addView(relativeLayout);
        }

        RelativeLayout.LayoutParams textNameDownParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textNameParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        RelativeLayout.LayoutParams textDataDownParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textDataParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        for(DownInfo downInfo : downInfos){
            RelativeLayout relativeLayout = new RelativeLayout(context);
            relativeLayout.setLayoutParams(relativeParams);

            TextView textViewName = new TextView(context);
            textViewName.setTypeface(face);
            textViewName.setTextColor(ContextCompat.getColor(context, R.color.text_investimento));
            textViewName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            textViewName.setLayoutParams(textNameDownParams);
            textViewName.setText(downInfo.getName());

            relativeLayout.addView(textViewName);

            TextView textViewData = new TextView(context);
            textViewData.setTypeface(face);
            textViewData.setTextColor(ContextCompat.getColor(context, R.color.link));
            textViewData.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            textViewData.setLayoutParams(textDataDownParams);
            textViewData.setText("Baixar");
            textViewData.setGravity(Gravity.END);
            Linkify.addLinks(textViewData, Linkify.WEB_URLS);
            textViewData.setLinksClickable(true);
            textViewData.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.download, 0);

            relativeLayout.addView(textViewData);

            linearInfo.addView(relativeLayout);
        }
    }

}
