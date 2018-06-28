package com.example.user.bangcock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class BangcockActivity extends AppCompatActivity {

    private Button btn_CONVERT;
    EditText EDITTEXT_SGD, EDITTEXT_BKK;

    private static final double THB2SGD = 0.041;
    private static final double SGD2THB = 24.24;
    private double SGDtext, THBtext;
    final NumberFormat currency = NumberFormat.getCurrencyInstance();

    final NumberFormat currencyFormatter = NumberFormat.getInstance( Locale.US );



    DecimalFormat formatter = new DecimalFormat("#,##0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangcock);

        btn_CONVERT = (Button)findViewById(R.id.btn_Convert);
        EDITTEXT_SGD = (EditText)findViewById(R.id.editText_SGD);
        EDITTEXT_BKK = (EditText)findViewById(R.id.editText_BKK);



        btn_CONVERT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(EDITTEXT_BKK.getText())) {
                    SGDtext = Double.parseDouble(EDITTEXT_SGD.getText().toString());
                    THBtext = SGDtext * SGD2THB;
                    EDITTEXT_SGD.setText(currencyFormatter.format(SGDtext) + " SGD");
                    EDITTEXT_BKK.setText(currencyFormatter.format(THBtext) + " BUTTS");
                }

                if (TextUtils.isEmpty(EDITTEXT_SGD.getText())) {
                    THBtext = Double.parseDouble(EDITTEXT_BKK.getText().toString());
                    SGDtext = THBtext * THB2SGD;
                    EDITTEXT_SGD.setText(currencyFormatter.format(SGDtext) + " SGD");
                    EDITTEXT_BKK.setText(currencyFormatter.format(THBtext) + " BUTTS");
                }

                //EDITTEXT_SGD.setText(Double.toString(SGDtext));
                //EDITTEXT_BKK.setText(Double.toString(THBtext));
            }
        });

        EDITTEXT_SGD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EDITTEXT_SGD.getText().clear();
                EDITTEXT_BKK.getText().clear();

            }
        });

        EDITTEXT_BKK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EDITTEXT_BKK.getText().clear();
                EDITTEXT_SGD.getText().clear();
            }
        });
    }
}
