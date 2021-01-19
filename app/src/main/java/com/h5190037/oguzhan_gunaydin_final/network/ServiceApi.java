package com.h5190037.oguzhan_gunaydin_final.network;

import com.h5190037.oguzhan_gunaydin_final.model.FirmaModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {

    @GET("company.json")
    Observable<List<FirmaModel>> firmalariGetir();
}
