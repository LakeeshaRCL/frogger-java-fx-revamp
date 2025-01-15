package com.lagocp.sprites;

import com.lagocp.gameEngine.sprite.Sprite;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Frog extends Sprite {
    public Frog(double x, double y, double width, double height, GraphicsContext gc) {
        super(x, y, width, height, gc);
    }

    public Frog(String imageFile, double x, double y, double width, double height, GraphicsContext gc) {
        super(imageFile, x, y, width, height, gc);
    }

    @Override
    public boolean didCollideWith(Sprite other) {
        return false;
    }

    @Override
    public boolean didCollideWithTopWall(Canvas canvas) {
        return false;
    }

    @Override
    public boolean didCollideWithBotWall(Canvas canvas) {
        return false;
    }

    @Override
    public boolean didCollideWithLeftWall(Canvas canvas) {
        return false;
    }

    @Override
    public boolean didCollideWithRightWall(Canvas canvas) {
        return false;
    }

    @Override
    public void render(GraphicsContext gc) {

    }
}
