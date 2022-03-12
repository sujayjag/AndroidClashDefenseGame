package com.example.towerdefense;

import android.media.Image;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Place {
    public ImageButton place;
    public boolean visible;

    Place(ImageButton place) {
        this.place = place;
        visible = false;
    }
}
