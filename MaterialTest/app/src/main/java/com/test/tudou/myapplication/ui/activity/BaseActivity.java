package com.test.tudou.myapplication.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by tudou on 14-12-22.
 */
public class BaseActivity extends FragmentActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  /**
   * Converts an intent into a {@link Bundle} suitable for use as fragment arguments.
   */
  public static Bundle intentToFragmentArgments(Intent intent) {
    Bundle arguments = new Bundle();
    if(intent == null) {
      return arguments;
    }
    final Uri data = intent.getData();
    if (data != null) {
      arguments.putParcelable("_uri", data);
    }
    final Bundle extras = intent.getExtras();
    if (extras != null) {
      arguments.putAll(intent.getExtras());
    }

    return arguments;
  }

  /**
   * Converts a fragment arguments bundle into an intent.
   */
  public static Intent fragmentArgmentsToIntent(Bundle arguments) {
    Intent intent = new Intent();
    if (arguments == null) {
      return intent;
    }

    final Uri data = arguments.getParcelable("_uri");
    if (data != null) {
      intent.setData(data);
    }

    intent.putExtras(arguments);
    intent.removeExtra("_uri");
    return intent;
  }
}
