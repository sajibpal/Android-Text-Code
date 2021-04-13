package com.example.sajibpal.appupdateforce;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by sajib pal on 11/1/2019.
 */

class UpdateMeeDialog {

    ActivityManager am;
    TextView rootName;
    Context context;
    Dialog dialog;
    String key1,schoolId;
    public void showDialogAddRoute(Activity activity, final String packageName){
        context=activity;
        dialog = new Dialog(context);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_update);
        am = (ActivityManager)activity.getSystemService(Context.ACTIVITY_SERVICE);

        Button cancelDialogue=(Button)dialog.findViewById(R.id.buttonUpdate);
        Log.i("package name",packageName);
        cancelDialogue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://play.google.com/store/apps/details?"+"id=+com.example.sajibpal.appupdateforce+&hl=en"));
                        context.startActivity(intent);
            }
        });
        dialog.show();
    }

}
