package appstore.openthos.com.networktest;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by ln on 18-1-22.
 */

public class TestFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SettingsApplication settingsApplication = (SettingsApplication) getActivity().getApplication();
    }
}
