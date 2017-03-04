package easynvest.bruno.com.easynvesttest.modelo.screen;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Bruno on 03/03/2017.
 */

public class ListInfo {

    @JsonProperty("info")
    private List<Info> listInfo;

    public List<Info> getListInfo() {
        return listInfo;
    }

    public void setListInfo(List<Info> listInfo) {
        this.listInfo = listInfo;
    }
}
