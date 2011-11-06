// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BaseFacebookActivity.java

package com.facebook.katana.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.facebook.katana.IntentUriHandler;

// Referenced classes of package com.facebook.katana.activity:
//            FacebookActivity, FacebookActivityDelegate

public class BaseFacebookActivity extends Activity
    implements FacebookActivity
{

    public BaseFacebookActivity()
    {
        mDelegate = new FacebookActivityDelegate(this);
    }

    public boolean facebookOnBackPressed()
    {
        finish();
        return true;
    }

    public void finish()
    {
        mDelegate.finish();
        super.finish();
    }

    public long getActivityId()
    {
        return mDelegate.getActivityId();
    }

    protected String getTag()
    {
        return mDelegate.getTag();
    }

    protected void hideSearchButton()
    {
        mDelegate.hideSearchButton();
    }

    public boolean isOnTop()
    {
        return mDelegate.isOnTop();
    }

    protected void launchComposer(Uri uri, Bundle bundle, Integer integer, long l)
    {
        mDelegate.launchComposer(uri, bundle, integer, l);
    }

    protected void logStepDataReceived()
    {
        mDelegate.logStepDataReceived();
    }

    protected void logStepDataRequested()
    {
        mDelegate.logStepDataRequested();
    }

    public void onContentChanged()
    {
        super.onContentChanged();
        mDelegate.onContentChanged();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mDelegate.onCreate(bundle);
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        Boolean boolean1 = mDelegate.onKeyDown(i, keyevent);
        boolean flag;
        if(boolean1 != null)
            flag = boolean1.booleanValue();
        else
            flag = super.onKeyDown(i, keyevent);
        return flag;
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        Boolean boolean1 = mDelegate.onKeyUp(i, keyevent);
        boolean flag;
        if(boolean1 != null)
            flag = boolean1.booleanValue();
        else
            flag = super.onKeyUp(i, keyevent);
        return flag;
    }

    protected void onPause()
    {
        mDelegate.onPause();
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        mDelegate.onResume();
    }

    public boolean onSearchRequested()
    {
        return mDelegate.onSearchRequested();
    }

    protected void setPrimaryActionFace(int i, String s)
    {
        mDelegate.setPrimaryActionFace(i, s);
    }

    protected void setPrimaryActionIcon(int i)
    {
        mDelegate.setPrimaryActionIcon(i);
    }

    public void setTransitioningToBackground(boolean flag)
    {
        mDelegate.setTransitioningToBackground(flag);
    }

    public void startActivity(Intent intent)
    {
        mDelegate.startActivity(intent);
        super.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int i)
    {
        mDelegate.startActivityForResult(intent, i);
        super.startActivityForResult(intent, i);
    }

    public void titleBarClickHandler(View view)
    {
        Intent intent = IntentUriHandler.getIntentForUri(this, "fb://root");
        intent.setFlags(0x4000000);
        startActivity(intent);
    }

    public void titleBarPrimaryActionClickHandler(View view)
    {
        mDelegate.titleBarPrimaryActionClickHandler(view);
    }

    public void titleBarSearchClickHandler(View view)
    {
        mDelegate.titleBarSearchClickHandler(view);
    }

    public static final String INTENT_WITHIN_TAB = "within_tab";
    private FacebookActivityDelegate mDelegate;
}
