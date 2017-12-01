package com.land.myfeature.myutils;

import android.media.AudioManager;
import android.media.SoundPool;

import com.land.myfeature.BaseApplication;
import com.land.myfeature.R;

import java.util.HashMap;

/**
 * com.land.myfeature.myutils
 * Created by nikai on 2017-12-01.
 * Description:
 */

public class MySoundPool {
    private static final int MAX_STREAMS_COUNT = 10;
    private static final int SOUND_POOL_SRC_QUALITY = 0;

    private static final int SOUND_ID_KEYPRESS_STANDARD = 1;
    private static final int SOUND_ID_KEYPRESS_DELETE = 2;
    private static final int SOUND_ID_KEYPRESS_INVALID = 3;
    private static final int SOUND_ID_MIRA = 4;

    private SoundPool mSoundPool;
    private HashMap<Integer, Integer> musicId;

    private MySoundPool() {
        initSoundPool();
    }

    public static final MySoundPool getInstance() {
        return MySoundPoolHolder.INSTANCE;
    }

    private void initSoundPool() {
        musicId = new HashMap<>();
        mSoundPool = new SoundPool(MAX_STREAMS_COUNT, AudioManager.STREAM_MUSIC, SOUND_POOL_SRC_QUALITY);
        musicId.put(SOUND_ID_KEYPRESS_STANDARD,
                mSoundPool.load(BaseApplication.getContextObject(), R.raw.keypress_standard, 1));
        musicId.put(SOUND_ID_KEYPRESS_DELETE,
                mSoundPool.load(BaseApplication.getContextObject(), R.raw.keypress_delete, 1));
        musicId.put(SOUND_ID_KEYPRESS_INVALID,
                mSoundPool.load(BaseApplication.getContextObject(), R.raw.keypress_invalid, 1));
        musicId.put(SOUND_ID_MIRA,
                mSoundPool.load(BaseApplication.getContextObject(), R.raw.mira, 1));

    }

    public void playKeyPressStandard() {
        mSoundPool.play(musicId.get(SOUND_ID_KEYPRESS_STANDARD), 1f, 1f, 0, 0, 1f);
    }

    public void palyKeyPressDelete() {
        mSoundPool.play(musicId.get(SOUND_ID_KEYPRESS_DELETE), 1f, 1f, 0, 0, 1f);
    }

    public void palyKeyPressInvalid() {
        mSoundPool.play(musicId.get(SOUND_ID_KEYPRESS_INVALID), 1f, 1f, 0, 0, 1f);
    }

    public void palyMira() {
        mSoundPool.play(musicId.get(SOUND_ID_MIRA), 1f, 1f, 0, 0, 1f);
    }

    private static class MySoundPoolHolder {
        private static final MySoundPool INSTANCE = new MySoundPool();
    }


}
