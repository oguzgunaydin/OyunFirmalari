package com.h5190037.oguzhan_gunaydin_final.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190037.oguzhan_gunaydin_final.R;

public class FirmaViewHolder extends RecyclerView.ViewHolder {

        ImageView imgFirma;
        TextView txtFirmaAdi;
        TextView txtKurulusTarihi;
        TextView txtKurulusYeri;

        public FirmaViewHolder(@NonNull View itemView, FirmaAdaptor.OnItemClickListener listener) {
            super(itemView);

            imgFirma = itemView.findViewById(R.id.imgFirma);
            txtFirmaAdi = itemView.findViewById(R.id.txtFirmaAdi);
            txtKurulusTarihi = itemView.findViewById(R.id.txtKurulusTarihi);
            txtKurulusYeri = itemView.findViewById(R.id.txtKurulusYeri);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    listener.onClick(getAdapterPosition());
                }
            });
        }



}
