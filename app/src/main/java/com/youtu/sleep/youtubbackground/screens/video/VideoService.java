package com.youtu.sleep.youtubbackground.screens.video;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.view.SurfaceHolder;
import android.widget.RemoteViews;

import com.youtu.sleep.youtubbackground.R;
import com.youtu.sleep.youtubbackground.data.model.popularvideo.Video;
import com.youtu.sleep.youtubbackground.utils.Contants;

import java.io.IOException;
import java.util.List;

/**
 * Created by DaiPhongPC on 8/8/2018.
 */

public class VideoService extends Service implements MediaPlayer.OnPreparedListener {
    public static final int ID = 1000;
    public static VideoCallback mCallbackVideo;
    private int mPosition;
    private List<Video> mListVideos;
    private MediaPlayer mMediaPlayer;
    private IBinder mIbind = new BinderService();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        if (intent.getAction().equals(ActionVideo.PLAY_NEW)) {
            mPosition = intent.getIntExtra(Contants.EXTRA_POSS, 0);
            mListVideos = intent.getParcelableArrayListExtra(Contants.EXTRA_LIST_VIDEOS);
            playVideo();
        }
        return mIbind;
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.start();
        mCallbackVideo.alreadyPlayVideo();
        mCallbackVideo.addHolderSurface(mediaPlayer);
        mCallbackVideo.updateStatusVideo(mediaPlayer.isPlaying());
    }

    public void setPosition(int position) {
        this.mPosition = position;
    }

    public List<Video> getListVideos() {
        return mListVideos;
    }

    public Video getCurrentVideo() {
        return mListVideos.get(mPosition);
    }

    /**
     * receive Intent from notification
     */
    public void receiveIntent(Intent intent) {
        switch (intent.getAction()) {
            case ActionVideo.PLAY:
                break;
            case ActionVideo.NEXT:

                break;
            case ActionVideo.PRE:
                break;
        }
    }

    /**
     * play new video
     */
    public void playVideo() {
        mMediaPlayer = new MediaPlayer();
        try {
            mMediaPlayer.setDataSource(mListVideos.get(mPosition).getUrl());
            mMediaPlayer.prepareAsync();
            mMediaPlayer.setOnPreparedListener(this);
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        } catch (IOException e) {
            e.printStackTrace();
            mCallbackVideo.showMessagePlayVideoError();
        }
    }

    /**
     * play or pause video
     */
    public void changeMediaStatus() {
        if (mMediaPlayer.isPlaying()) {
            mMediaPlayer.pause();
        } else {
            mMediaPlayer.start();
        }
        mCallbackVideo.updateStatusVideo(mMediaPlayer.isPlaying());
    }

    /**
     * stop Video
     */
    public void stopVideo() {
        if (mMediaPlayer.isPlaying()) {
            mMediaPlayer.stop();
            mMediaPlayer.release();
        }
    }

    /**
     * get current duration video
     */
    public int getCurrentDurationVideo() {
        return mMediaPlayer != null ? mMediaPlayer.getCurrentPosition() : 0;
    }

    /**
     * get  duration video
     */
    public int getDurationVideo() {
        return mMediaPlayer != null ? mMediaPlayer.getDuration() : 0;
    }

    /**
     * change current time of video
     */
    public void changeCurrenttime(int mms) {
        mMediaPlayer.seekTo(mms);
    }

    /**
     * remove holder
     */
    public void setHolder(SurfaceHolder holder) {
        if (mMediaPlayer != null) {
            mMediaPlayer.setDisplay(holder);
        }
    }

    /**
     * creat a custom notification
     */
    public NotificationCompat.Builder creatNotification(Video video) {
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.notification_small_layout);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true)
                .setContent(remoteViews);
//        PendingIntent pendingNext = creatPendingIntent(ActionVideo.NEXT);
//        PendingIntent pendingPre = creatPendingIntent(ActionVideo.PRE);
//        PendingIntent pendingPlay = creatPendingIntent(ActionVideo.PLAY);
//        remoteViews.setTextViewText(R.id.text_title, video.getTitle());
//        remoteViews.setTextViewText(R.id.text_title, video.getChannelTitle());
//        remoteViews.setOnClickPendingIntent(R.id.image_prev, pendingPre);
//        remoteViews.setOnClickPendingIntent(R.id.image_next, pendingNext);
//        remoteViews.setOnClickPendingIntent(R.id.image_play, pendingPlay);
        return builder;
    }

    private PendingIntent creatPendingIntent(@ActionVideo String action) {
        Intent intent = new Intent(this, VideoService.class);
        intent.setAction(action);
        PendingIntent pb = PendingIntent.getService(this, 0, intent, 0);
        return pb;
    }

    public class BinderService extends Binder {
        VideoService getService() {
            return VideoService.this;
        }
    }

    @Override
    public boolean onUnbind(Intent intent) {
        NotificationCompat.Builder builder = creatNotification(mListVideos.get(mPosition));
        startForeground(ID, builder.build());
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
