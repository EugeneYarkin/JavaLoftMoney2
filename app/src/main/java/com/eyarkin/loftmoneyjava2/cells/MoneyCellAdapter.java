package com.eyarkin.loftmoneyjava2.cells;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eyarkin.loftmoneyjava2.R;

import java.util.ArrayList;
import java.util.List;

public class MoneyCellAdapter extends RecyclerView.Adapter<MoneyCellAdapter.MoneyViewHolder>{

    private List<MoneyItem> moneyItemList = new ArrayList<>();

    public MoneyCellAdapterClick moneyCellAdapterClick;

    public void setData(List <MoneyItem> moneyItems){
        moneyItemList.clear();
        moneyItemList.addAll(moneyItems);
        notifyDataSetChanged();
    }

    public void setMoneyCellAdapterClick(MoneyCellAdapterClick moneyCellAdapterClick) {
        this.moneyCellAdapterClick = moneyCellAdapterClick;
    }

    @NonNull
    @Override
    public MoneyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =  LayoutInflater.from(parent.getContext());
        return new MoneyViewHolder(layoutInflater.inflate(R.layout.cell_money,parent,false),
                moneyCellAdapterClick);
    }

    @Override
    public void onBindViewHolder(@NonNull MoneyViewHolder holder, int position) {

        holder.bind(moneyItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return moneyItemList.size();
    }

    static class MoneyViewHolder extends RecyclerView.ViewHolder{

        private TextView titleTextView;
        private TextView valueTextView;
        private MoneyCellAdapterClick moneyCellAdapterClick;

        public MoneyViewHolder(@NonNull View itemView, MoneyCellAdapterClick moneyCellAdapterClick) {
            super(itemView);

            this.moneyCellAdapterClick = moneyCellAdapterClick;

            titleTextView = (TextView) itemView.findViewById(R.id.moneyCellTitleView);
            valueTextView = (TextView) itemView.findViewById(R.id.moneyCellValueView);
        }
        public void bind(MoneyItem moneyItem){
            titleTextView.setText(moneyItem.getTitle());
            valueTextView.setText(moneyItem.getValue());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (moneyCellAdapterClick !=null){
                        moneyCellAdapterClick.onCellClick(moneyItem);
                    }
                }
            });
            titleTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (moneyCellAdapterClick !=null){
                        moneyCellAdapterClick.onTitleClick();
                    }
                }
            });
        }
    }

}
