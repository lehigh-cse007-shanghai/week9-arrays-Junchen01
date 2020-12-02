package lehigh;


import processing.core.PApplet;

public class BubbleSortTextProcessing extends PApplet {
    int[] arr = {99, 33, 15, 38, 26, 11, 19};
    float[] x = {20, 70, 120, 170, 220, 270, 320};
    float y = 130;

    int i = 0;
    int max = arr.length - 1;

    public void settings() {
        size(400, 230);
    }


    public void swap(int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void draw(){
        delay(800);
        background(0);

        if (i >= max) {
            i = 0;
            max--;
        }

        int j = i + 1;
        if (arr[i] > arr[i + 1]) {
            swap(i, i + 1);
        }

        for(int i = 0; i < arr.length; i ++) {
            textSize(16);
            fill(255);
            text(Integer.toString(arr[i]), x[i], y);
        }
        i ++;
    }

    public static void main (String[]args){
        String[] processingArgs = {"BubbleSortTextProcessing"};
        BubbleSortTextProcessing bubbleSortTextProcessing = new BubbleSortTextProcessing();
        PApplet.runSketch(processingArgs, bubbleSortTextProcessing);
    }
}