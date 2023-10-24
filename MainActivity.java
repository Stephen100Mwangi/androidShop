package com.example.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    Declare components
    private Button getDiscount,getTotal,getNet,bread,sugar,milk,flour;
    private EditText totalCost,discountCost,netCost;
    private int breadCount = 0;
    private int sugarCount = 0;
    private int milkCount = 0;
    private int flourCount = 0;
    private double cost=0.0;
    double totalDiscount = 0.0;
    double totalPrice = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Binding

        bread = findViewById(R.id.buyBread);
        sugar = findViewById(R.id.buySugar);
        milk = findViewById(R.id.buyMilk);
        flour = findViewById(R.id.buyFlour);
        getNet = findViewById(R.id.getNetPay);
        getDiscount = findViewById(R.id.getDiscount);
        getTotal = findViewById(R.id.grandTotal);

        totalCost = findViewById(R.id.totalCost);
        discountCost = findViewById(R.id.totalDiscount);
        netCost = findViewById(R.id.totalNet);


//        Events
        sugar.setOnClickListener(view ->{
            sugarCount+=1;
            cost+=3500;
            totalCost.setText(String.valueOf(cost));

            if (sugarCount>=4){
                sugar.setVisibility(View.INVISIBLE);
                Toast.makeText(this, "You can only buy 4 bags of sugar", Toast.LENGTH_SHORT).show();
            }
        });
        bread.setOnClickListener(view ->{
            breadCount+=1;
            cost+=120;
            totalCost.setText(String.valueOf(cost));
            if (breadCount>=4){
                bread.setVisibility(View.INVISIBLE);
                Toast.makeText(this, "You can only buy 4 loaves of bread", Toast.LENGTH_SHORT).show();
            }
        });
        flour.setOnClickListener(view ->{
            flourCount+=1;
            cost+=3500;
            totalCost.setText(String.valueOf(cost));
            if (flourCount >= 4){
                flour.setVisibility(View.INVISIBLE);
                Toast.makeText(this, "You can only buy 4 bales of flour", Toast.LENGTH_SHORT).show();
            }
        });
        milk.setOnClickListener(view ->{
            milkCount+=1;
            cost+=200;
            totalCost.setText(String.valueOf(cost));
            if (milkCount >= 4){
                milk.setVisibility(View.INVISIBLE);
                Toast.makeText(this, "You can only buy 4 packets of milk", Toast.LENGTH_SHORT).show();
            }
        });
        getTotal.setOnClickListener(view ->{
            applyDiscount();
        });
        getDiscount.setOnClickListener(view ->{
            applyDiscount();
        });
        getNet.setOnClickListener(view ->{
            applyDiscount();
        });
    }
    public double updateCost(double itemPrice){
        cost += itemPrice;
        totalCost.setText((int) cost);
        return cost;
    }
    private void applyDiscount() {
        if (cost < 10000) {
            Toast.makeText(this, "No discount just yet..!!!", Toast.LENGTH_SHORT).show();
        }else{
            totalDiscount = 0.15 * cost;
            totalPrice = cost - totalDiscount;

            netCost.setText(String.valueOf(totalPrice));
            discountCost.setText(String.valueOf(totalDiscount));
            totalCost.setText(String.valueOf(cost));
        }
    }
}