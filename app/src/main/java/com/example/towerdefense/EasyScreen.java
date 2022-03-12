package com.example.towerdefense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class EasyScreen extends AppCompatActivity {
    private TextView money;
    private TextView health;
    private Button tower1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_easy_screen);
        money = (TextView) findViewById(R.id.money1);
        health = (TextView) findViewById(R.id.health1);
        tower1 = (Button) findViewById(R.id.tower1);

        tower1.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                final int action = event.getAction();
                switch (action) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        break;

                    case DragEvent.ACTION_DRAG_EXITED:
                        break;

                    case DragEvent.ACTION_DRAG_ENTERED:
                        break;

                    case DragEvent.ACTION_DROP:
                        break;

                    case DragEvent.ACTION_DRAG_ENDED: {
                        Toast.makeText(getApplicationContext(), "Tower Bought", Toast.LENGTH_LONG).show();
                    }

                    default:
                        break;

                }
                return true;
            }
        });

        tower1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadow = new View.DragShadowBuilder(tower1);
                v.startDrag(data, shadow, null, 0);
                return false;
            }
        });

        money.setText("Money: $500");
        health.setText("Monument Health: 100");
    }
}
