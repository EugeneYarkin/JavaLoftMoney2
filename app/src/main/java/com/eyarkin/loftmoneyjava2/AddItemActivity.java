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
    private boolean flToast=true;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        Button button = findViewById(R.id.add_button);
        EditText textCost = findViewById(R.id.ed_cost);
        EditText textName = findViewById(R.id.ed_name);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textCost.setText("");
                textName.setText("");
                if (!flToast){
                    Toast.makeText(getApplicationContext(),
                            R.string.request_sent,
                            Toast.LENGTH_SHORT).show();
                    flToast=true;
                }

            }
        });
        textCost.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().equals("")) {
                    button.setEnabled(true);
                } else {
                    button.setEnabled(false);
                }
                if (flToast){
                    Toast.makeText(getApplicationContext(),
                            R.string.data_entered,
                            Toast.LENGTH_SHORT).show();
                    flToast=false;
                }
            }
        });
    }


}