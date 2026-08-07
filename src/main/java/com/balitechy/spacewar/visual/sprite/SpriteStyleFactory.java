package com.balitechy.spacewar.visual.sprite;

import com.balitechy.spacewar.main.Game;
import com.balitechy.spacewar.visual.IBackgroundRenderer;
import com.balitechy.spacewar.visual.IBullet;
import com.balitechy.spacewar.visual.IPlayer;
import com.balitechy.spacewar.visual.VisualStyleFactory;

/**
 * Fábrica concreta: crea la familia de productos del estilo visual
 * "sprite" (basado en imágenes), el estilo original del juego.
 */
public class SpriteStyleFactory implements VisualStyleFactory {

	@Override
	public IPlayer crearJugador(double x, double y, Game game) {
		return new SpritePlayer(x, y, game);
	}

	@Override
	public IBullet crearBala(double x, double y, Game game) {
		return new SpriteBullet(x, y, game);
	}

	@Override
	public IBackgroundRenderer crearFondo() {
		return new SpriteBackgroundRenderer();
	}

}
