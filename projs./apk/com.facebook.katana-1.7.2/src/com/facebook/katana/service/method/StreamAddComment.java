// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   StreamAddComment.java

package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.katana.model.FacebookApiException;
import com.facebook.katana.util.jsonmirror.JMException;
import java.io.IOException;
import java.util.Map;
import org.codehaus.jackson.JsonParseException;

// Referenced classes of package com.facebook.katana.service.method:
//            ApiMethod, FBJsonFactory, ApiMethodListener

public class StreamAddComment extends ApiMethod
{

    public StreamAddComment(Context context, Intent intent, String s, long l, String s1, String s2, 
            ApiMethodListener apimethodlistener)
    {
        super(context, intent, "GET", "stream.addComment", com.facebook.katana.Constants.URL.getApiUrl(context), apimethodlistener);
        mParams.put("call_id", (new StringBuilder()).append("").append(System.currentTimeMillis()).toString());
        mParams.put("session_key", s);
        mParams.put("uid", (new StringBuilder()).append("").append(l).toString());
        mParams.put("post_id", s1);
        mParams.put("comment", s2);
    }

    public String getCommentId()
    {
        return mCommentId;
    }

    protected void parseResponse(String s)
        throws FacebookApiException, JsonParseException, IOException, JMException
    {
        printJson(s);
        if(s.startsWith("{"))
        {
            throw new FacebookApiException(mJsonFactory.createJsonParser(s));
        } else
        {
            mCommentId = removeChar(s, '"');
            return;
        }
    }

    private String mCommentId;
}
