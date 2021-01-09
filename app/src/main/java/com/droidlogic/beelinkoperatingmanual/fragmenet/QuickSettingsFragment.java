package com.droidlogic.beelinkoperatingmanual.fragmenet;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.droidlogic.beelinkoperatingmanual.R;
import com.droidlogic.beelinkoperatingmanual.bottomView.MainUpView;
import com.droidlogic.beelinkoperatingmanual.util.AnimUtil;

import butterknife.BindView;

public class QuickSettingsFragment extends Fragment implements View.OnClickListener, View.OnFocusChangeListener {

    LinearLayout llUninstall;
    MainUpView mainUpView;
    private View mOldView;

    public static QuickSettingsFragment newInstance() {
        QuickSettingsFragment quickSettingsFragment = new QuickSettingsFragment();
        Bundle args = new Bundle();
        quickSettingsFragment.setArguments(args);
        return quickSettingsFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quick_settings, container, false);
        llUninstall = view.findViewById(R.id.ll_uninstall);
        mainUpView = view.findViewById(R.id.mainUpView1);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //init();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void init() {
        llUninstall.requestFocus();
        llUninstall.setOnClickListener(this);
        llUninstall.setOnFocusChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_uninstall:
                mainUpView.setFocusView(v, mOldView, 1.05f);
                mOldView = v;
                break;
            default:
                break;
        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (v.hasFocus()) {
            switch (v.getId()) {
                case R.id.ll_uninstall:
                    v.bringToFront();
                    AnimUtil.setViewScale(v, 1.2f);
                    break;
            }
        } else {
            switch (v.getId()) {
                case R.id.ll_uninstall:
                    AnimUtil.setViewScaleDefault(v);
                    break;
            }
        }
    }
}
