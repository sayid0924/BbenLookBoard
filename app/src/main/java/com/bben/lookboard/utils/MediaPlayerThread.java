package com.bben.lookboard.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;

public class MediaPlayerThread implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {

    static MediaPlayer mediaPlayer;
    private Context context;
    static MediaPlayerThread mediaPlayerThread;
    private String musicUrl;
    private int type;
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() {
        @SuppressLint("NewApi")
        public void run() {
            try {
                mediaPlayer.reset();
                if (type == 1) {
                    AssetManager assetManager = context.getAssets();   ////获得该应用的AssetManager
                    AssetFileDescriptor afd = assetManager.openFd("10.mp3");
                    mediaPlayer.setDataSource(afd.getFileDescriptor(),
                            afd.getStartOffset(), afd.getLength());
                } else {
                    mediaPlayer.setDataSource(musicUrl); // 设置数据源
                }
                mediaPlayer.prepare();                           // prepare自动播放
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public static synchronized MediaPlayerThread getInstance(Context context) {
        if (mediaPlayerThread == null)
            mediaPlayerThread = new MediaPlayerThread(context);
        return mediaPlayerThread;
    }

    public MediaPlayerThread(Context context) {
        this.context = context;
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);// 设置媒体流类型
        mediaPlayer.setOnBufferingUpdateListener(this);
        mediaPlayer.setOnPreparedListener(this);
        mediaPlayer.setOnCompletionListener(this);

    }

    public void playUrl(final String url) {
        this.musicUrl = url;
        mHandler.post(mRunnable);
    }

    public void playUrl(int type) {
        this.type = type;
        mHandler.post(mRunnable);
    }

    public void start() {
        mediaPlayer.start();
    }

    public boolean isPlay() {
        return mediaPlayer != null && mediaPlayer.isPlaying();
    }

    // 停止
    public void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
            mediaPlayerThread =null;
        }
    }

    // 暂停
    public void pause() {
        mediaPlayer.pause();
    }

    // 线程销毁
    public void remove() {
        mHandler.removeCallbacks(mRunnable);
    }

    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {

    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
        mp.setLooping(true);
    }

    @Override
    public void onCompletion(MediaPlayer mp) {

    }
}