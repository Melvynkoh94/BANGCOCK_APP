package com.example.user.bangcock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.text.NumberFormat;

public class BangcockActivity extends AppCompatActivity {

    private Button btn_CONVERT;
    EditText EDITTEXT_SGD, EDITTEXT_BKK;

    private static final double THB2SGD = 0.041;
    private static final double SGD2THB = 24.24;
    private double SGDtext, THBtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangcock);

        btn_CONVERT = (Button)findViewById(R.id.btn_Convert);
        EDITTEXT_SGD = (EditText)findViewById(R.id.editText_SGD);
        EDITTEXT_BKK = (EditText)findViewById(R.id.editText_BKK);

        //NumberFormat currency = NumberFormat.getCurrencyInstance();
        //myTextView.setText(currency.format(dollars));


        btn_CONVERT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SGDtext = Double.parseDouble(EDITTEXT_SGD.getText().toString());
                THBtext = SGDtext * SGD2THB;
                EDITTEXT_SGD.setText(Double.toString(SGDtext));
                EDITTEXT_BKK.setText(Double.toString(THBtext));
                //mValueOne = Float.parseFloat(EDITTEXT_SGD.getText() + "");
                //mSubtract = true;
                //crunchifyEditText.setText(null);
            }
        });
    }
}
