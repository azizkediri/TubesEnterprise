package com.example.abdazizs.go_loundry.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.abdazizs.go_loundry.Admin.EditOrderActivity;
import com.example.abdazizs.go_loundry.Models.GetTranksaksi;
import com.example.abdazizs.go_loundry.R;

import java.util.List;

public class RVAdminOrder  extends RecyclerView.Adapter<RVAdminOrder.ViewHolder>{
    List<GetTranksaksi> dftrTran;
    private Context mContext;

    public RVAdminOrder(){

    }
    public RVAdminOrder(List<GetTranksaksi> input, Context mContext){
        dftrTran =input;
        this.mContext = mContext;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        // di tutorial ini kita hanya menggunakan data String untuk tiapitem
        public TextView TvNama,tvAntar,tvStatus;

        public ViewHolder(View v) {
            super(v);
            TvNama = (TextView) v.findViewById(R.id.txtAdminListNamaCust);
            tvAntar =(TextView) v.findViewById(R.id.txtAdminListCustAntar);
            tvStatus=(TextView) v.findViewById(R.id.txtAdminListCustStatus);
        }
    }
    @Override
    public RVAdminOrder.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // membuat view baru
        View v =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_order, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter kelas_card lainnya
        RVAdminOrder.ViewHolder vh = new ViewHolder(v);

        return vh;
    }
    @Override
    public void onBindViewHolder(RVAdminOrder.ViewHolder holder, final int position) {
        GetTranksaksi k = dftrTran.get(position);
        String status = Integer.toString(k.getStatusLay());
        String antar = Integer.toString(k.getAntar());
        holder.TvNama.setText(k.getNama());
        holder.tvStatus.setText(status);
        holder.tvAntar.setText(antar);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), EditOrderActivity.class);
                intent.putExtra("id_tranksaksi", dftrTran.get(position).getIdTran());
                intent.putExtra("antar", dftrTran.get(position).getAntar());
                intent.putExtra("status", dftrTran.get(position).getStatusLay());
                view.getContext().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return dftrTran.size();
    }
}
