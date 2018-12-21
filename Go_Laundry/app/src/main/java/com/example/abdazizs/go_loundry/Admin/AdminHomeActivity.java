package com.example.abdazizs.go_loundry.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.abdazizs.go_loundry.R;

public class AdminHomeActivity extends AppCompatActivity {
    TextView tvNama;
    Button btProfil, btListOder, btListCust;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        btProfil = findViewById(R.id.btnAdminProfil);
        btListCust = findViewById(R.id.btnAdminListCust);
        btListOder = findViewById(R.id.btnAdminListOrder);
        tvNama = findViewById(R.id.txtAdminHomeNama);

        btListCust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),ListCustomer.class);
                startActivity(i);
            }
        });
        btListOder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ListOrderActivity.class);
                startActivity(i);
            }
        });

    }
}
