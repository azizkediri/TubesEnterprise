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
import com.example.abdazizs.go_loundry.Models.ResultUser;
import com.example.abdazizs.go_loundry.Rest.ApiClient;
import com.example.abdazizs.go_loundry.Rest.ApiInterface;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddDataCustomer extends AppCompatActivity {
    Context mContext;
    ImageView mImageView;
    Button btAddPhotoId, btAddBack, btAddData;
    EditText edPassUser, edtAddNamaCustomer, edtAddAlamatCustomer;
    EditText edtAddTelpnCustomer;
    TextView tvAddMessage;
    String imagePath = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data_user);
        mContext = getApplicationContext();
        mImageView = (ImageView) findViewById(R.id.imgAddPhotoIdv);
        btAddPhotoId = (Button) findViewById(R.id.btAddPhotoId);
        edPassUser = (EditText) findViewById(R.id.edtAddPassCustomer);
        edtAddNamaCustomer = (EditText) findViewById(R.id.edtAddNamaPembeli);
        edtAddAlamatCustomer = (EditText) findViewById(R.id.edtAddAlamatPembeli);
        edtAddTelpnCustomer = (EditText) findViewById(R.id.edtAddTelpnPembeli);
        btAddData = (Button) findViewById(R.id.btnAddData);
        btAddBack = (Button) findViewById(R.id.btAddBack);
        tvAddMessage = (TextView) findViewById(R.id.tvAddMessage);
        btAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiInterface mApiInterface = ApiClient.getClient().create(ApiInterface.class);
                MultipartBody.Part body = null;
                if (!imagePath.isEmpty()){
//File creating from selected URL
                    File file = new File(imagePath);
// create RequestBody instance from file
                    RequestBody requestFile =  RequestBody.create(MediaType.parse("multipart/form-data"), file);
// MultipartBody.Part is used to send also the actual file name
                    body = MultipartBody.Part.createFormData("photo_id", file.getName(), requestFile);
                }

                RequestBody reqNama = MultipartBody.create(MediaType.parse("multipart/form-data"),
                        (edtAddNamaCustomer.getText().toString().isEmpty())?"":edtAddNamaCustomer.getText().toString());
                RequestBody reqAlamat = MultipartBody.create(MediaType.parse("multipart/form-data"),
                        (edtAddNamaCustomer.getText().toString().isEmpty())?"":edtAddAlamatCustomer.getText().toString());
                RequestBody reqTelpn = MultipartBody.create(MediaType.parse("multipart/form-data"),
                        (edtAddNamaCustomer.getText().toString().isEmpty())?"":edtAddTelpnCustomer.getText().toString());
                RequestBody reqPass = MultipartBody.create(MediaType.parse("multipart/form-data"),
                        (edtAddNamaCustomer.getText().toString().isEmpty())?"":edPassUser.getText().toString());
                RequestBody reqAction = MultipartBody.create(MediaType.parse("multipart/form-data"), "post");
                Call<ResultUser> mUserCall = mApiInterface.postUser(body, reqNama, reqAlamat, reqTelpn, reqPass, reqAction,"0" );
                mUserCall.enqueue(new Callback<ResultUser>() {
                    @Override
                    public void onResponse(Call<ResultUser> call,Response<ResultUser> response) {
// Log.d("Insert Retrofit",response.body().getStatus());
                        if (response.body().getStatus().isEmpty()){
                            tvAddMessage.setText("Retrofit Update \n Status = "+response.body().getStatus()
                                    +"\n"+ "Message ="+response.body().getMessage()+"\n");
                        }else{
                            String detail = "\n"+
                                    "nama = "+response.body().getResult().get(0).getNama()
                                    +"\n"+ "alamat = "+response.body().getResult().get(0).getAlamat()
                                    +"\n"+ "telpn = "+response.body().getResult().get(0).getTelpn()
                                    +"\n"+ "photo_id = "+response.body().getResult().get(0).getPhotoId()
                                    +"\n";tvAddMessage.setText("Retrofit Update \n Status = "+response.body().getStatus()
                                    +"\n"+ "Message = "+response.body().getMessage()+detail);
                        }
                    }
                    @Override
                    public void onFailure(Call<ResultUser> call, Throwable t) {
// Log.d("Insert Retrofit", t.getMessage());
                        tvAddMessage.setText("Retrofit Update \n Status = "+ t.getMessage());
                    }
                });
            }
        });
        btAddBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, GetCustomerActivity.class);
                startActivity(intent);
            }
        });
        btAddPhotoId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent galleryIntent = new Intent();
                galleryIntent.setType("image/*");
                galleryIntent.setAction(Intent.ACTION_PICK);
                Intent intentChoose = Intent.createChooser(galleryIntent, "Pilih Gambar Untuk Di upload");
                startActivityForResult(intentChoose, 10);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode ==10){
            if (data==null){
                Toast.makeText(mContext, "Gambar Gagal Di load", Toast.LENGTH_LONG).show();
                return;
            }
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imagePath =cursor.getString(columnIndex);
                //Picasso.with(mContext).load(new File(imagePath)).fit().into(mImageView);
                Glide.with(mContext).load(new File(imagePath)).into(mImageView);
                cursor.close();
            }else{
                Toast.makeText(mContext, "Gambar Gagal Di load", Toast.LENGTH_LONG).show();
            }
        }
    }
}