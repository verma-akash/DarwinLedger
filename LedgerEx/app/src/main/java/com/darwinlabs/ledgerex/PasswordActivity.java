package com.darwinlabs.ledgerex;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.darwinlabs.ledgerex.Utils.Constants;

/**
 * Created by Akash on 07-Sep-17.
 */

public class PasswordActivity extends AppCompatActivity {

    private ImageView forward;
    private ImageView pin_1, pin_2, pin_3, pin_4;
    private LinearLayout pinTextCancel;
    private TextView pinText0, pinText1, pinText2, pinText3, pinText4, pinText5, pinText6, pinText7, pinText8, pinText9;
    private String passwordEntered = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_password);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.backicon);

        forward = (ImageView) findViewById(R.id.forward);
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Integer.parseInt(passwordEntered) == Constants.PASSWORD){
                    Intent intent = new Intent(PasswordActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {

                    passwordEntered = "";

                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                        pin_1.setImageDrawable(getResources().getDrawable(R.drawable.circle_blank, getTheme()));
                        pin_2.setImageDrawable(getResources().getDrawable(R.drawable.circle_blank, getTheme()));
                        pin_3.setImageDrawable(getResources().getDrawable(R.drawable.circle_blank, getTheme()));
                        pin_4.setImageDrawable(getResources().getDrawable(R.drawable.circle_blank, getTheme()));

                    } else {
                        pin_1.setImageDrawable(getResources().getDrawable(R.drawable.circle_blank));
                        pin_2.setImageDrawable(getResources().getDrawable(R.drawable.circle_blank));
                        pin_3.setImageDrawable(getResources().getDrawable(R.drawable.circle_blank));
                        pin_4.setImageDrawable(getResources().getDrawable(R.drawable.circle_blank));

                    }
                    Toast.makeText(PasswordActivity.this, "Wrong Password!!! Please Try Again", Toast.LENGTH_SHORT).show();
                }
            }
        });


        pin_1 = (ImageView) findViewById(R.id.pin_1);
        pin_2 = (ImageView) findViewById(R.id.pin_2);
        pin_3 = (ImageView) findViewById(R.id.pin_3);
        pin_4 = (ImageView) findViewById(R.id.pin_4);

        pinText0 = (TextView) findViewById(R.id.pinText0);
        pinText1 = (TextView) findViewById(R.id.pinText1);
        pinText2 = (TextView) findViewById(R.id.pinText2);
        pinText3 = (TextView) findViewById(R.id.pinText3);
        pinText4 = (TextView) findViewById(R.id.pinText4);
        pinText5 = (TextView) findViewById(R.id.pinText5);
        pinText6 = (TextView) findViewById(R.id.pinText6);
        pinText7 = (TextView) findViewById(R.id.pinText7);
        pinText8 = (TextView) findViewById(R.id.pinText8);
        pinText9 = (TextView) findViewById(R.id.pinText9);

        pinTextCancel = (LinearLayout) findViewById(R.id.pinTextCancel);

        setUpClickListner();
    }

    public void setUpClickListner(){

        pinText0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (passwordEntered.length()<4){
                    passwordEntered += pinText0.getText();

                    switch (passwordEntered.length()){
                        case 1:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_1.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_1.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;
                        case 2:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_2.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_2.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;
                        case 3:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_3.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_3.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;
                        case 4:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_4.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_4.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;

                        default:
                            break;
                    }
                }
            }
        });

        pinText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (passwordEntered.length()<4){
                    passwordEntered += pinText1.getText();

                    switch (passwordEntered.length()){
                        case 1:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_1.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_1.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;
                        case 2:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_2.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_2.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;
                        case 3:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_3.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_3.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;
                        case 4:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_4.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_4.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;

                        default:
                            break;
                    }
                }
            }
        });

        pinText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (passwordEntered.length()<4){
                    passwordEntered += pinText2.getText();

                    switch (passwordEntered.length()){
                        case 1:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_1.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_1.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;
                        case 2:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_2.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_2.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;
                        case 3:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_3.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_3.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;
                        case 4:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_4.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_4.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;

                        default:
                            break;
                    }
                }
            }
        });

        pinText3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (passwordEntered.length()<4){
                    passwordEntered += pinText3.getText();

                    switch (passwordEntered.length()){
                        case 1:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_1.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_1.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;
                        case 2:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_2.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_2.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;
                        case 3:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_3.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_3.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;
                        case 4:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_4.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_4.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;

                        default:
                            break;
                    }
                }
            }
        });

        pinText4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (passwordEntered.length()<4){
                    passwordEntered += pinText4.getText();

                    switch (passwordEntered.length()){
                        case 1:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_1.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_1.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;
                        case 2:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_2.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_2.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;
                        case 3:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_3.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_3.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;
                        case 4:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_4.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_4.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;

                        default:
                            break;
                    }
                }
            }
        });

        pinText5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (passwordEntered.length()<4){
                    passwordEntered += pinText5.getText();

                    switch (passwordEntered.length()){
                        case 1:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_1.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_1.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;
                        case 2:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_2.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_2.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;
                        case 3:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_3.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_3.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;
                        case 4:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_4.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_4.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;

                        default:
                            break;
                    }
                }
            }
        });

        pinText6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (passwordEntered.length()<4){
                    passwordEntered += pinText6.getText();

                    switch (passwordEntered.length()){
                        case 1:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_1.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_1.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;
                        case 2:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_2.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_2.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;
                        case 3:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_3.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_3.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;
                        case 4:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_4.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_4.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;

                        default:
                            break;
                    }
                }
            }
        });

        pinText7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (passwordEntered.length()<4){
                    passwordEntered += pinText7.getText();

                    switch (passwordEntered.length()){
                        case 1:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_1.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_1.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;
                        case 2:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_2.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_2.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;
                        case 3:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_3.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_3.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;
                        case 4:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_4.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_4.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;

                        default:
                            break;
                    }
                }
            }
        });

        pinText8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (passwordEntered.length()<4){
                    passwordEntered += pinText8.getText();
                    switch (passwordEntered.length()){
                        case 1:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_1.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_1.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;
                        case 2:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_2.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_2.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;
                        case 3:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_3.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_3.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;
                        case 4:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_4.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_4.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;

                        default:
                            break;
                    }
                }
            }
        });

        pinText9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (passwordEntered.length()<4){
                    passwordEntered += pinText9.getText();

                    switch (passwordEntered.length()){
                        case 1:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_1.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_1.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;
                        case 2:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_2.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_2.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;
                        case 3:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_3.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_3.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;
                        case 4:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_4.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled, getTheme()));
                            } else {
                                pin_4.setImageDrawable(getResources().getDrawable(R.drawable.circle_filled));
                            }
                            break;

                        default:
                            break;
                    }
                }
            }
        });

        pinTextCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(passwordEntered.length()>0){
                    passwordEntered = passwordEntered.substring(0, passwordEntered.length()-1);

                    switch (passwordEntered.length()){
                        case 0:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_1.setImageDrawable(getResources().getDrawable(R.drawable.circle_blank, getTheme()));
                            } else {
                                pin_1.setImageDrawable(getResources().getDrawable(R.drawable.circle_blank));
                            }
                            break;
                        case 1:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_2.setImageDrawable(getResources().getDrawable(R.drawable.circle_blank, getTheme()));
                            } else {
                                pin_2.setImageDrawable(getResources().getDrawable(R.drawable.circle_blank));
                            }
                            break;
                        case 2:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_3.setImageDrawable(getResources().getDrawable(R.drawable.circle_blank, getTheme()));
                            } else {
                                pin_3.setImageDrawable(getResources().getDrawable(R.drawable.circle_blank));
                            }
                            break;
                        case 3:
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                pin_4.setImageDrawable(getResources().getDrawable(R.drawable.circle_blank, getTheme()));
                            } else {
                                pin_4.setImageDrawable(getResources().getDrawable(R.drawable.circle_blank));
                            }
                            break;

                        default:
                            break;
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                supportFinishAfterTransition();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
