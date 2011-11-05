package com.facebook.katana.activity.media;

import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.katana.model.FacebookPhoto;
import com.facebook.katana.util.ImageUtils;
import com.facebook.katana.util.StringUtils;

public class PhotoInfoDialog {

   public PhotoInfoDialog() {}

   public static Dialog create(Context var0, FacebookPhoto var1) {
      Builder var2 = new Builder(var0);
      Builder var3 = var2.setIcon(17301659);
      String var4 = var0.getString(2131362093);
      var2.setTitle(var4);
      View var6 = ((LayoutInflater)var0.getSystemService("layout_inflater")).inflate(2130903041, (ViewGroup)null);
      var2.setView(var6);
      fillView(var0, var6, var1);
      String var8 = var0.getString(2131362013);
      var2.setPositiveButton(var8, (OnClickListener)null);
      return var2.create();
   }

   private static void fillView(Context var0, View var1, FacebookPhoto var2) {
      ImageView var3 = (ImageView)var1.findViewById(2131623940);
      byte[] var4 = var2.getImageBytes();
      if(var4 != null) {
         int var5 = var4.length;
         Bitmap var6 = ImageUtils.decodeByteArray(var4, 0, var5);
         if(var6 != null) {
            var3.setImageBitmap(var6);
         }
      } else {
         var3.setImageResource(2130837760);
      }

      TextView var7 = (TextView)var1.findViewById(2131623941);
      String var8 = var2.getCaption();
      var7.setText(var8);
      TextView var9 = (TextView)var1.findViewById(2131623943);
      StringUtils.TimeFormatStyle var10 = StringUtils.TimeFormatStyle.MONTH_DAY_YEAR_STYLE;
      long var11 = var2.getCreatedMs();
      String var13 = StringUtils.getTimeAsString(var0, var10, var11);
      var9.setText(var13);
      var1.findViewById(2131623944).setVisibility(8);
      var1.findViewById(2131623945).setVisibility(8);
      var1.findViewById(2131623946).setVisibility(8);
      var1.findViewById(2131623947).setVisibility(8);
   }

   public static void update(Dialog var0, FacebookPhoto var1) {
      Context var2 = var0.getContext();
      View var3 = var0.findViewById(2131623938);
      fillView(var2, var3, var1);
   }
}
