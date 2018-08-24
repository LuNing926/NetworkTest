package appstore.openthos.com.networktest;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class CloudInfoDialog extends Dialog {
    private Context mContext;
    private String mUsbs;

    public CloudInfoDialog(@NonNull Context context) {
        super(context);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_cloud_info);
        getWindow().setBackgroundDrawable(mContext.getResources().
                                          getDrawable(R.color.colorPrimary));
        initBody();
        initFoot();
    }

    private void initBody() {
        TextView size = (TextView) findViewById(R.id.size);
        TextView sizeOnDisk = (TextView) findViewById(R.id.size_on_disk);

        size.setText("seafile001@163.com");
    }

    private void initFoot() {
        TextView confirm = (TextView) findViewById(R.id.confirm);
        View.OnClickListener click= new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dismiss();
            }
        };
        confirm.setOnClickListener(click);
    }
}
