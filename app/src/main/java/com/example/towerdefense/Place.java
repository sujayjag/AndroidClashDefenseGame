package com.example.towerdefense;

import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;

import java.util.Timer;
import java.util.TimerTask;

public class Place {
    private ImageButton place;
    private boolean visible;
    private String cannonType;
    //add attribute of tower?

    Place(ImageButton place) {
        this.setPlace(place);
        setVisible(false);
        place.setVisibility(View.GONE);
    }

    public ImageButton getPlace() {
        return place;
    }

    public void setPlace(ImageButton place) {
        this.place = place;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void attackEnemy() {

        final Handler handler = new Handler();
        Runnable task = new Runnable() {
            boolean stop = false;
            int i = 0;
            @Override
            public void run() {
                if (i % 2 == 0) {
                    if (cannonType.equals("Cannon1")){
                        place.setImageResource(R.drawable.cannon1explosion);
                    } else if (cannonType.equals("Cannon2")) {
                        place.setImageResource(R.drawable.cannon2explosion);
                    } else if (cannonType.equals("Cannon3")) {
                        place.setImageResource(R.drawable.cannon3explosion);
                    }
                } else {
                    if (cannonType.equals("Cannon1")){
                        place.setImageResource(R.drawable.cannon1new);
                    } else if (cannonType.equals("Cannon2")) {
                        place.setImageResource(R.drawable.cannon2newnew);
                    } else if (cannonType.equals("Cannon3")) {
                        place.setImageResource(R.drawable.cannon3newnew);
                    }
                }
                System.out.println(i);
                i++;
                if (i < 2) {
                    handler.postDelayed(this, 1000);
                }
            }
        };
        handler.post(task);
    }

    public String getCannonType() {
        return cannonType;
    }

    public void setCannonType(String cannonType) {
        this.cannonType = cannonType;
    }
}
