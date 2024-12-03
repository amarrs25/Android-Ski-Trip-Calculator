package com.example.amarrsfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }

    double cost;

    Trip trip = new Trip();

    public void userInput(View v) {
        Spinner destination = findViewById(R.id.spinner);

        String[] destDesc = getResources().getStringArray(R.array.destdescrips);

        String destinationSelect = destination.getSelectedItem().toString();

        trip.setDestination(destinationSelect);

            switch (destinationSelect) {
                case "Aspen":
                    trip.setImg(R.drawable.aspen);
                    trip.setDescription(destDesc[0]);
                    trip.setInternational(false);
                    break;
                case "Big Sky":
                    trip.setImg(R.drawable.bigsky);
                    trip.setDescription(destDesc[1]);
                    trip.setInternational(false);
                    break;
                case "Breckenridge":
                    trip.setImg(R.drawable.breck);
                    trip.setDescription(destDesc[2]);
                    trip.setInternational(false);
                    break;
                case "Jackson Hole":
                    trip.setImg(R.drawable.jacksonhole);
                    trip.setDescription(destDesc[3]);
                    trip.setInternational(false);
                    break;
                case "Park City":
                    trip.setImg(R.drawable.parkcity);
                    trip.setDescription(destDesc[4]);
                    trip.setInternational(false);
                    break;
                case "Steamboat":
                    trip.setImg(R.drawable.steamboat);
                    trip.setDescription(destDesc[5]);
                    trip.setInternational(false);
                    break;
                case "Vail":
                    trip.setImg(R.drawable.vail);
                    trip.setDescription(destDesc[6]);
                    trip.setInternational(false);
                    break;
                case "Whistler Blackcomb, Canada":
                    trip.setImg(R.drawable.whistler);
                    trip.setDescription(destDesc[7]);
                    trip.setInternational(true);
                    break;
                case "Saint Anton am Arlberg, Austria":
                    trip.setImg(R.drawable.stanton);
                    trip.setDescription(destDesc[8]);
                    trip.setInternational(true);
                    break;
                default:
                    trip.setImg(-1);
                    trip.setDescription(null);
                    trip.setInternational(false);
                    break;
            }


        String mode = "";
        cost = 0;

        RadioGroup travel = findViewById(R.id.rdgpTravel);
        int travelSelect = travel.getCheckedRadioButtonId();

        if(travelSelect == R.id.btnAir){
            mode = "air travel";
            if(trip.isInternational()) {
                cost += 3000;
            }
            else {
                cost += 2000;
            }
        }
        else {
            mode = "car travel";
            cost += 1000;
        }

        RadioGroup time = findViewById(R.id.rdgpTime);
        int timeSelect = time.getCheckedRadioButtonId();

        String timeString;
        if(timeSelect == R.id.btnOneDay) {
            timeString = "1 day";
        } else if (timeSelect == R.id.btnTwoDay) {
            timeString = "2 days";
            cost += 1200;
        } else if (timeSelect == R.id.btnThreeDay) {
            timeString = "3 days";
            cost += 4000;
        } else if (timeSelect == R.id.btnWeek) {
            timeString = "1 week";
            cost += 9600;
        } else {
            timeString = "No Time Selected";
        }

        EditText skis = findViewById(R.id.txtSkis);
        EditText snowboards = findViewById(R.id.txtSnowboard);

        int skiNum = 0;
        int snowboardNum = 0;
        try {
            skiNum = Integer.parseInt(skis.getText().toString());
            snowboardNum = Integer.parseInt(snowboards.getText().toString());
        } catch (Exception ex) {
            return;
        }
        int rentalCost = 0;
        if(skiNum != 0 || snowboardNum !=0){
            rentalCost += (skiNum * 200);
            rentalCost += (snowboardNum * 250);
        }

        cost += rentalCost;

        trip.setCost(cost);
        trip.setMode(mode);
        trip.setTime(timeString);
        trip.setSkis(skiNum);
        trip.setSnowboards(snowboardNum);
        trip.setRentalCost(rentalCost);

    }

    public void OpenMoreDetails(View v){
        userInput(v);

        Intent showDetails = new Intent(this, MoreDetails.class);

        showDetails.putExtra("tripObject", trip);

        startActivity(showDetails);
    }

    public void OpenFinal (View v){
        userInput(v);

        Intent showFinal = new Intent(this, Final.class);

        showFinal.putExtra("tripObject", trip);

        startActivity(showFinal);
    }
}