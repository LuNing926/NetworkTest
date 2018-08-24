package appstore.openthos.com.networktest;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Binder;
import android.os.Handler;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends Activity {

    private RadioButton mRbSync, mRbDesync;
    public ExecutorService mSingleThreadPool;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Handler handler;
//
//        mSingleThreadPool = Executors.newSingleThreadExecutor();
//        Thread thread = new Thread() {
//
//            @Override
//            public void run() {
//                super.run();
//            }
//        };
//        mSingleThreadPool.execute(thread);
//
//        mRbSync = (RadioButton) findViewById(R.id.rb_sync);
//        mRbDesync = (RadioButton) findViewById(R.id.rb_desync);
//        mRbSync.setClickable(false);
//        mRbSync.setEnabled(true);
//
//        mRbSync.setVisibility(View.VISIBLE);
//        CloudInfoDialog cloudInfoDialog = new CloudInfoDialog(this);
//        cloudInfoDialog.show();
//        NetworkReceiver networkReceiver = new NetworkReceiver();
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
//        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
//        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
//        registerReceiver(networkReceiver, intentFilter);


    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private class NetworkReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            HttpsURLConnection j;
            switch (intent.getAction()) {
                case ConnectivityManager.CONNECTIVITY_ACTION:
                    ConnectivityManager manager = (ConnectivityManager) context
                            .getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
                    if (activeNetwork != null) { // connected to the internet
                        if (activeNetwork.isConnected()) {
                            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                                // connected to the mobile provider's data plan
                            }
                            Log.e("WWWWWWWWWWWW", "---isConnected ");
                            "".replace("", "");
                        } else {
                            Log.e("WWWWWWWWWWWW", "---!isConnected ");
                        }

                        Log.e("WWWWWWWWWWWW", "---activeNetwork != null");
//                        Log.e("WWWWWWWWWWWW", "getSubtypeName()" + activeNetwork.getSubtypeName());
//                        Log.e("WWWWWWWWWWWW", "getState()" + activeNetwork.getState());
//                        Log.e("WWWWWWWWWWWW", "getDetailedState()"
//                                + activeNetwork.getDetailedState().name());
//                        Log.e("WWWWWWWWWWWW", "getDetailedState()" + activeNetwork.getExtraInfo());
//                        Log.e("WWWWWWWWWWWW", "getType()" + activeNetwork.getType());
                    } else {   // not connected to the internet
                        Log.e("WWWWWWWWWWWW", "---activeNetwork == null");
                    }
                    break;
            }
        }
    }

    private class ClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.rb_sync:
//                    new Binder().transact();
                    break;
                case R.id.rb_desync:
                    break;
            }
        }
    }


    class jjj extends Binder {
        @Override
        protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            return super.onTransact(code, data, reply, flags);
        }
    }
}
