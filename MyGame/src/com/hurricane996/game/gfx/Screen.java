package com.hurricane996.game.gfx;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Screen extends Bitmap {
    public BufferedImage image;

    public Screen(int w, int h) {
        super(w, h);
        image = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
        pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
    }
    public void render(IRenderable renderable,int x, int y){
        renderable.render(this,x,y);
    }
}
