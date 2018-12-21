package com.example.abdazizs.go_loundry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abdazizs.go_loundry.Admin.AdminHomeActivity;
import com.example.abdazizs.go_loundry.Customer.CRUD.CustomerAddData;
import com.example.abdazizs.go_loundry.Customer.CustomerHomeActivity;
import com.example.abdazizs.go_loundry.Models.GetUser;
import com.example.abdazizs.go_loundry.Models.PutDelUser;
import com.example.abdazizs.go_loundry.Models.ResultUser;
import com.example.abdazizs.go_loundry.Rest.ApiClient;
import com.example.abdazizs.go_loundry.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Button btLogin, btAdmin;
    //EditText edNama, edPass;
    TextView btDaftar;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btLogin = findViewById(R.id.btnLogin);
        btDaftar = findViewById(R.id.btnTextSignUpCust);
        btAdmin = findViewById(R.id.btnAdmin);
        final EditText nama_cust = findViewById(R.id.editUsernameLog);
        final EditText password = findViewById(R.id.editPassLog);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Call<PutDelUser> t = mApiInterface.getLogin(nama_cust.getText().toString(),password.getText().toString());
                t.enqueue(new Callback<PutDelUser>() {
                    @Override
                    public void onResponse(Call<PutDelUser> call, Response<PutDelUser> response) {
                        String status = response.body().getStatus();
                        if (status.equals("Berhasil")) {
                            GetUser cstmr = response.body().getUser();

                            if (cstmr.getLevel()==1) {
                                Intent i = new Intent(getApplicationContext(), AdminHomeActivity.class);
                                i.putExtra("nama",nama_cust.getText().toString());
                                i.putExtra("id",cstmr.getId());
                                startActivity(i);
                                finish();
                            } else {
                                Intent i =new Intent(getApplicationContext(), CustomerHomeActivity.class);
                                i.putExtra("nama",nama_cust.getText().toString());
                                startActivity(i);
                                finish();

                            }

                        } else {
                            Toast.makeText(getApplicationContext(), "Fail Login", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<PutDelUser> call, Throwable t) {

                        Toast.makeText(getApplicationContext(),"error"+t,Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });

        btDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), CustomerAddData.class);
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
