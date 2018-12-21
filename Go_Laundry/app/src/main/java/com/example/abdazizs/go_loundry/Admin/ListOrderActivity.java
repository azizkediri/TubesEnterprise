package com.example.abdazizs.go_loundry.Admin;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.abdazizs.go_loundry.Adapters.RVAdminOrder;
import com.example.abdazizs.go_loundry.Models.GetTranksaksi;
import com.example.abdazizs.go_loundry.Models.ResultTranksaksi;
import com.example.abdazizs.go_loundry.R;
import com.example.abdazizs.go_loundry.Rest.ApiClient;
import com.example.abdazizs.go_loundry.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListOrderActivity extends AppCompatActivity {
    RecyclerView rvOrder;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<GetTranksaksi> dataTrans;
    private ApiInterface mApiInterface;
    private RVAdminOrder mAdapter;
    private Context mCon;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_list_order);
        rvOrder = (RecyclerView) findViewById(R.id.recyAdminOrder);
        rvOrder.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rvOrder.setLayoutManager(mLayoutManager);
        mCon = this;

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ResultTranksaksi> getCustomer = mApiInterface.getTranksaksi();
        getCustomer.enqueue(new Callback<ResultTranksaksi>() {

            @Override
            public void onResponse(Call<ResultTranksaksi> call, Response<ResultTranksaksi> response) {
                dataTrans = response.body().getResult();
                mAdapter =  new RVAdminOrder(dataTrans, mCon);
                rvOrder.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<ResultTranksaksi> call, Throwable t) {

            }
        });


    }
}
