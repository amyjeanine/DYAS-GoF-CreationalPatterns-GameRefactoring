package com.balitechy.spacewar.visual.colorfulvectorial;

import com.balitechy.spacewar.visual.vectorial.AbstractVectorialBackgroundRenderer;

import java.awt.Color;

/**
 * Fondo vectorial con estrellas multicolor y borde blanco (estilo
 * "colorful-vectorial-style"). Reutiliza toda la lógica de
 * AbstractVectorialBackgroundRenderer (posiciones de estrellas, dibujo del
 * borde); sólo cambia la paleta de colores.
 */
public class ColorfulVectorialBackgroundRenderer extends AbstractVectorialBackgroundRenderer {

	private static final Color[] PALETA = {
		Color.CYAN, Color.MAGENTA, Color.YELLOW, Color.GREEN, Color.ORANGE, Color.PINK
	};

	@Override
	protected Color getColor() {
		return Color.WHITE;
	}

	@Override
	protected Color colorEstrella(int indice) {
		return PALETA[indice % PALETA.length];
	}
}
