package com.example.harvey.datepicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements OnClickListener,DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener{

    TextView date;
    TextView time;
    TextView log;
    Calendar c=Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date=(TextView)findViewById(R.id.textView1);
        time=(TextView)findViewById(R.id.textView2);
        log=(TextView)findViewById(R.id.log);
        date.setOnClickListener(this);
        time.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        String msg="";
        if (view.getId()==R.id.textView1){
            new DatePickerDialog(this,this,c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show();

        }

        else{

            new TimePickerDialog(this,this,c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE),true).show();
        }


      //  log.setText(msg);

    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonh) {

        date.setText("日期:"+year+"/"+(monthOfYear+1)+"/"+dayOfMonh);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        time.setText("时间:"+hourOfDay+":"+minute);
    }
}
