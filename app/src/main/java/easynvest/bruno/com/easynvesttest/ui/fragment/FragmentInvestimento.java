package easynvest.bruno.com.easynvesttest.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mikephil.charting.charts.LineChart;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import easynvest.bruno.com.easynvesttest.R;
import easynvest.bruno.com.easynvesttest.modelo.screen.ScreenMapper;
import easynvest.bruno.com.easynvesttest.ui.UIGeneratorInvestimento;
import easynvest.bruno.com.easynvesttest.ui.base.BaseFragment;

/**
 * Created by Bruno on 04/03/2017.
 */

public class FragmentInvestimento extends BaseFragment {

    @BindView(R.id.root)
    LinearLayout root;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.tv_fund_name)
    TextView tvFundName;

    @BindView(R.id.tv_what_is)
    TextView tvWhatIs;

    @BindView(R.id.tv_definition)
    TextView tvDefinition;

    @BindView(R.id.chart)
    LineChart lineChart;

    @BindView(R.id.tv_risk_title)
    TextView tvRiskTitle;

    @BindView(R.id.tv_info_title)
    TextView tvInfoTitle;

    @BindView(R.id.tv_month_fund)
    TextView tvMonthFund;

    @BindView(R.id.tv_month_cdi)
    TextView tvMonthCdi;

    @BindView(R.id.tv_year_fund)
    TextView tvYearFund;

    @BindView(R.id.tv_year_cdi)
    TextView tvYearCdi;

    @BindView(R.id.tv_twelve_months_fund)
    TextView tvTwelveMonthsFund;

    @BindView(R.id.tv_twelve_months_cdi)
    TextView tvTwelveMonthsCdi;

    @BindView(R.id.info)
    LinearLayout linearInfo;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_investimento, container, false);

        setUnBinder(ButterKnife.bind(this, rootView));
        createLayout();

        return rootView;
    }

    @Override
    protected void createLayout() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            ScreenMapper screen = mapper.readValue(getActivity().getAssets().open("fund.json"), ScreenMapper.class);

            tvTitle.setText(screen.getScreen().getTitle());
            tvFundName.setText(screen.getScreen().getFundName());
            tvWhatIs.setText(screen.getScreen().getWhatIs());
            tvDefinition.setText(screen.getScreen().getDefinition());

            //Graph
            List<Double> cdiPoints = screen.getScreen().getGraph().getCdiPoints();
            List<Double> fundPoints = screen.getScreen().getGraph().getCdiPoints();
            List<String> xPoints = screen.getScreen().getGraph().getxPoints();

            UIGeneratorInvestimento.createGraph(lineChart, cdiPoints, fundPoints, xPoints);

            tvRiskTitle.setText(screen.getScreen().getRiskTitle());

            //View com os graus de risco

            tvInfoTitle.setText(screen.getScreen().getInfoTitle());
            tvMonthFund.setText(screen.getScreen().getMoreInfo().getMonth().getFund() + "%");
            tvMonthCdi.setText(screen.getScreen().getMoreInfo().getMonth().getCdi() + "%");
            tvYearFund.setText(screen.getScreen().getMoreInfo().getYear().getFund() + "%");
            tvYearCdi.setText(screen.getScreen().getMoreInfo().getYear().getCdi() + "%");
            tvTwelveMonthsFund.setText(screen.getScreen().getMoreInfo().getTwelveMonths().getFund() + "%");
            tvTwelveMonthsCdi.setText(screen.getScreen().getMoreInfo().getTwelveMonths().getCdi() + "%");

            UIGeneratorInvestimento.createInfoLayout(getActivity(), linearInfo, screen.getScreen().getListInfo(), screen.getScreen().getDownInfoList());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
