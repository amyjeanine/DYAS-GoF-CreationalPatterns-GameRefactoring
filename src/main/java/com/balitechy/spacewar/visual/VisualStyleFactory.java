package com.balitechy.spacewar.visual;

import com.balitechy.spacewar.main.Game;

/**
 * Fábrica Abstracta (patrón GoF Abstract Factory) del estilo visual del
 * juego. Define la familia de productos (jugador, bala, fondo) que un
 * estilo visual concreto (sprites, vectorial, vectorial a color, ...) debe
 * poder construir.
 *
 * El núcleo del juego (paquete com.balitechy.spacewar.main) sólo depende de
 * esta interfaz y de los productos abstractos (IPlayer, IBullet,
 * IBackgroundRenderer); nunca de una fábrica ni de un producto concreto.
 */
public interface VisualStyleFactory {

    IPlayer crearJugador(double x, double y, Game game);

    IBullet crearBala(double x, double y, Game game);

    IBackgroundRenderer crearFondo();
}
