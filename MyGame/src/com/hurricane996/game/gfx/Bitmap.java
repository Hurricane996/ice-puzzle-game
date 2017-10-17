package com.hurricane996.game.gfx;

import com.hurricane996.game.Game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;

public class Bitmap {
    public int w,h;
    public int[] pixels;

    public Bitmap(int w,int h){
        this.w=w;
        this.h=h;
        pixels = new int[w*h];
    }

    public void clear(int color){
            Arrays.fill(pixels,color);
    }
    public void render(Bitmap bitmap, int x, int y){
        int x0 = x;
        int x1 = x + bitmap.w;
        int y0 = y;
        int y1 = y + bitmap.h;

        if(x0<0 || x1 > w || y0 < 0 || y1 > h){
            throw new IndexOutOfBoundsException("Bitmap drawn outside of screen: "+x0+" "+x1+" "+y0+" "+y1);
        }
        for(int i = 0; i<bitmap.w; i++){
            for(int j = 0; j < bitmap.h; j++){
                pixels[(y+j)*w+(x+i)] = bitmap.pixels[j*bitmap.w+i];
            }
        }
    }
    public static Bitmap getBitmapFromFile(String path){
        try {
            BufferedImage image = ImageIO.read(Game.class.getResourceAsStream(path));
            Bitmap out = new Bitmap(image.getWidth(),image.getHeight());
            for(int i = 0; i < out.w; i++){
                for(int j = 0; j < out.h; j++){
                    out.pixels[j*out.w+i] = image.getRGB(i,j);
                }
            }
            return out;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
