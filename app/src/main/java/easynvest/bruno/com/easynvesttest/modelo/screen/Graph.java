package easynvest.bruno.com.easynvesttest.modelo.screen;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Bruno on 03/03/2017.
 */

public class Graph {

    @JsonProperty("CDI")
    private List<Double> cdiPoints;
    @JsonProperty("fund")
    private List<Double> fundPoints;
    @JsonProperty("x")
    private List<String> xPoints;

    public List<Double> getCdiPoints() {
        return cdiPoints;
    }

    public void setCdiPoints(List<Double> cdiPoints) {
        this.cdiPoints = cdiPoints;
    }

    public List<Double> getFundPoints() {
        return fundPoints;
    }

    public void setFundPoints(List<Double> fundPoints) {
        this.fundPoints = fundPoints;
    }

    public List<String> getxPoints() {
        return xPoints;
    }

    public void setxPoints(List<String> xPoints) {
        this.xPoints = xPoints;
    }
}
