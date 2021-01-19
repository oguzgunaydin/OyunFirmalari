package com.h5190037.oguzhan_gunaydin_final.util;

import android.app.Activity;
import android.app.AlertDialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;

import com.h5190037.oguzhan_gunaydin_final.R;

public class AlertDialogUtil {

        public static void alertDialogShow(Context context, String title, String message, String yes, String no ,String screen)
        {
            AlertDialog.Builder builder =new AlertDialog.Builder(context);
            builder.setTitle(title);
            builder.setMessage(message);
            builder.setPositiveButton(yes, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface window, int i) {
                    if(screen.toString() == context.getResources().getString(R.string.app_splashEkranBilgi)){
                        context.startActivity(new Intent(android.provider.Settings.ACTION_SETTINGS));
                    }
                    else{
                        ((Activity)context).onBackPressed();
                        ((Activity)context).finish();
                    }

                }
            });

            builder.setNegativeButton(no, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface window, int i) {
                    if(screen.toString() == context.getResources().getString(R.string.app_splashEkranBilgi)){
                        ((Activity)context).finish();
                    }
                    else{
                        window.dismiss();
                    }

                }
            });
            builder.show();
        }




}
