package com.example.kevin.encyclopediaprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class EncyclopediaActivity extends AppCompatActivity {

    Button buttonSearch;
    ImageButton imageButtonLion;
    ImageButton imageButtonBlueArrowFrog;
    ImageButton imageButtonEmperorPenguin;
    ImageButton imageButtonLeatherbackTurtle;
    ImageButton imageButtonOrchidMantis;
    ImageButton imageButtonWhiteShark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encyclopedia);

        buttonSearch = (Button) findViewById(R.id.buttonSearch);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goSearch();
            }
        });
        imageButtonLion = (ImageButton) findViewById(R.id.imageButtonLion);
        imageButtonLion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLion();
            }
        });
        imageButtonBlueArrowFrog = (ImageButton) findViewById(R.id.imageButtonBlueArrowFrog);
        imageButtonBlueArrowFrog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBlueArrowFrog();
            }
        });
        imageButtonEmperorPenguin = (ImageButton) findViewById(R.id.imageButtonEmperorPenguin);
        imageButtonEmperorPenguin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goEmperorPenguin();
            }
        });
        imageButtonLeatherbackTurtle = (ImageButton) findViewById(R.id.imageButtonLeatherbackTurtle);
        imageButtonLeatherbackTurtle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLeatherbackTurtle();
            }
        });
        imageButtonOrchidMantis = (ImageButton) findViewById(R.id.imageButtonOrchidMantis);
        imageButtonOrchidMantis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goOrchidMantis();
            }
        });
        imageButtonWhiteShark = (ImageButton) findViewById(R.id.imageButtonWhiteShark);
        imageButtonWhiteShark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goWhiteShark();
            }
        });
    }

    private void goSearch(){
        Intent search = new Intent(getApplicationContext(), SearchActivity.class);
        startActivity(search);
    }

    private void goLion(){
        Intent lion = new Intent(getApplicationContext(), LionActivity.class);
        startActivity(lion);
    }

    private void goBlueArrowFrog(){
        Intent blueArrowFrog = new Intent(getApplicationContext(), BlueArrowFrogActivity.class);
        startActivity(blueArrowFrog);
    }

    private void goEmperorPenguin(){
        Intent emperorPenguin = new Intent(getApplicationContext(), EmperorPenguinActivity.class);
        startActivity(emperorPenguin);
    }

    private void goLeatherbackTurtle(){
        Intent leatherbackTurtle = new Intent(getApplicationContext(), LeatherbackTurtleActivity.class);
        startActivity(leatherbackTurtle);
    }

    private void goOrchidMantis(){
        Intent orchidMantis = new Intent(getApplicationContext(), OrchidMantisActivity.class);
        startActivity(orchidMantis);
    }

    private void goWhiteShark(){
        Intent whiteShark = new Intent(getApplicationContext(), WhiteSharkActivity.class);
        startActivity(whiteShark);
    }
}
