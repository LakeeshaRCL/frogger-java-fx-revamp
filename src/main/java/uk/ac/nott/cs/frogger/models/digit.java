package uk.ac.nott.cs.frogger.models;

import javafx.scene.image.Image;

public class digit extends Actor{
	int dim;
	Image im1;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	public digit(int n, int dim, int x, int y) {
		im1 = new Image("file:src/p4_group_8_repo/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
	
}
