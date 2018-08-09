package com.youtu.sleep.youtubebackground.screens.video;

import android.support.annotation.StringDef;

/**
 * Created by DaiPhongPC on 8/7/2018.
 */
@StringDef({ActionVideo.NEXT, ActionVideo.PLAY, ActionVideo.PLAY_NEW, ActionVideo.PRE, ActionVideo.CREAT_NOTI})
public @interface ActionVideo {
    String CREAT_NOTI= "com.youtu.sleep.youtubebackground.CREATNOTIFICATION";
    String PLAY_NEW = "com.youtu.sleep.youtubebackground.PLAYNEW";
    String PLAY = "com.youtu.sleep.youtubebackground.PLAY";
    String NEXT = "com.youtu.sleep.youtubebackground.NEXT";
    String PRE = "com.youtu.sleep.youtubebackground.PRE";
}
