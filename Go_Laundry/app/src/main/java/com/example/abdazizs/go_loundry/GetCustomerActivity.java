package com.example.abdazizs.go_loundry;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.example.abdazizs.go_loundry.Rest.ApiInterface;
import com.example.abdazizs.networking.Adapters.PembeliAdapter;
import com.example.abdazizs.networking.Models.Pembeli;
import com.example.abdazizs.networking.Models.ResultPembeli;
import com.example.abdazizs.networking.Rest.ApiClient;
import com.example.abdazizs.networking.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GetCustomerActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    Context mContext;
    ApiInterface mApiInterface;
    Button btAddData, btGet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_pembeli);
        mContext = getApplicationContext();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(mLayoutManager);
        btAddData = (Button) findViewById(R.id.btnAddData);
        btGet = (Button) findViewById(R.id.btGet);
        btGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mApiInterface = ApiClient.getClient().create(ApiInterface.class);
                Call<ResultPembeli> mPembeliCall = mApiInterface.getPembeli();
                mPembeliCall.enqueue(new Callback<ResultPembeli>() {
                    @Override
                    public void onResponse(Call<ResultPembeli> call, Response<ResultPembeli> response) {
                        Log.d("Get User",response.body().getStatus());
                        List<Pembeli> listPembeli = response.body().getResult();
                        mAdapter = new PembeliAdapter(listPembeli);
                        mRecyclerView.setAdapter(mAdapter);
                    }
                    @Override
                    public void onFailure(Call<ResultPembeli> call, Throwable t) {
                        Log.d("Get User",t.getMessage());
                    }
                });
            }
        });
        btAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent intent = new Intent(mContext, AddDataCustomer.class);
             startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        return super.onCreateOptionsMenu(menu);
    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        Intent mIntent;
//        switch (item.getItemId()) {
//            case R.id.menuGetPembelian:
//                mIntent = new Intent(this, MainActivity.class);
//                startActivity(mIntent);
//                return true;
//            case R.id.menuGetPembeli:
//                mIntent = new Intent(this, GetCustomerActivity.class);
//                startActivity(mIntent);
//                return true;
//            case R.id.menuTransaksiPembelian:
//                mIntent = new Intent(this, Main2Activity.class);
//                startActivity(mIntent);
//                return true;
//            case R.id.menuTransaksiPembeli:
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//  }
}