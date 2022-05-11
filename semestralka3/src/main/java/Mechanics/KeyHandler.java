package Mechanics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class KeyHandler implements KeyListener {
    GamePanel gp;
    public boolean up;
    public boolean down;
    public boolean left;
    public boolean right;
    public boolean space;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {

        int code = e.getKeyCode();
        if(gp.gameState == GamePanel.runState) {
            switch (code) {
                case (KeyEvent.VK_W): {
                    up = true;
                    break;
                }
                case (KeyEvent.VK_S): {
                    down = true;
                    break;
                }
                case (KeyEvent.VK_A): {
                    left = true;
                    break;
                }
                case (KeyEvent.VK_D): {
                    right = true;
                    break;
                }
                case (KeyEvent.VK_SPACE): {
                    space = true;
                    break;
                }
                case (KeyEvent.VK_Q):
                {
                    gp.player.throwOut();
                    break;
                }
            }
            if (e.getKeyCode() <= KeyEvent.VK_9 && e.getKeyCode() >= KeyEvent.VK_1)
            {
                gp.player.selectItem(Character.getNumericValue(e.getKeyChar()));
            }
        }
        else if(gp.gameState == GamePanel.menuState)
        {
            switch (e.getKeyCode()) {
                case (KeyEvent.VK_W): {
                    gp.ui.numberChosen= (gp.ui.numberChosen+1)%2;
                    break;
                }
                case (KeyEvent.VK_S): {
                    gp.ui.numberChosen= (gp.ui.numberChosen+1)%2;
                    break;
                }
                case (KeyEvent.VK_ENTER): {
                    gp.ui.submit();
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code)
        {
            case(KeyEvent.VK_W):
            {
                up = false;
                break;
            }
            case(KeyEvent.VK_S):
            {
                down = false;
                break;
            }
            case(KeyEvent.VK_A):
            {
                left = false;
                break;
            }
            case(KeyEvent.VK_D):
            {
                right = false;
                break;
            }
            case(KeyEvent.VK_SPACE):
            {
                space = false;
                break;
            }
        }
    }
}
