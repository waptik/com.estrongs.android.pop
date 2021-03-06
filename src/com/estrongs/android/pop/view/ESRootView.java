package com.estrongs.android.pop.view;

import android.content.Context;
import android.gesture.Gesture;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import com.estrongs.android.ui.guesture.ESGestureCtrl;
import com.estrongs.android.ui.navigation.r;
import com.estrongs.android.util.l;
import com.estrongs.android.widget.ThumbContentViewSwitcher;

public class ESRootView
  extends ESGestureCtrl
{
  public ESRootView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ESRootView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ESRootView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private View a(View paramView1, int paramInt, View paramView2)
  {
    for (;;)
    {
      try
      {
        FileExplorerActivity localFileExplorerActivity = FileExplorerActivity.X();
        if ((localFileExplorerActivity != null) && (paramView1 != null))
        {
          if (localFileExplorerActivity.a(paramView1))
          {
            if (paramInt == 17)
            {
              if ((!u) || (c) || (y == null) || (z.getVisibility() != 0)) {
                break label318;
              }
              paramView1 = y.d();
              if ((paramView1 != null) && (paramView1.hasFocusable())) {
                return paramView1;
              }
            }
            else
            {
              if (paramInt == 33)
              {
                if ((h != null) && (localFileExplorerActivity.ap()))
                {
                  paramInt = h.getCurrentChildIndex();
                  paramView1 = h.getChildAt(paramInt);
                  continue;
                }
                if (localFileExplorerActivity.a() == null) {
                  break label318;
                }
                paramView1 = localFileExplorerActivity.a();
                continue;
              }
              if (paramInt == 130)
              {
                if ((h != null) && (localFileExplorerActivity.ap()))
                {
                  paramInt = h.getCurrentChildIndex();
                  paramView1 = h.getChildAt(paramInt);
                  continue;
                }
                if (localFileExplorerActivity.b() == null) {
                  break label318;
                }
                paramView1 = localFileExplorerActivity.b();
                continue;
              }
              if ((paramInt != 66) || (h == null)) {
                break label318;
              }
              paramInt = h.getCurrentChildIndex();
              paramView1 = h.getChildAt(paramInt);
              continue;
            }
            if (paramView2 != null) {
              break;
            }
            return localFileExplorerActivity.getCurrentFocus();
          }
        }
        else if ((u) && (!c))
        {
          if ((y != null) && (z.getVisibility() == 0)) {
            return y.d();
          }
        }
        else if (localFileExplorerActivity.a() != null)
        {
          paramView1 = localFileExplorerActivity.a();
          return paramView1;
        }
      }
      catch (Exception paramView1) {}
      return null;
      label318:
      paramView1 = null;
    }
    return paramView2;
  }
  
  public void a(Gesture paramGesture)
  {
    if (FileExplorerActivity.X() != null) {
      FileExplorerActivity.X().a(paramGesture);
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    try
    {
      boolean bool = super.dispatchKeyEvent(paramKeyEvent);
      return bool;
    }
    catch (IllegalStateException paramKeyEvent) {}
    return true;
  }
  
  public void draw(Canvas paramCanvas)
  {
    try
    {
      super.draw(paramCanvas);
      if (FileExplorerActivity.X() != null) {
        FileExplorerActivity.X().ak();
      }
      setBackgroundDrawable(null);
      return;
    }
    catch (Throwable paramCanvas)
    {
      for (;;)
      {
        paramCanvas.printStackTrace();
        l.d("ESRootView", "ESRootView.draw() catchs " + paramCanvas.getMessage());
      }
    }
  }
  
  public View focusSearch(int paramInt)
  {
    View localView1 = super.focusSearch(paramInt);
    View localView2 = a(localView1, paramInt, null);
    if (localView2 == null) {
      return localView1;
    }
    return localView2;
  }
  
  public View focusSearch(View paramView, int paramInt)
  {
    View localView = super.focusSearch(paramView, paramInt);
    paramView = a(localView, paramInt, paramView);
    if (paramView == null) {
      return localView;
    }
    return paramView;
  }
}

/* Location:
 * Qualified Name:     com.estrongs.android.pop.view.ESRootView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */