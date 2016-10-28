package com.droidacid.apticalc.common;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.droidacid.apticalc.R;
import com.droidacid.apticalc.more.AboutUs;
import com.droidacid.apticalc.more.Report;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    private static final String FEEDBACK_URL = "http://www.droidacid.com/suggestions/";
    private static final String LIKE_US = "http://www.facebook.com/AptitudeCrackerApp/";
    private static final String PLAY_STORE_URL = "http://play.google.com/store/apps/details?id=" +
            AptitudeApplication.getInstance().getPackageName();
    private static final String PLAY_STORE_URI = "market://details?id=" +
            AptitudeApplication.getInstance().getPackageName();

    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
    }

    public abstract int getLayout();

    public void showToolbar(String title, boolean showBack) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(showBack);
    }

    public void showToolbar(Toolbar toolbar, String title, boolean showBack) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(showBack);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.likeButton:
                try {
                    CommonUtils.startActivityWithAction(this, PLAY_STORE_URI);
                } catch (android.content.ActivityNotFoundException e) {
                    CommonUtils.startActivityWithAction(this, PLAY_STORE_URL);
                }
                break;
            case R.id.reportBug:
                CommonUtils.startActivity(this, Report.class);
                break;
            case R.id.feedback:
                CommonUtils.startActivityWithAction(this, FEEDBACK_URL);
                break;
            case R.id.facebook:
                CommonUtils.startActivityWithAction(this, LIKE_US);
                break;
            case R.id.about:
                CommonUtils.startActivity(this, AboutUs.class);
                break;
        }
        return true;
    }
}