package com.example.amarrsfinal;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Final extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_final);

        tripDetails();
    }

    public void tripDetails() {
        Intent source = getIntent();

        if (source != null) {
            String destination = "You are going to ";
            String description = "Your selected mode of travel is ";
            String mode = "";
            String time = "";
            String skis = "";
            String snowboards = "";
            boolean isInternational = false;
            double rentalCost = 0;
            double cost = 0;
            int img = -1;

            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                Trip trip = (Trip) source.getSerializableExtra("tripObject");

                if (trip != null) {
                    destination += trip.getDestination();
                    mode += trip.getMode();
                    time += trip.getTime();
                    skis += trip.getSkis();
                    snowboards += trip.getSnowboards();
                    isInternational = trip.isInternational();
                    rentalCost = trip.getRentalCost();
                    cost = trip.getCost();
                    img = trip.getImg();
                }
            }

            destination += " resort!";

            description += mode + ". You are going for " + time + "  after you have paid us $" + cost + ". You have rented " +
                    skis + " ski(s) and " + snowboards + " snowboard(s) for an additional cost of $" + rentalCost + " already included in your total!";

            if(isInternational){
                description += " You have selected an international destination for an additional charge of $1000.0 already included in your total.";
            }

            TextView dest = findViewById(R.id.txtFinalDest);
            dest.setText(destination);

            TextView desc = findViewById(R.id.txtFinalDesc);
            desc.setText(description);

            ImageView imgV = findViewById(R.id.imgFinal);
            imgV.setImageResource(img);
        }
    }
}