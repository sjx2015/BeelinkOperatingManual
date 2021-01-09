package com.droidlogic.beelinkoperatingmanual;

import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.text.TextUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.droidlogic.beelinkoperatingmanual.adapter.DataAdapter;
import com.droidlogic.beelinkoperatingmanual.bottomView.EffectNoDrawBridge;
import com.droidlogic.beelinkoperatingmanual.bottomView.MainUpView;
import com.droidlogic.beelinkoperatingmanual.fragmenet.AudioFragment;
import com.droidlogic.beelinkoperatingmanual.fragmenet.BasicIntroductionFragment;
import com.droidlogic.beelinkoperatingmanual.fragmenet.CommonProblemFragment;
import com.droidlogic.beelinkoperatingmanual.fragmenet.HardDiskFragment;
import com.droidlogic.beelinkoperatingmanual.fragmenet.PersonalizationFragment;
import com.droidlogic.beelinkoperatingmanual.fragmenet.PlaybackSettingsFragment;
import com.droidlogic.beelinkoperatingmanual.fragmenet.QuickSettingsFragment;
import com.droidlogic.beelinkoperatingmanual.fragmenet.BootupFragment;
import com.droidlogic.beelinkoperatingmanual.fragmenet.VoiceRemoteControlFragment;
import com.droidlogic.beelinkoperatingmanual.fragmenet.WirelessTransmissionFragment;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {

    @BindView(R.id.headers)
    ListView mHeaderList;
    @BindView(R.id.fly_container)
    FrameLayout flyContainer;
    @BindView(R.id.main_up_view)
    MainUpView mainUpView;

    private FragmentManager fragmentManager;
    private Fragment currentFragment;
    private List<Fragment> fragmentList = new ArrayList<>();
    private BasicIntroductionFragment basicIntroductionFragment;
    private CommonProblemFragment commonProblemFragment;
    private PersonalizationFragment personalizationFragment;
    private PlaybackSettingsFragment playbackSettingsFragment;
    private HardDiskFragment hardDiskFragment;
    private AudioFragment audioFragment;
    private QuickSettingsFragment quickSettingsFragment;
    private BootupFragment bootupFragment;
    private VoiceRemoteControlFragment voiceRemoteControlFragment;
    private WirelessTransmissionFragment wirelessTransmissionFragment;

    private static String switchchange = null;

    private static final String BUILD_MODEL = "ro.product.model";
    public static String  model;


    public static String getProperty(String key, String defaultValue) {
        String value = defaultValue;
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method get = c.getMethod("get", String.class, String.class);
            value = (String) (get.invoke(c, key, defaultValue));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        model = getProperty(BUILD_MODEL,"GTKing");
        init();
        initView();
    }

    private void init() {
        fragmentManager = getSupportFragmentManager();

        basicIntroductionFragment = BasicIntroductionFragment.newInstance();
        commonProblemFragment = CommonProblemFragment.newInstance();
        personalizationFragment = PersonalizationFragment.newInstance();
        playbackSettingsFragment = PlaybackSettingsFragment.newInstance();
        hardDiskFragment = HardDiskFragment.newInstance();
        audioFragment = AudioFragment.newInstance();
        quickSettingsFragment = QuickSettingsFragment.newInstance();
        bootupFragment = BootupFragment.newInstance();
        voiceRemoteControlFragment = VoiceRemoteControlFragment.newInstance();
        wirelessTransmissionFragment = WirelessTransmissionFragment.newInstance();
        fragmentList.add(basicIntroductionFragment);
        fragmentList.add(bootupFragment);
        fragmentList.add(commonProblemFragment);
        fragmentList.add(personalizationFragment);
        fragmentList.add(playbackSettingsFragment);
        fragmentList.add(hardDiskFragment);
        fragmentList.add(audioFragment);
        fragmentList.add(quickSettingsFragment);
        fragmentList.add(voiceRemoteControlFragment);
        fragmentList.add(wirelessTransmissionFragment);
    }

    private void initView() {
        //初始化界面　首页展示设备管理界面
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction
                .add(R.id.fly_container, fragmentList.get(0))
                .commit();
        currentFragment = fragmentList.get(0);

        DataAdapter recyclerDataAdapter = new DataAdapter(this, getDataToPass());
        mHeaderList.setAdapter(recyclerDataAdapter);
        mHeaderList.setOnItemClickListener(this);
        mHeaderList.setOnItemSelectedListener(this);

        mainUpView.setEffectBridge(new EffectNoDrawBridge());
        EffectNoDrawBridge bridget = (EffectNoDrawBridge) mainUpView.getEffectBridge();
        bridget.setTranDurAnimTime(200);
        // 设置移动边框的图片.
        mainUpView.setUpRectResource(R.drawable.gray);
        // 移动方框缩小的距离.左上右下
        mainUpView.setDrawUpRectPadding(new Rect(5, 5, 5, 5));
    }
    public List<Map<String,Object>> getDataToPass(){
        Map<String,Object> introduction = new HashMap<String,Object>();
        introduction.put("title", R.string.basic);
        introduction.put("icon", R.mipmap.icon_header_introduction);

        Map<String,Object> voice = new HashMap<String,Object>();
        voice.put("title", R.string.voice);
        voice.put("icon", R.mipmap.icon_header_voice);

        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        Map<String,Object> boot = new HashMap<String,Object>();
        boot.put("title", R.string.boot);
        boot.put("icon", R.mipmap.icon_header_boot);

        Map<String,Object> network = new HashMap<String,Object>();
        network.put("title", R.string.network);
        network.put("icon", R.mipmap.icon_header_network);

        Map<String,Object> playback = new HashMap<String,Object>();
        playback.put("title", R.string.playback);
        playback.put("icon", R.mipmap.icon_header_playback);

        Map<String,Object> harddisk = new HashMap<String,Object>();
        if (TextUtils.equals(model,"GS-King X")) {
            harddisk.put("title", R.string.harddisk);
        }
        else
            harddisk.put("title", R.string.harddisk_gsking_x);
        harddisk.put("icon", R.mipmap.icon_header_harddisk);

        Map<String,Object> audio = new HashMap<String,Object>();
        audio.put("title", R.string.audio_output);
        audio.put("icon", R.mipmap.icon_header_audio_output);

        Map<String,Object> personalization = new HashMap<String,Object>();
        personalization.put("title", R.string.personalization);
        personalization.put("icon", R.mipmap.icon_header_personalization);

        Map<String,Object> shotcut = new HashMap<String,Object>();
        shotcut.put("title", R.string.shotcut);
        shotcut.put("icon", R.mipmap.icon_header_shotcut);

        Map<String,Object> commonProblems = new HashMap<String,Object>();
        commonProblems.put("title", R.string.commonProblems);
        commonProblems.put("icon", R.mipmap.icon_header_help);


        list.add(introduction);
        list.add(voice);
        list.add(boot);
        list.add(network);
        list.add(playback);
        list.add(harddisk);
        Log.d("djb","model=" + model);
        if (TextUtils.equals(model,"GS-King X")) {
            list.add(audio);
        }
        list.add(personalization);
        list.add(shotcut);
        list.add(commonProblems);
        return list;
    }

    /**
     * 切换Fragment
     *
     * @param fromFragment：需要隐藏的Fragment
     * @param toFragment：需要显示的Fragment
     */
    private void switchFragment(Fragment fromFragment, Fragment toFragment) {
        if (fromFragment != toFragment) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            if (!toFragment.isAdded()) {
                fragmentTransaction.hide(fromFragment).add(R.id.fly_container, toFragment).commit();
            } else {
                fragmentTransaction.hide(fromFragment).show(toFragment).commit();
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        handleItem(view);
    }

    private void handleItem(View view){

        DataAdapter.ViewHolder holder = (DataAdapter.ViewHolder)view.getTag();
        String obj = (String) holder.title.getText();
        if (obj.equals(getResources().getString(R.string.boot))) {
            switchFragment(currentFragment, bootupFragment);
            currentFragment = bootupFragment;
        } else if (obj.equals(getResources().getString(R.string.network))) {
            switchFragment(currentFragment, wirelessTransmissionFragment);
            currentFragment = wirelessTransmissionFragment;
        } else if (obj.equals(getResources().getString(R.string.voice))) {
            switchFragment(currentFragment, voiceRemoteControlFragment);
            currentFragment = voiceRemoteControlFragment;
        } else if (obj.equals(getResources().getString(R.string.playback))) {
            switchFragment(currentFragment, playbackSettingsFragment);
            currentFragment = playbackSettingsFragment;
        } else if (obj.equals(getResources().getString(R.string.harddisk)) || obj.equals(getResources().getString(R.string.harddisk_gsking_x))) {
            switchFragment(currentFragment, hardDiskFragment);
            currentFragment = hardDiskFragment;
        } else if (obj.equals(getResources().getString(R.string.audio_output))) {
            switchFragment(currentFragment, audioFragment);
            currentFragment = audioFragment;
        } else if (obj.equals(getResources().getString(R.string.personalization))) {
            switchFragment(currentFragment, personalizationFragment);
            currentFragment = personalizationFragment;
        } else if (obj.equals(getResources().getString(R.string.commonProblems))) {
            switchFragment(currentFragment, commonProblemFragment);
            currentFragment = commonProblemFragment;
        } else if (obj.equals(getResources().getString(R.string.shotcut))) {
            switchFragment(currentFragment, quickSettingsFragment);
            currentFragment = quickSettingsFragment;
        }else if (obj.equals(getResources().getString(R.string.basic))) {
            switchFragment(currentFragment, basicIntroductionFragment);
            currentFragment = basicIntroductionFragment;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        handleItem(view);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
