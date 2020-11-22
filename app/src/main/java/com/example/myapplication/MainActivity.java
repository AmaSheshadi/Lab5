package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1;
    private NotificationCompat.Builder New;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.button);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel nc = new NotificationChannel("01", "XYZ", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager nm = getSystemService((NotificationManager.class));
            nm.createNotificationChannel(nc);
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder ncb= new NotificationCompat.Builder(getApplicationContext(),"01");
                ncb.setSmallIcon(R.drawable.ic_baseline_account_circle_24);
                ncb.setContentTitle("My Notification");
                ncb.setContentText("Hello Ama! Welcome to the MAD team");
                NotificationManagerCompat nmc = NotificationManagerCompat.from(MainActivity.this);
                nmc.notify(1,ncb.build());

            }
        });
    }
}