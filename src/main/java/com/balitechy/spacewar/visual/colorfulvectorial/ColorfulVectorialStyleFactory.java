package com.balitechy.spacewar.visual.colorfulvectorial;

import com.balitechy.spacewar.main.Game;
import com.balitechy.spacewar.visual.IBackgroundRenderer;
import com.balitechy.spacewar.visual.IBullet;
import com.balitechy.spacewar.visual.IPlayer;
import com.balitechy.spacewar.visual.VisualStyleFactory;

/**
 * Fábrica concreta: crea la familia de productos del nuevo estilo visual
 * "colorful-vectorial-style". Para habilitarlo sólo hizo falta:
 *  1. Estas clases de productos concretos (Player/Bullet/BackgroundRenderer).
 *  2. Esta fábrica concreta.
 *  3. Cambiar "visual.style.factory" en game.properties para que apunte
 *     a esta clase (com.balitechy.spacewar.visual.colorfulvectorial.ColorfulVectorialStyleFactory).
 * No fue necesario modificar Game, BulletController, ni ningún otro
 * estilo visual existente.
 */
public class ColorfulVectorialStyleFactory implements VisualStyleFactory {

	@Override
	public IPlayer crearJugador(double x, double y, Game game) {
		return new ColorfulVectorialPlayer(x, y, game);
	}

	@Override
	public IBullet crearBala(double x, double y, Game game) {
		return new ColorfulVectorialBullet(x, y, game);
	}

	@Override
	public IBackgroundRenderer crearFondo() {
		return new ColorfulVectorialBackgroundRenderer();
	}
}
