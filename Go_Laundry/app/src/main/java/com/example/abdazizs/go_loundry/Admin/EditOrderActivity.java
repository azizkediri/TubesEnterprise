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

import com.example.abdazizs.go_loundry.Models.ResultTranksaksi;
import com.example.abdazizs.go_loundry.R;
import com.example.abdazizs.go_loundry.Rest.ApiClient;
import com.example.abdazizs.go_loundry.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditOrderActivity extends AppCompatActivity {
    Button btpdate, btBack;
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

        Intent mIntent = getIntent();
        id = mIntent.getIntExtra("id_tranksaksi",0);
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
                Call<ResultTranksaksi> mTra = mApiInterface.putTranksaksi(
                        id,
                        newAntar,
                        newStatus,"put" );
                mTra.enqueue(new Callback<ResultTranksaksi>() {
                    @Override
                    public void onResponse(Call<ResultTranksaksi> call, Response<ResultTranksaksi> response) {
                        Toast.makeText(getApplicationContext(), "Suksess Ditambah", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<ResultTranksaksi> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "error " + t, Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });

    }
}
