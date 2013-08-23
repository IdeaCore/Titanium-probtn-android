package ru.hintsolutions.PizzaBtn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import ru.hintsolutions.PizzaButton.PizzaBtn;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        (findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, OtherActivity.class));
            }
        });
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
        PizzaBtn.activate(MainActivity.this);
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
