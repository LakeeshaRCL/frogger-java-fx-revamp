package uk.ac.nott.cs.frogger.models;

import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import uk.ac.nott.cs.frogger.views.World;

import java.util.ArrayList;


public abstract class Actor extends ImageView{

    public void move(double dx, double dy) {
        setX(getX() - dx);
        setY(getY() - dy);
    }

    public World getWorld() {
        return (World) getParent();
    }

    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    public <A extends Actor> java.util.List<A> getIntersectingObjects(Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    
    public void manageInput(InputEvent e) {
        
    }

    public <A extends Actor> A getOneIntersectingObject(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
                break;
            }
        }
        return someArray.get(0);
    }

    public abstract void act(long now);

}
