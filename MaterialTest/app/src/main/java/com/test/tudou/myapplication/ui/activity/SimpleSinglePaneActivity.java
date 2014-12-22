package com.test.tudou.myapplication.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.test.tudou.myapplication.R;

/**
 * Created by tudou on 14-12-22.
 */
public abstract class SimpleSinglePaneActivity extends BaseActivity {

  private Fragment mFragment;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getContentViewResId());

    if (savedInstanceState == null) {
      mFragment = onCreatePane();
      mFragment.setArguments(intentToFragmentArgments(getIntent()));
      getSupportFragmentManager().beginTransaction()
          .add(R.id.root_container, mFragment, "single_pane")
          .commit();
    } else {
      mFragment = getSupportFragmentManager().findFragmentByTag("single_pane");
    }
  }

  private int getContentViewResId() {
    return R.layout.activity_singlepane_empty;
  }

  /**
   * Called in <code>onCreate</code> when the fragment constituting this activity is needed.
   * The returned fragment's arguments will be set to the intent used to invoke this activity.
   */
  protected abstract Fragment onCreatePane();

  public Fragment getFragment() {
    return mFragment;
  }

  @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    mFragment.onActivityResult(requestCode, resultCode, data);
  }
}
