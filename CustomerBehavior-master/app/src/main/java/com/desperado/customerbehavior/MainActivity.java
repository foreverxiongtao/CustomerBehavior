package com.desperado.customerbehavior;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button mBtn_main_otherview;
    private Button btn_main_textview;
    private Button btn_main_scollview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn_main_otherview = (Button) findViewById(R.id.btn_main_otherview);
        btn_main_textview = (Button) findViewById(R.id.btn_main_textview);
        btn_main_scollview = (Button) findViewById(R.id.btn_main_scollview);
        btn_main_scollview.setOnClickListener(this);
        btn_main_textview.setOnClickListener(this);
        mBtn_main_otherview.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_main_otherview:
                break;
            case R.id.btn_main_scollview:
                startActivity(new Intent(this,ScrollViewActivity.class));
                break;
            case R.id.btn_main_textview:
                startActivity(new Intent(this,SecondActivity.class));
                break;
            default:
                break;
        }
    }
}
