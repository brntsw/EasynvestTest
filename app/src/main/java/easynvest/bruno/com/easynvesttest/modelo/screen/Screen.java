package easynvest.bruno.com.easynvesttest.modelo.screen;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Bruno on 03/03/2017.
 */

public class Screen {

    @JsonProperty("title")
    private String title;
    @JsonProperty("fundName")
    private String fundName;
    @JsonProperty("whatIs")
    private String whatIs;
    @JsonProperty("definition")
    private String definition;
    @JsonProperty("graph")
    private Graph graph;
    @JsonProperty("riskTitle")
    private String riskTitle;
    @JsonProperty("risk")
    private int risk;
    @JsonProperty("infoTitle")
    private String infoTitle;
    @JsonProperty("moreInfo")
    private MoreInfo moreInfo;
    @JsonProperty("info")
    private List<Info> listInfo;
    @JsonProperty("downInfo")
    private List<DownInfo> downInfoList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getWhatIs() {
        return whatIs;
    }

    public void setWhatIs(String whatIs) {
        this.whatIs = whatIs;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getRiskTitle() {
        return riskTitle;
    }

    public void setRiskTitle(String riskTitle) {
        this.riskTitle = riskTitle;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public int getRisk() {
        return risk;
    }

    public void setRisk(int risk) {
        this.risk = risk;
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }

    public MoreInfo getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(MoreInfo moreInfo) {
        this.moreInfo = moreInfo;
    }

    public List<Info> getListInfo() {
        return listInfo;
    }

    public void setListInfo(List<Info> listInfo) {
        this.listInfo = listInfo;
    }

    public List<DownInfo> getDownInfoList() {
        return downInfoList;
    }

    public void setDownInfoList(List<DownInfo> downInfoList) {
        this.downInfoList = downInfoList;
    }
}
