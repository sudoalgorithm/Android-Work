package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void submitOrder(View view){
        int price = quantity * 5;
        String message = "Total AED:- " +price + "\nThank you";
        displayMessage(message);
    }

    public void increment(View v){
        quantity =  quantity + 1;
        display(quantity);
    }

    public void decrement(View v){
        quantity = quantity - 1;
        display(quantity);
    }

    /*private void displayPrice(int i) {
        TextView tv1 = (TextView) findViewById(R.id.price_text_view);
        tv1.setText(NumberFormat.getCurrencyInstance().format(i));
    }*/

    private void display(int i) {
        TextView tv = (TextView) findViewById(R.id.quantity_text_view);
        tv.setText("" + i);
    }

    private void displayMessage(String s){
        TextView tv2 = (TextView) findViewById(R.id.price_text_view);
        tv2.setText(s);
    }


}
