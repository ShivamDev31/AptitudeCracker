package com.droidacid.apticalc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.droidacid.apticalc.more.AboutUs;
import com.droidacid.apticalc.more.Report;

public class MyActionBar extends ActionBarActivity {


    ActionBar actionBar;

    String urlFeedback = "http://www.droidacid.com/suggestions/";
    String likeUs = "http://www.facebook.com/AptitudeCrackerApp/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        actionBar = getSupportActionBar();

        /*try {
            ViewConfiguration config = ViewConfiguration.get(this);
            Field menuKeyField = ViewConfiguration.class
                    .getDeclaredField("sHasPermanentMenuKey");

            if (menuKeyField != null) {
                menuKeyField.setAccessible(true);
                menuKeyField.setBoolean(config, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    public void showActionBar() {
        actionBar.show();
    }

    public void hideActionBar() {
        actionBar.hide();
    }

    public ActionBar actionBar() {
        // actionBar.setCustomView(R.layout.action_bar);
        // actionBar.setDisplayShowTitleEnabled(false);
        // actionBar.setDisplayShowCustomEnabled(true);
        // actionBar.setDisplayShowHomeEnabled(false);
        return actionBar;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
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
                    // rate.setFlags(Intent.);
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
                feedback.setData(Uri.parse(urlFeedback));
                startActivity(feedback);
                break;
            case R.id.facebook:
                Intent likeus = new Intent(android.content.Intent.ACTION_VIEW);
                likeus.setData(Uri.parse(likeUs));
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
