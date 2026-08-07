package com.balitechy.spacewar.visual.vectorial;

import com.balitechy.spacewar.main.Game;
import com.balitechy.spacewar.visual.IBullet;
import com.balitechy.spacewar.visual.IPlayer;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Lógica común (posición, movimiento, límites del área de juego, disparo y
 * geometría de la nave) compartida por todas las variantes "vectoriales"
 * del jugador (blanco y negro, a color, ...). Evita duplicar código entre
 * esas variantes (DRY); lo único que cada subclase concreta decide es el
 * color con el que se dibuja.
 */
public abstract class AbstractVectorialPlayer implements IPlayer {

	public static final int WIDTH = 40;
	public static final int HEIGHT = 30;

	private double x;
	private double y;
	private double velX;
	private double velY;
	private final Game game;

	protected AbstractVectorialPlayer(double x, double y, Game game) {
		this.x = x;
		this.y = y;
		this.game = game;
	}

	/**
	 * Color con el que se dibuja la nave; cada estilo vectorial concreto lo define.
	 */
	protected abstract Color getColor();

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
	public void shoot() {
		IBullet bala = game.getFactory().crearBala(x + (WIDTH / 2.0) - 2, y - 12, game);
		game.getBullets().addBullet(bala);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;

		if (x <= 0) {
			x = 0;
		}
		if (x >= (Game.WIDTH * Game.SCALE) - WIDTH) {
			x = (Game.WIDTH * Game.SCALE) - WIDTH;
		}
		if (y <= 0) {
			y = 0;
		}
		if (y >= (Game.HEIGHT * Game.SCALE) - HEIGHT) {
			y = (Game.HEIGHT * Game.SCALE) - HEIGHT;
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(getColor());
		int[] xs = {(int) x + WIDTH / 2, (int) x, (int) x + WIDTH};
		int[] ys = {(int) y, (int) y + HEIGHT, (int) y + HEIGHT};
		g.drawPolygon(xs, ys, 3);
		g.drawLine((int) x + WIDTH / 2, (int) y + HEIGHT / 3, (int) x + WIDTH / 2, (int) y + HEIGHT);
	}
}
