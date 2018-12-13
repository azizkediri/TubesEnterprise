package com.example.abdazizs.go_loundry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.abdazizs.go_loundry.Admin.AdminHomeActivity;
import com.example.abdazizs.go_loundry.Customer.CustomerHomeActivity;
import com.example.abdazizs.go_loundry.Customer.TambahCustomerAcivity;

public class LoginActivity extends AppCompatActivity {
    Button btCustomer, btAdmin;
    TextView btDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btAdmin = findViewById(R.id.btnAdmin);
        btCustomer = findViewById(R.id.btnLogin);

        btDaftar = findViewById(R.id.btnTextSignUpCust);

        btDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), TambahCustomerAcivity.class);
                startActivity(i);
            }
        });

        btCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), CustomerHomeActivity.class);
                startActivity(i);
            }
        });

        btAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), AdminHomeActivity.class);
                startActivity(i);
            }
        });
    }
}
