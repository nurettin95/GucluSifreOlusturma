package com.nurettingorsoy.guclusifreolusturma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SifreUret sifre = new SifreUret(16);
                textView.setText(sifre.getSifre().toString());

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SifreUret sifre = new SifreUret(10);
                textView.setText(sifre.getSifre().toString());

            }
        });


    }

}