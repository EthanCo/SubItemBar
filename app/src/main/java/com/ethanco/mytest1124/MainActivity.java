package com.ethanco.mytest1124;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ethanco.subitembar.OnLeftTextClickListener;
import com.ethanco.subitembar.OnRightTextClickListener;
import com.ethanco.subitembar.SubTitleBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SubTitleBar subTitleBar = (SubTitleBar) findViewById(R.id.sub_title_bar);
        subTitleBar.addOnLeftTextClickListener(new OnLeftTextClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "左侧被点击", Toast.LENGTH_SHORT).show();
            }
        });

        subTitleBar.addOnRightTextClickListener(new OnRightTextClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "右侧被点击", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
