
package com.example.covid_19reporter;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.covid_19reporter.Adaptors.HospitalViewAdaptor;
import com.example.covid_19reporter.DTO.Hospital;
import com.example.covid_19reporter.DTO.HospitalsData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LocalCases_hospitalsFragment extends AppCompatActivity {
    private final String url="https://www.hpb.health.gov.lk/api/get-current-statistical";
    private List<HospitalsData> hospitals;
    //private Hospital hospital;
    private HospitalsData hospitalsData;
    private RecyclerView view;
    private RecyclerView.Adapter adapter;
    private RequestQueue requestQueue;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hospitals=new ArrayList<>();
        setContentView(R.layout.local_cases_hospitals);
        view=findViewById(R.id.local_hospitalsview);
        RecyclerView.LayoutManager hospitalLayoutManager=new LinearLayoutManager(this);
        view.setLayoutManager(hospitalLayoutManager);

        requestQueue=Volley.newRequestQueue(getApplicationContext());
        loadUrlData();

    }

    private void initializeDisplayContent(){
        view=findViewById(R.id.local_hospitalsview);
        RecyclerView.LayoutManager hospitalLayoutManager=new LinearLayoutManager(this);
        view.setLayoutManager(hospitalLayoutManager);


    }

    private void loadUrlData(){
        final JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            String cumulative_local;

            String cumulative_foreign;

            String treatment_local;

            String treatment_foreign;

            String id;

            String name;

            Hospital hospital;

            @Override
            public void onResponse(JSONObject response) {
                String TAG="hospitalcop";
                try {
                    JSONObject jsonObject=response.getJSONObject("data");
                    JSONArray jsonArray=jsonObject.getJSONArray("hospital_data");

                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject hospitalObject=jsonArray.getJSONObject(i);
                        cumulative_local=hospitalObject.getString("cumulative_local");

                        cumulative_foreign=hospitalObject.getString("cumulative_foreign");

                        treatment_local=hospitalObject.getString("treatment_local");

                        treatment_foreign=hospitalObject.getString("treatment_foreign");

                        id=hospitalObject.getJSONObject("hospital").getString("id");
                        name=hospitalObject.getJSONObject("hospital").getString("name");
//                        JSONArray array=hospitalObject.getJSONArray("hospital");

//                        id=array.getString(0);
//                        name=array.getString(1);
//                        id=hospitalOBJ.getString("id");
//                        name=hospitalOBJ.getString("name");
                        Log.i(TAG, "onResponse: "+id+"  "+name+" "+treatment_local+"  "+treatment_foreign);
                        hospital=new Hospital(id,name);
                        hospitalsData=new HospitalsData(cumulative_local,cumulative_foreign,treatment_local,treatment_foreign,hospital);
                        hospitals.add(i,hospitalsData);


                    }
                    adapter=new HospitalViewAdaptor(LocalCases_hospitalsFragment.this,hospitals);
                    view.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(request);
    }
}
