package com.example.sajibpal.appupdateforce;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import org.jsoup.Jsoup;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            versionChecker VersionChecker = new versionChecker();
            String versionUpdated = VersionChecker.execute().get().toString();
            Log.i("version code is", versionUpdated);


            PackageInfo packageInfo = null;
            try {
                packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            int version_code = packageInfo.versionCode;
            String version_name = packageInfo.versionName;
            Log.i("updated version code", String.valueOf(version_code) + "  " + version_name);
            if (version_name != versionUpdated) {
                String packageName = getApplicationContext().getPackageName();
                UpdateMeeDialog updateMeeDialog = new UpdateMeeDialog();
                updateMeeDialog.showDialogAddRoute(MainActivity.this, packageName);
                Toast.makeText(getApplicationContext(), "please updated", Toast.LENGTH_LONG).show();
            }

        } catch (Exception e) {
            e.getStackTrace();
        }
    }


    class versionChecker extends AsyncTask<String, String, String> {
        String newVersion;

        @Override
        protected String doInBackground(String... params) {

            try {

                newVersion = Jsoup.connect("https://play.google.com/store/apps/details?"+"id=+com.example.sajibpal.appupdateforce+&hl=en")
                        .timeout(30000)
                        .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                        .referrer("http://www.google.com")
                        .get()
                        .select("div[itemprop=softwareVersion]")
                        .first()
                        .ownText();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return newVersion;
        }
    }
}
