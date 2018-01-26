package com.example.xsourav.androidclock;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TimePicker picker;
    TextView timetextView;
    Button button;
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void SetTimer()

    {   picker.setEnabled(true);
        final int a,b;
        String time;
        int d;
        Random rand=new Random();
        a=rand.nextInt(24);
        b=rand.nextInt(60);
        d=rand.nextInt(2);
        if (a<9||b<9)
        {
            timetextView.setText("0"+Integer.toString(a)+":"+"0"+Integer.toString(b));
        }
        timetextView.setText(Integer.toString(a)+":"+Integer.toString(b));
       /* new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long l) {
                TextView textView=(TextView)findViewById(R.id.instruction);
                textView.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFinish() {
                int hour=picker.getHour();
                int min=picker.getMinute();
                if(a==hour&&b==min)
                {
                    Toast.makeText(MainActivity.this, "Correct time", Toast.LENGTH_SHORT).show();
                }
                picker.setEnabled(false);
            }
        };*/

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timetextView=findViewById(R.id.time_display);
        picker=(TimePicker)findViewById(R.id.timePicker);
        button=(Button) findViewById(R.id.timeButton);
        picker.setIs24HourView(true);
        SetTimer();
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                SetTimer();
            }
        });
    }
}
