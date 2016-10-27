package com.droidacid.apticalc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.droidacid.apticalc.more.AboutUs;
import com.droidacid.apticalc.more.Report;

public class MyActionBar extends AppCompatActivity {
    private static final String FEEDBACK_URL = "http://www.droidacid.com/suggestions/";
    private static final String LIKE_US = "http://www.facebook.com/AptitudeCrackerApp/";

    private ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionBar = getSupportActionBar();
    }

    public void showActionBar() {
        actionBar.show();
    }

    public void hideActionBar() {
        actionBar.hide();
    }

    public ActionBar actionBar() {
        return actionBar;
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
                    Intent rate = new Intent(Intent.ACTION_VIEW);
                    rate.setData(Uri.parse("market://details?id="
                            + this.getPackageName()));
                    startActivity(rate);
                } catch (android.content.ActivityNotFoundException e) {
                    Intent rate = new Intent(Intent.ACTION_VIEW);
                    rate.setData(Uri
                            .parse("http://play.google.com/store/apps/details?id="
                                    + this.getPackageName()));

                    startActivity(rate);
                }
                break;

            case R.id.reportBug:
                Intent report = new Intent(this, Report.class);
                startActivity(report);
                break;
            case R.id.feedback:
                Intent feedback = new Intent(android.content.Intent.ACTION_VIEW);
                feedback.setData(Uri.parse(FEEDBACK_URL));
                startActivity(feedback);
                break;
            case R.id.facebook:
                Intent likeus = new Intent(android.content.Intent.ACTION_VIEW);
                likeus.setData(Uri.parse(LIKE_US));
                startActivity(likeus);
                break;
            case R.id.about:
                Intent about = new Intent(this, AboutUs.class);
                startActivity(about);
                break;
        }
        return true;
    }
}