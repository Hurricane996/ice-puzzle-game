package com.hurricane996.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

    public boolean up,down,left,right = false;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Any key registered");
        up = e.getKeyCode()    == KeyEvent.VK_W ? true : up;
        left = e.getKeyCode()  == KeyEvent.VK_A ? true : left;
        down = e.getKeyCode()  == KeyEvent.VK_S ? true : down;
        right = e.getKeyCode() == KeyEvent.VK_D ? true : right;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
};