package com.squeeze.squeezeadmin.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;
import android.widget.ImageView;

import com.squeeze.squeezeadmin.R;

public class MainActivity extends AppCompatActivity {

    /* UI */

    private Toolbar mainToolbar;

    private ImageView addEmployeeButton;
    private ImageView viewEmployeeButton;
    private ImageView trainNetworkButton;
    private ImageView reportsEmployeeButton;
    private ImageView settingsButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Initializing UI */
        mainToolbar = (Toolbar) findViewById(R.id.mainToolbar);
        addEmployeeButton = (ImageView) findViewById(R.id.addEmployeeButton);
        viewEmployeeButton = (ImageView) findViewById(R.id.viewEmployeeButton);
        trainNetworkButton = (ImageView) findViewById(R.id.trainEmployeeButton);
        reportsEmployeeButton= (ImageView) findViewById(R.id.reportsEmployeeButton);
        settingsButton = (ImageView) findViewById(R.id.settingsButton);

        /* Setting up status bar color and toolbar*/
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Drawable icon = ContextCompat.getDrawable(this,R.drawable.ic_logo_24px);
        mainToolbar.setNavigationIcon(icon);
        mainToolbar.setTitle(R.string.app_name);

        /* Setting up listeners */
        addEmployeeButton.setOnClickListener((view)->{
            Intent intent = new Intent(MainActivity.this,AddEmployeeActivity.class);
            startActivity(intent);
        });

        viewEmployeeButton.setOnClickListener( (view) -> {
            Intent intent = new Intent(MainActivity.this,ViewEmployeesActivity.class);
            startActivity(intent);
        });

        trainNetworkButton.setOnClickListener( (view) -> {
            Intent intent = new Intent(MainActivity.this, TrainNetworkActivity.class);
            startActivity(intent);
        });

        reportsEmployeeButton.setOnClickListener((view) -> {
            Intent intent = new Intent(MainActivity.this, ViewLogsActivity.class);
            startActivity(intent);
        });

        settingsButton.setOnClickListener((view) -> {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        });

    }
}
//TODO: Settings must allow to delete all the pictures from the folders.
// TODO : Delete employee by swipping
