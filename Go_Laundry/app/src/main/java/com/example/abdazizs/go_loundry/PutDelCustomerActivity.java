package com.example.abdazizs.go_loundry;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.abdazizs.networking.Models.ResultPembeli;
import com.example.abdazizs.networking.Rest.ApiClient;
import com.example.abdazizs.networking.Rest.ApiInterface;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//import com.squareup.picasso.Picasso;

public class PutDelCustomerActivity extends AppCompatActivity {
    ImageView mPhotoid, mImageView;
    EditText edtIdPembeli, edtNama, edtAlamat, edtTelpn;
    TextView tvMessage;
    Context mContext;
    Button btUpdate, btDelete, btBack, btPhotoId;
    String pathImage="";
    String imagePath="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_del_user);
        mContext = getApplicationContext();
        mPhotoid = (ImageView) findViewById(R.id.imgPhotoIdv);
        mImageView = (ImageView) findViewById(R.id.imgPhotoIdv);
        edtIdPembeli = (EditText) findViewById(R.id.edtIdPembeli);
        edtNama = (EditText) findViewById(R.id.edtNamaPembeli);
        edtAlamat = (EditText) findViewById(R.id.edtAlamatPembeli);
        edtTelpn = (EditText) findViewById(R.id.edtTelpnPembeli);
        tvMessage = (TextView) findViewById(R.id.tvMessage);
        btUpdate = (Button) findViewById(R.id.btUpdate);
        btDelete = (Button) findViewById(R.id.btDelete);
        btBack = (Button) findViewById(R.id.btBack);
        btPhotoId = (Button) findViewById(R.id.btPhotoId);
        Intent mIntent = getIntent();
        edtIdPembeli.setText(mIntent.getStringExtra("id_pembeli"));
        edtNama.setText(mIntent.getStringExtra("nama"));
        edtAlamat.setText(mIntent.getStringExtra("alamat"));
        edtTelpn.setText(mIntent.getStringExtra("telpn"));
         if (mIntent.getStringExtra("photo_id").length()>0)
//        Picasso.with(mContext).load(ApiClient.BASE_upload + mIntent.getStringExtra("photo_id")).into(mPhotoid);
//        else Picasso.with(mContext).load(R.drawable.photoid).into(mPhotoid);
        if (mIntent.getStringExtra("photo_id").length()>0){
            Glide.with(mContext).load(ApiClient.BASE_upload + mIntent.getStringExtra("photo_id")).into(mPhotoid);
        }
        else{
            Glide.with(mContext).load(R.drawable.photoid).into(mPhotoid);
        }
        pathImage = mIntent.getStringExtra("photo_id");
        setListener();
    }
    private void setListener() {
        final ApiInterface mApiInterface =
                ApiClient.getClient().create(ApiInterface.class);
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MultipartBody.Part body = null;
//dicek apakah image sama dengan yang ada di server atau berubah
//jika sama dikirim lagi jika berbeda akan dikirim ke server
                if
                        ((pathImage.contains("upload/"+edtIdPembeli.getText().toString())==false)&&(pathImage.length()>0)){
//File creating from selected URL
                    File file = new File(pathImage);
// create RequestBody instance from file
                    RequestBody requestFile =
                            RequestBody.create(MediaType.parse("multipart/form-data"), file);
// MultipartBody.Part is used to send also the actual file name
                    body = MultipartBody.Part.createFormData("photo_id", file.getName(), requestFile);
                }
                RequestBody reqIdPembeli =
                        MultipartBody.create(MediaType.parse("multipart/form-data"),
                                (edtIdPembeli.getText().toString().isEmpty()==true)?"":edtIdPembeli.getText().toString());
                RequestBody reqNama =
                        MultipartBody.create(MediaType.parse("multipart/form-data"),
                                (edtNama.getText().toString().isEmpty()==true)?"":edtNama.getText().toString());
                RequestBody reqAlamat =
                        MultipartBody.create(MediaType.parse("multipart/form-data"),
                                (edtAlamat.getText().toString().isEmpty()==true)?"":edtAlamat.getText().toString());
                RequestBody reqTelpn =
                        MultipartBody.create(MediaType.parse("multipart/form-data"),
                                (edtTelpn.getText().toString().isEmpty()==true)?"":edtTelpn.getText().toString());
                RequestBody reqAction =
                        MultipartBody.create(MediaType.parse("multipart/form-data"),
                                "put");
                Call<ResultPembeli> callUpdate = mApiInterface.putPembeli(body, reqIdPembeli,
                        reqNama, reqAlamat, reqTelpn,
                        reqAction);
                callUpdate.enqueue(new Callback<ResultPembeli>() {
                    @Override
                    public void onResponse(Call<ResultPembeli> call, Response<ResultPembeli>
                            response) {
//Log.d("Update Retrofit ", response.body().getStatus());
                        if (response.body().getStatus().equals("failed")){
                            tvMessage.setText("Retrofit Update \n Status = "+response.body().getStatus()+"\n"+
                                    "Message = "+response.body().getMessage()+"\n");
                        }else{
                            String detail = "\n"+ "id_pembeli = "+response.body().getResult().get(0).getIdPembeli()
                                    +"\n"+ "agama = "+response.body().getResult().get(0).getNama()
                                    +"\n"+ "alamat = "+response.body().getResult().get(0).getAlamat()
                                    +"\n"+ "telpn = "+response.body().getResult().get(0).getTelpn()
                                    +"\n"+ "photo_id = "+response.body().getResult().get(0).getPhotoId()
                                    +"\n";tvMessage.setText("Retrofit Update \n Status = "+response.body().getStatus()
                                    +"\n"+ "Message = "+response.body().getMessage()+detail);
                        }
                    }
                    @Override
                    public void onFailure(Call<ResultPembeli> call, Throwable t) {
//Log.d("Update Retrofit ", t.getMessage());
                        tvMessage.setText("Retrofit Update \n Status = "+ t.getMessage());
                    }
                });
            }
        });
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestBody reqIdPembeli =
                        MultipartBody.create(MediaType.parse("multipart/form-data"),
                                (edtIdPembeli.getText().toString().isEmpty()==true)?"":edtIdPembeli.getText().toString())
                        ;
                RequestBody reqAction =
                        MultipartBody.create(MediaType.parse("multipart/form-data"),"delete");
                Call<ResultPembeli> callDelete =
                        mApiInterface.deletePembeli(reqIdPembeli,reqAction);
                callDelete.enqueue(new Callback<ResultPembeli>() {
                    @Override
                    public void onResponse(Call<ResultPembeli> call,
                                           Response<ResultPembeli> response)
                    { tvMessage.setText("Retrofit Delete \n Status = "+response.body().getStatus() +"\n"+ "Message = "+response.body().getMessage()+"\n");
                    }
                    @Override
                    public void onFailure(Call<ResultPembeli> call, Throwable t) {
                        tvMessage.setText("Retrofit Delete \n Status = "+ t.getMessage());
                    }
                });
            }
        });
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tempIntent = new Intent(mContext, GetCustomerActivity.class);
                startActivity(tempIntent);
            }
        });
        btPhotoId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent galleryIntent = new Intent();
                galleryIntent.setType("image/*");
                galleryIntent.setAction(Intent.ACTION_PICK);
                Intent intentChoose = Intent.createChooser(galleryIntent, "Pilih Gamb Untuk Di upload");
                        startActivityForResult(intentChoose, 10);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode ==10) {
            if (data == null) {
                Toast.makeText(mContext, "Gambar Gagal Di load",
                        Toast.LENGTH_LONG).show();
                return;
            }
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn,
                    null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                pathImage = cursor.getString(columnIndex);
                //Picasso.with(mContext).load(new File(imagePath)).fit().into(mImageView);
                Glide.with(mContext).load(new File(pathImage)).into(mPhotoid);
                cursor.close();
            } else {
                Toast.makeText(mContext, "Gambar Gagal Di load", Toast.LENGTH_LONG).show();
            }
        }
    }
}