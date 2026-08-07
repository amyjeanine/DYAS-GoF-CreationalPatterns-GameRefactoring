package com.balitechy.spacewar.visual.colorfulvectorial;

import com.balitechy.spacewar.main.Game;
import com.balitechy.spacewar.visual.vectorial.AbstractVectorialBullet;

import java.awt.Color;

/** Bala vectorial a color (estilo "colorful-vectorial-style"). */
public class ColorfulVectorialBullet extends AbstractVectorialBullet {

	public ColorfulVectorialBullet(double x, double y, Game game) {
		super(x, y);
	}

	@Override
	protected Color getColor() {
		return Color.YELLOW;
	}
}
