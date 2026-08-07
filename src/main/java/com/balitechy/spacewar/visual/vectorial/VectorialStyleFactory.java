package com.balitechy.spacewar.visual.vectorial;

import com.balitechy.spacewar.main.Game;
import com.balitechy.spacewar.visual.IBackgroundRenderer;
import com.balitechy.spacewar.visual.IBullet;
import com.balitechy.spacewar.visual.IPlayer;
import com.balitechy.spacewar.visual.VisualStyleFactory;

/**
 * Fábrica concreta: crea la familia de productos del estilo visual
 * "vectorial-style" (primitivas gráficas en blanco y negro).
 */
public class VectorialStyleFactory implements VisualStyleFactory {

	@Override
	public IPlayer crearJugador(double x, double y, Game game) {
		return new VectorialPlayer(x, y, game);
	}

	@Override
	public IBullet crearBala(double x, double y, Game game) {
		return new VectorialBullet(x, y, game);
	}

	@Override
	public IBackgroundRenderer crearFondo() {
		return new VectorialBackgroundRenderer();
	}
}
