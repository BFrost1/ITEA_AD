package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Panel extends JPanel implements Runnable, KeyListener {
    public static final int WIDTH = 500, HEIGHT = 500;
    private boolean right = false, left = false, up = false, down = false;
    private int x = 10, y = 10, size = 5;
    private int ticks;
    private List<Snake> snakeList = new ArrayList<>();
    private List<Items> itemsList = new ArrayList<>();

    public Panel() {
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        addKeyListener(this);
        new Thread(this).start();
    }


    public void stop() {
            Thread.currentThread().interrupt();
    }

    public void tick() {
        if (snakeList.size() == 0) {
            snakeList.add(new Snake(x, y, 10));
        }
        if (itemsList.size() == 0) {
            itemsList.add(new Items(new Random().nextInt(49), new Random().nextInt(49), 10));
        }
        if (ticks++ > WIDTH * HEIGHT) {
            if (right) x++;
            if (left) x--;
            if (up) y--;
            if (down) y++;
            ticks = 0;
            snakeList.add(new Snake(x, y, 10));
            if (snakeList.size() > size) {
                snakeList.remove(0);
            }
        }
        for (int i = 0; i < itemsList.size(); i++) {
            if (x == itemsList.get(i).getX() && y == itemsList.get(i).getY()) {
                size++;
                itemsList.remove(i);
                i++;
            }
        }

        if (x < 0 || x > 49 || y < 0 || y > 49) {
            stop();
        }
    }

    public void paint(Graphics gr) {
        gr.clearRect(0, 0, WIDTH, HEIGHT);
        gr.fillRect(0, 0, WIDTH, HEIGHT);

        for (int i = 0; i < WIDTH / 10; i++) {
            gr.drawLine(i * 10, 0, i * 10, WIDTH);
            gr.drawLine(i * 10, 0, i * 10, HEIGHT);
        }

        for (int i = 0; i < snakeList.size(); i++) {
            snakeList.get(i).draw(gr);
        }
        for (int i = 0; i < itemsList.size(); i++) {
            itemsList.get(i).draw(gr);
        }
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            tick();
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && !left) {
            right = true;
            up = false;
            down = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT && !right) {
            left = true;
            up = false;
            down = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_UP && !down) {
            up = true;
            left = false;
            right = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN && !up) {
            down = true;
            left = false;
            right = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
