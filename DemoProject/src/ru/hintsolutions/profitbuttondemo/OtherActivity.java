package ru.hintsolutions.profitbuttondemo;

import android.app.Activity;
import android.os.Bundle;
import ru.hintsolutions.ProBtn.ProBtn;

/**
 * Created with IntelliJ IDEA.
 * User: enginegl
 * Date: 21.08.13
 */
public class OtherActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (android.os.Build.VERSION.SDK_INT < 14) {
            ProBtn.onActivityPaused(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (android.os.Build.VERSION.SDK_INT < 14) {
            ProBtn.onActivityResumed(this);
        }
    }
}