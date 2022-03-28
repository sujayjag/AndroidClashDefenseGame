package com.example.towerdefense;

import android.view.View;
import android.widget.ImageButton;

public class Place {
    private ImageButton place;
    private boolean visible;
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
}
