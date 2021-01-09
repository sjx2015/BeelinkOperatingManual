package com.droidlogic.beelinkoperatingmanual.fragmenet;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.droidlogic.beelinkoperatingmanual.MainActivity;
import com.droidlogic.beelinkoperatingmanual.R;
import com.droidlogic.beelinkoperatingmanual.bottomView.MainUpView;
import com.droidlogic.beelinkoperatingmanual.util.AnimUtil;

public class CommonProblemFragment extends Fragment implements View.OnFocusChangeListener, View.OnClickListener {

    private LinearLayout llLanguageModify;
    private LinearLayout llPowerCustom;
    private LinearLayout llTrouble;
    private LinearLayout llTime;
    private LinearLayout llNoWifi;
    private LinearLayout llOTAUpdate;
    private LinearLayout llInstallFirmware;
    private LinearLayout llInstallFirmwareOther;
    private MainUpView mainUpView;
    private View mOldView;
    private ImageView imgBurnPic_GTKing,imgBurnPic_GTKingPro,imgBurnPic_GSKing_X;
    private ImageView img_sdcard_burn_help_sd3_gtking,img_sdcard_burn_help_sd3_gtking_pro,img_sdcard_burn_help_sd3_gsking_x;
    private ImageView img_sdcard_burn_help_sd1,img_sdcard_burn_help_sd1_big;

    public static CommonProblemFragment newInstance() {
        CommonProblemFragment commonProblemFragment = new CommonProblemFragment();
        Bundle args = new Bundle();
        commonProblemFragment.setArguments(args);
        return commonProblemFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_common_problem, container, false);
        llLanguageModify = view.findViewById(R.id.ll_language_modify);
        llPowerCustom = view.findViewById(R.id.ll_power_custom);
        llTrouble = view.findViewById(R.id.ll_trouble);
        llTime = view.findViewById(R.id.ll_time);
        llNoWifi = view.findViewById(R.id.ll_no_wifi);
        llInstallFirmware = view.findViewById(R.id.ll_install_firmware);

        //dynamic pic accordding to the model.
        imgBurnPic_GTKing = view.findViewById(R.id.imgBurnPic_GTKing);
        imgBurnPic_GTKingPro = view.findViewById(R.id.imgBurnPic_GTKingPro);
        imgBurnPic_GSKing_X = view.findViewById(R.id.imgBurnPic_GSKing_X);

        Log.d("djb","model=" + MainActivity.model);

        if (TextUtils.equals(MainActivity.model,"GS-King X")) {
            imgBurnPic_GTKing.setVisibility(View.GONE);
            imgBurnPic_GTKingPro.setVisibility(View.GONE);
            imgBurnPic_GSKing_X.setVisibility(View.VISIBLE);
        }
        else if (TextUtils.equals(MainActivity.model,"GTKing")) {
            imgBurnPic_GTKing.setVisibility(View.VISIBLE);
            imgBurnPic_GTKingPro.setVisibility(View.GONE);
            imgBurnPic_GSKing_X.setVisibility(View.GONE);
        }
        else if (TextUtils.equals(MainActivity.model,"GTKing PRO")) {
            imgBurnPic_GTKing.setVisibility(View.GONE);
            imgBurnPic_GTKingPro.setVisibility(View.VISIBLE);
            imgBurnPic_GSKing_X.setVisibility(View.GONE);
        }
        //dynamic pic accordding to the model.

        img_sdcard_burn_help_sd3_gtking = view.findViewById(R.id.img_sdcard_burn_help_sd3_gtking);
        img_sdcard_burn_help_sd3_gtking_pro = view.findViewById(R.id.img_sdcard_burn_help_sd3_gtking_pro);
        img_sdcard_burn_help_sd3_gsking_x = view.findViewById(R.id.img_sdcard_burn_help_sd3_gsking_x);

        if (TextUtils.equals(MainActivity.model,"GS-King X")) {
            img_sdcard_burn_help_sd3_gtking.setVisibility(View.GONE);
            img_sdcard_burn_help_sd3_gtking_pro.setVisibility(View.GONE);
            img_sdcard_burn_help_sd3_gsking_x.setVisibility(View.VISIBLE);
        }
        else if (TextUtils.equals(MainActivity.model,"GTKing")) {
            img_sdcard_burn_help_sd3_gtking.setVisibility(View.VISIBLE);
            img_sdcard_burn_help_sd3_gtking_pro.setVisibility(View.GONE);
            img_sdcard_burn_help_sd3_gsking_x.setVisibility(View.GONE);
        }
        else if (TextUtils.equals(MainActivity.model,"GTKing PRO")) {
            img_sdcard_burn_help_sd3_gtking.setVisibility(View.GONE);
            img_sdcard_burn_help_sd3_gtking_pro.setVisibility(View.VISIBLE);
            img_sdcard_burn_help_sd3_gsking_x.setVisibility(View.GONE);
        }
        //dynamic pic accordding to the model.

        img_sdcard_burn_help_sd1 = view.findViewById(R.id.img_sdcard_burn_help_sd1);
        img_sdcard_burn_help_sd1_big = view.findViewById(R.id.img_sdcard_burn_help_sd1_big);

        if (TextUtils.equals(MainActivity.model,"GTKing PRO")) {
            img_sdcard_burn_help_sd1.setVisibility(View.GONE);
            img_sdcard_burn_help_sd1_big.setVisibility(View.VISIBLE);
        }
        else //for gtking and gsking-x: TF card
        {
            img_sdcard_burn_help_sd1.setVisibility(View.VISIBLE);
            img_sdcard_burn_help_sd1_big.setVisibility(View.GONE);
        }
        //dynamic pic accordding to the model.


        mainUpView = view.findViewById(R.id.main_up_view);
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
        llLanguageModify.requestFocus();

        llLanguageModify.setOnFocusChangeListener(this);
        llPowerCustom.setOnFocusChangeListener(this);
        llTrouble.setOnFocusChangeListener(this);
        llTime.setOnFocusChangeListener(this);
        llNoWifi.setOnFocusChangeListener(this);
        llOTAUpdate.setOnFocusChangeListener(this);
        llInstallFirmware.setOnFocusChangeListener(this);
        llInstallFirmwareOther.setOnFocusChangeListener(this);

        llLanguageModify.setOnClickListener(this);
        llPowerCustom.setOnClickListener(this);
        llTrouble.setOnClickListener(this);
        llTime.setOnClickListener(this);
        llNoWifi.setOnClickListener(this);
        llOTAUpdate.setOnClickListener(this);
        llInstallFirmware.setOnClickListener(this);
        llInstallFirmwareOther.setOnClickListener(this);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (v.hasFocus()) {
            switch (v.getId()) {
                case R.id.ll_language_modify:
                case R.id.ll_power_custom:
                case R.id.ll_trouble:
                case R.id.ll_time:
                case R.id.ll_no_wifi:
                case R.id.ll_install_firmware:
                    v.bringToFront();
                    // AnimUtil.setViewScale(v, 1.2f);
                    mainUpView.setVisibility(View.VISIBLE);
                    mainUpView.setFocusView(v, 1.1f);
                    break;
            }
        } else {
            switch (v.getId()) {
                case R.id.ll_language_modify:
                case R.id.ll_power_custom:
                case R.id.ll_trouble:
                case R.id.ll_time:
                case R.id.ll_no_wifi:
                case R.id.ll_install_firmware:
                    AnimUtil.setViewScaleDefault(v);
                    mainUpView.setVisibility(View.INVISIBLE);
                    break;
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_language_modify:
            case R.id.ll_power_custom:
            case R.id.ll_trouble:
            case R.id.ll_time:
            case R.id.ll_no_wifi:
            case R.id.ll_install_firmware:
                mainUpView.setFocusView(v, mOldView, 1.05f);
                mOldView = v;
                break;
            default:
                break;
        }

    }
}
