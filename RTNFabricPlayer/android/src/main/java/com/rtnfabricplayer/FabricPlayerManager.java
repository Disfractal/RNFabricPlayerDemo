package com.rtnfabricplayer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.util.Log;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RTNFabricPlayerManagerInterface;
import com.facebook.react.viewmanagers.RTNFabricPlayerManagerDelegate;

import java.util.HashMap;
import java.util.Map;

@ReactModule(name = FabricPlayerManager.NAME)
public class FabricPlayerManager extends SimpleViewManager<FabricPlayer>
    implements RTNFabricPlayerManagerInterface<FabricPlayer> {

  private final ViewManagerDelegate<FabricPlayer> mDelegate;

  private static final String TAG = "FabricPlayerManager";
  private final String tag = "FabricPlayerManager";
  static final String NAME = "RTNFabricPlayer";

  private static final String PROP_SRC = "source";

  public FabricPlayerManager(ReactApplicationContext context) {
    FLog.i(TAG, "Created");
    mDelegate = new RTNFabricPlayerManagerDelegate<>(this);
  }

  @Override
  public @Nullable Map<String, Object> getExportedCustomDirectEventTypeConstants() {
    @Nullable
    Map<String, Object> baseEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
    Map<String, Object> eventTypeConstants =
        baseEventTypeConstants == null ? new HashMap<String, Object>() : baseEventTypeConstants;
    eventTypeConstants.putAll(
        MapBuilder.<String, Object>builder()
            .put(
                "topOnLog",
                MapBuilder.of("registrationName", "onLog"))
            .build());
    return eventTypeConstants;
  }

  @Nullable
  @Override
  protected ViewManagerDelegate<FabricPlayer> getDelegate() {
    return mDelegate;
  }

  @NonNull
  @Override
  public String getName() {
    return FabricPlayerManager.NAME;
  }

  @NonNull
  @Override
  protected FabricPlayer createViewInstance(@NonNull ThemedReactContext context) {
    return new FabricPlayer(context);
  }

  
  @Override
  @ReactProp(name = PROP_SRC)
  public void setSource(final FabricPlayer view, @Nullable String src) {
    FLog.d(TAG, "setSource");
      view.setSource(src);

  }

}
