package com.serafinebot.dint.lesson5_date;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button dateBtn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dateBtn = new Button(this);
        dateBtn.setOnClickListener(this);
        updateTime();
        setContentView(dateBtn);
    }

    public void onClick(View view) {
        updateTime();
    }

    public void updateTime() {
        if (dateBtn == null) return;
        dateBtn.setText(new Date().toString());
    }
}