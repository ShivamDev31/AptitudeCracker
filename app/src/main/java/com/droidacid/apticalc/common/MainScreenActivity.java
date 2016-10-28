package com.droidacid.apticalc.common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.droidacid.apticalc.R;
import com.droidacid.apticalc.aptitudes.AptitudeActivity;
import com.droidacid.apticalc.formulas.Formulas;
import com.droidacid.apticalc.tipsandtricks.TipsAndTricks;
import com.droidacid.apticalc.tys.OneDifficulty;

public class MainScreenActivity extends BaseActivity implements OnItemClickListener {

    private static final int APTITUDE_SECTION = 0;
    private static final int TEST_SECTION = 1;
    private static final int TIPS_SECTION = 3;
    private static final int FORMULAS_SECTION = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showToolbar(getString(R.string.app_name), false);
        GridView myGridView = (GridView) findViewById(R.id.gridView);
        myGridView.setAdapter(new GridAdapter(this));
        myGridView.setOnItemClickListener(this);
    }

    @Override
    public int getLayout() {
        return R.layout.main_menu;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent;

        switch (position) {
            case APTITUDE_SECTION:
                intent = new Intent(this, AptitudeActivity.class);
                startActivity(intent);
                break;
            case TEST_SECTION:
                intent = new Intent(this, OneDifficulty.class);
                startActivity(intent);
                break;
            case TIPS_SECTION:
                intent = new Intent(this, TipsAndTricks.class);
                startActivity(intent);
                break;
            case FORMULAS_SECTION:
                intent = new Intent(this, Formulas.class);
                startActivity(intent);
                break;
        }
    }
}