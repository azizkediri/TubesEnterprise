package com.example.abdazizs.go_loundry.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.abdazizs.go_loundry.R;

public class CustomerHomeActivity extends AppCompatActivity {
    private Button btPesan, btnCek;
    TextView tvNama;
    private Intent mInt;
    int id;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home);
        btPesan = findViewById(R.id.btnAdminListOrder);
        btnCek = findViewById(R.id.btnCustomerCek);
        tvNama = findViewById(R.id.txtCustHomeNama);
        mInt = getIntent();
        tvNama.setText(mInt.getStringExtra("nama"));
        id = mInt.getIntExtra("id",0);
        btPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), CustomerPesanActivity.class);
                i.putExtra("nama",mInt.getStringExtra("nama"));
                i.putExtra("id",id);
                startActivity(i);
            }
        });

//        btnCek.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(getApplicationContext(), CustomerPesanDetailActivity.class);
//                startActivity(i);
//            }
//        });

    }
}
