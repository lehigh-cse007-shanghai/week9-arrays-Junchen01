package lehigh;

import processing.core.PApplet;

import java.util.Random;


public class BubbleSort extends PApplet {


    int width = 25;
    int number = 10;
    int[] height  = new int[number];
    int[] x = new int[] {15, 65, 115, 165, 215, 265, 315, 365, 415 , 465};
    int[] y = new int[number];
//    int[] height  = new int[] {150, 280, 60, 310, 100, 430, 90, 200, 460, 390};
//    int[] x = new int[] {15, 65, 115, 165, 215, 265, 315, 365, 415 , 465};
//    int[] y = new int[] {500-height[0],500-height[1], 500-height[2], 500-height[3],500-height[4], 500-height[5],
//            500-height[6],500-height[7], 500-height[8], 500-height[9]};
//    int[] y = new int[] {350, 220, 440, 190, 400, 70, 410, 300, 40, 390};
    int i = 0;
    int max = height.length-1;
    int [][] color = new int [10] [3] ;
    int z = 0;



    public void settings(){
        size(500,500);
        Random random = new Random();
        for (int i = 0; i < x.length ; i++){
            height[i] = (int) random(50,450);
            y[i] = 500-height[i];
            color[i] = new int[] {255,255,255};
            }
    }

    public void draw(){
        delay(500);
        background(255);

        if (i >= max) {
            i = 0;
            color[max][0] = 0;
            color[max][1] = 255;
            color[max][2] = 0;
            max--;
        }


        color[Math.abs(i-1)][0] = 255;
        color[Math.abs(i-1)][1] = 255;
        color[Math.abs(i-1)][2] = 255;
        if (i-1 < 0 ){
            color[max][0] = 255;
            color[max][1] = 255;
            color[max][2] = 255;
        }

        color[i][0] = 255;
        color[i][1] = 178;
        color[i][2] = 102;
        color[i+1][0] = 255;
        color[i+1][1] = 178;
        color[i+1][2] = 102;

        if(max - 1 < 0){
            color[0][0] = 0;
            color[0][1] = 255;
            color[0][2] = 0;
            color[1][0] = 0;
            color[1][1] = 255;
            color[1][2] = 0;
        }
        if (height[i] > height[i + 1]){
        z++;
            if (z == 2){
                z = 0;
                color[i][0] = 0;
                color[i][1] = 128;
                color[i][2] = 255;
                color[i+1][0] = 0;
                color[i+1][1] = 128;
                color[i+1][2] = 255;
                if (height[i] > height[i + 1]) {
                    int tmp = height[i];
                    height[i] = height[i+1];
                    height[i+1] = tmp;
                    tmp = y[i];
                    y[i] = y[i+1];
                    y[i+1] = tmp;
                }
            i++;
            }
        }else {
            i++;
        }


        for (int i = 0; i < height.length; i++){
            fill(color[i][0],color[i][1],color[i][2]);
            rect(x[i], y[i], width, height[i]);
        }

    }


    public static void main(String[] args) {
        String[] processingArgs = {"BubbleSort"};
        BubbleSort bubbleSort = new BubbleSort();
        PApplet.runSketch(processingArgs, bubbleSort);
    }

}
