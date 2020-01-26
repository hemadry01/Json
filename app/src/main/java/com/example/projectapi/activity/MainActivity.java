package com.example.projectapi.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.projectapi.JsonAdepter;
import com.example.projectapi.R;
import com.example.projectapi.api.ApiClient;
import com.example.projectapi.model.JsonFile;
import com.example.projectapi.model.SearchResult;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private JsonAdepter jsonAdepter;
    private List<SearchResult> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view_id);
        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        results=new ArrayList<>();

        Call<JsonFile> listCall = ApiClient.getInstance().getApi().getResult();
        listCall.enqueue(new Callback<JsonFile>() {
            @Override
            public void onResponse(Call<JsonFile> call, Response<JsonFile> response) {
                if (response.isSuccessful()){
                    results = (List<SearchResult>) response.body().getSearchResult();

                    for (int i=0;i<results.size();i++){
                        System.out.println(""+results.get(i).getName());
                    }
                    jsonAdepter = new JsonAdepter(results,getApplicationContext());
                    recyclerView.setAdapter(jsonAdepter);
                    jsonAdepter.notifyDataSetChanged();

                    Log.d("tag","response"+results);
                }
            }

            @Override
            public void onFailure(Call<JsonFile> call, Throwable t) {
                Log.d("tag", "onFailure: "+t.getMessage());
            }
        });
    }
}
