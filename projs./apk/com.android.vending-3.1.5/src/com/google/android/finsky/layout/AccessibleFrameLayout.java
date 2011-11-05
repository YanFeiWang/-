package com.google.android.finsky.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;

public class AccessibleFrameLayout extends FrameLayout {

   public AccessibleFrameLayout(Context var1) {
      super(var1);
   }

   public AccessibleFrameLayout(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent var1) {
      boolean var2 = super.dispatchPopulateAccessibilityEvent(var1);
      var1.getText().clear();
      return var2;
   }
}
