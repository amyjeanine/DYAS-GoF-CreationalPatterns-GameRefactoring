package com.balitechy.spacewar.visual;

import java.awt.Canvas;
import java.awt.Graphics;
import java.io.IOException;

/**
 * Producto abstracto: dibuja el fondo del juego. Cada estilo visual decide
 * cómo se ve el fondo (imagen de fondo, estrellas vectoriales, etc.).
 */
public interface IBackgroundRenderer {

    void render(Graphics g, Canvas c) throws IOException;
}
