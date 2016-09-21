package com.desperado.customerbehavior;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView mTv_second_source;
    private TextView tv_second_target;
    private float last_y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_second);
        mTv_second_source = (TextView) findViewById(R.id.tv_second_source);
        tv_second_target = (TextView) findViewById(R.id.tv_second_target);
        mTv_second_source.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        mTv_second_source.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        float offset = event.getY() - last_y;
                        last_y = event.getY();
                        if (offset > 0) {
                            ViewCompat.offsetTopAndBottom(mTv_second_source, 5);
                        } else {
                            ViewCompat.offsetTopAndBottom(mTv_second_source, -5);
                        }
                        break;
                }
                return false;
            }
        });

    }

}
