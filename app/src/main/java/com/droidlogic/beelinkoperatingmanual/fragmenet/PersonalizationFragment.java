package com.droidlogic.beelinkoperatingmanual.fragmenet;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.droidlogic.beelinkoperatingmanual.R;
import com.droidlogic.beelinkoperatingmanual.bottomView.EffectNoDrawBridge;
import com.droidlogic.beelinkoperatingmanual.bottomView.MainUpView;
import com.droidlogic.beelinkoperatingmanual.util.AnimUtil;

public class PersonalizationFragment extends Fragment implements View.OnFocusChangeListener, View.OnClickListener {

    LinearLayout llDpi;
    LinearLayout llTheme;
    LinearLayout llWidget;
    LinearLayout llHibernate;
    LinearLayout llFont;
    LinearLayout llLanguage;
    MainUpView mainUpView1;
    private View mOldView;

    public static PersonalizationFragment newInstance() {
        PersonalizationFragment personalizationFragment = new PersonalizationFragment();
        Bundle args = new Bundle();
        personalizationFragment.setArguments(args);
        return personalizationFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personalization, container, false);
        llDpi = view.findViewById(R.id.ll_dpi);
        llTheme = view.findViewById(R.id.ll_theme);
        llWidget = view.findViewById(R.id.ll_widget);
        llHibernate = view.findViewById(R.id.ll_hibernate);
        llFont = view.findViewById(R.id.ll_font);
        llLanguage = view.findViewById(R.id.ll_language);
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
        // 建议使用 NoDraw.
        mainUpView1.setEffectBridge(new EffectNoDrawBridge());
        EffectNoDrawBridge bridget = (EffectNoDrawBridge) mainUpView1.getEffectBridge();
        bridget.setTranDurAnimTime(200);
        // 设置移动边框的图片.
        mainUpView1.setUpRectResource(R.drawable.white_light_10);
        // 移动方框缩小的距离.
        mainUpView1.setDrawUpRectPadding(new Rect(10, 10, 10, -55));

        llDpi.setOnFocusChangeListener(this);
        llDpi.setOnClickListener(this);
        llTheme.setOnFocusChangeListener(this);
        llTheme.setOnClickListener(this);
        llWidget.setOnFocusChangeListener(this);
        llWidget.setOnClickListener(this);
        llHibernate.setOnFocusChangeListener(this);
        llHibernate.setOnClickListener(this);
        llFont.setOnFocusChangeListener(this);
        llFont.setOnFocusChangeListener(this);
        llLanguage.setOnFocusChangeListener(this);
        llLanguage.setOnClickListener(this);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (v.hasFocus()) {
            switch (v.getId()) {
                case R.id.ll_dpi:
                case R.id.ll_theme:
                case R.id.ll_widget:
                case R.id.ll_hibernate:
                case R.id.ll_font:
                case R.id.ll_language:
                    v.bringToFront();
                    // AnimUtil.setViewScale(v, 1.2f);
                    mainUpView1.setVisibility(View.VISIBLE);
                    mainUpView1.setFocusView(v, 1.1f);
                    break;
            }
        } else {
            switch (v.getId()) {
                case R.id.ll_dpi:
                case R.id.ll_theme:
                case R.id.ll_widget:
                case R.id.ll_hibernate:
                case R.id.ll_font:
                case R.id.ll_language:
                    AnimUtil.setViewScaleDefault(v);
                    mainUpView1.setVisibility(View.INVISIBLE);
                    break;
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_dpi:
            case R.id.ll_theme:
            case R.id.ll_widget:
            case R.id.ll_hibernate:
            case R.id.ll_font:
            case R.id.ll_language:
                mainUpView1.setFocusView(v, mOldView, 1.05f);
                mOldView = v;
                break;
            default:
                break;
        }
    }
}
