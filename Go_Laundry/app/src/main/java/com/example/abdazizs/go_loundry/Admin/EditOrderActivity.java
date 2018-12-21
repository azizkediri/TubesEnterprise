package com.example.abdazizs.go_loundry.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abdazizs.go_loundry.Models.PutDelTranksaksi;
import com.example.abdazizs.go_loundry.Models.ResultTranksaksi;
import com.example.abdazizs.go_loundry.R;
import com.example.abdazizs.go_loundry.Rest.ApiClient;
import com.example.abdazizs.go_loundry.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditOrderActivity extends AppCompatActivity {
    Button btpdate, btBack;
    Intent mIntent;
    EditText edAntar;
    EditText edSatus;
    TextView tvNama;
    private int id,antar,status;
    private int newAntar, newStatus;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_edit_order);
        edSatus = findViewById(R.id.edtAdminEditStatusPakaian);
        edAntar = findViewById(R.id.edtAdminEditStatusAntar);
        btBack = findViewById(R.id.btnAdminEditBack);
        btpdate = findViewById(R.id.btnAdminEditUbah);
        tvNama = findViewById(R.id.txtAdminEditNmUser);

        mIntent = getIntent();
        id = mIntent.getIntExtra("id_tranksaksi",1);
        antar = mIntent.getIntExtra("antar",0);
        status = mIntent.getIntExtra("status",0);

        tvNama.setText(Integer.toString(id));

        edAntar.setText(Integer.toString(antar));
        edSatus.setText(Integer.toString(status));

        newAntar = Integer.parseInt(edAntar.getText().toString());
        newStatus = Integer.parseInt(edSatus.getText().toString());

        btpdate.setOnClickListener(new View.OnClickListener() {
            ApiInterface mApiInterface = ApiClient.getClient().create(ApiInterface.class);

            @Override
            public void onClick(View view) {
                Call<PutDelTranksaksi> mTra = mApiInterface.putTranksaksi(
                        mIntent.getIntExtra("id_tranksaksi",0),
                        Integer.parseInt(edAntar.getText().toString()),
                        Integer.parseInt(edSatus.getText().toString())
                );
                mTra.enqueue(new Callback<PutDelTranksaksi>() {
                    @Override
                    public void onResponse(Call<PutDelTranksaksi> call, Response<PutDelTranksaksi> response) {
                        String status = response.body().getStatus();
                        if (status.equals("success")) {
                        Toast.makeText(getApplicationContext(), "Suksess Ditambah", Toast.LENGTH_SHORT).show();
                        finish();
                        }
//                        mIntent = new Intent(getApplicationContext(),ListOrderActivity.class);
//                        startActivity(mIntent);
                    }

                    @Override
                    public void onFailure(Call<PutDelTranksaksi> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "error     " + t, Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });

    }
}
