package com.example.justjava;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int noc=0;
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String msg="Total = ₹"+noc*20;
        msg+="\nThank You!";
        display(noc);
        displayMessage(msg);
     //   displayPrice(noc*20);
    }

    public void increment(View view) {
        noc++;
        display(noc);
        displayPrice(noc*20);
    }

        public void decrement (View view) {
            if (noc >0) {
                noc--;
                display(noc);
                displayPrice(noc * 20);
            }
        }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_tv);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_tv);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_tv);
        priceTextView.setText(message);
    }
}