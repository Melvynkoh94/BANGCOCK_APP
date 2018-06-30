package com.melvyn.user.bangcock;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;



public class BangcockActivity extends AppCompatActivity {

    private Button btn_CONVERT;
    EditText EDITTEXT_SGD, EDITTEXT_BKK;

    private static final double THB2SGD = 0.041;
    private static final double SGD2THB = 24.24;
    private double SGDtext, THBtext;
    final NumberFormat currencyFormatter = NumberFormat.getInstance( Locale.US );
    DecimalFormat formatter = new DecimalFormat("#,##0.00");

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Toast.makeText(getApplicationContext(), "Where is your home?", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BangcockActivity.this, HomeActivity.class));
                    return true;

                case R.id.navigation_BANGCOCK:
                    Toast.makeText(getApplicationContext(), "SAWADIKAP!", Toast.LENGTH_SHORT).show();
                    return true;

                case R.id.navigation_CALCULATOR:
                    Toast.makeText(getApplicationContext(), "SINE COSINE TANGENT", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BangcockActivity.this, MainActivity.class));
                    return true;
            }
            return false;
        }
    };

    //close the keyboard after you pressed CONVERT button
    public void dismissKeyboard(){
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(getApplicationContext().INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangcock);

        //MY BOTTOM NAVIGATION
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_BANGCOCK);


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
                    dismissKeyboard();
                }

                else if (TextUtils.isEmpty(EDITTEXT_SGD.getText())) {
                    THBtext = Double.parseDouble(EDITTEXT_BKK.getText().toString());
                    SGDtext = THBtext * THB2SGD;
                    EDITTEXT_SGD.setText(currencyFormatter.format(SGDtext) + " SGD");
                    EDITTEXT_BKK.setText(currencyFormatter.format(THBtext) + " BUTTS");
                    dismissKeyboard();
                }

                //APPLICATION STILL CRASHES WHEN I JUST CLICK CONVERT WITH FIELDS EMPTY
                else if (TextUtils.isEmpty(EDITTEXT_SGD.getText()) & TextUtils.isEmpty(EDITTEXT_BKK.getText())){
                    Toast.makeText(getApplicationContext(), "Both fields should not be empty!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Clears the EditText when the user click on the EditText so that the user doesn't have to waste time clearing the EditText box
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
