package com.hurricane996.game.lvl;

import com.hurricane996.game.gfx.Bitmap;
import com.hurricane996.game.gfx.IRenderable;
import com.hurricane996.game.gfx.Screen;
import javafx.scene.paint.Color;

public class Tile implements IRenderable {
    public static final Tile   WALL        = new SolidColorTile(0xFF494949);
    public static final Tile   FLOOR       = new SolidColorTile(0xFF848484);
    public static final Tile   ICE         = new SolidColorTile(0xFFEFFFFF);
    public static final Tile   DEATH       = new SolidColorTile(0xFFFF6000);
    public static final Tile   START       = new SolidColorTile(0xFF848484);
    public static final Tile   FINISH      = new SolidColorTile(0xFF00FF00);
    public static final Tile   DOOR_CLOSED = new SolidColorTile(0xFF603507);
    public static final Tile   DOOR_OPEN   = new SolidColorTile(0xFF91500B);
    public static final Tile   LEVER       = new SolidColorTile(0xFF13579B);

    public static final Tile[] TILES = {
            WALL,
            FLOOR,
            ICE,
            DEATH,
            START,
            FINISH,
            DOOR_CLOSED,
            DOOR_OPEN,
            LEVER
    };

    public static final int TILE_WIDTH = 32, TILE_HEIGHT = 32;

    public Bitmap bitmap;

    public Tile(){
        this.bitmap = new Bitmap(TILE_WIDTH,TILE_HEIGHT);
    }

    @Override
    public void render(Screen screen, int x, int y) {
        screen.render(this.bitmap,x*Tile.TILE_WIDTH,y*Tile.TILE_HEIGHT);
    }
}
