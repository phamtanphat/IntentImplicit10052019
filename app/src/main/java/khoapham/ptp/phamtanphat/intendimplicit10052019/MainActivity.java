package khoapham.ptp.phamtanphat.intendimplicit10052019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnWifi;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWifi = findViewById(R.id.buttonCheckwifi);

        btnWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                startActivity(intent);
            }
        });
        if (isConnectingToInternet()){
            Log.d("BBB","Có internet");
        }else if (isConnectingToWifi()){
            Log.d("BBB","Có wifi");
        }
    }
    private boolean isConnectingToInternet() {
        ConnectivityManager connectivity = (ConnectivityManager) MainActivity.this
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }

        }
        return false;
    }

    private boolean isConnectingToWifi() {
        ConnectivityManager connManager = (ConnectivityManager) MainActivity.this
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mWifi = connManager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (mWifi != null) {
            if (mWifi.getState() == NetworkInfo.State.CONNECTED)
                return true;
        }
        return false;
    }
}
