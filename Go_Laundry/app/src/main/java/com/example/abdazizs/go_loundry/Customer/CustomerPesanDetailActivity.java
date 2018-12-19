package com.example.abdazizs.go_loundry.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.abdazizs.go_loundry.Models.ResultTranksaksi;
import com.example.abdazizs.go_loundry.Models.ResultUser;
import com.example.abdazizs.go_loundry.R;
import com.example.abdazizs.go_loundry.Rest.ApiClient;
import com.example.abdazizs.go_loundry.Rest.ApiInterface;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomerPesanDetailActivity extends AppCompatActivity {
    Intent mIn;
    Button btKofirm, btHome;
    String nama="";
    int total=0;
    ApiInterface mApiInterface;
    private int cuci, setrika, xpress, antar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cutomer_detail_layanan);
        mIn = getIntent();
        btKofirm = findViewById(R.id.btnCustPsnDtlKofirmasi);
        btHome = findViewById(R.id.btnCustPsnDtlHome);

       cuci = mIn.getIntExtra("cuci",0);
       setrika = mIn.getIntExtra("setrika",0);
       antar = mIn.getIntExtra("antar",0);
       xpress = mIn.getIntExtra("xpress",0);

       if (cuci==1){
           total +=5000;
       }if (setrika==1){
            total +=2000;
        }if (antar==1){
            total +=1000;
        }if (xpress==1){
            total +=2500;
        }

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

       btKofirm.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               Call<ResultTranksaksi> mTra = mApiInterface.postTransaksi(
                       nama,
                       cuci,
                       setrika,
                       xpress,
                       antar,
                       total,
                       0,"post" );
               mTra.enqueue(new Callback<ResultTranksaksi>() {
                   @Override
                   public void onResponse(Call<ResultTranksaksi> call, Response<ResultTranksaksi> response) {
                       Toast.makeText(getApplicationContext(),"Suksess Ditambah",Toast.LENGTH_SHORT).show();
                       finish();
                   }

                   @Override
                   public void onFailure(Call<ResultTranksaksi> call, Throwable t) {
                       Toast.makeText(getApplicationContext(),"error "+t,Toast.LENGTH_SHORT).show();
                   }
               });
           }
       });
       btHome.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent(getBaseContext(), CustomerPesanActivity.class);
               startActivity(i);
           }
       });


    }
}
