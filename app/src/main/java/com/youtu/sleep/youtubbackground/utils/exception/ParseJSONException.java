package com.youtu.sleep.youtubbackground.utils.exception;

import org.json.JSONException;

/**
 * Created by thuy on 08/08/2018.
 */
public class ParseJSONException extends Exception {
    public ParseJSONException(JSONException e){
        super(e);
    }
}
