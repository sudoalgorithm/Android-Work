package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int quantity = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void submitOrder(View view){
        CheckBox cb = (CheckBox) findViewById(R.id.whipped_cream_topping);
        CheckBox cb1 = (CheckBox) findViewById(R.id.chocolate_topping);
        EditText et1 = (EditText) findViewById(R.id.edit_field_name);
        boolean value = cb.isChecked();
        boolean value1 = cb1.isChecked();
        String name = String.valueOf(et1.getText());
        String orderSummery = createOrderSummary(name,value, value1);
        int price = calculatePrice(quantity, 5,value, value1);
        String message = orderSummery+ "\nTotal AED :- " +price + "\nThank you";
        //displayMessage(message);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, "kunal@smartspot.co.in");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for "+name);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) !=null ){
            startActivity(intent);
        }


    }



    public void increment(View v){
        if (quantity == 100){
            Toast.makeText(this, "You cannot order more than 100 coffees", Toast.LENGTH_SHORT).show();
            return;

        }
        quantity =  quantity + 1;
        display(String.valueOf(quantity));
    }

    public void decrement(View v){
        if (quantity == 1){
            Toast.makeText(this, "You cannot less then 1 coffee", Toast.LENGTH_SHORT).show();
            return;

        }
        quantity = quantity - 1;
        display(String.valueOf(quantity));
    }

    /*private void displayPrice(int i) {
        TextView tv1 = (TextView) findViewById(R.id.price_text_view);
        tv1.setText(NumberFormat.getCurrencyInstance().format(i));
    }*/

    private void display(String number) {
        TextView tv = (TextView) findViewById(R.id.quantity_text_view);
        tv.setText(number);
    }

    private int calculatePrice(int n, int price, boolean value, boolean value1){
        if (value == true && value1 == false) {
            return (price + 1) * n;
        }else if (value == false && value1 == true){
            return (price + 2) * n;
        }else if (value == true && value1 == true){
            return (price + 2 + 1) * n;
        }else {
            return price * n;
        }
    }

    /*private void displayMessage(String s){
        TextView tv2 = (TextView) findViewById(R.id.order_summary_text_view);
        tv2.setText(s);
    }*/

    private String createOrderSummary(String name, boolean value, boolean value1){
        String topping = "Add whipped cream ? ";
        String tooping1 = "Add chocolate ? ";
        return "Name: "+ name+"\n" + topping + value +"\n"+ tooping1+ value1+ "\nQuantity: " + quantity;
    }


}
