package com.android.email.activity;

import android.content.Context;
import com.android.email.activity.IconListAdapter;
import java.util.ArrayList;
import java.util.List;

public class AddAttachmentSelectorAdapter extends IconListAdapter {

   public static final int ATTACHMENT_ADD_AUDIO = 9;
   public static final int ATTACHMENT_ADD_DRAWINGPAD = 19;
   public static final int ATTACHMENT_ADD_IMAGE = 4;
   public static final int ATTACHMENT_ADD_MYFILES = 0;
   public static final int ATTACHMENT_ADD_PENMEMO = 18;
   public static final int ATTACHMENT_ADD_VCAL = 2;
   public static final int ATTACHMENT_ADD_VCARD = 1;
   public static final int ATTACHMENT_ADD_VIDEO = 6;
   public static final int ATTACHMENT_ADD_VNOTE = 3;
   public static final int ATTACHMENT_ADD_VTODO = 17;
   public static final int ATTACHMENT_LOCATION = 8;
   public static final int ATTACHMENT_RECORD_AUDIO = 16;
   public static final int ATTACHMENT_RECORD_VIDEO = 7;
   public static final int ATTACHMENT_TAKE_PICTURE = 5;


   public AddAttachmentSelectorAdapter(Context var1) {
      List var2 = getData(var1);
      super(var1, var2);
   }

   protected static void addItem(List<IconListAdapter.IconListItem> var0, String var1, int var2, int var3) {
      AddAttachmentSelectorAdapter.AttachmentListItem var4 = new AddAttachmentSelectorAdapter.AttachmentListItem(var1, var2, var3);
      var0.add(var4);
   }

   protected static List<IconListAdapter.IconListItem> getData(Context var0) {
      ArrayList var1 = new ArrayList();
      String var2 = var0.getString(2131166568);
      addItem(var1, var2, 2130837549, 0);
      String var3 = var0.getString(2131166572);
      addItem(var1, var3, 2130837553, 4);
      String var4 = var0.getString(2131166573);
      addItem(var1, var4, 2130837543, 5);
      String var5 = var0.getString(2131166574);
      addItem(var1, var5, 2130837557, 6);
      String var6 = var0.getString(2131166575);
      addItem(var1, var6, 2130837544, 7);
      String var7 = var0.getString(2131166576);
      addItem(var1, var7, 2130837541, 9);
      String var8 = var0.getString(2131166577);
      addItem(var1, var8, 2130837554, 16);
      String var9 = var0.getString(2131166569);
      addItem(var1, var9, 2130837550, 1);
      String var10 = var0.getString(2131166570);
      addItem(var1, var10, 2130837542, 2);
      String var11 = var0.getString(2131166571);
      addItem(var1, var11, 2130837548, 3);
      String var12 = var0.getString(2131166815);
      addItem(var1, var12, 2130837878, 17);
      return var1;
   }

   public int buttonToCommand(int var1) {
      return ((AddAttachmentSelectorAdapter.AttachmentListItem)this.getItem(var1)).getCommand();
   }

   public static class AttachmentListItem extends IconListAdapter.IconListItem {

      private int mCommand;


      public AttachmentListItem(String var1, int var2, int var3) {
         super(var1, var2);
         this.mCommand = var3;
      }

      public int getCommand() {
         return this.mCommand;
      }
   }
}
