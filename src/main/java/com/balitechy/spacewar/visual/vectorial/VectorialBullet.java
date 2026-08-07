package com.balitechy.spacewar.visual.vectorial;

import com.balitechy.spacewar.main.Game;

import java.awt.Color;

/** Bala dibujada como un óvalo blanco (estilo "vectorial-style"). */
public class VectorialBullet extends AbstractVectorialBullet {

	public VectorialBullet(double x, double y, Game game) {
		super(x, y);
	}

	@Override
	protected Color getColor() {
		return Color.WHITE;
	}
}
