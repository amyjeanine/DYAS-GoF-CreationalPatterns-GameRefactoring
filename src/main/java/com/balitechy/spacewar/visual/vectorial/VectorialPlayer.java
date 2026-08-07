package com.balitechy.spacewar.visual.vectorial;

import com.balitechy.spacewar.main.Game;

import java.awt.Color;

/** Nave dibujada como líneas blancas (estilo "vectorial-style"). */
public class VectorialPlayer extends AbstractVectorialPlayer {

	public VectorialPlayer(double x, double y, Game game) {
		super(x, y, game);
	}

	@Override
	protected Color getColor() {
		return Color.WHITE;
	}
}
