package com.example.xsourav.androidclock;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TimePicker picker;
    TextView timetextView;
    Button button,check;
    int a,b;
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void SetTimer()

    {
        String time,s="";
        int d;
        Random rand=new Random();
        a=rand.nextInt(24);
        b=rand.nextInt(60);
        d=rand.nextInt(2);
        if (a<10)
        {
            s+= "0"+Integer.toString(a)+":"+Integer.toString(b);
            timetextView.setText(s);
        }
        else if(b<10)
        {
            s+=(Integer.toString(a)+":"+"0"+Integer.toString(b));
            timetextView.setText(s);
        }
        else if (a<10&&b<10)
        {
            s+=("0"+Integer.toString(a)+":"+"0"+Integer.toString(b));
            timetextView.setText(s);
        }
        else
        {
            timetextView.setText(Integer.toString(a)+":"+Integer.toString(b));
        }
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
    public void checkTime()
    {
        MediaPlayer mediaPlayer;
        int hr=picker.getHour();
        int min=picker.getMinute();

        if (a==hr && b==min)
        {
            Toast.makeText(this, "correct match", Toast.LENGTH_SHORT).show();
            mediaPlayer=MediaPlayer.create(this,R.raw.correct);
            mediaPlayer.start();

        }
        else

        {
            Toast.makeText(this, "Try Again", Toast.LENGTH_SHORT).show();
            mediaPlayer=MediaPlayer.create(this,R.raw.wrong);
            mediaPlayer.start();
        }
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

        check=(Button)findViewById(R.id.checkButton);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkTime();
            }
        });
    }
}
