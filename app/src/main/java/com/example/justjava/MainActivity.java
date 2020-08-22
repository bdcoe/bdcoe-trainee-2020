package com.example.justjava;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int noc = 0;

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCream= findViewById(R.id.chkbox_whippedcream);
        CheckBox chocolate= findViewById(R.id.chocolate_checkbox);
        boolean haswhippedCream= whippedCream.isChecked();
        boolean haschocolate= chocolate.isChecked();
        int price=calculatePrice(noc);
        displayMessage(createOrderSummary(price,haswhippedCream,haschocolate));
    }

    public void increment(View view) {
        noc++;
        display(noc);
        displayPrice(noc * 20);
    }

    public void decrement(View view) {
        if (noc > 0) {
            noc--;
            display(noc);
            displayPrice(noc * 20);
        }
    }

    private String createOrderSummary(int price,boolean hasCream,boolean haschoco){
        String msg = "Name: Arpit Chauhan\nQuantity: "+ noc;
        msg+="\nAdded Whipped Cream ? "+ hasCream;
        msg+="\nAdded Chocolate ? "+ haschoco;
        msg+="\nTotal = ₹" + price;
        msg += "\nThank You!";
        return msg;
    }


    /**
     * Calculates the price of the order based on the current quantity.
     *
     * @return the price
     */
    private int calculatePrice(int quantity) {
        int price = quantity * 20;
        return price;
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