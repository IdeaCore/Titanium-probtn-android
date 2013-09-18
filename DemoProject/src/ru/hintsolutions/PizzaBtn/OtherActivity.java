package ru.hintsolutions.PizzaBtn;

import android.app.Activity;
import android.os.Bundle;
import ru.hintsolutions.PizzaButton.PizzaBtn;

/**
 * Created with IntelliJ IDEA.
 * User: enginegl
 * Date: 21.08.13
 */
public class OtherActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other);
        // Callback for devices with Android API level lower than 11
        if (android.os.Build.VERSION.SDK_INT < 11) {
            PizzaBtn.onActivityCreated();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Callback for devices with Android API level lower than 11
        if (android.os.Build.VERSION.SDK_INT < 11) {
            PizzaBtn.onActivityResumed(this);
        }
    }

    @Override
    protected void onPause() {
        // Callback for devices with Android API level lower than 11
        if (android.os.Build.VERSION.SDK_INT < 11) {
            PizzaBtn.onActivityPaused();
        }
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        // Callback for devices with Android API level lower than 11
        if (android.os.Build.VERSION.SDK_INT < 11) {
            PizzaBtn.onActivityDestroyed(this);
        }
        super.onDestroy();
    }
}