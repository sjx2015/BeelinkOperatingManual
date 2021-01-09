package com.droidlogic.beelinkoperatingmanual.fragmenet;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.droidlogic.beelinkoperatingmanual.R;
import com.droidlogic.beelinkoperatingmanual.bottomView.MainUpView;
import com.droidlogic.beelinkoperatingmanual.util.AnimUtil;

    public class AudioFragment extends Fragment implements View.OnFocusChangeListener, View.OnClickListener {

    RelativeLayout rl_audio;
    MainUpView mainUpView;
    private View mOldView;

    public static AudioFragment newInstance() {
        AudioFragment audioFragment = new AudioFragment();
        Bundle args = new Bundle();
        audioFragment.setArguments(args);
        return audioFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_audio_settings, container, false);
        rl_audio = view.findViewById(R.id.ll_disk_plug_unplug);
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
        rl_audio.setOnFocusChangeListener(this);

        rl_audio.setOnClickListener(this);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (v.hasFocus()) {
            switch (v.getId()) {
                case R.id.rl_audio:
                    v.bringToFront();
                    // AnimUtil.setViewScale(v, 1.2f);
                    mainUpView.setVisibility(View.VISIBLE);
                    mainUpView.setFocusView(v, 1.1f);
                    break;
            }
        } else {
            switch (v.getId()) {
                case R.id.rl_audio:
                    AnimUtil.setViewScaleDefault(v);
                    mainUpView.setVisibility(View.INVISIBLE);
                    break;
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_audio:
                mainUpView.setFocusView(v, mOldView, 1.05f);
                mOldView = v;
                break;
        }
    }
}
