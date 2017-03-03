package easynvest.bruno.com.easynvesttest.modelo;

/**
 * Created by Bruno on 03/03/2017.
 */

public class Cell {

    private int id;
    private int type;
    private String message;
    private int typeField;
    private boolean hidden;
    private double topSpacing;
    private int show;
    private boolean required;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTypeField() {
        return typeField;
    }

    public void setTypeField(int typeField) {
        this.typeField = typeField;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public double getTopSpacing() {
        return topSpacing;
    }

    public void setTopSpacing(double topSpacing) {
        this.topSpacing = topSpacing;
    }

    public int getShow() {
        return show;
    }

    public void setShow(int show) {
        this.show = show;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }
}