package com.hurricane996.game.player;

import com.hurricane996.game.Game;
import com.hurricane996.game.gfx.Bitmap;
import com.hurricane996.game.gfx.IRenderable;
import com.hurricane996.game.gfx.Screen;
import com.hurricane996.game.lvl.Level;
import com.hurricane996.game.lvl.Tile;

public class Player implements IRenderable {

    public int x,y;
    Bitmap sprite;
    Game game;
    public Level level;
    private boolean iceCheck;
    private boolean lavaCheck;
    private int iceCheckDX = 0, iceCheckDY = 0;
    public int framesSinceLastMoveCheck = 0;
    public boolean up,down,left,right;

    public Player(int x, int y, String path,Game game){
        this.x = x;
        this.y = y;

        sprite=Bitmap.getBitmapFromFile(path);
        this.game = game;

    }
    @Override
    public void render(Screen screen, int x, int y) {
        screen.render(sprite,x* Tile.TILE_WIDTH,y*Tile.TILE_HEIGHT);
    }
    public void update() {
        framesSinceLastMoveCheck++;
        if(framesSinceLastMoveCheck >= 20){
            framesSinceLastMoveCheck = 0;
            if(iceCheck){
                check(x,y,iceCheckDX,iceCheckDY);
            }
            else if(lavaCheck){
                level.respawn(this);
                this.lavaCheck = false;
                this.iceCheckDX = 0;
                this.iceCheckDY = 0;
            }
            else{
                this.iceCheckDX = 0;
                this.iceCheckDY = 0;
                if(up){
                    this.check(x,y,0,-1);
                }
                if(down){
                    this.check(x,y,0,1);
                }
                if(left){
                    this.check(x,y,-1,0);
                }
                if(right){
                    this.check(x,y,1,0);
                }
            }
        }
    }

    private void check(int x, int y, int dx, int dy) {

        if ((level.getTileAt(x + dx, y + dy) == Tile.FLOOR) || level.getTileAt(x + dx, y + dy) == Tile.START || level.getTileAt(x+dx,y+dy) == Tile.DOOR_OPEN) {
            this.x += dx;
            this.y += dy;
            this.iceCheck = false;
        } else if (level.getTileAt(x + dx, y + dy) == Tile.WALL || level.getTileAt(x+dx,y+dy) == Tile.DOOR_CLOSED) {
            this.iceCheck = false;
        } else if (level.getTileAt(x + dx, y + dy) == Tile.DEATH) {
            this.iceCheck = false;
            this.lavaCheck = true;
            this.x += dx;
            this.y += dy;
        } else if (level.getTileAt(x + dx, y + dy) == Tile.ICE) {
            this.x += dx;
            this.y += dy;
            this.iceCheck = true;
            this.iceCheckDX = dx;
            this.iceCheckDY = dy;
        } else if (level.getTileAt(x + dx, y + dy) == Tile.FINISH) {
            this.x += dx;
            this.y += dy;
            this.iceCheck = false;
            game.nextLevel();
        } else if (level.getTileAt(x + dx, y + dy) == Tile.LEVER) {
            this.x += dx;
            this.y += dy;
            level.toggleDoor();
        }
    }
}
