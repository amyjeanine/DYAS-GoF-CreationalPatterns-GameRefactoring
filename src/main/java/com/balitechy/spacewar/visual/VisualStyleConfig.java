package com.balitechy.spacewar.visual;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Lee game.properties (classpath) y a partir de ahí instancia, por
 * reflexión, la {@link VisualStyleFactory} concreta que se debe usar.
 *
 * Esto es lo único que hay que tocar para cambiar el estilo visual del
 * juego, o para habilitar un estilo nuevo: basta con agregar sus clases
 * concretas (productos + fábrica) en un paquete nuevo, y apuntar
 * "visual.style.factory" al nombre completamente calificado de esa nueva
 * fábrica. El núcleo del juego (Game, BulletController, InputHandler) no
 * requiere ningún cambio de código.
 */
public final class VisualStyleConfig {

    private static final String ARCHIVO_CONFIG = "/game.properties";
    private static final String LLAVE_FABRICA = "visual.style.factory";
    private static final String FABRICA_DEFECTO = "com.balitechy.spacewar.visual.sprite.SpriteStyleFactory";

    private VisualStyleConfig() {
    }

    public static VisualStyleFactory obtenerFabrica() {
        String nombreClase = leerNombreClaseFabrica();
        try {
            Class<?> clase = Class.forName(nombreClase);
            return (VisualStyleFactory) clase.getDeclaredConstructor().newInstance();
        } catch (ReflectiveOperationException | ClassCastException ex) {
            Logger.getLogger(VisualStyleConfig.class.getName())
                    .log(Level.SEVERE, "No se pudo instanciar la VisualStyleFactory configurada ("
                            + nombreClase + "). Se usará la fábrica por defecto.", ex);
            return crearFabricaPorDefecto();
        }
    }

    private static String leerNombreClaseFabrica() {
        Properties props = new Properties();
        try (InputStream in = VisualStyleConfig.class.getResourceAsStream(ARCHIVO_CONFIG)) {
            if (in != null) {
                props.load(in);
            }
        } catch (IOException ex) {
            Logger.getLogger(VisualStyleConfig.class.getName())
                    .log(Level.WARNING, "No se pudo leer game.properties, se usará la fábrica por defecto.", ex);
        }
        return props.getProperty(LLAVE_FABRICA, FABRICA_DEFECTO).trim();
    }

    private static VisualStyleFactory crearFabricaPorDefecto() {
        try {
            return (VisualStyleFactory) Class.forName(FABRICA_DEFECTO).getDeclaredConstructor().newInstance();
        } catch (ReflectiveOperationException ex) {
            throw new IllegalStateException("No fue posible crear ni siquiera la fábrica visual por defecto.", ex);
        }
    }

}
