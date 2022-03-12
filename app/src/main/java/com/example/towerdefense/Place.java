package com.example.towerdefense;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Place {
    public Button place;
    public ImageButton cannon1;
    public ImageButton cannon2;
    public ImageButton cannon3;

    Place(Button place, ImageButton cannon1, ImageButton cannon2, ImageButton cannon3) {
        this.place = place;
        this.cannon1 = cannon1;
        this.cannon2 = cannon2;
        this.cannon3 = cannon3;

        this.cannon1.setVisibility(View.GONE);
        this.cannon2.setVisibility(View.GONE);
        this.cannon3.setVisibility(View.GONE);

    }
}
