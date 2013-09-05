package ru.hintsolutions.PizzaBtn;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import ru.hintsolutions.PizzaButton.PizzaBtn;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        (findViewById(R.id.showButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Show Pizza Button programmatically
                PizzaBtn.showPizzaBtn(MainActivity.this);
            }
        });
        (findViewById(R.id.hideButon)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Hide Pizza Button programmatically
                PizzaBtn.hidePizzaBtn();
            }
        });
        // Activate Pizza Button
        PizzaBtn.open(MainActivity.this);
        // Callback for devices with Android API level lower than 11
        if (android.os.Build.VERSION.SDK_INT < 11) {
            PizzaBtn.onActivityCreated();
        }
        (findViewById(R.id.goButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PizzaBtn.setNewUrl(((EditText)findViewById(R.id.editText)).getText().toString());
                hideSoftKeyboard(MainActivity.this);
            }
        });
    }

    public static void hideSoftKeyboard(Activity activity)
    {
        if(activity != null) {
            InputMethodManager inputManager = (InputMethodManager)
                    activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            if(inputManager != null) {
                if(activity.getCurrentFocus() != null) {
                    if(activity.getCurrentFocus().getWindowToken() != null) {
                        inputManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(),
                                InputMethodManager.HIDE_NOT_ALWAYS);
                    }
                }
            }
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
