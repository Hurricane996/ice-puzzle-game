package com.hurricane996.game.lvl;

public class SolidColorTile extends Tile{
    public SolidColorTile( int color) {
        this.bitmap.clear(color);
    }
}
