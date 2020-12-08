package com.example.dinoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.dinoapp.model.ExampleCompany;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class YtjActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private CompanyAdapter mCompanyAdapter;
    private ArrayList<ExampleCompany> mExampleCompanyList;
    private RequestQueue mRequestQueue;

 //   String searchCompanyName = getIntent().getStringExtra("search");
 //   String url = "https://avoindata.prh.fi/bis/v1?totalResults=false&maxResults=10&resultsFrom=0&companyRegistrationFrom=2014-02-28&name=" + searchCompanyName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ytj);
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mExampleCompanyList = new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(this);

        getDataJson();

    }

    private void getDataJson() {

        String searchCompanyName = getIntent().getStringExtra("search");
        String url = "https://avoindata.prh.fi/bis/v1?totalResults=false&maxResults=10&resultsFrom=0&companyRegistrationFrom=2014-02-28&name=" + searchCompanyName;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("results");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject result = jsonArray.getJSONObject(i);
                                String businessId = result.getString("businessId");
                                String name = result.getString("name");
                                String companyForm = result.getString("companyForm");

                                mExampleCompanyList.add(new ExampleCompany(businessId, name, companyForm));
                            }

                            mCompanyAdapter = new CompanyAdapter(YtjActivity.this, mExampleCompanyList);
                            mRecyclerView.setAdapter(mCompanyAdapter);

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

        mRequestQueue.add(request);
    }
}