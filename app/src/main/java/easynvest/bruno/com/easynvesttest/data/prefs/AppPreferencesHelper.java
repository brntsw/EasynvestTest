package easynvest.bruno.com.easynvesttest.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Bruno on 05/03/2017.
 */

public class AppPreferencesHelper implements PreferencesHelper {

    private static final String PREF_KEY_SUCESSO = "PREF_KEY_SUCESSO";

    private final SharedPreferences mPrefs;

    public AppPreferencesHelper(Context context){
        mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Override
    public boolean isSucessoCurrentPage() {
        return mPrefs.getBoolean(PREF_KEY_SUCESSO, false);
    }

    @Override
    public void setSucessoCurrentPage(boolean sucesso) {
        mPrefs.edit().putBoolean(PREF_KEY_SUCESSO, sucesso).apply();
    }
}
