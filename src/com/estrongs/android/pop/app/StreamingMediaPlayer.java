package com.estrongs.android.pop.app;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.MediaController;
import com.estrongs.android.pop.a;
import com.estrongs.android.pop.esclasses.ESActivity;
import com.estrongs.android.ui.view.ESVideoView;
import com.estrongs.android.util.ap;
import com.estrongs.android.util.bg;
import com.estrongs.fs.FileSystemException;
import com.estrongs.fs.d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamingMediaPlayer
  extends ESActivity
{
  private boolean A = false;
  private d a = d.a(this);
  private ESVideoView b;
  private int c = 0;
  private MediaController d;
  private boolean e = false;
  private long f;
  private long g = 0L;
  private long h = 0L;
  private final Handler i = new Handler();
  private File j;
  private final String k = a.f + "/downloadingMedia.dat";
  private boolean l;
  private String m;
  private MediaPlayer n = null;
  private boolean o = false;
  private Thread p;
  private final int q = 1;
  private final int r = 2;
  private final int t = 3;
  private final int u = 4;
  private final int v = 5;
  private final int w = 6;
  private ProgressDialog x = null;
  private ProgressDialog y = null;
  private boolean z = false;
  
  private void a(String paramString, long paramLong)
  {
    p = new Thread(new mq(this, paramString));
    p.start();
  }
  
  private void a(boolean paramBoolean)
  {
    i.post(new mj(this, paramBoolean));
  }
  
  private void b()
  {
    l = true;
    if ((p != null) && (p.isAlive())) {
      p.interrupt();
    }
  }
  
  private boolean c()
  {
    if (l)
    {
      if (b != null) {}
      return false;
    }
    return true;
  }
  
  private void d()
  {
    try
    {
      if ((!e) && (g > 1048576L))
      {
        e();
        return;
      }
      if ((e) && (b.isPlaying()) && (b.getDuration() - b.getCurrentPosition() <= 1000))
      {
        a(false);
        return;
      }
    }
    catch (IllegalStateException localIllegalStateException) {}catch (NullPointerException localNullPointerException) {}
  }
  
  private void e()
  {
    mi localmi = new mi(this);
    i.post(localmi);
  }
  
  private boolean f()
  {
    return g == f;
  }
  
  private void g()
  {
    float f1 = (float)g / (float)f;
    if ((x != null) && (x.isShowing())) {
      x.setProgress((int)g);
    }
  }
  
  private void h()
  {
    b.seekTo(0);
    b.start();
    h = 0L;
    e = true;
  }
  
  private void i()
  {
    A = true;
    a(z);
  }
  
  public void a()
  {
    l = true;
    c();
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (!o) {
        showDialog(paramInt);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = a.e(paramString);
      if (paramString == null)
      {
        i.post(new mt(this));
        return;
      }
    }
    catch (FileSystemException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
      j = new File(k);
      if (j.exists()) {
        j.delete();
      }
    }
    for (;;)
    {
      Object localObject;
      byte[] arrayOfByte;
      int i1;
      int i3;
      int i2;
      try
      {
        localObject = j.getParentFile();
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        boolean bool = j.createNewFile();
        if (!bool) {}
        localObject = new FileOutputStream(j);
        arrayOfByte = new byte[262144];
        i1 = 0;
        i3 = paramString.read(arrayOfByte, 0, 262144);
        i2 = i3;
        if (i3 < 0)
        {
          paramString.close();
          if (!c()) {
            break;
          }
          i();
          return;
        }
      }
      catch (IOException paramString)
      {
        i.post(new mu(this));
        return;
      }
      do
      {
        i2 += i3;
        if (i2 >= 262144) {
          break;
        }
        i3 = paramString.read(arrayOfByte, i2, 262144 - i2);
      } while (i3 >= 0);
      ((FileOutputStream)localObject).write(arrayOfByte, 0, i2);
      i1 += i2;
      g = i1;
      h += i2;
      d();
      g();
      if (g < f) {
        if (c()) {}
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    setDefaultKeyMode(2);
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    getWindow().setFlags(2000, 1024);
    setContentView(2130903380);
    m = getIntent().getData().toString();
    d = new MediaController(this);
    b = ((ESVideoView)findViewById(2131625376));
    b.setMediaController(d);
    d.requestFocus();
    b.setOnPreparedListener(new me(this));
    b.setOnCompletionListener(new mk(this));
    b.setOnErrorListener(new mm(this));
    if (bg.R(ap.d(m)))
    {
      a(4);
      return;
    }
    new mo(this).start();
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new AlertDialog.Builder(this).setIcon(17301543).setTitle(2131231716).setCancelable(false).setMessage(2131232382).setPositiveButton(2131231270, new mv(this)).create();
    case 2: 
      return new AlertDialog.Builder(this).setIcon(17301543).setTitle(2131231716).setCancelable(false).setMessage(2131231850).setPositiveButton(2131231270, new mw(this)).create();
    case 3: 
      return new AlertDialog.Builder(this).setIcon(17301543).setTitle(2131231716).setMessage(2131232384).setCancelable(false).setPositiveButton(2131231270, new mf(this)).create();
    case 4: 
      return new AlertDialog.Builder(this).setIcon(17301543).setTitle(2131231716).setCancelable(false).setMessage(2131232383).setPositiveButton(2131231270, new mg(this)).create();
    case 5: 
      x = new ProgressDialog(this);
      x.setIcon(17301543);
      x.setTitle(2131232381);
      x.setProgressStyle(1);
      x.setCancelable(false);
      x.setMessage(getText(2131232380));
      x.setButton2(getText(2131231265), new mh(this));
      return x;
    }
    y = new ProgressDialog(this);
    y.setMessage(getText(2131232182));
    y.setIndeterminate(true);
    y.setCancelable(true);
    return y;
  }
  
  public void onDestroy()
  {
    b();
    if ((j != null) && (j.exists())) {
      j.delete();
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0)) {
      a();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    if (e)
    {
      if (b.isPlaying()) {
        b.pause();
      }
      c = b.getCurrentPosition();
    }
    if (isFinishing()) {
      o = true;
    }
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    c = paramBundle.getInt("playback_position", 0);
  }
  
  public void onResume()
  {
    super.onResume();
    if (e)
    {
      b.seekTo(c);
      b.start();
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putInt("playback_position", c);
  }
  
  public void onStop()
  {
    super.onStop();
  }
}

/* Location:
 * Qualified Name:     com.estrongs.android.pop.app.StreamingMediaPlayer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */