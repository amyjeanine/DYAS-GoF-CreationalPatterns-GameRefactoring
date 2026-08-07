package com.balitechy.spacewar.visual;

import java.awt.Graphics;

/**
 * Producto abstracto: representa una bala desde el punto de vista del
 * núcleo del juego.
 */
public interface IBullet {

    void tick();

    void render(Graphics g);

    double getY();
}
