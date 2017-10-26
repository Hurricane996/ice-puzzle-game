package com.hurricane996.game;

import com.hurricane996.game.player.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

    Player player;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                player.up = true;
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                player.left = true;
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                player.down = true;
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                player.right = true;
                break;
            default:
                break;
        }
    }

    public InputHandler(Player player) {
        this.player = player;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                player.up = false;
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                player.left = false;
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                player.down = false;
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                player.right = false;
                break;
            default:
                break;
        }
    }
};