package com.example.kevin.encyclopediaprototype;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class BlueArrowFrogActivity extends AppCompatActivity {

    TextView textName;
    TextView textWeight;
    TextView textMeasure;
    TextView textAverageAge;
    TextView textClass;
    TextView textFamily;
    TextView textViewServer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue_arrow_frog);

        textName = (TextView) findViewById(R.id.textName);
        textWeight = (TextView) findViewById(R.id.textWeight);
        textMeasure = (TextView) findViewById(R.id.textMeasure);
        textAverageAge = (TextView) findViewById(R.id.textAverageAge);
        textClass = (TextView) findViewById(R.id.textClass);
        textFamily = (TextView) findViewById(R.id.textFamily);
        textViewServer = (TextView) findViewById(R.id.textViewServer);
        dataBlueArrowFrog();
    }

    private void dataBlueArrowFrog(){
        //String url = "http://192.168.201.15:40000/api/animal/3";
        String url = "http://192.168.1.40:40000/api/animal/3";
        RequestQueue requestQueue;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            textName.setText(response.getString("name"));
                            textWeight.setText(response.getString("weight"));
                            textMeasure.setText(response.getString("measure"));
                            textAverageAge.setText(response.getString("averageAge"));
                            textClass.setText(response.getString("classification"));
                            textFamily.setText(response.getString("family"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textViewServer.setText("Error, server unavailable");
                    }
                });

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);
    }
}
