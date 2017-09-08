package com.darwinlabs.ledgerex;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.darwinlabs.ledgerex.Utils.Constants;

/**
 * Created by Akash on 07-Sep-17.
 */

public class ReceiveActivity extends AppCompatActivity {

    private ImageView copyAddress;
    private TextView addressText, currencyAddressText, qrCodeText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_receive);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.backicon);

        addressText = (TextView) findViewById(R.id.addressText);

        copyAddress = (ImageView) findViewById(R.id.copyAddress);

        copyAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("QR_ADDRESS", addressText.getText());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(ReceiveActivity.this, "Address Copied on ClipBoard", Toast.LENGTH_SHORT).show();
            }
        });

        currencyAddressText = (TextView) findViewById(R.id.currencyAddressText);
        qrCodeText = (TextView) findViewById(R.id.qrCodeText);

        Bundle bundle = getIntent().getExtras();
        String currencyName = bundle.getString("currency");

        qrCodeText.setText("YOUR "+ Constants.cryptoCurrencyLinkedHashMap.get(currencyName).getCurrencyName()+" QR CODE");
        currencyAddressText.setText("YOUR "+ Constants.cryptoCurrencyLinkedHashMap.get(currencyName).getCurrencyName()+" ADDRESS");

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
