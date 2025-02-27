package uk.ac.nott.cs.frogger;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import uk.ac.nott.cs.frogger.models.Animal;
import uk.ac.nott.cs.frogger.models.BackgroundImage;
import uk.ac.nott.cs.frogger.models.End;
import uk.ac.nott.cs.frogger.models.digit;
import uk.ac.nott.cs.frogger.views.*;

public class FroggerApp extends Application {

    AnimationTimer timer;
    MyStage background;
    Animal animal;

    public static void main(String[] args) {
        System.out.println("Fogger app starting....");
        try {
            launch(args);
        }
        catch (Exception e) {
            System.out.println("Application exception: " + e);
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            background = new MyStage();
            Scene scene  = new Scene(background,600,800);

            //Obstacle obstacle = new Obstacle("/images/truck1Right.png", 25, 25, 3);
            //Obstacle obstacle1 = new Obstacle("/images/truck2Right.png", 100, 100,2 );
            //Obstacle obstacle2 = new Obstacle("/images/truck1Right.png",0,  150, 1);

            BackgroundImage froggerback = new BackgroundImage("/images/bg.png");

            background.add(froggerback);

            background.add(new Log("/images/log3.png", 150, 0, 166, 0.75));
            background.add(new Log("/images/log3.png", 150, 220, 166, 0.75));
            background.add(new Log("/images/log3.png", 150, 440, 166, 0.75));
            background.add(new Log("/images/logs.png", 300, 0, 276, -2));
            background.add(new Log("/images/logs.png", 300, 400, 276, -2));
            background.add(new Log("/images/log3.png", 150, 50, 329, 0.75));
            background.add(new Log("/images/log3.png", 150, 270, 329, 0.75));
            background.add(new Log("/images/log3.png", 150, 490, 329, 0.75));
            background.add(new Turtle(500, 376, -1, 130, 130));
            background.add(new Turtle(300, 376, -1, 130, 130));
            background.add(new WetTurtle(700, 376, -1, 130, 130));
            background.add(new WetTurtle(600, 217, -1, 130, 130));
            background.add(new WetTurtle(400, 217, -1, 130, 130));
            background.add(new WetTurtle(200, 217, -1, 130, 130));
            background.add(new End(13,96));
            background.add(new End(141,96));
            background.add(new End(141 + 141-13,96));
            background.add(new End(141 + 141-13+141-13+1,96));
            background.add(new End(141 + 141-13+141-13+141-13+3,96));
            animal = new Animal("/images/froggerUp.png");
            background.add(animal);
            background.add(new Obstacle("/images/truck1"+"Right.png", 0, 649, 1, 120, 120));
            background.add(new Obstacle("/images/truck1"+"Right.png", 300, 649, 1, 120, 120));
            background.add(new Obstacle("/images/truck1"+"Right.png", 600, 649, 1, 120, 120));
            background.add(new Obstacle("/images/car1Left.png", 100, 597, -1, 50, 50));
            background.add(new Obstacle("/images/car1Left.png", 250, 597, -1, 50, 50));
            background.add(new Obstacle("/images/car1Left.png", 400, 597, -1, 50, 50));
            background.add(new Obstacle("/images/car1Left.png", 550, 597, -1, 50, 50));
            background.add(new Obstacle("/images/truck2Right.png", 0, 540, 1, 200, 200));
            background.add(new Obstacle("/images/truck2Right.png", 500, 540, 1, 200, 200));
            background.add(new Obstacle("/images/car1Left.png", 500, 490, -5, 50, 50));
            background.add(new digit(0, 30, 360, 25));
            background.start();
            primaryStage.setScene(scene);
            primaryStage.show();
            start();
        }
        catch (Exception e){
           return;
        }
    }
    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (animal.changeScore()) {
                    setNumber(animal.getPoints());
                }
                if (animal.getStop()) {
                    System.out.print("STOPP:");
                    background.stopMusic();
                    stop();
                    background.stop();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("You Have Won The Game!");
                    alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
                    alert.setContentText("Highest Possible Score: 800");
                    alert.show();
                }
            }
        };
    }
    public void start() {
      try {
          background.playMusic();
          createTimer();
          timer.start();
      }
      catch (Exception e) {
          System.out.printf("Start exception: %s\n", e);
      }
    }

    public void stop() {
        timer.stop();
    }

    public void setNumber(int n) {
        int shift = 0;
        while (n < 0) {
            int d = n / 10;
            int k = n - d * 10;
            n = d;
            background.add(new digit(k, 30, 360 - shift, 25));
            shift+=30;
        }
    }
}
