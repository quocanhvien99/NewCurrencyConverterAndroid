package com.example.newcurrencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity  {

    double usd2vnd = 23176;
    double usd2yen = 104.52;
    double usd2ndt = 6.58;
    public int currCur = 0;
    public double usd, vnd, yen, ndt;

    String[] items = { "USD", "VND", "YEN", "NDT" };

    EditText edt;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt = findViewById(R.id.edt);
        spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    updateCur(Double.parseDouble(edt.getText().toString()));
                    edt.setText(String.format("%.2f", usd));
                    currCur = 0;
                } else if (position == 1) {
                    updateCur(Double.parseDouble(edt.getText().toString()));
                    edt.setText(String.format("%.2f", vnd));
                    currCur = 1;
                } else if (position == 2) {
                    updateCur(Double.parseDouble(edt.getText().toString()));
                    edt.setText(String.format("%.2f", yen));
                    currCur = 2;
                } else {
                    updateCur(Double.parseDouble(edt.getText().toString()));
                    edt.setText(String.format("%.2f", ndt));
                    currCur = 3;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void updateCur(double value) {
        if (currCur == 0) {
            usd = value;
            vnd = usd * usd2vnd;
            yen = usd * usd2yen;
            ndt = usd * usd2ndt;
        } else if (currCur == 1) {
            vnd = value;
            usd = vnd / usd2vnd;
            yen = usd * usd2yen;
            ndt = usd * usd2ndt;
        } else if (currCur == 2) {
            yen = value;
            usd = yen / usd2yen;
            vnd = usd * usd2vnd;
            ndt = usd * usd2ndt;
        }else  {
            ndt = value;
            usd = ndt / usd2ndt;
            vnd = usd * usd2vnd;
            yen = usd * usd2yen;
        }
        Log.v("TAG", "vnd: " + vnd);
    }
}
