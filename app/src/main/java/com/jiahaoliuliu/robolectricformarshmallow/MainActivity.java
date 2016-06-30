package com.jiahaoliuliu.robolectricformarshmallow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mSimpleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSimpleTextView = (TextView) findViewById(R.id.simple_text_view);
        setTextByGenericContext();
    }

    /**
     * Method create to test the generic context by extending the Application class
     */
    private void setTextByGenericContext() {
        mSimpleTextView.setText(MainApplication.getContext().getText(R.string.app_name));
    }
}
