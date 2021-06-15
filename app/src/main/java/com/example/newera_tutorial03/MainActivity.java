package com.example.newera_tutorial03;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int numberCup=1, price=5;

    private Button btnMinus, btnAdd, btnMakeOrder;
    private TextView tvNumberCup;
    private CheckBox checkCream, checkCookie, checkChocolate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        setListener();
    }
    private void findView(){
        btnMinus = findViewById(R.id.btnMinus);
        btnAdd = findViewById(R.id.btnAdd);
        btnMakeOrder = findViewById(R.id.btnMakeOrder);
        checkCream = findViewById(R.id.checkCream);
        checkCookie = findViewById(R.id.checkCookie);
        checkChocolate = findViewById(R.id.checkChocolate);
        tvNumberCup = findViewById(R.id.tvNumberCup);
    }

    private void setListener() {
        btnMinus.setOnClickListener(view -> {
            if (numberCup != 1) {
                numberCup--;
            }

            tvNumberCup.setText(Integer.toString(numberCup));
        });

        btnAdd.setOnClickListener(view -> {
            numberCup++;

            tvNumberCup.setText(Integer.toString(numberCup));
        });

        btnMakeOrder.setOnClickListener(view -> {
            price = 5;
            if (checkCream.isChecked()) {
                price += 1;
            }
            if (checkCookie.isChecked()) {
                price += 2;
            }
            if (checkChocolate.isChecked()) {
                price += 3;
            }

            price = price * numberCup;

            AlertDialog.Builder totalPrice = new AlertDialog.Builder(MainActivity.this);
            totalPrice.setMessage("Your order is complete! The total price is $" + price);
            totalPrice.setNegativeButton("OK", null);
            totalPrice.create().show();
        });
    }
}
