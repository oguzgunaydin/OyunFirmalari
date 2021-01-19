package com.h5190037.oguzhan_gunaydin_final.util;

import com.google.gson.Gson;
import com.h5190037.oguzhan_gunaydin_final.model.FirmaModel;

public class ObjectUtil {

    public static String firmaToJsonString(FirmaModel firmaModel)
    {
        Gson gson = new Gson();
        return gson.toJson(firmaModel);
    }

    public static FirmaModel jsonStringToBurc(String jsonString)
    {
        Gson gson = new Gson();
        return gson.fromJson(jsonString,FirmaModel.class);
    }
}
