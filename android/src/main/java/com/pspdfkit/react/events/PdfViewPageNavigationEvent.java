/*
 * PdfViewPageNavigationEvent.java
 *
 *   PSPDFKit
 *
 *   Copyright © 2021-2024 PSPDFKit GmbH. All rights reserved.
 *
 *   THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
 *   AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE PSPDFKIT LICENSE AGREEMENT.
 *   UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
 *   This notice may not be removed from this file.
 */

package com.pspdfkit.react.events;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.pspdfkit.ui.navigation.PageNavigator;

import java.util.HashMap;
import java.util.Map;

/**
 * Event sent by the {@link com.pspdfkit.ui.navigation.PageNavigator} when the page index changes.
 */
public class PdfViewPageNavigationEvent extends Event<PdfViewPageNavigationEvent> {

    public static final String EVENT_NAME = "pdfViewPageNavigationEvent";

    private final Map<String, Object> navigationData;

    public PdfViewPageNavigationEvent(@IdRes int viewId, int newPageIndex) {
        super(viewId);

        // Construct the navigation data with page index details
        navigationData = new HashMap<>();
        navigationData.put("pageIndex", newPageIndex);
    }

    @Override
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override
    public void dispatch(RCTEventEmitter rctEventEmitter) {
        WritableMap eventData = Arguments.makeNativeMap(navigationData);
        rctEventEmitter.receiveEvent(getViewTag(), getEventName(), eventData);
    }
}
