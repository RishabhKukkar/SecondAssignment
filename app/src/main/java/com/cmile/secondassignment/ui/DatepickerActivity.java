package com.cmile.secondassignment.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;

import com.cmile.secondassignment.R;
import com.cmile.secondassignment.utils.Common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.cmile.secondassignment.utils.Constants.DATE;
import static com.cmile.secondassignment.utils.Constants.DATEPICKER_RESULT;
import static com.cmile.secondassignment.utils.Constants.SET_DATE;

public class DatepickerActivity extends BaseActivity {
    private Common common=new Common();

    @BindView(R.id.datePicker)
    DatePicker datePicker;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.bt_selectDate)
    Button bt_selectDate;

    @BindView(R.id.bt_goback)
    Button bt_goback;

    Calendar calendar = Calendar.getInstance();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datepicker);
        ButterKnife.bind(this);
        setupToolbar(toolbar,getString(R.string.date_picker_activity));
        bt_goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        bt_selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();    // calling/parent intent //
                Bundle bundle = new Bundle();
                bundle.putString(DATE,common.postDate);
                intent.putExtra(SET_DATE, bundle);
                setResult(DATEPICKER_RESULT, intent);
                finish();
            }
        });

        calendar.setTimeInMillis(System.currentTimeMillis());
        /*datePicker.getCalendarView().setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Log.d("tag", "finally found the listener, the date is: year " + year + ", month "  + month + ", dayOfMonth " + dayOfMonth);
            }
        });*/
        datePicker.setMaxDate(System.currentTimeMillis());
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                formateDate(calendar);
            }
        });

    }
    private void formateDate(Calendar calendar) {
        String formattedDate = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formattedDate, Locale.getDefault());
        common.postDate = simpleDateFormat.format(calendar.getTime());
    }
}
