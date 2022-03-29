package com.example.towerdefense;

import android.graphics.Path;


public class Difficulty {
    private int layout;
    private Path path;
    private int numWitches;
    private int numWizards;
    private int numArchers;
//    private int width = 553;
//    private int height = 311;

    public Difficulty (Player player) {
        String difficulty = player.getDifficulty();
        if (difficulty.equals("easy")) {
            setLayout(R.layout.activity_easy_screen);
            setNumArchers(2);
            setNumWitches(2);
            setNumWizards(2);
            //path.lineTo
        } else if (difficulty.equals("medium")) {
            setLayout(R.layout.activity_medium_screen);
            setNumArchers(3);
            setNumWitches(3);
            setNumWizards(3);
            //path.lineTo
        } else {
            setLayout(R.layout.activity_hard_screen);
            setNumArchers(3);
            setNumWitches(4);
            setNumWizards(4);
            //path.lineTo

            int width = 650;
            int height = 450;

            //path
            path = new Path();
            path.moveTo((int)pxFromDp(0.183 * width), 0);


            path.lineTo((int) pxFromDp(0.183 * width), (int) pxFromDp(0.457 * height));

            path.lineTo((int) pxFromDp(0.708 * width), (int) pxFromDp(0.457 * height));

            path.lineTo((int) pxFromDp(0.708 * width), (int) pxFromDp(height));


//            int x = 0;
//            int y = 0;
//            //path
//            path = new Path();
//            path.moveTo(x, y);
//
//            y += 200;
//            path.lineTo(x, y);
//
//            x += 800;
//            path.lineTo(x, y);
//
//            y += 200;
//            path.lineTo(x, y);
        }
    }

    public static float pxFromDp(double d) {
        float scale = 432f;
        float dp = (float) d;
        float px = dp * (scale/160);
        return px;
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

    public int getNumWitches() {
        return numWitches;
    }

    public void setNumWitches(int numWitches) {
        this.numWitches = numWitches;
    }

    public int getNumWizards() {
        return numWizards;
    }

    public void setNumWizards(int numWizards) {
        this.numWizards = numWizards;
    }

    public int getNumArchers() {
        return numArchers;
    }

    public void setNumArchers(int numArchers) {
        this.numArchers = numArchers;
    }
}
