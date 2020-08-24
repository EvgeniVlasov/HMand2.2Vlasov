package com.example.hmand22vlasov;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.GregorianCalendar;

public class Calendar_Activity extends AppCompatActivity {
    private Button bStart;
    private Button bFinish;
    private Button bOk;
    private CalendarView cStart;
    private CalendarView cFinish;

    private String cStartTitle;
    private long cStartDate;
    private long cFinishDate;
    private String cFinishTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_);
        initView();
    }
    private void initView() {



        bStart = findViewById(R.id.btnStart);
        bFinish = findViewById(R.id.btnFinish);
        bOk = findViewById(R.id.btnOk);
        cStart = findViewById(R.id.calendarStart);
        cFinish = findViewById(R.id.calendarFinish);


        cStart.setVisibility(View.GONE);
        cFinish.setVisibility(View.GONE);

        bStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cStart.setVisibility(View.VISIBLE);
                cFinish.setVisibility(View.GONE);

                cStart.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                        cStartTitle = year +"-"+ month +"-"+dayOfMonth;
                        bStart.setText("Дата старта задачи: " + cStartTitle);
                        GregorianCalendar gregorianCalendar = new GregorianCalendar();
                        gregorianCalendar.set(year,month,dayOfMonth);
                        cStartDate = gregorianCalendar.getTimeInMillis();
                        cStart.setVisibility(View.GONE);

                    }
                });
            }
        });
        bFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cStart.setVisibility(View.GONE);
                cFinish.setVisibility(View.VISIBLE);

                cFinish.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                        cFinishTitle = year +"-"+month+"-"+dayOfMonth;
                        bFinish.setText("Дата окончание задачи: "+cFinishTitle);
                        GregorianCalendar gregorianCalendar = new GregorianCalendar();
                        gregorianCalendar.set(year,month,dayOfMonth);
                        cFinishDate= gregorianCalendar.getTimeInMillis();
                        cFinish.setVisibility(View.GONE);
                    }
                });
            }
        });
        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cStartDate>cFinishDate) {
                    Toast.makeText(Calendar_Activity.this,"Ошибка", Toast.LENGTH_LONG).show();
                    bStart.setText("Дата старта задачи:");
                    bFinish.setText("Дата окончания задачи:");
                } else {
                    Toast.makeText(Calendar_Activity.this, " Старт"+cStartTitle + " "+" Окончание" +cFinishTitle,Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}