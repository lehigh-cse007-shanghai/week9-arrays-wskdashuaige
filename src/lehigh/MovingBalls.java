package lehigh;

import processing.core.PApplet;

import java.util.Arrays;
import java.util.Random;

public class MovingBalls extends PApplet{
    int howmanyballs = 10;
    float x [] = new float[howmanyballs];
    float y [] = new float[howmanyballs ];
    float speedx [] = new float[howmanyballs];
    float speedy [] = new float[howmanyballs];
    float color[][] = new float[howmanyballs][3];
    int radius = 30;


    public void settings(){
        size(500, 500);
        for (int i = 0; i< howmanyballs; i++){
            x[i] = random(radius, width-radius);
            y[i] = random(radius, height-radius);
            speedx[i] = random(8);
            speedy[i] = random(8);
            color[i] = new float[]{random(255), random(255), random(255)};

        }

    }





    public void draw(){
        background(255);
        for ( int i = 0; i < howmanyballs; i++) {
            ellipse(x[i], y[i], 50, 50);
            x[i] += speedx[i];
            y[i] += speedy[i];
            fill(color[i][0], color[i][1], color[i][2]);
            for (int j = 0; j < howmanyballs; j++) {
                float X = Math.abs(x[i] - x[j]);
                float Y = Math.abs(y[i] - y[j]);

                if ((X <= 50) && Y<= 50)
                    line(x[i], y[i], x[j], y[j]);
            }

            if (x[i] > 450 || x[i] < 0) {
                speedx[i] *= -1;
            }
            if (y[i] > 450 || y[i] < 0) {
                speedy[i] *= -1;

            }


        }

        }











    public static void main(String[] args) {
        String[] processingArgs = {"MovingBalls"};
        MovingBalls movingBalls = new MovingBalls();
        PApplet.runSketch(processingArgs, movingBalls);
    }
}
