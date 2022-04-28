package com.eyarkin.loftmoneyjava2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.eyarkin.loftmoneyjava2.cells.MoneyCellAdapter;
import com.eyarkin.loftmoneyjava2.cells.MoneyItem;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView itemsView;

    private MoneyCellAdapter moneyCellAdapter=new MoneyCellAdapter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent activity = new Intent(this, AddItemActivity.class);
        startActivity(activity);

        configureRecyclerView();

        generateMoney();

    }
    private void generateMoney(){
        List<MoneyItem> moneyItems = new ArrayList<>();
        moneyItems.add(new MoneyItem("PS5", "23000"));
        moneyItems.add(new MoneyItem("Salary","5000000"));

        moneyCellAdapter.setData(moneyItems);
    }

    private void configureRecyclerView(){
        itemsView = findViewById(R.id.itemsView);
        itemsView.setAdapter(moneyCellAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false);

        itemsView.setLayoutManager(layoutManager);
    }
}
