package com.example.towerdefense;

import android.graphics.Path;
import android.widget.ImageView;
import android.widget.LinearLayout;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class Difficulty {
    private int layout;
    private Path path;
    public Difficulty (Player player, int width, int height) {
        String difficulty = player.getDifficulty();
        if (difficulty.equals("easy")) {
            setLayout(R.layout.activity_easy_screen);
            //path.lineTo
        } else if (difficulty.equals("medium")) {
            setLayout(R.layout.activity_medium_screen);
            //path.lineTo
        } else {
            setLayout(R.layout.activity_hard_screen);
            //path.lineTo
            int x = 0;
            int y = 0;
            
            path = new Path();
            path.moveTo(x, y);

            y += 200;
            path.lineTo(x, y);

            x += 800;
            path.lineTo(x, y);

            y += 200;
            path.lineTo(x, y);
        }
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }
}
