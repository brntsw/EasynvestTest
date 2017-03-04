package easynvest.bruno.com.easynvesttest.modelo.screen;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Bruno on 04/03/2017.
 */

public class ScreenMapper {

    @JsonProperty("screen")
    private Screen screen;

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }
}
