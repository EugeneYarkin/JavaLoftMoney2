package com.eyarkin.loftmoneyjava2;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddItemActivity extends AppCompatActivity {
    static boolean flToast=true;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        Button button = (Button)findViewById(R.id.add_button);
        EditText textIncomes = findViewById(R.id.incomes_tv);
        EditText textExpenses = findViewById(R.id.expenses_tv);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIncomes.setText("");
                textExpenses.setText("");
                if (!flToast){
                    Toast.makeText(getApplicationContext(),
                            "Запрос отправлен!",
                            Toast.LENGTH_SHORT).show();
                    flToast=true;
                }

            }
        });
        textIncomes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (flToast){
                    Toast.makeText(getApplicationContext(),
                            "Данные введены!",
                            Toast.LENGTH_SHORT).show();
                    flToast=false;
                }
                }


            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().equals("")) {
                    button.setEnabled(true);
                } else {
                    button.setEnabled(false);
                }
            }
        });
    }
}