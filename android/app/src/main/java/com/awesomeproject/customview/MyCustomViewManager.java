package com.awesomeproject.customview;

import android.content.Context;
import android.view.LayoutInflater;

import com.facebook.react.common.MapBuilder.Builder;

import com.awesomeproject.R;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.Map;

public class MyCustomViewManager extends SimpleViewManager<MyCustomView> {

    public static final String REACT_CLASS = "RCTMyCustomView";

    @Override
    public String getName() { return REACT_CLASS; }

    @Override
    public MyCustomView createViewInstance(ThemedReactContext context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        MyCustomView view = (MyCustomView)inflater.inflate(R.layout.custom_view, null);
        return view;
    }

    @ReactProp(name = "status")
    public void setStatus(MyCustomView view, Boolean status) {
        view.setStatus(status);
    }

    public Map getExportedCustomBubblingEventTypeConstants() {

        String eventName = "onClickEvent";
        String propName = "onClick";
        Map onClickHandler = MapBuilder.of("phasedRegistrationNames",MapBuilder.of("bubbled", propName));

        Builder events = MapBuilder.builder();
        events.put(eventName, onClickHandler);
        return events.build();

    }

}
