package com.example.timers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Debug;
import android.os.Handler;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  public int min=2,sec=60;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SeekBar seekBar;
        setContentView(R.layout.activity_main); 
        seekBar=findViewById(R.id.bar);
        seekBar.setMax(600);
        seekBar.setProgress(30);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int minutes = progress / 60;
                int seconds = progress % 60;
                TextView clock=findViewById(R.id.text_clocl);
                clock.setText(Integer.toString(minutes)+":"+Integer.toString(seconds));

            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        new CountDownTimer( convert(),1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                 Log.i("you have seconds left", String.valueOf(millisUntilFinished /1000));
            }

            @Override
            public void onFinish() {
                Log.i("you have seconds left", "done");

            }
        }.start();
    }
    void count()

    {
       while (min!=-1)
        {sec--;
            if (sec==0)
            {
                sec=59;
                min=min-1;
            }
            if (min==0&&sec==0)
            {
                Log.i("time is ",":"+0+":"+0);
            }
            else

                Log.i("time is ",":"+min+":"+sec);
//            if (sec!=0&&min==0)
//            {
//                sec--;
//            }

        }
//       while (sec!=0)
//       {
//           sec--;
//           Log.i("time is ",":"+min+":"+sec);
//       }

    }

public int convert()
{
    return min * 60000 + sec * 1000;
}





}
