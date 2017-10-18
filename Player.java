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
        if(game.handler.up){
            this.check(x,y,0,-1);
            game.handler.up = false;
        }
        if(game.handler.right){
            this.check(x,y,1,0);
            game.handler.right = false;
        }
        if(game.handler.down){
            this.check(x,y,0,1);
            game.handler.down = false;
        }
        if(game.handler.left){
            this.check(x,y,-1,0);
            game.handler.left = false;
        }
    }

    private void check(int x, int y, int dx, int dy) {
        if ((level.getTileAt(x + dx, y + dy) == Tile.FLOOR) || level.getTileAt(x + dx, y + dy) == Tile.START || level.getTileAt(x+dx,y+dy) == Tile.DOOR_OPEN) {
            this.x += dx;
            this.y += dy;
        } else if (level.getTileAt(x + dx, y + dy) == Tile.WALL || level.getTileAt(x+dx,y+dy) == Tile.DOOR_CLOSED) {
            return;
        } else if (level.getTileAt(x + dx, y + dy) == Tile.DEATH) {
            level.respawn(this);
        } else if (level.getTileAt(x + dx, y + dy) == Tile.ICE) {
            this.x += dx;
            this.y += dy;
            check(this.x, this.y, dx, dy);
        } else if (level.getTileAt(x + dx, y + dy) == Tile.FINISH) {
            this.x += dx;
            this.y += dy;
            game.nextLevel();
        } else if (level.getTileAt(x + dx, y + dy) == Tile.LEVER) {
            this.x += dx;
            this.y += dy;
            level.toggleDoor();
        }
    }
}
