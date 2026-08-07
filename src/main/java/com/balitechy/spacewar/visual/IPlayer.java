package com.balitechy.spacewar.visual;

import java.awt.Graphics;

/**
 * Producto abstracto: representa al jugador desde el punto de vista del
 * NÚCLEO del juego (posición, movimiento, disparo, render). El núcleo del
 * juego (Game) sólo conoce esta interfaz, nunca una implementación
 * concreta (sprite, vectorial, etc.).
 */
public interface IPlayer {

    double getX();

    void setX(double x);

    double getY();

    void setY(double y);

    void setVelX(double velX);

    void setVelY(double velY);

    void tick();

    void render(Graphics g);

    void shoot();
}
