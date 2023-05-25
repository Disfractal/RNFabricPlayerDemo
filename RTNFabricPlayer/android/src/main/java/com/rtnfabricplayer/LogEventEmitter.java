package com.rtnfabricplayer;

import androidx.annotation.NonNull;
import android.view.View;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.uimanager.events.EventDispatcher;

public class LogEventEmitter {
    
    private static final String TAG = "LogEventEmitter";

    /**
     * Log
     * @param message
     */
    public static void sendLog(@NonNull int viewId, String message, ReactContext context) {
        EventDispatcher eventDispatcher =
            UIManagerHelper.getEventDispatcherForReactTag(context, viewId);
        if (eventDispatcher != null) {
          eventDispatcher.dispatchEvent(
              new LogEvent(UIManagerHelper.getSurfaceId(context), viewId, message));
        }
    }

}
