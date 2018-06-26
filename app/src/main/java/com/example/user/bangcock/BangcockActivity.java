package com.example.user.bangcock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class BangcockActivity extends AppCompatActivity {

    private Button btn_CONVERT;
    EditText EDITTEXT_SGD, EDITTEXT_BKK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangcock);

        btn_CONVERT = (Button)findViewById(R.id.btn_Convert);
        EDITTEXT_SGD = (EditText)findViewById(R.id.editText_SGD);
        EDITTEXT_BKK = (EditText)findViewById(R.id.editText_BKK);


    }
}
