
package com.example.abdazizs.go_loundry.Admin;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.abdazizs.go_loundry.Adapters.RVAdminUser;
import com.example.abdazizs.go_loundry.Models.GetUser;
import com.example.abdazizs.go_loundry.Models.PutDelUser;
import com.example.abdazizs.go_loundry.Models.ResultUser;
import com.example.abdazizs.go_loundry.R;
import com.example.abdazizs.go_loundry.Rest.ApiClient;
import com.example.abdazizs.go_loundry.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListCustomer extends AppCompatActivity {
    private RecyclerView rv;
    private RVAdminUser mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<GetUser> dataUser;
    private ApiInterface mApiInterface;
    private Context mCon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_list_customer);
        rv = (RecyclerView) findViewById(R.id.recyAdminCust);
        mCon = this;
        rv.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rv.setLayoutManager(mLayoutManager);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ResultUser> getUserCall = mApiInterface.getUser();
        getUserCall.enqueue(new Callback<ResultUser>() {

            @Override
            public void onResponse(Call<ResultUser> call, Response<ResultUser> response) {
                dataUser =  response.body().getUser();
                mAdapter =  new RVAdminUser(dataUser,mCon);
                rv.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<ResultUser> call, Throwable t) {

            }
        });

    }
}
