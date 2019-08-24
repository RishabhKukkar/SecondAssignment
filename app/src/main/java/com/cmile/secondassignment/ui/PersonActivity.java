package com.cmile.secondassignment.ui;

import android.bluetooth.BluetoothAssignedNumbers;
import android.content.Intent;
import android.support.annotation.Nullable;
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
import com.cmile.secondassignment.utils.Common;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.cmile.secondassignment.utils.Constants.DATE;
import static com.cmile.secondassignment.utils.Constants.DATEPICKER_RESULT;
import static com.cmile.secondassignment.utils.Constants.SET_DATE;

public class PersonActivity extends BaseActivity {
    private Common common = new Common();

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
                startActivityForResult(new Intent(PersonActivity.this, DatepickerActivity.class), 2);
            }
        });

        bt_pickCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PersonActivity.this, CountryandStateActivity.class));
            }
        });

        setupToolbar(toolbar, getString(R.string.app_name));
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == DATEPICKER_RESULT) {
            if (data != null && data.getExtras() != null) {
                Bundle bundle = data.getBundleExtra(SET_DATE);
                common.postDate = bundle.getString(DATE);
                setDate(common.postDate);
            }
        }
    }

    private void setDate(String date) {
        bt_pickDate.setText(date);
    }

}

