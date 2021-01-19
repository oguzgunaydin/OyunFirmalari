package com.h5190037.oguzhan_gunaydin_final.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.h5190037.oguzhan_gunaydin_final.R;
import com.h5190037.oguzhan_gunaydin_final.adapter.FirmaAdaptor;
import com.h5190037.oguzhan_gunaydin_final.model.FirmaModel;
import com.h5190037.oguzhan_gunaydin_final.network.Service;
import com.h5190037.oguzhan_gunaydin_final.util.AlertDialogUtil;
import com.h5190037.oguzhan_gunaydin_final.util.Constants;
import com.h5190037.oguzhan_gunaydin_final.util.ObjectUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListeActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);

        init();

    }

    private  void  init()
    {
        firmalariGetir();
        progressDialog = new ProgressDialog(ListeActivity.this);
        progressDialog.setMessage(getResources().getString(R.string.app_wait));
        progressDialog.show();
    }

    @Override
    public void onBackPressed() {
        AlertDialogUtil.alertDialogShow(ListeActivity.this, getResources().getString(R.string.app_extBtn),getResources().getString(R.string.app_extMsg),getResources().getString(R.string.app_yes),getResources().getString(R.string.app_no),getResources().getString(R.string.app_listeEkranBilgi));
    }


    void  firmalariGetir()
    {

        new Service().getServiceApi().firmalariGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<FirmaModel>>() {

                    List<FirmaModel> firmalar=new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("RETROFIT","onSubscribe : ");
                    }

                    @Override
                    public void onNext(List<FirmaModel> firmaList) {
                        Log.e("RETROFIT","onNext : ");
                        firmalar = firmaList;
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e("RETROFIT","onError : " + e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete()
                    {
                        Log.e("RETROFIT","onComplete : ");

                        if(firmalar.size()>0) {
                            initRecycleView(firmalar);
                            progressDialog.dismiss();
                        }

                    }
                });
    }


    private  void  initRecycleView(List<FirmaModel> firmaList)
    {

        recyclerView =findViewById(R.id.rcvFirmalar);
        FirmaAdaptor firmaAdaptor =new FirmaAdaptor(firmaList, getApplicationContext(), new FirmaAdaptor.OnItemClickListener() {
            @Override
            public void onClick(int position) {

                FirmaModel tiklananFirma = firmaList.get(position);
                openNextActivity(tiklananFirma);

            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(firmaAdaptor);
    }

    private void openNextActivity(FirmaModel tiklananFirma){

        Intent secondActivityIntent = new Intent(getApplicationContext(),DetayActivity.class);
        String tiklananFirmaString = ObjectUtil.firmaToJsonString(tiklananFirma);
        secondActivityIntent.putExtra(Constants.TIKLANAN_FIRMA_TASINANIN_BASLIGI, tiklananFirmaString );
        startActivity(secondActivityIntent);

    }
}