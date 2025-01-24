package uk.ac.nott.cs.frogger.views;

import javafx.scene.image.Image;
import uk.ac.nott.cs.frogger.models.Actor;

public class WetTurtle extends Actor {
	Image t1;
	Image t2;
	Image t3;
	Image t4;
	int speed;
	int i = 1;
	boolean bool = true;
	boolean sunk = false;
	@Override
	public void act(long now) {

				if (now/900000000  % 4 ==0) {
					setImage(t1);
					sunk = false;
					
				}
				else if (now/900000000 % 4 == 1) {
					setImage(t2);
					sunk = false;
				}
				else if (now/900000000 %4 == 2) {
					setImage(t3);
					sunk = false;
				} else if (now/900000000 %4 == 3) {
					setImage(t4);
					sunk = true;
				}
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}
	public WetTurtle(int xpos, int ypos, int s, int w, int h) {
		t1 = new Image("/images/TurtleAnimation1.png", h, w, true, true);
		t2 = new Image("/images/TurtleAnimation2Wet.png", h, w, true, true);
		t3 = new Image("/images/TurtleAnimation3Wet.png", w, h, true, true);
		t4 = new Image("/images/TurtleAnimation4Wet.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(t2);
	}
	public boolean isSunk() {
		return sunk;
	}
}
