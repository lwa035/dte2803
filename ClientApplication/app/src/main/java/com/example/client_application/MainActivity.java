package com.example.client_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button btn_get_p, btn_post_p, btn_put_p, btn_del_p;
    EditText data_id, data_name, data_symptoms;
    ListView lv_patients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assigning value to each control
        btn_get_p = findViewById(R.id.btn_get);
        btn_post_p = findViewById(R.id.btn_post);
        btn_put_p = findViewById(R.id.btn_put);
        btn_del_p = findViewById(R.id.btn_delete);

        data_id = findViewById(R.id.data_id);
        data_name = findViewById(R.id.data_name);
        data_symptoms = findViewById(R.id.data_symptoms);

        lv_patients = findViewById(R.id.lv_patients);

        // Click listener
        btn_get_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Instantiate the RequestQueue.
                // Replaced for grouping of requests in RequestQueue
                String url = "localhost:8080/patients" + data_id.getText().toString();

                // Request a string response from the provided URL.
                JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                String id = "";
                                String name = "";
                                String symptoms = "";
                                try{
                                    JSONObject patients = response.getJSONObject(Integer.parseInt(data_id.getText().toString()));
                                    id = patients.getString("id");
                                    name = patients.getString("name");
                                    symptoms = patients.getString("symptom");
                                } catch (JSONException e){
                                    e.printStackTrace();
                                }

                                Toast.makeText(MainActivity.this, "ID = " + id + "\nName = " + name + "\nSymptoms = " + symptoms, Toast.LENGTH_SHORT).show();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Error in GET patient.", Toast.LENGTH_SHORT).show();
                    }
                });

                // Add the request to the RequestQueue.
                DataServicePatients.getInstance(MainActivity.this).addToRequestQueue(request);
            }
        });

        btn_post_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = data_id.getText().toString();
                String symptoms = data_symptoms.getText().toString();

                String url = "localhost:8080/patients";

                // Code for POST
            }
        });

        btn_put_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "localhost:8080/patients" + data_id.getText().toString();
                // Code for PUT
            }
        });

        btn_del_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "localhost:8080/patients" + data_id.getText().toString();
                // Code for DELETE
            }
        });
    }
}