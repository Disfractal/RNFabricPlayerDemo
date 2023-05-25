package com.rtnfabricplayer;

import androidx.annotation.Nullable;
import android.annotation.SuppressLint;

import android.content.Context;

import android.graphics.Color;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;

import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableArray;

import com.facebook.react.uimanager.ThemedReactContext;

import java.util.ArrayList;


@SuppressLint("ViewConstructor")
public class FabricPlayer extends TextureView implements 
        LifecycleEventListener, 
        TextureView.SurfaceTextureListener, 
        AudioManager.OnAudioFocusChangeListener {

    private static final String TAG = "FabricPlayer";
    private final String tag = "FabricPlayer";

    private String src;

    private int mId = -1;

    private final ThemedReactContext themedReactContext;
    private final AudioManager audioManager;




    public FabricPlayer(ThemedReactContext context) {
        super(context);
        this.themedReactContext = context;
        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        this.setSurfaceTextureListener(this);
    }

    private void configureComponent() {
    }

    @Override
    public void setId(int id) {
        super.setId(id);
        this.mId = id;
    }
    @Override
    public void onHostResume() {
        FLog.i(TAG,  "---------onHostResume------------>");
    }


    @Override
    public void onHostPause() {
        FLog.i(TAG, "---------onHostPause------------>");
    }


    @Override
    public void onHostDestroy() {
        FLog.i(TAG, "---------onHostDestroy------------>");
    }

    @Override
    public void onAudioFocusChange(int focusChange) {
        FLog.i(TAG, "---------onAudioFocusChange------------>");
    }

    /**
     * Set resource path
     *
     * @param uri
     * @param isNetStr
     */
    public void setSource(String uri) {
        LogEventEmitter.sendLog(this.mId, "setSource", this.themedReactContext);
    }

    // Surface Texture Listeners

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        Log.i(TAG, "onSurfaceTextureAvailable");
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
        Log.i(TAG, "onSurfaceTextureSizeChanged");
    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        Log.i(TAG, "onSurfaceTextureDestroyed");
        return true;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
        Log.i(TAG, "onSurfaceTextureUpdated");
    }

}
