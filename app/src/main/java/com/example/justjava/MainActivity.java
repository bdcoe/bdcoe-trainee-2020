package com.example.justjava;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
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

    int noc = 1;

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCream= findViewById(R.id.chkbox_whippedcream);
        CheckBox chocolate= findViewById(R.id.chocolate_checkbox);
        EditText nameField= findViewById(R.id.name_field);
        String name=nameField.getText().toString();
        boolean haswhippedCream= whippedCream.isChecked();
        boolean haschocolate= chocolate.isChecked();
        int price=calculatePrice(noc,haschocolate,haswhippedCream);
        displayMessage(createOrderSummary(price,haswhippedCream,haschocolate,name));
    }

    public boolean checkCream(){
        CheckBox whippedCream= findViewById(R.id.chkbox_whippedcream);
        boolean haswhippedCream= whippedCream.isChecked();
        return haswhippedCream;
    }

    public boolean checkChoco(){
        CheckBox chocolate= findViewById(R.id.chocolate_checkbox);
        boolean haschocolate= chocolate.isChecked();
        return haschocolate;
    }

    public void increment(View view) {
        noc++;
        display(noc);
        displayPrice(calculatePrice(noc,checkChoco(),checkCream()));
    }

    public void decrement(View view) {
        if (noc > 0) {
            noc--;
            display(noc);
            displayPrice(calculatePrice(noc,checkChoco(),checkCream()));
        }
    }

    private String createOrderSummary(int price,boolean hasCream,boolean haschoco,String nm){
        String msg = "Name: "+nm;
        msg+="\nQuantity: "+ noc;
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
    private int calculatePrice(int quantity,boolean hasChoco,boolean hasCream) {
        int price=20;
        if(hasChoco)
            price+=5;
        if(hasCream)
            price+=2;

        return price*quantity;
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