package easynvest.bruno.com.easynvesttest.modelo.screen;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Bruno on 03/03/2017.
 */

public class MoreInfo {

    @JsonProperty("month")
    private Month month;
    @JsonProperty("year")
    private Year year;
    @JsonProperty("12months")
    private TwelveMonths twelveMonths;

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public TwelveMonths getTwelveMonths() {
        return twelveMonths;
    }

    public void setTwelveMonths(TwelveMonths twelveMonths) {
        this.twelveMonths = twelveMonths;
    }
}
