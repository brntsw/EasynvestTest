package easynvest.bruno.com.easynvesttest.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Bruno on 03/03/2017.
 */

public class ListCell {

    @JsonProperty("cells")
    private List<Cell> listCells;

    public List<Cell> getListCells() {
        return listCells;
    }

    public void setListCells(List<Cell> listCells) {
        this.listCells = listCells;
    }
}
