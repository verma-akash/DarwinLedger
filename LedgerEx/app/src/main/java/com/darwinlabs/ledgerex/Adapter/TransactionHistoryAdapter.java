package com.darwinlabs.ledgerex.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.darwinlabs.ledgerex.Model.TransactionHistory;
import com.darwinlabs.ledgerex.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Akash on 06-Sep-17.
 */

public class TransactionHistoryAdapter extends RecyclerView.Adapter<TransactionHistoryAdapter.TransactionHolder> {

    private Context context;
    private ArrayList<TransactionHistory> transactionHistoryArrayList;

    public TransactionHistoryAdapter(Context context, ArrayList<TransactionHistory> transactionHistoryArrayList) {
        this.context = context;
        this.transactionHistoryArrayList = transactionHistoryArrayList;
    }

    @Override
    public TransactionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.trans_history_item_row, parent, false);
        return new TransactionHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TransactionHolder holder, int position) {
        holder.transDate.setText(transactionHistoryArrayList.get(position).getTransDate());
        holder.transTime.setText(transactionHistoryArrayList.get(position).getTransTime());
        holder.transAmount.setText(String.valueOf(transactionHistoryArrayList.get(position).getTransAmount()));
        holder.currency.setText(transactionHistoryArrayList.get(position).getCurrency());

    }

    @Override
    public int getItemCount() {
        return transactionHistoryArrayList.size();
    }

    public class TransactionHolder extends RecyclerView.ViewHolder{

        public TextView transDate;
        public TextView transTime;
        public TextView transAmount;
        public TextView currency;

        public TransactionHolder(View itemView) {
            super(itemView);

            transDate = (TextView) itemView.findViewById(R.id.transDate);
            transTime = (TextView) itemView.findViewById(R.id.transTime);
            transAmount = (TextView) itemView.findViewById(R.id.transAmount);
            currency = (TextView) itemView.findViewById(R.id.currency);
        }
    }
}
