package com.h5190037.oguzhan_gunaydin_final.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190037.oguzhan_gunaydin_final.R;
import com.h5190037.oguzhan_gunaydin_final.model.FirmaModel;
import com.h5190037.oguzhan_gunaydin_final.util.GlideUtil;

import java.util.List;

public class
FirmaAdaptor extends RecyclerView.Adapter<FirmaViewHolder> {

    List<FirmaModel> firmalar;
    Context context;
    OnItemClickListener listener;

    public interface  OnItemClickListener {
        void onClick(int position);
    }

    public FirmaAdaptor(List<FirmaModel> firmalar, Context context, OnItemClickListener listener){
        this.firmalar = firmalar;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FirmaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_firma,parent, false);
        return new FirmaViewHolder(itemView, listener);
    }


    @Override
    public void onBindViewHolder(@NonNull FirmaViewHolder viewHolder, int position){

        viewHolder.txtFirmaAdi.setText(firmalar.get(position).getCompanyName());
        viewHolder.txtKurulusTarihi.setText(firmalar.get(position).getReleaseDate());
        viewHolder.txtKurulusYeri.setText(firmalar.get(position).getCountry());
        GlideUtil.resimIndiripGoster(context,firmalar.get(position).getLogoUrl(),viewHolder.imgFirma);

    }
    @Override
    public int getItemCount() {
        return firmalar.size();
    }
}
