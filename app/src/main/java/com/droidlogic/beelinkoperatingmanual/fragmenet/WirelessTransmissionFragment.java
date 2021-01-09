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

public class WirelessTransmissionFragment extends Fragment implements View.OnFocusChangeListener, View.OnClickListener {

    LinearLayout llBluetoothPair;
    LinearLayout llWifiConnect;
    LinearLayout llHotspotSwitch;
    MainUpView mainUpView;
    private View mOldView;

    public static WirelessTransmissionFragment newInstance() {
        WirelessTransmissionFragment wirelessTransmissionFragment = new WirelessTransmissionFragment();
        Bundle args = new Bundle();
        wirelessTransmissionFragment.setArguments(args);
        return wirelessTransmissionFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wireless_transmission, container, false);
        llBluetoothPair = view.findViewById(R.id.ll_bluetooth_pair);
        llWifiConnect = view.findViewById(R.id.ll_wifi_connect);
        llHotspotSwitch = view.findViewById(R.id.ll_hotspot_switch);
        mainUpView = view.findViewById(R.id.mainUpView1);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //init();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void init() {
        llBluetoothPair.setOnFocusChangeListener(this);
        llWifiConnect.setOnFocusChangeListener(this);
        llHotspotSwitch.setOnFocusChangeListener(this);

        llBluetoothPair.setOnClickListener(this);
        llWifiConnect.setOnClickListener(this);
        llHotspotSwitch.setOnClickListener(this);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (v.hasFocus()) {
            switch (v.getId()) {
                case R.id.ll_bluetooth_pair:
                case R.id.ll_wifi_connect:
                case R.id.ll_hotspot_switch:
                    v.bringToFront();
                    // AnimUtil.setViewScale(v, 1.2f);
                    mainUpView.setVisibility(View.VISIBLE);
                    mainUpView.setFocusView(v, 1.1f);
                    break;
            }
        } else {
            switch (v.getId()) {
                case R.id.ll_bluetooth_pair:
                case R.id.ll_wifi_connect:
                case R.id.ll_hotspot_switch:
                    AnimUtil.setViewScaleDefault(v);
                    mainUpView.setVisibility(View.INVISIBLE);
                    break;
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_bluetooth_pair:
            case R.id.ll_wifi_connect:
            case R.id.ll_hotspot_switch:
                mainUpView.setFocusView(v, mOldView, 1.05f);
                mOldView = v;
                break;
        }
    }
}
