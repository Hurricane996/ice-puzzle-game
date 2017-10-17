package com.hurricane996.game;

import com.hurricane996.game.gfx.Screen;
import com.hurricane996.game.lvl.Level;
import com.hurricane996.game.player.Player;

import javax.swing.JFrame;

import java.awt.*;

import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
    public InputHandler handler;
    public static final int WIDTH = 640, HEIGHT = 480;
    public static final String NAME = "GAME";

    public int index = 0;
    public Level level = Level.levels[index];

    Player player;
    private boolean running = false;

    private Screen screen;
    private boolean won = false;

    public Game(){

        screen  = new Screen(WIDTH,HEIGHT);
        player  = new Player(1,1,"/player_temp_sprite.png",this);
        setLevel();
        handler = new InputHandler();
        addKeyListener(handler);

    }
    public static void main(String[] args){
        Game game = new Game();
        game.setMaximumSize(new Dimension(WIDTH,HEIGHT));
        game.setMinimumSize(new Dimension(WIDTH,HEIGHT));
        game.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        game.setSize(new Dimension(WIDTH,HEIGHT));

        JFrame jframe = new JFrame();
        jframe.setTitle(NAME);
        jframe.add(game);
        jframe.pack();
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
        jframe.setLocationRelativeTo(null);

        game.startGame();

    }
    public void startGame(){
        running = true;
        new Thread(this).start();
    }
    public void stopGame(){
        running = false;
    }
    @Override
    public void run() {
        int fps = 0, tick = 0;
        double fpsTimer = System.currentTimeMillis();
        double nsPerTick = 1000000000.0d/60;
        double then = System.nanoTime();
        double unprocessed = 0;
        while(running){
            boolean canRender = false;
            double now = System.nanoTime();
            unprocessed += (now - then)/nsPerTick;
            then = now;
            while(unprocessed>1){
                tick++;
                tick();
                unprocessed--;
                canRender=true;
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(canRender) {
                fps++;
                render();
            }
            if(System.currentTimeMillis() - fpsTimer > 1000){
                System.out.printf("%d fps, %d tick,\n",fps,tick);
                fps=0;
                tick=0;
                fpsTimer = System.currentTimeMillis();
            }
        }

    }

    private void render() {
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);
            requestFocus();
            return;
        }
        Graphics g = bs.getDrawGraphics();
        if(won){
            screen.clear(0xFF000000);
            screen.render(Level.youWon,0,0);
        } else {
            screen.clear(0xFF000000);

            screen.render(level, 0, 0);
            screen.render(player, player.x, player.y);
        }
        g.drawImage(screen.image,0,0,WIDTH,HEIGHT,null);

        g.dispose();
        bs.show();
    }
    private void tick() {
        player.update();
    }
    public void setLevel(){
        level = Level.levels[index];
        player.level = level;
        level.respawn(player);
    }
    public void nextLevel(){
        index++;
        if(index>=Level.levels.length){
            won = true;
            return;
        }
        setLevel();
    }
}
