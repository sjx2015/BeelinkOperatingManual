package com.droidlogic.beelinkoperatingmanual.fragmenet;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.droidlogic.beelinkoperatingmanual.R;
import com.droidlogic.beelinkoperatingmanual.bottomView.MainUpView;
import com.droidlogic.beelinkoperatingmanual.util.AnimUtil;

public class BootupFragment extends Fragment implements View.OnFocusChangeListener, View.OnClickListener {


    LinearLayout rllOne;
    RelativeLayout rllTwo;
    LinearLayout llTitle;
    MainUpView mainUpView;
    private View mOldView;

    public static BootupFragment newInstance() {
        BootupFragment bootupFragment = new BootupFragment();
        Bundle args = new Bundle();
        bootupFragment.setArguments(args);
        return bootupFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bootup, container, false);
        rllOne = view.findViewById(R.id.rll_one);
        rllTwo = view.findViewById(R.id.rll_two);
        //llTitle = view.findViewById(R.id.ll_title);
        mainUpView = view.findViewById(R.id.mainUpView1);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //init();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void init() {
        rllOne.requestFocus();//请求焦点
        rllOne.setNextFocusRightId(R.id.rll_two);
        rllOne.setOnFocusChangeListener(this);
        rllTwo.setOnFocusChangeListener(this);
        rllOne.setOnClickListener(this);
        rllTwo.setOnClickListener(this);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (v.hasFocus()) {
            switch (v.getId()) {
                case R.id.rll_one:
                case R.id.rll_two:
                //case R.id.ll_title:
                    v.bringToFront();
                    // AnimUtil.setViewScale(v, 1.2f);
                    mainUpView.setVisibility(View.VISIBLE);
                    mainUpView.setFocusView(v, 1.1f);
                    break;
            }
        } else {
            switch (v.getId()) {
                case R.id.rll_one:
                case R.id.rll_two:
                //case R.id.ll_title:
                    AnimUtil.setViewScaleDefault(v);
                    mainUpView.setVisibility(View.INVISIBLE);
                    break;
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rll_one:
            case R.id.rll_two:
            //case R.id.ll_title:
                mainUpView.setFocusView(v, mOldView, 1.05f);
                mOldView = v;
                break;
            default:
                break;
        }
    }
}
