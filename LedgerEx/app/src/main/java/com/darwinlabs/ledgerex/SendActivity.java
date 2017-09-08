package com.darwinlabs.ledgerex;

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

import java.math.BigDecimal;

/**
 * Created by Akash on 07-Sep-17.
 */

public class SendActivity extends AppCompatActivity {

    private static int divisorTimes = 0;
    private boolean periodSelected = false;
    private LinearLayout pinTextCancel;
    private TextView pinText0, pinText1, pinText2, pinText3, pinText4, pinText5, pinText6, pinText7, pinText8, pinText9, pinTextDot, currencyName;
    private BigDecimal amountEntered = new BigDecimal("0.0");
    private TextView amountToSend, amountInUsd;

    private String currency;

    private ImageView sendAmountButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_send);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.backicon);

        Bundle bundle = getIntent().getExtras();
        currency = bundle.getString("currency");

        currencyName = (TextView) findViewById(R.id.currencyName);
        currencyName.setText(currency.toUpperCase());

        amountToSend = (TextView) findViewById(R.id.amountToSend);
        amountInUsd = (TextView) findViewById(R.id.amountInUsd);

        amountToSend.setText(amountEntered + "");
        amountInUsd.setText(amountEntered + "");

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
        pinTextDot = (TextView) findViewById(R.id.pinTextDot);

        pinTextCancel = (LinearLayout) findViewById(R.id.pinTextCancel);

        sendAmountButton = (ImageView) findViewById(R.id.sendAmountButton);

        setUpClickListner();
    }

    public void setUpClickListner() {

        pinText0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateAmount(pinText0.getText().toString());
            }
        });

        pinText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateAmount(pinText1.getText().toString());

            }
        });

        pinText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateAmount(pinText2.getText().toString());

            }
        });

        pinText3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateAmount(pinText3.getText().toString());

            }
        });

        pinText4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateAmount(pinText4.getText().toString());

            }
        });

        pinText5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateAmount(pinText5.getText().toString());

            }
        });

        pinText6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateAmount(pinText6.getText().toString());
            }
        });

        pinText7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateAmount(pinText7.getText().toString());
            }
        });

        pinText8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateAmount(pinText8.getText().toString());

            }
        });

        pinText9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateAmount(pinText9.getText().toString());
            }
        });

        pinTextDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!periodSelected) {
                    periodSelected = true;
                    divisorTimes = 1;
                }
            }
        });

        pinTextCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                periodSelected = false;
                divisorTimes = 0;
                amountEntered = new BigDecimal("0.0");
                amountToSend.setText(amountEntered + "");
                updateAmountUsd();
            }
        });

        sendAmountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double amountBalance = Constants.cryptoCurrencyLinkedHashMap.get(currency).getCurrencyAmount();

                if (Double.valueOf(amountToSend.getText().toString()) > amountBalance) {
                    Toast.makeText(SendActivity.this, "Sorry, not enough balance", Toast.LENGTH_SHORT).show();
                } else {
                    Constants.cryptoCurrencyLinkedHashMap.get(currency).setCurrencyAmount(amountBalance-Double.valueOf(amountToSend.getText().toString()));
                    Constants.cryptoCurrencyLinkedHashMap.get(currency).setAmountInDollars((amountBalance-Double.valueOf(amountToSend.getText().toString()))*Constants.cryptoCurrencyLinkedHashMap.get(currency).getRateInDollars());
                    Toast.makeText(SendActivity.this, "Transaction Complete", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }

    public void updateAmount(String number) {
        BigDecimal num = new BigDecimal(number);

        if (!periodSelected) {
            amountEntered = amountEntered.multiply(new BigDecimal("10")).add(num);
        } else {
            for (int i = 0; i < divisorTimes; i++)
                num = num.divide(new BigDecimal("10"));

            amountEntered = amountEntered.add(num).setScale(divisorTimes);
            divisorTimes++;
        }

        amountToSend.setText(amountEntered + "");
        updateAmountUsd();
    }

    private void updateAmountUsd() {
        double rateInUsd = Constants.cryptoCurrencyLinkedHashMap.get(currency).getRateInDollars();
        amountInUsd.setText(rateInUsd * Double.valueOf(amountToSend.getText().toString()) + "");
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
