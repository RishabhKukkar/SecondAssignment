package com.cmile.secondassignment.ui;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import com.cmile.secondassignment.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PersonActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.bt_pickDate)
    Button bt_pickDate;

    @BindView(R.id.bt_pickCountry)
    Button bt_pickCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        ButterKnife.bind(this);

        bt_pickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PersonActivity.this, DatepickerActivity.class));
            }
        });

        bt_pickCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PersonActivity.this, CountryandStateActivity.class));
            }
        });


        setToolbar();
    }

    private void setToolbar() {
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu_actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case R.id.view_users:
                startActivity(new Intent(PersonActivity.this, ListUserActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

