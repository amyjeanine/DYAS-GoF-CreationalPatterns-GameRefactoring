package com.balitechy.spacewar.visual.sprite;

import com.balitechy.spacewar.main.Game;
import com.balitechy.spacewar.visual.IBullet;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Producto concreto del estilo visual "sprite" (equivalente a la clase
 * Bullet original del juego, antes del refactoring).
 */
public class SpriteBullet implements IBullet {

	public static final int WIDTH = 11;
	public static final int HEIGHT = 21;

	private double x;
	private double y;
	private BufferedImage image;

	public SpriteBullet(double x, double y, Game game){
		this.x = x;
		this.y = y;

		SpritesImageLoader sprites = new SpritesImageLoader("/sprites.png");
		try {
			sprites.loadImage();
			image = sprites.getImage(35, 52, WIDTH, HEIGHT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void tick(){
		y -= 5;
	}

	@Override
	public void render(Graphics g){
		g.drawImage(image, (int) x, (int) y, null);
	}

	@Override
	public double getY(){
		return y;
	}
}
