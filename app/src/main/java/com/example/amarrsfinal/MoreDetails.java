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

public class MoreDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_more_details);

        LoadValues();
    }

    private void LoadValues(){
        Intent source = getIntent();

        if(source != null){
            String destination = "Destination: ";
            String description = "";
            int img = -1;
            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                Trip trip = (Trip) source.getSerializableExtra("tripObject", Trip.class);

                if(trip != null) {
                    destination += trip.getDestination();
                    description = trip.getDescription();
                    img = trip.getImg();
                }
            }

            TextView dest = findViewById(R.id.txtDescDest);
            dest.setText(destination);

            TextView desc = findViewById(R.id.txtDesc);
            desc.setText(description);

            ImageView imgV = findViewById(R.id.imgDesc);
            imgV.setImageResource(img);

        }
    }
}