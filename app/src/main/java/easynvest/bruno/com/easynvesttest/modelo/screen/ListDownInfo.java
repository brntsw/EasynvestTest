package easynvest.bruno.com.easynvesttest.modelo.screen;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Bruno on 03/03/2017.
 */

public class ListDownInfo {

    @JsonProperty("downInfo")
    private List<DownInfo> listDownInfo;

    public List<DownInfo> getListDownInfo() {
        return listDownInfo;
    }

    public void setListDownInfo(List<DownInfo> listDownInfo) {
        this.listDownInfo = listDownInfo;
    }
}
