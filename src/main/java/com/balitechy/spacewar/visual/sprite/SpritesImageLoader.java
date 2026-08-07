package com.balitechy.spacewar.visual.sprite;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Utilitario de bajo nivel para cargar hojas de sprites (sprite sheets) y
 * recortar sub-imágenes. Es un detalle de implementación exclusivo del
 * estilo visual "sprite"; el resto del juego no lo conoce.
 */
public class SpritesImageLoader {

    private String path;
    private BufferedImage image;

    public SpritesImageLoader(String path) {
        this.path = path;
    }

    public BufferedImage loadImage() throws IOException {
        image = ImageIO.read(getClass().getResource(path));
        return image;
    }

    public BufferedImage getImage(int top, int left, int width, int height) {
        BufferedImage img = image.getSubimage(top, left, width, height);
        return img;
    }
}
