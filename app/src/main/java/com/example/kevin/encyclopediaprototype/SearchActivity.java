package com.example.kevin.encyclopediaprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class SearchActivity extends AppCompatActivity {

    EditText editTextSearch;
    Button buttonConfirm;
    TextView textViewShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        editTextSearch = (EditText) findViewById(R.id.editTextSearch);
        textViewShow = (TextView) findViewById(R.id.textViewShow);
        buttonConfirm = (Button) findViewById(R.id.buttonConfirm);
        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateData();
            }
        });
    }

    private void validateData(){
        editTextSearch = (EditText) findViewById(R.id.editTextSearch);
        String search = editTextSearch.getText().toString();

        editTextSearch.setError(null);

        if(TextUtils.isEmpty(search)){
            editTextSearch.setError(getString(R.string.requireField));
            editTextSearch.requestFocus();
        } else{
            searchData();
        }
    }

    private void searchData(){
        String classification = editTextSearch.getText().toString();
        //String url = "http://192.168.201.15:40000/api/classification/" + classification;
        String url = "http://192.168.1.40:40000/api/classification/" + classification;

        RequestQueue requestQueue;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        textViewShow.setText(response.toString());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textViewShow.setText("Error, server unavailable");
                    }
                });

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);
    }
}
