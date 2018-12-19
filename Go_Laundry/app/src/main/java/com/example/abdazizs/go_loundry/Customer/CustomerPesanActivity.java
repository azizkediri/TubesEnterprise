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
    RadioButton rbCuci, rbSetrika, rbXpress, rbAntar;
    private int cuci, setrika, xpress, antar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_pesan);
        btPesanDetail = findViewById(R.id.btnCustAddPesan);


        rbCuci = findViewById(R.id.radCuci);
        rbSetrika = findViewById(R.id.radSetrika);
        rbXpress = findViewById(R.id.radXpress);
        rbAntar = findViewById(R.id.radAntar);

        btPesanDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(getApplicationContext(), CustomerPesanDetailActivity.class);
                if (rbAntar.isSelected()){
                    antar = 1;
                }
                if (rbCuci.isSelected()){
                    cuci = 1;
                }
                if (rbSetrika.isSelected()){
                    setrika = 1;
                }
                if (rbXpress.isSelected()){
                    xpress = 1;
                }

                i.putExtra("cuci",cuci);
                i.putExtra("setrika",setrika);
                i.putExtra("antar",antar);
                i.putExtra("xpress",xpress);

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
