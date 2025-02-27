package uk.ac.nott.cs.frogger.views;

import javafx.scene.image.Image;
import uk.ac.nott.cs.frogger.models.Actor;

public class Log extends Actor {

	private double speed;
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>600 && speed>0)
			setX(-180);
		if (getX()<-300 && speed<0)
			setX(700);
	}
	
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size,size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
		
	}


	public Log(double speed){
		this.speed = speed;
	}

	public boolean getLeft() {
		return speed < 0;
	}
}
