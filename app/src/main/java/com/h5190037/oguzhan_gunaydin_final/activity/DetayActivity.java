package com.h5190037.oguzhan_gunaydin_final.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.h5190037.oguzhan_gunaydin_final.R;
import com.h5190037.oguzhan_gunaydin_final.model.FirmaModel;
import com.h5190037.oguzhan_gunaydin_final.util.Constants;
import com.h5190037.oguzhan_gunaydin_final.util.GlideUtil;
import com.h5190037.oguzhan_gunaydin_final.util.ObjectUtil;

public class DetayActivity extends AppCompatActivity {

    ImageView imgDetayKapak;
    TextView txtBaslik;
    TextView txtDetay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);
        init();

    }

    private void init() {

        String tasinanFirmaString = getIntent().getStringExtra(Constants.TIKLANAN_FIRMA_TASINANIN_BASLIGI);
        FirmaModel firmaModel = ObjectUtil.jsonStringToBurc(tasinanFirmaString);

        imgDetayKapak = findViewById(R.id.imgDetayKapak);
        txtBaslik = findViewById(R.id.txtBaslik);
        txtDetay = findViewById(R.id.txtDetay);

        txtBaslik.setText(firmaModel.getCompanyName());
        txtDetay.setText(firmaModel.getDescription());
        GlideUtil.resimIndiripGoster(getApplicationContext(),firmaModel.getHeaderUrl(),imgDetayKapak);

    }

}
