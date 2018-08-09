package com.youtu.sleep.youtubbackground.screens.video;

import android.support.annotation.StringDef;

/**
 * Created by DaiPhongPC on 8/7/2018.
 */
@StringDef({ActionVideo.NEXT, ActionVideo.PLAY, ActionVideo.PLAY_NEW, ActionVideo.PRE})
public @interface ActionVideo {
    String PLAY_NEW = "com.youtu.sleep.youtubbackground.PLAYNEW";
    String PLAY = "com.youtu.sleep.youtubbackground.PLAY";
    String NEXT = "com.youtu.sleep.youtubbackground.NEXT";
    String PRE = "com.youtu.sleep.youtubbackground.PRE";
}
