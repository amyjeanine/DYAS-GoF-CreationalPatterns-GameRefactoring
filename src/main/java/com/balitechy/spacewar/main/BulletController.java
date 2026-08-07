package com.balitechy.spacewar.main;

import com.balitechy.spacewar.visual.IBullet;
import java.awt.Graphics;
import java.util.LinkedList;

/**
 * Controla el ciclo de vida de las balas activas. Nótese que sólo conoce
 * IBullet (producto abstracto): nunca una implementación concreta como
 * SpriteBullet o VectorialBullet.
 */
public class BulletController {

    private LinkedList<IBullet> bl = new LinkedList<IBullet>();

    public void tick() {
        for (int i = 0; i < bl.size(); i++) {
            if (bl.get(i).getY() < 0) {
                removeBullet(bl.get(i));
            } else {
                bl.get(i).tick();
            }
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < bl.size(); i++) {
            bl.get(i).render(g);
        }
    }

    public void addBullet(IBullet bullet) {
        bl.add(bullet);
    }

    public void removeBullet(IBullet bullet) {
        bl.remove(bullet);
    }
}
