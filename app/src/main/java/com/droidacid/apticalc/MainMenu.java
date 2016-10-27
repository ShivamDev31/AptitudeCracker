package com.droidacid.apticalc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.droidacid.apticalc.aptitudes.AptiCalc;
import com.droidacid.apticalc.formulas.Formulas;
import com.droidacid.apticalc.tipsandtricks.TipsAndTricks;
import com.droidacid.apticalc.tys.OneDifficulty;

public class MainMenu extends MyActionBar implements OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionBar();
        setContentView(R.layout.main_menu);
        GridView myGridView;
        myGridView = (GridView) findViewById(R.id.gridView);
        myGridView.setAdapter(new GridAdapter(this));
        myGridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent;

        switch (position) {
            case 0:
                intent = new Intent(this, AptiCalc.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(this, OneDifficulty.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(this, TipsAndTricks.class);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(this, Formulas.class);
                startActivity(intent);
                break;
        }
    }
}