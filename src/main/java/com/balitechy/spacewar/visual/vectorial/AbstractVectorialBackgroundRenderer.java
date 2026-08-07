package com.balitechy.spacewar.visual.vectorial;

import com.balitechy.spacewar.main.Game;
import com.balitechy.spacewar.visual.IBackgroundRenderer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * Fondo "estilo retro": fondo negro con un campo de estrellas dibujadas con
 * primitivas gráficas (g.drawOval), más un borde del área de juego. La
 * posición de las estrellas se calcula una sola vez (semilla fija) para que
 * no "parpadeen" entre cuadros.
 *
 * Las subclases sólo deciden de qué color se ve cada estrella y el borde
 * (DRY entre estilo blanco-y-negro y a color).
 */
public abstract class AbstractVectorialBackgroundRenderer implements IBackgroundRenderer {

	private static final int NUM_ESTRELLAS = 60;
	private static final long SEMILLA_FIJA = 42L;

	private final int[] estrellaX = new int[NUM_ESTRELLAS];
	private final int[] estrellaY = new int[NUM_ESTRELLAS];

	protected AbstractVectorialBackgroundRenderer() {
		Random rnd = new Random(SEMILLA_FIJA);
		for (int i = 0; i < NUM_ESTRELLAS; i++) {
			estrellaX[i] = rnd.nextInt(Game.WIDTH * Game.SCALE);
			estrellaY[i] = rnd.nextInt(Game.HEIGHT * Game.SCALE);
		}
	}

	/** Color del borde del área de juego. */
	protected abstract Color getColor();

	/** Color de cada estrella; por defecto, el mismo color del borde. */
	protected Color colorEstrella(int indice) {
		return getColor();
	}

	@Override
	public void render(Graphics g, Canvas c) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, c.getWidth(), c.getHeight());

		for (int i = 0; i < NUM_ESTRELLAS; i++) {
			g.setColor(colorEstrella(i));
			g.drawOval(estrellaX[i], estrellaY[i], 2, 2);
		}

		g.setColor(getColor());
		g.drawRect(2, 2, c.getWidth() - 4, c.getHeight() - 4);
	}
}
