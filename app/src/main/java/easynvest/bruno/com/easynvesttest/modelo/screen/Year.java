package easynvest.bruno.com.easynvesttest.modelo.screen;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Bruno on 03/03/2017.
 */

public class Year {

    @JsonProperty("fund")
    private double fund;
    @JsonProperty("CDI")
    private double cdi;

    public double getFund() {
        return fund;
    }

    public void setFund(double fund) {
        this.fund = fund;
    }

    public double getCdi() {
        return cdi;
    }

    public void setCdi(double cdi) {
        this.cdi = cdi;
    }
}
