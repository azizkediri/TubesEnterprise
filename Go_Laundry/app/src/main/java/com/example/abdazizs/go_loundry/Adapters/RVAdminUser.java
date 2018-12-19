package com.example.abdazizs.go_loundry.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.abdazizs.go_loundry.Models.GetUser;
import com.example.abdazizs.go_loundry.R;

import java.util.List;

public class RVAdminUser extends RecyclerView.Adapter<RVAdminUser.ViewHolder>{

    List<GetUser> daftarcustomer;
    private Context mContext;

    public RVAdminUser(List<GetUser> input, Context mContext){
        daftarcustomer =input;
        this.mContext = mContext;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        // di tutorial ini kita hanya menggunakan data String untuk tiapitem
        public TextView TvNama,TvAlamat,TvTelpn;

        public ViewHolder(View v) {
            super(v);
            TvNama = (TextView) v.findViewById(R.id.txt_nama);
            TvAlamat =(TextView) v.findViewById(R.id.txt_alamat);
            TvTelpn=(TextView) v.findViewById(R.id.txt_telpn);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // membuat view baru
        View v =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_admin_user, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter kelas_card lainnya
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        GetUser k = daftarcustomer.get(position);
        holder.TvNama.setText(k.getNama());
        holder.TvAlamat.setText(k.getAlamat());
        holder.TvTelpn.setText(k.getTelpn());


    }

    @Override
    public int getItemCount() {
        // menghitung ukuran dataset / jumlah data yang ditampilkan di RecyclerView
        return daftarcustomer.size();
    }
}
