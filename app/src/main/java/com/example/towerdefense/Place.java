package com.example.towerdefense;

import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;

public class Place {
    private ImageButton place;
    private boolean visible;
    private String cannonType;
    private Tower cannon;
    private Player player;
    //add attribute of tower?

    Place(ImageButton place, Player player) {
        this.player = player;
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
                //System.out.println(i);
                i++;
                if (i < 2) {
                    handler.postDelayed(this, 100);
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
        if (cannonType.equals("Cannon1")) {
            setCannon(new Cannon1(player, place));
        } else if(cannonType.equals("Cannon2")) {
            setCannon(new Cannon2(player, place));
        } else {
            setCannon(new Cannon3(player, place));
        }
    }

    public Tower getCannon() {
        return cannon;
    }

    public Player getPlayer() { return player;}

    public void setCannon(Tower cannon) {
        this.cannon = cannon;
    }
}
