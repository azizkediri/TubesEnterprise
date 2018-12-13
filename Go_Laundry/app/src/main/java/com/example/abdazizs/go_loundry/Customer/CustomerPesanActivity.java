package com.example.abdazizs.go_loundry.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.abdazizs.go_loundry.R;

public class CustomerPesanActivity extends AppCompatActivity {
    Button btPesanDetail;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_pesan);
        btPesanDetail = findViewById(R.id.btnCustPesanDetail);

        btPesanDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(getApplicationContext(), CustomerCekActivity.class);
                startActivity(i);
            }
        });

    }
}
