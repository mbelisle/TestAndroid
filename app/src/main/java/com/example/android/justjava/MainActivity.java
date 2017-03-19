package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    int quantity;
    double price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quantity = 0;
    }

    public void orderSummary(View view) {
        updateOrder();
        displayMessage("Thank you!");
    }

    public void checker(View view) {
        updateOrder();
    }

    /**
     * This method is called when the order button is clicked.
     */
    private void updateOrder() {
        display();
        calculatePrice();
        displayPrice();

    }

    public void increment(View view) {
        quantity++;
        updateOrder();
    }

    public void decrement(View view) {
        if(quantity > 0) {
            quantity--;
            updateOrder();
        }
    }

    private void calculatePrice() {
        price = quantity * 5;
        CheckBox whipBox = (CheckBox) findViewById(R.id.whip);
        if (whipBox.isChecked()) {
            price += 1.50;
        }
        CheckBox chocBox = (CheckBox) findViewById(R.id.choc);
        if (chocBox.isChecked()) {
            price += 0.75;
        }

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display() {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity);
        quantityTextView.setText("" + quantity);
    }

    private void displayPrice() {
        TextView quantityTextView = (TextView) findViewById(R.id.price);
        quantityTextView.setText("$" + price);
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price);
        priceTextView.setText(priceTextView.getText() + "\n" + message);
    }

}