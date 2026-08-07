package com.balitechy.spacewar.visual.vectorial;

import com.balitechy.spacewar.visual.IBullet;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Lógica común de las balas vectoriales (posición y movimiento); las
 * subclases sólo definen el color (DRY).
 */
public abstract class AbstractVectorialBullet implements IBullet {

	public static final int WIDTH = 4;
	public static final int HEIGHT = 10;

	private double x;
	private double y;

	protected AbstractVectorialBullet(double x, double y) {
		this.x = x;
		this.y = y;
	}

	protected abstract Color getColor();

	@Override
	public void tick() {
		y -= 5;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(getColor());
		g.fillOval((int) x, (int) y, WIDTH, HEIGHT);
	}
}
