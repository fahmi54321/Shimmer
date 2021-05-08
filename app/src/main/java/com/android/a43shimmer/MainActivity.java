package com.android.a43shimmer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

public class MainActivity extends AppCompatActivity {

    ShimmerTextView shimmerTextView;
    Shimmer shimmer;
    Button button;

    boolean isStart = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shimmerTextView = (ShimmerTextView) findViewById(R.id.shimmer_tv);
        button = (Button) findViewById(R.id.btnAnim);

        shimmer = new Shimmer()
                .setDirection(Shimmer.ANIMATION_DIRECTION_RTL)
                .setDuration(500)
                .setStartDelay(300);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isStart){
                    shimmer.start(shimmerTextView);
                    button.setText("Stop Animation");
                }else{
                    shimmer.cancel();
                    button.setText("Start Animation");
                }
                isStart = !isStart;
            }
        });

    }
}