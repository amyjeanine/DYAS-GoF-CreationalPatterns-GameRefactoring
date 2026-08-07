package com.balitechy.spacewar.visual.sprite;

import com.balitechy.spacewar.main.Game;
import com.balitechy.spacewar.visual.IBullet;
import com.balitechy.spacewar.visual.IPlayer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Producto concreto del estilo visual "sprite" (equivalente a la clase
 * Player original del juego, antes del refactoring).
 */
public class SpritePlayer implements IPlayer {

	public static final int WIDTH = 56;
	public static final int HEIGHT = 28;

	private double x;
	private double y;

	private double velX;
	private double velY;

	private BufferedImage image;
	private final Game game;

	public SpritePlayer(double x, double y, Game game){
		this.x = x;
		this.y = y;
		this.game = game;

		SpritesImageLoader sprites = new SpritesImageLoader("/sprites.png");
		try {
			sprites.loadImage();
			image = sprites.getImage(219, 304, WIDTH, HEIGHT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public double getX() {
		return x;
	}

	@Override
	public void setX(double x) {
		this.x = x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public void setY(double y) {
		this.y = y;
	}

	@Override
	public void setVelX(double velX) {
		this.velX = velX;
	}

	@Override
	public void setVelY(double velY) {
		this.velY = velY;
	}

	@Override
	public void shoot(){
		IBullet b = game.getFactory().crearBala(x+(WIDTH/2)-5, y-18, game);
		game.getBullets().addBullet(b);
	}

	@Override
	public void tick(){
		x += velX;
		y += velY;

		// To avoid player go outside the arena.
		if(x <= 0)
			x = 0;
		if(x >= (Game.WIDTH * Game.SCALE) - WIDTH)
			x = (Game.WIDTH * Game.SCALE) - WIDTH;
		if(y <= 0)
			y = 0;
		if(y >= (Game.HEIGHT * Game.SCALE) - HEIGHT)
			y = (Game.HEIGHT * Game.SCALE) - HEIGHT;
	}

	@Override
	public void render(Graphics g){
		g.setColor(Color.white);
		g.drawImage(image, (int) x, (int) y, null);
	}
}
