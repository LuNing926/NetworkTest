package appstore.openthos.com.networktest;

import android.app.Dialog;
import android.app.Service;
import android.app.WallpaperInfo;
import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by ln on 18-2-26.
 */

public class MySeavice extends Service {

    private String[] shareObj = { "true" };
    IClient mClient;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    IService.Stub mBinder = new IService.Stub() {
        @Override
        public void set(String s, IClient i) throws RemoteException {
            mClient = i;
            Log.d("aaaaaaa", "---------------" + s);
//            i.get("gggggggggggggg");
            mClient.get("uuuuuuuuu");
        }
    };

    private class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            synchronized (shareObj) {
                try {
                    shareObj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test();
            }
        }
    }
    @Override
    public void onCreate() {
        super.onCreate();
//        MyThread myThread = new MyThread();
//        myThread.start();
//
//        try {
//            myThread.wait(30000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        MyDialog dialog = new MyDialog(this);
//        dialog.isShowing();

    }

    private class MyDialog extends Dialog {

        public MyDialog(@NonNull Context context) {
            super(context);
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }
    }

    private class SeafileServiceConnection implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            synchronized (shareObj) {
                shareObj.notify();
                shareObj[0] = "false";
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }

    private void test() {
        getPackageManager();
        WallpaperManager.getInstance(this);
        sendBroadcast(new Intent());
        Toast.makeText(this, getResources().getString(R.string.app_name), Toast.LENGTH_SHORT).show();
    }
}
