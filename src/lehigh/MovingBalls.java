package lehigh;

import processing.core.PApplet;
import processing.core.PFont;

import java.util.ArrayList;
import java.util.Random;


public class MovingBalls extends PApplet{

    int number = 4;
    int score = 0;
    PFont f;
    ArrayList<Ball> balls;

    class Ball{
        int x, y, speedX,speedY,radius;
        int [] color;
        Random random = new Random();
        Ball(){
            radius = (int)random(50,70);
            x = (int)random(radius,width-radius);
            y = (int)random(radius,height-radius);
            speedX = random.nextInt(3) + 1;
            speedY = random.nextInt(3) + 1;
            color =  new int[]{random.nextInt(255),random.nextInt(255),random.nextInt(255)};
        }

        public void move(){
            ellipse(x, y, radius, radius);
            fill(color[0],color[1],color[2]);

            if(x >= width - radius/2 || x <= radius/2){
                speedX = -speedX;
            }
            if(y >= height - radius/2 || y <= radius/2){
                speedY = -speedY;
            }
            x += speedX;
            y += speedY;
        }

    }


    public void settings(){
        size(500, 500);
        balls = new ArrayList<>();
        for(int i = 0; i < number; i++) {
            balls.add(new Ball());
        }
    }
    public void setup() {
        f = createFont("Arial",16,true);
    }


    public void draw(){
        background(255);

        for (int i = 0; i < balls.size();i++){
            balls.get(i).move();
        }

//        for (Ball b: balls){
//            b.move();
//        }

        textFont(f);
        textAlign(CENTER);
        text("Score : " + score,100,60);
    }

    public void mousePressed() {
        for(int i =0;i <= number;i++){
             if (mouseX <= balls.get(i).x + balls.get(i).radius && mouseX >= balls.get(i).x - balls.get(i).radius &&
                     mouseY <= balls.get(i).y + balls.get(i).radius && mouseY >= balls.get(i).y - balls.get(i).radius) {
                balls.get(i).speedX += balls.get(i).speedX + 1;
                balls.get(i).speedY += balls.get(i).speedY + 1;
                score++;
            }
        }
    }

    public static void main(String[] args) {
        String[] processingArgs = {"MovingBalls"};
        MovingBalls movingBalls = new MovingBalls();
        PApplet.runSketch(processingArgs, movingBalls);
    }
}
