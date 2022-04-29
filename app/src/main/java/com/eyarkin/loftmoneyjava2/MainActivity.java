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
import android.widget.Toast;

import com.eyarkin.loftmoneyjava2.cells.MoneyCellAdapter;
import com.eyarkin.loftmoneyjava2.cells.MoneyCellAdapterClick;
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

        moneyItems.add(new MoneyItem("Intel Celeron G5905 OEM", "6 199 ₽"));
        moneyItems.add(new MoneyItem("Intel Celeron G5905 BOX","6 599 ₽"));
        moneyItems.add(new MoneyItem("Intel Core i5-11400 BOX","18 299 ₽"));
        moneyItems.add(new MoneyItem("Процессор Intel Core i5-11400 BOX","18 299 ₽"));
        moneyItems.add(new MoneyItem(" Процессор Intel Celeron G5905 OEM LGA 1200, 6 x 2.6 ГГц, L2 - 3 МБ, L3 - 12 МБ, 2хDDR4-3200 МГц, Intel UHD Graphics 730, TDP 65 Вт", "6 199 ₽"));
        moneyItems.add(new MoneyItem("Intel Celeron G5905 OEM", "6 199 ₽"));
        moneyItems.add(new MoneyItem("Intel Celeron G5905 BOX","6 599 ₽"));
        moneyItems.add(new MoneyItem("Intel Core i5-11400 BOX","18 299 ₽"));
        moneyItems.add(new MoneyItem("Процессор Intel Core i5-11400 BOX","18 299 ₽"));
        moneyItems.add(new MoneyItem(" Процессор Intel Celeron G5905 OEM LGA 1200, 6 x 2.6 ГГц, L2 - 3 МБ, L3 - 12 МБ, 2хDDR4-3200 МГц, Intel UHD Graphics 730, TDP 65 Вт", "6 199 ₽"));
        moneyItems.add(new MoneyItem("Intel Celeron G5905 OEM", "6 199 ₽"));
        moneyItems.add(new MoneyItem("Intel Celeron G5905 BOX","6 599 ₽"));
        moneyItems.add(new MoneyItem("Intel Core i5-11400 BOX","18 299 ₽"));
        moneyItems.add(new MoneyItem("Процессор Intel Core i5-11400 BOX","18 299 ₽"));
        moneyItems.add(new MoneyItem(" Процессор Intel Celeron G5905 OEM LGA 1200, 6 x 2.6 ГГц, L2 - 3 МБ, L3 - 12 МБ, 2хDDR4-3200 МГц, Intel UHD Graphics 730, TDP 65 Вт", "6 199 ₽"));
        moneyItems.add(new MoneyItem("Intel Celeron G5905 OEM", "6 199 ₽"));
        moneyItems.add(new MoneyItem("Intel Celeron G5905 BOX","6 599 ₽"));
        moneyItems.add(new MoneyItem("Intel Core i5-11400 BOX","18 299 ₽"));
        moneyItems.add(new MoneyItem("Процессор Intel Core i5-11400 BOX","18 299 ₽"));
        moneyItems.add(new MoneyItem(" Процессор Intel Celeron G5905 OEM LGA 1200, 6 x 2.6 ГГц, L2 - 3 МБ, L3 - 12 МБ, 2хDDR4-3200 МГц, Intel UHD Graphics 730, TDP 65 Вт", "6 199 ₽"));
        moneyItems.add(new MoneyItem("Intel Celeron G5905 OEM", "6 199 ₽"));
        moneyItems.add(new MoneyItem("Intel Celeron G5905 BOX","6 599 ₽"));
        moneyItems.add(new MoneyItem("Intel Core i5-11400 BOX","18 299 ₽"));
        moneyItems.add(new MoneyItem("Процессор Intel Core i5-11400 BOX","18 299 ₽"));
        moneyItems.add(new MoneyItem(" Процессор Intel Celeron G5905 OEM LGA 1200, 6 x 2.6 ГГц, L2 - 3 МБ, L3 - 12 МБ, 2хDDR4-3200 МГц, Intel UHD Graphics 730, TDP 65 Вт", "6 199 ₽"));



        moneyCellAdapter.setData(moneyItems);
    }

    private void configureRecyclerView(){
        itemsView = findViewById(R.id.itemsView);
        itemsView.setAdapter(moneyCellAdapter);

        moneyCellAdapter.moneyCellAdapterClick = new MoneyCellAdapterClick() {
            @Override
            public void onCellClick(MoneyItem moneyItem) {
                Toast.makeText(getApplicationContext(),
                        getResources().getString(R.string.cell_clicked) + " " + moneyItem.getValue(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTitleClick() {
                Toast.makeText(getApplicationContext(),
                        R.string.title_clicked,
                        Toast.LENGTH_SHORT).show();
            }
        };

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false);

        itemsView.setLayoutManager(layoutManager);
    }
}
