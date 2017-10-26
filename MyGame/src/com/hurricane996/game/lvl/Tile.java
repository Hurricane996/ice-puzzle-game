package com.hurricane996.game.lvl;

import com.hurricane996.game.gfx.Bitmap;
import com.hurricane996.game.gfx.IRenderable;
import com.hurricane996.game.gfx.Screen;
import javafx.scene.paint.Color;

public class Tile implements IRenderable {
    public static final Tile   WALL        = new Tile("/wall.png");
    public static final Tile   FLOOR       = new Tile("/floor.png");
    public static final Tile   ICE         = new Tile("/ice.png");
    public static final Tile   DEATH       = new Tile("/death.png");
    public static final Tile   START       = new Tile("/start.png");
    public static final Tile   FINISH      = new Tile("/finish.png");
    public static final Tile   DOOR_CLOSED = new Tile("/door_closed.png");
    public static final Tile   DOOR_OPEN   = new Tile("/door_open.png");
    public static final Tile   LEVER       = new Tile("/lever.png");

    public class SolidColorTile extends Tile{
        public SolidColorTile( int color) {
            this.bitmap.clear(color);
        }
    }

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
    public Tile(String path){this.bitmap = Bitmap.getBitmapFromFile(path);}

    @Override
    public void render(Screen screen, int x, int y) {
        screen.render(this.bitmap,x*Tile.TILE_WIDTH,y*Tile.TILE_HEIGHT);
    }
}
