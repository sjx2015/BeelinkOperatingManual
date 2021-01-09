package com.droidlogic.beelinkoperatingmanual.fragmenet;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.droidlogic.beelinkoperatingmanual.R;
import com.droidlogic.beelinkoperatingmanual.bottomView.MainUpView;
import com.droidlogic.beelinkoperatingmanual.util.AnimUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class VoiceRemoteControlFragment extends Fragment implements View.OnFocusChangeListener, View.OnClickListener {

//    LinearLayout llRemoteControl;
    LinearLayout llLanguageInput;
    LinearLayout llVolanteControl;
//    ImageView ivOne;
    ImageView ivTwo;
    ImageView ivThree;
    MainUpView mainUpView1;
    private View mOldView;

    public static VoiceRemoteControlFragment newInstance() {
        VoiceRemoteControlFragment voiceRemoteControlFragment = new VoiceRemoteControlFragment();
        Bundle args = new Bundle();
        voiceRemoteControlFragment.setArguments(args);
        return voiceRemoteControlFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_voice_remote_control, container, false);
//        llRemoteControl = view.findViewById(R.id.ll_remote_control);
//        llRemoteControl.setVisibility(View.GONE);//add by djb,hide this unnecessary page
        llLanguageInput = view.findViewById(R.id.ll_language_input);
        llVolanteControl = view.findViewById(R.id.ll_volante_control);
        mainUpView1 = view.findViewById(R.id.mainUpView1);
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
//        llRemoteControl.setOnFocusChangeListener(this);
        llLanguageInput.setOnFocusChangeListener(this);
        llVolanteControl.setOnFocusChangeListener(this);
//        ivOne.setOnFocusChangeListener(this);
        ivTwo.setOnFocusChangeListener(this);
        ivThree.setOnFocusChangeListener(this);

//        llRemoteControl.setOnClickListener(this);
        llLanguageInput.setOnClickListener(this);
        llVolanteControl.setOnClickListener(this);
//        ivOne.setOnClickListener(this);
        ivTwo.setOnClickListener(this);
        ivThree.setOnClickListener(this);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (v.hasFocus()) {
            switch (v.getId()) {
//                case R.id.ll_remote_control:
                case R.id.ll_language_input:
                case R.id.ll_volante_control:
//                case R.id.iv_one:
                case R.id.iv_two:
                case R.id.iv_three:
                    v.bringToFront();
                    // AnimUtil.setViewScale(v, 1.2f);
                    mainUpView1.setVisibility(View.VISIBLE);
                    mainUpView1.setFocusView(v, 1.1f);
                    break;
            }
        } else {
            switch (v.getId()) {
//                case R.id.ll_remote_control:
                case R.id.ll_language_input:
                case R.id.ll_volante_control:
//                case R.id.iv_one:
                case R.id.iv_two:
                case R.id.iv_three:
                    AnimUtil.setViewScaleDefault(v);
                    mainUpView1.setVisibility(View.INVISIBLE);
                    break;
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.ll_remote_control:
            case R.id.ll_language_input:
            case R.id.ll_volante_control:
//            case R.id.iv_one:
            case R.id.iv_two:
            case R.id.iv_three:
                mainUpView1.setFocusView(v, mOldView, 1.05f);
                mOldView = v;
            default:
                break;
        }
    }

}
