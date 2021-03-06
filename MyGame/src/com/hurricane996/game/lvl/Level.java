package com.hurricane996.game.lvl;

import com.hurricane996.game.gfx.IRenderable;
import com.hurricane996.game.gfx.Screen;
import com.hurricane996.game.player.Player;

public class Level implements IRenderable {


    private Tile[][] tiles;
    private int spawnX = 1,spawnY = 1;

    public static Level[] levels = {
    new Level(new int[][]{
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    }),
    new Level(new int[][]{
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {0,3,3,3,3,3,3,3,3,1,3,3,3,3,3,3,3,3,3,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    }),
    new Level(new int[][]{
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,4,2,2,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1,0},
            {0,2,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,0},
            {0,2,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,0},
            {0,2,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,0},
            {0,2,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,0},
            {0,2,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,0},
            {0,3,3,3,3,3,3,3,3,1,3,3,3,3,3,3,3,3,3,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    }),
    new Level(new int[][]{
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,8,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,6,0,0,0,0,0,0,0},
            {0,8,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,7,0,0,0,0,0,0,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    }),
    new Level(new int[][]{
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,4,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3,3,3,0},
            {0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,3,3,0},
            {0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,5,3,0},
            {0,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3,0},
            {0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,0},
            {0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,1,0},
            {0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,0,2,0},
            {0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
            {0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
            {0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,0},
            {0,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
            {0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
            {0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,2,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    })
    };
    public static Level youWon = new Level(new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 2, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 0},
            {0, 1, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 1, 2, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 2, 1, 1, 2, 1, 2, 1, 2, 1, 1, 2, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 2, 1, 2, 1, 2, 1, 2, 2, 2, 1, 2, 1, 1, 2, 1, 1, 0},
            {0, 1, 1, 2, 1, 2, 1, 2, 1, 1, 2, 1, 1, 2, 2, 1, 2, 1, 1, 0},
            {0, 1, 1, 2, 1, 2, 1, 2, 1, 1, 2, 1, 1, 2, 1, 2, 2, 1, 1, 0},
            {0, 1, 1, 1, 2, 1, 2, 1, 1, 2, 2, 2, 1, 2, 1, 1, 2, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    });
    @Override
    public void render(Screen screen, int x, int y) {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                screen.render(tiles[i][j], i, j);
            }
        }
    }
    public Level(int[][] tilesAsInts){
        tiles = new Tile[tilesAsInts[0].length][tilesAsInts.length];
        for(int x = 0; x < tilesAsInts[0].length; x++){
            for(int y = 0; y < tilesAsInts.length; y++){
                tiles[x][y] = Tile.TILES[tilesAsInts[y][x]];
                if(tiles[x][y] == Tile.START){
                    spawnX = x;
                    spawnY = y;
                }
            }
        }
    }
    public Tile getTileAt(int x, int y) {
        return tiles[x][y];
    }
    public void respawn(Player player) {
        player.x = spawnX;
        player.y = spawnY;
    }
    public void toggleDoor(){
        for(int i = 0; i < tiles.length; i++){
            for(int j = 0; j < tiles[i].length; j++){
                if(tiles[i][j] == Tile.DOOR_CLOSED){
                    tiles[i][j] = Tile.DOOR_OPEN;
                }
                else if(tiles[i][j] == Tile.DOOR_OPEN){
                    tiles[i][j] = Tile.DOOR_CLOSED;
                }
            }
        }
    }
}
