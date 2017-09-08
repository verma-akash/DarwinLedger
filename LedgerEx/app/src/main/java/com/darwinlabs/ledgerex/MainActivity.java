package com.darwinlabs.ledgerex;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.darwinlabs.ledgerex.Adapter.TransactionHistoryAdapter;
import com.darwinlabs.ledgerex.Model.CryptoCurrency;
import com.darwinlabs.ledgerex.Model.NavigationItem;
import com.darwinlabs.ledgerex.Model.TransactionHistory;
import com.darwinlabs.ledgerex.Utils.Constants;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TRANS_OUTGOING = "outgoing";
    private static final String TRANS_INCOMING = "incoming";
    private static String selectedCurrency = "btc";
    int[] progressArray;
    ItemArrayAdapter itemArrayAdapter;
    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;
    private TextView currencyName;
    private TextView currencyAmount;
    private TextView currencyAmountDollars;
    private TextView unitCurrency;
    private TextView rateUSD;
    private ImageView arrowPercentGainDay;
    private TextView percentGainDay;
    private ImageView arrowPercentGainWeek;
    private TextView percentGainWeek;
    private BottomSheetBehavior mBottomSheetBehavior;
    private RecyclerView recyclerView;
    private ArrayList<TransactionHistory> transactionHistoryArrayList;
    private LinearLayout sendAmount;
    private LinearLayout receiveAmount;
    private LinearLayout buySellAmount;

    ArrayList<NavigationItem> navigationItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currencyName = (TextView) findViewById(R.id.currencyName);
        currencyAmount = (TextView) findViewById(R.id.currencyAmount);
        currencyAmountDollars = (TextView) findViewById(R.id.currencyAmountDollars);
        unitCurrency = (TextView) findViewById(R.id.unitCurrency);
        rateUSD = (TextView) findViewById(R.id.rateUSD);
        percentGainDay = (TextView) findViewById(R.id.percentGainDay);
        percentGainWeek = (TextView) findViewById(R.id.percentGainWeek);
        arrowPercentGainDay = (ImageView) findViewById(R.id.arrowPercentGainDay);
        arrowPercentGainWeek = (ImageView) findViewById(R.id.arrowPercentGainWeek);

        //currency data can be fetched from server or database for each user
        //for now populating with static data
        Constants.cryptoCurrencyLinkedHashMap.put("btc", new CryptoCurrency("BITCOIN", 50.000, 232099.50, 4641.99, 2.36, 1.22));
        Constants.cryptoCurrencyLinkedHashMap.put("eth", new CryptoCurrency("ETHEREUM", 42.000, 13788.3907229325, 328.2950172127, 2.36, 1.22));
        Constants.cryptoCurrencyLinkedHashMap.put("ltc", new CryptoCurrency("LITECOIN", 58.000, 4419.9289552249, 76.2056716418, 2.36, 1.22));
        Constants.cryptoCurrencyLinkedHashMap.put("stm", new CryptoCurrency("STM", 10.000, 100.00, 10.00, 2.36, 1.22));
        Constants.cryptoCurrencyLinkedHashMap.put("dsh", new CryptoCurrency("DASHCOIN", 20.000, 0.6869527491, 0.0343476375, 2.36, 1.22));

        Constants.btcUsdRate = 4641.99;
        Constants.ethUsdRate = 328.2950172127;
        Constants.ltcUsdRate = 76.2056716418;
        Constants.stmUsdRate = 10.00;
        Constants.dshUsdRate = 0.0343476375;

        setUpLedgerView(selectedCurrency);

        View bottomSheet = findViewById(R.id.bottom_sheet);

        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        mBottomSheetBehavior.setPeekHeight(400);
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    mBottomSheetBehavior.setPeekHeight(400);
                }
            }

            @Override
            public void onSlide(View bottomSheet, float slideOffset) {
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.transHistoryRecyclerView);

        buildTransHistoryData();

        TransactionHistoryAdapter transactionHistoryAdapter = new TransactionHistoryAdapter(this, transactionHistoryArrayList);
        recyclerView.setAdapter(transactionHistoryAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        sendAmount = (LinearLayout) findViewById(R.id.sendAmount);
        receiveAmount = (LinearLayout) findViewById(R.id.receiveAmount);
        buySellAmount = (LinearLayout) findViewById(R.id.buySellAmount);

        sendAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent(MainActivity.this, SendActivity.class);
                sendIntent.putExtra("currency", selectedCurrency);
                startActivity(sendIntent);
            }
        });

        receiveAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent(MainActivity.this, ReceiveActivity.class);
                sendIntent.putExtra("currency", selectedCurrency);
                startActivity(sendIntent);
            }
        });

        buySellAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Buy/Sell Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.setScrimColor(getResources().getColor(android.R.color.transparent));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menuicon);

        if (drawerToggle == null) {

            drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
                public void onDrawerClosed(View view) {
                }

                public void onDrawerOpened(View drawerView) {

                }

                public void onDrawerSlide(View drawerView, float slideOffset) {
                }

                public void onDrawerStateChanged(int newState) {

                }

            };
            drawerLayout.setDrawerListener(drawerToggle);
            drawerToggle.setDrawerIndicatorEnabled(false);
            drawerToggle.setHomeAsUpIndicator(R.drawable.menuicon);

            drawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                    if (drawer.isDrawerOpen(GravityCompat.START)) {
                        drawer.closeDrawer(GravityCompat.START);
                    } else {
                        drawer.openDrawer(GravityCompat.START);
                    }
                }
            });
        }

        drawerToggle.syncState();

        ListView currencies = (ListView) findViewById(R.id.list);

        String[] currencyArray = {"BTC", "ETH", "LTC", "STM", "DSH"};
        progressArray = calculateProgress();

        for (int i = 0; i < 5; i++) {
            navigationItems.add(new NavigationItem(currencyArray[i], progressArray[i]));
        }

        itemArrayAdapter = new ItemArrayAdapter(this, R.layout.navigation_drawer_list_item, navigationItems);
        currencies.setAdapter(itemArrayAdapter);

        currencies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                NavigationItem selectedItem = (NavigationItem) adapterView.getItemAtPosition(i);

                String selectedItemStr = selectedItem.getItemName();

                setUpLedgerView(selectedItemStr.toLowerCase());
                selectedCurrency = selectedItemStr.toLowerCase();
                drawerLayout.closeDrawer(Gravity.LEFT);

                TextView tv = (TextView) view.findViewById(R.id.tv_text);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    tv.setTextColor(getResources().getColor(R.color.colorPrimaryDark, getTheme()));
                } else {
                    tv.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                }

                itemArrayAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (mBottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void setUpLedgerView(String currency) {
        CryptoCurrency cryptoCurrency = Constants.cryptoCurrencyLinkedHashMap.get(currency);

        currencyName.setText(cryptoCurrency.getCurrencyName() + " BALANCE");
        currencyAmount.setText(String.valueOf(cryptoCurrency.getCurrencyAmount()));
        currencyAmountDollars.setText("$" + String.valueOf(cryptoCurrency.getAmountInDollars()));
        unitCurrency.setText("1 " + currency.toUpperCase() + " = ");
        rateUSD.setText(String.valueOf(cryptoCurrency.getRateInDollars()) + " USD");
        percentGainDay.setText(String.valueOf(cryptoCurrency.getPercentGainLossDay()) + "%");
        percentGainWeek.setText(String.valueOf(cryptoCurrency.getPercentGainLossWeek()) + "%");
    }

    public void buildTransHistoryData() {

        transactionHistoryArrayList = new ArrayList<>();

        transactionHistoryArrayList.add(new TransactionHistory("28 JULY 2017", "8:36 AM", 0.084316, "ETH", TRANS_OUTGOING));
        transactionHistoryArrayList.add(new TransactionHistory("27 JUNE 2017", "7:16 PM", 0.001216, "BTC", TRANS_INCOMING));
        transactionHistoryArrayList.add(new TransactionHistory("24 MARCH 2017", "8:08 AM", 0.1897, "ETH", TRANS_INCOMING));
        transactionHistoryArrayList.add(new TransactionHistory("20 FEB 2017", "12:36 AM", 0.0099, "DSH", TRANS_OUTGOING));
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        progressArray = calculateProgress();

        for (int i = 0; i < 5; i++) {
            navigationItems.get(i).setProgress(progressArray[i]);
        }

        itemArrayAdapter.notifyDataSetChanged();
        setUpLedgerView(selectedCurrency);
    }

    public int[] calculateProgress() {

        int[] progArray = new int[5];

        String maxCurrencyName = "";
        double maxCurrencyAmount = 0.0;

        for (Map.Entry<String, CryptoCurrency> entry : Constants.cryptoCurrencyLinkedHashMap.entrySet()) {
            if (entry.getValue().getCurrencyAmount() > maxCurrencyAmount) {
                maxCurrencyAmount = entry.getValue().getCurrencyAmount();
                maxCurrencyName = entry.getKey();
            }
        }

        int i = 0;
        for (Map.Entry<String, CryptoCurrency> entry : Constants.cryptoCurrencyLinkedHashMap.entrySet()) {
            if (entry.getKey().equals(maxCurrencyName)) {
                progArray[i] = 100;
            } else {
                Double d = ((entry.getValue().getCurrencyAmount() / maxCurrencyAmount) * 100);
                progArray[i] = d.intValue();
            }
            i++;
        }

        return progArray;
    }

    public class ItemArrayAdapter extends ArrayAdapter<NavigationItem> {
        ArrayList<NavigationItem> navigationItems = new ArrayList<>();
        /*String[] itemList;
        int[] progressList;*/
        private int listItemLayout;

        public ItemArrayAdapter(Context context, int layoutId, ArrayList<NavigationItem> objects) {
            super(context, layoutId, objects);
            listItemLayout = layoutId;
            navigationItems = objects;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            int pos = position;
            final String item = getItem(pos).getItemName();
            final int progress = getItem(pos).getProgress();

            ViewHolder viewHolder;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(listItemLayout, parent, false);
                viewHolder.item = (TextView) convertView.findViewById(R.id.tv_text);
                viewHolder.progressBar = (ProgressBar) convertView.findViewById(R.id.progressBar);
                convertView.setTag(viewHolder);

            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.progressBar.setProgress(progress);
            viewHolder.item.setText(item);

            if (getItem(position).getItemName().equalsIgnoreCase(selectedCurrency)) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    viewHolder.item.setTextColor(getResources().getColor(R.color.colorPrimaryDark, getTheme()));
                    viewHolder.progressBar.setProgressDrawable(getResources().getDrawable(R.drawable.progress_bar, getTheme()));
                } else {
                    viewHolder.item.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                    viewHolder.progressBar.setProgressDrawable(getResources().getDrawable(R.drawable.progress_bar));
                }
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    viewHolder.item.setTextColor(getResources().getColor(R.color.lt_gray, getTheme()));
                    viewHolder.progressBar.setProgressDrawable(getResources().getDrawable(R.drawable.progress_bar_unselected, getTheme()));
                } else {
                    viewHolder.item.setTextColor(getResources().getColor(R.color.lt_gray));
                    viewHolder.progressBar.setProgressDrawable(getResources().getDrawable(R.drawable.progress_bar_unselected));
                }
            }

            return convertView;
        }

        class ViewHolder {
            TextView item;
            ProgressBar progressBar;
        }
    }
}
