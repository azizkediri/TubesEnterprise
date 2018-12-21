package com.example.abdazizs.go_loundry.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.abdazizs.go_loundry.R;

public class CustomerPesanActivity extends AppCompatActivity implements View.OnClickListener {
    Button btPesanDetail;
    private RadioButton rbCuci, rbSetrika, rbXpress, rbAntar;
    private int cuci, setrika, xpress, antar;
    private String nama;
    private Intent mInt;
    int id;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_pesan);
        btPesanDetail = findViewById(R.id.btnCustAddPesan);


        rbCuci = findViewById(R.id.radCuci);
        rbSetrika = findViewById(R.id.radSetrika);
        rbXpress = findViewById(R.id.radXpress);
        rbAntar = findViewById(R.id.radAntar);

        rbCuci.setOnClickListener(this);
        rbSetrika.setOnClickListener(this);
        rbXpress.setOnClickListener(this);
        rbAntar.setOnClickListener(this);

        mInt = getIntent();
        nama = mInt.getStringExtra("nama");
        id = mInt.getIntExtra("id",0);



        btPesanDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(getApplicationContext(), CustomerPesanDetailActivity.class);
                if (rbAntar.isChecked()){
                    antar = 1;
                }else{
                    antar = 0;
                }
                if (rbCuci.isChecked()){
                    cuci = 1;
                }else{
                    cuci = 0;
                }
                if (rbSetrika.isChecked()){
                    setrika = 1;
                }else{
                    setrika = 0;
                }
                if (rbXpress.isChecked()){
                    xpress = 1;
                }else{
                    xpress = 0;
                }

                i.putExtra("cuci",cuci);
                i.putExtra("setrika",setrika);
                i.putExtra("antar",antar);
                i.putExtra("xpress",xpress);
                i.putExtra("nama",nama);


                startActivity(i);
            }
        });

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.radCuci:
                if (rbCuci.isSelected()){
                    rbCuci.setSelected(false);
                    rbCuci.setChecked(false);
                }else {
                    rbCuci.setSelected(true);
                    rbCuci.setChecked(true);
                }
                break;
            case R.id.radSetrika:
                if (rbSetrika.isSelected()){
                    rbSetrika.setSelected(false);
                    rbSetrika.setChecked(false);
                }else {
                    rbSetrika.setSelected(true);
                    rbSetrika.setChecked(true);
                }
                break;
            case R.id.radXpress:
                if (rbXpress.isSelected()){
                    rbXpress.setSelected(false);
                    rbXpress.setChecked(false);
                }else {
                    rbXpress.setSelected(true);
                    rbXpress.setChecked(true);
                }
                break;
            case R.id.radAntar:
                if (rbAntar.isSelected()){
                    rbAntar.setSelected(false);
                    rbAntar.setChecked(false);
                }else {
                    rbAntar.setSelected(true);
                    rbAntar.setChecked(true);
                }
                break;
        }
    }
}
