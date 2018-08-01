package com.youtu.sleep.youtubbackground.widget.textview;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;

/**
 * Created by DaiPhongPC on 7/31/2018.
 */

public class FontCache {
    public static final String PATH_FONT = "fonts/";
    public static HashMap<String, Typeface> fontCache = new HashMap<>();

    public static Typeface getTypeface(Context context, String fontName) {
        Typeface typeface = fontCache.get(fontName);
        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(), PATH_FONT + fontName);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            fontCache.put(fontName, typeface);
        }
        return typeface;
    }
}
