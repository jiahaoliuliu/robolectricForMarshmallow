package com.jiahaoliuliu.robolectricformarshmallow;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.widget.TextView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.jiahaoliuliu.robolectricformarshmallow.controller.MainController;

public class MainActivity extends BaseActivity implements OnMapReadyCallback{

    private static final int REQUEST_CODE_ASK_PERMISSION_READ_PHONE_STATE = 1000;

    // Views
    private TextView mSimpleTextView;
    private SupportMapFragment mSupportMapFragment;

    // Internal variables
    private MainController mMainController;
    private GoogleMap mGoogleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set the internal variables
        mMainController = MainController.getMainController(this);

        // Link the views
        mSimpleTextView = (TextView) findViewById(R.id.simple_text_view);
        setTextByGenericContext();

        mSupportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mSupportMapFragment.getMapAsync(this);

        // Check the read phone state permission
        if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.READ_PHONE_STATE)
                    == PackageManager.PERMISSION_GRANTED) {
            mSimpleTextView.setText(mMainController.getTextToDisplay(true));
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
                    mSimpleTextView.setText(mMainController.getTextToDisplay(true));
                } else {
                    // If the user's permission is not granted, use random device id in the User data module
                    mSimpleTextView.setText(mMainController.getTextToDisplay(false));
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                break;
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // The map is ready
        this.mGoogleMap = googleMap;

        // Set the map as hybrid
        mGoogleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }
}
