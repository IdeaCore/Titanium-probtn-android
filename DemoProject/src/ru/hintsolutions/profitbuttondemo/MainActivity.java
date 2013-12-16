package ru.hintsolutions.profitbuttondemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import ru.hintsolutions.ProBtn.ProBtn;

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
                // Show ProButton programmatically
                ProBtn.show(MainActivity.this);
            }
        });
        (findViewById(R.id.hideButon)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Hide ProButton programmatically
                ProBtn.hide();
            }
        });
        // Activate ProButton
        ProBtn.open(MainActivity.this);
        // Callback for devices with Android API level lower than 11
        if (android.os.Build.VERSION.SDK_INT < 11) {
            ProBtn.onActivityCreated();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Callback for devices with Android API level lower than 11
        if (android.os.Build.VERSION.SDK_INT < 11) {
            ProBtn.onActivityResumed(this);
        }
    }

    @Override
    protected void onPause() {
        // Callback for devices with Android API level lower than 11
        if (android.os.Build.VERSION.SDK_INT < 11) {
            ProBtn.onActivityPaused();
        }
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        // Callback for devices with Android API level lower than 11
        if (android.os.Build.VERSION.SDK_INT < 11) {
            ProBtn.onActivityDestroyed(this);
        }
        super.onDestroy();
    }
}
