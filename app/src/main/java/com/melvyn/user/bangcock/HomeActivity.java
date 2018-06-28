package com.melvyn.user.bangcock;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Type;

public class HomeActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Toast.makeText(getApplicationContext(), "Where is your home?", Toast.LENGTH_SHORT).show();
                    return true;

                case R.id.navigation_BANGCOCK:
                    Toast.makeText(getApplicationContext(), "SAWADIKAP!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(HomeActivity.this, BangcockActivity.class));
                    return true;

                case R.id.navigation_CALCULATOR:
                    Toast.makeText(getApplicationContext(), "SINE COSINE TANGENT", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(HomeActivity.this, MainActivity.class));
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //My Image
        ImageView thai_image = (ImageView) findViewById(R.id.thai_image);
        //thai_image.setImageResource(R.drawable.thailand); //ERRORRRRR

        //MY BOTTOM NAVIGATION
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_home);

        //Welcome to Bangkok text
        TextView text_title = (TextView) findViewById(R.id.textView);
        //Typeface face = Typeface.createFromAsset(getAssets(), "font/");


    }


}
