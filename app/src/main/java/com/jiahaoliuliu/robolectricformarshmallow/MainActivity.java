package com.jiahaoliuliu.robolectricformarshmallow;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_ASK_PERMISSION_READ_PHONE_STATE = 1000;

    private TextView mSimpleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSimpleTextView = (TextView) findViewById(R.id.simple_text_view);
        setTextByGenericContext();

        // Check the read phone state permission
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_PHONE_STATE)
                    == PackageManager.PERMISSION_GRANTED) {
            mSimpleTextView.setText("Read phone state permission guaranteed");
        } else {
            ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.READ_PHONE_STATE},
                REQUEST_CODE_ASK_PERMISSION_READ_PHONE_STATE);
        }
    }

    /**
     * Method create to test the generic context by extending the Application class
     */
    private void setTextByGenericContext() {
        mSimpleTextView.setText(MainApplication.getContext().getText(R.string.app_name));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
        @NonNull int[] grantResults) {
        switch(requestCode) {
            case REQUEST_CODE_ASK_PERMISSION_READ_PHONE_STATE:
                if (grantResults != null && grantResults.length > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mSimpleTextView.setText("Read phone state permission guaranteed");
                } else {
                    // If the user's permission is not granted, use random device id in the User data module
                    mSimpleTextView.setText("Read phone state permission denied");
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                break;
        }
    }
}
