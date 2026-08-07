package com.balitechy.spacewar.visual.sprite;

import com.balitechy.spacewar.visual.IBackgroundRenderer;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Producto concreto del estilo visual "sprite" (equivalente a la clase
 * BackgroundRenderer original del juego, antes del refactoring).
 */
public class SpriteBackgroundRenderer implements IBackgroundRenderer {

	@Override
	public void render(Graphics g, Canvas c) throws IOException {
		BufferedImage background;
		SpritesImageLoader bg = new SpritesImageLoader("/bg.png");
		bg.loadImage();
		background = bg.getImage(0, 0, 640, 480);
		g.drawImage(background, 0, 0, c.getWidth(), c.getHeight(), c);
	}

}
