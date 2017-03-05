package easynvest.bruno.com.easynvesttest;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Bruno on 05/03/2017.
 */

public class App extends Application {

    public void onCreate(){
        super.onCreate();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                                .setDefaultFontPath("fonts/DINEngschriftStd.otf")
                                .setFontAttrId(R.attr.fontPath)
                                .build());
    }

}
