package com.balitechy.spacewar.visual.colorfulvectorial;

import com.balitechy.spacewar.main.Game;
import com.balitechy.spacewar.visual.vectorial.AbstractVectorialPlayer;

import java.awt.Color;

/**
 * Nave dibujada con las mismas primitivas gráficas que VectorialPlayer,
 * pero a color (estilo "colorful-vectorial-style"). Reutiliza toda la
 * lógica de movimiento/geometría de AbstractVectorialPlayer: sólo cambia
 * el color.
 */
public class ColorfulVectorialPlayer extends AbstractVectorialPlayer {

	public ColorfulVectorialPlayer(double x, double y, Game game) {
		super(x, y, game);
	}

	@Override
	protected Color getColor() {
		return Color.CYAN;
	}
}
