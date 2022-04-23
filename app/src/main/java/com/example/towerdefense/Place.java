package com.example.towerdefense;

import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Place {
    private final Player player;
    private ImageButton place;
    private boolean visible;
    private String cannonType;
    private Tower cannon;
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

    public void attackEnemyAnimation() {

        final Handler handler = new Handler();
        Runnable task = new Runnable() {
            public void setI(int i) {
                this.i = i;
            }

            public int getI() {
                return i;
            }

            public boolean isStop() {
                return stop;
            }

            private final boolean stop = false;
            private int i = 0;

            @Override
            public void run() {
                if (getI() % 2 == 0) {
                    if (cannonType.equals("Cannon1")) {
                        place.setImageResource(R.drawable.cannon1explosion);
                    } else if (cannonType.equals("Cannon2")) {
                        place.setImageResource(R.drawable.cannon2explosion);
                    } else if (cannonType.equals("Cannon3")) {
                        place.setImageResource(R.drawable.cannon3explosion);
                    }
                } else {
                    if (cannonType.equals("Cannon1")) {
                        place.setImageResource(R.drawable.cannon1new);
                    } else if (cannonType.equals("Cannon2")) {
                        place.setImageResource(R.drawable.cannon2newnew);
                    } else if (cannonType.equals("Cannon3")) {
                        place.setImageResource(R.drawable.cannon3newnew);
                    }
                }
                //System.out.println(i);
                setI(getI() + 1);
                if (getI() < 2) {
                    handler.postDelayed(this, 100);
                }
            }
        };
        handler.post(task);
    }


    public void attackEnemy(int milliSeconds, int arrInd, View enemyView, TextView money,
                           Enemy enemy) {
        int enemyDead = 0;
        if (milliSeconds > this.getCannon().getAttackSpeed()) {
            if (milliSeconds % this.getCannon().getAttackSpeed() <= 200
                && ((ImageView) enemyView).getAlpha() > 0) {
                //System.out.println(((ImageView) enemyView).getAlpha());
                this.attackEnemyAnimation();
                ((ImageView) enemyView).setAlpha(((ImageView) enemyView).getAlpha()
                    - this.getCannon().getAttackDamage()); // should get attack damage from canon

                if (((ImageView) enemyView).getAlpha() <= 0) {
                    //((ImageView) enemyView).setAlpha(1f);
                    enemyView.setVisibility(View.GONE);
                    player.addBalance(enemy);
                    player.enemyDefeated();
                    money.setText("Money: " + player.getBalance());
                }

            }
        }
    }


    public String getCannonType() {
        return cannonType;
    }

    public void setCannonType(String cannonType) {
        this.cannonType = cannonType;
        if (cannonType.equals("Cannon1")) {
            setCannon(new Cannon1(player, place));
        } else if (cannonType.equals("Cannon2")) {
            setCannon(new Cannon2(player, place));
        } else {
            setCannon(new Cannon3(player, place));
        }
    }

    public Tower getCannon() {
        return cannon;
    }

    public void setCannon(Tower cannon) {
        this.cannon = cannon;
    }

    public Player getPlayer() {
        return player;
    }
}
