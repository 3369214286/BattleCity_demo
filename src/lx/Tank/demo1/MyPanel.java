package lx.Tank.demo1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener, Runnable {
    private Hero hero = null;
    private Vector<EnemyTank> vector = new Vector<>();
    private Vector<Node> nodeVector = null;

    public MyPanel(int key) throws IOException {
        File file=new File(Recorder.getStr());
        if(file.exists()){
            nodeVector = Recorder.getNodes();
        }else{
            key=1;
        }
        Recorder.setVector(vector);
        hero = new Hero(500, 500, 0, 0);
        switch (key) {
            case 0:
                nodeVector = Recorder.getNodes();
                for (int i = 0; i < nodeVector.size(); i++) {
                    EnemyTank enemyTank = new EnemyTank(nodeVector.get(i).getX(), nodeVector.get(i).getY(),
                            nodeVector.get(i).getFangxiang(), 1);
                    vector.add(enemyTank);
                    enemyTank.setEnemyTankVector(vector);
                    new Thread(enemyTank).start();
                }
                break;
            case 1:
                for (int i = 0; i < 3; i++) {
                    EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0, 1, 1);
                    vector.add(enemyTank);
                    enemyTank.setEnemyTankVector(vector);
                    new Thread(enemyTank).start();
                }
                break;

        }

    }

    public void show(Graphics g) {
        g.setColor(Color.BLACK);
        Font font = new Font("宋体", Font.BOLD, 25);
        g.setFont(font);
        g.drawString("你累计击毁敌方坦克", 925, 30);

        huaTank(1000, 50, g, 0, 1);
        g.setColor(Color.BLACK);
        g.drawString(Recorder.getJishu() + "", 1070, 110);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 900, 900);

        show(g);

        if (hero.getisLive() != false) {
            huaTank(hero.getX(), hero.getY(), g, hero.getFangxiang(), hero.getLeixing());
        }
        for (int i = 0; i < hero.getVector().size(); i++) {
            Dullet dullet = hero.getVector().get(i);
            hitEnemyTank(dullet);
            if (dullet != null && dullet.isLive() != false) {
                g.draw3DRect(dullet.getX(), dullet.getY(), 1, 1, false);
            } else {
                hero.getVector().remove(dullet);
            }
        }

        for (int i = 0; i < vector.size(); i++) {
            EnemyTank enemyTank = vector.get(i);
            if (enemyTank.getisLive() != false) {
                huaTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getFangxiang(), enemyTank.getLeixing());
                for (int j = 0; j < enemyTank.getVector().size(); j++) {
                    Dullet dullet = enemyTank.getVector().get(j);
                    hitTank(dullet, hero);
                    if (dullet != null && dullet.isLive() != false) {
                        g.draw3DRect(dullet.getX(), dullet.getY(), 1, 1, false);
                    } else {
                        vector.get(i).getVector().remove(dullet);
                    }
                }
            } else {
                vector.remove(enemyTank);
            }
        }

    }

    public void huaTank(int x, int y, Graphics g, int fangxiang, int leixing) {
        switch (leixing) {
            case 0:
                g.setColor(Color.ORANGE);
                break;
            case 1:
                g.setColor(Color.CYAN);
                break;
        }
        switch (fangxiang) {
            case 0:
                g.fillRect(x, y, 20, 60);
                g.fillRect(x + 40, y, 20, 60);
                g.fillRect(x + 20, y + 10, 20, 40);
                g.drawLine(x + 30, y + 30, x + 30, y);
                break;
            case 1:
                g.fillRect(x, y, 20, 60);
                g.fillRect(x + 40, y, 20, 60);
                g.fillRect(x + 20, y + 10, 20, 40);
                g.drawLine(x + 30, y + 30, x + 30, y + 60);
                break;
            case 2:
                g.fillRect(x, y, 60, 20);
                g.fillRect(x, y + 40, 60, 20);
                g.fillRect(x + 10, y + 20, 40, 20);
                g.drawLine(x + 30, y + 30, x, y + 30);
                break;
            case 3:
                g.fillRect(x, y, 60, 20);
                g.fillRect(x, y + 40, 60, 20);
                g.fillRect(x + 10, y + 20, 40, 20);
                g.drawLine(x + 30, y + 30, x + 60, y + 30);
                break;
        }
    }

    public void hitEnemyTank(Dullet dullet) {
        for (int i = 0; i < vector.size(); i++) {
            EnemyTank enemyTank = vector.get(i);
            for (int j = 0; j < enemyTank.getVector().size(); j++) {
                hitTank(dullet, enemyTank);
            }
        }
    }

    public void hitTank(Dullet dullet, Tank tank) {
        switch (tank.getFangxiang()) {
            case 0:
            case 1:
                if (dullet.getX() >= tank.getX() && dullet.getX() <= tank.getX() + 60 &&
                        dullet.getY() >= tank.getY() && dullet.getY() <= tank.getY() + 60) {
                    tank.setisLive(false);
                    dullet.setLive(false);
                    if (tank instanceof EnemyTank) {
                        Recorder.addjishu();
                    }
                }
                break;
            case 3:
            case 4:
                if (dullet.getX() >= tank.getX() && dullet.getX() <= tank.getX() + 60 &&
                        dullet.getY() >= tank.getY() && dullet.getY() <= tank.getY() + 60) {
                    tank.setisLive(false);
                    dullet.setLive(false);
                    if (tank instanceof EnemyTank) {
                        Recorder.addjishu();
                    }
                }
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            if (hero.getY() >= 0) {
                hero.moveW();
                hero.setFangxiang(0);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            if (hero.getY() + 60 <= 900) {
                hero.moveS();
                hero.setFangxiang(1);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            if (hero.getX() >= 0) {
                hero.moveA();
                hero.setFangxiang(2);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            if (hero.getX() + 60 <= 900) {
                hero.moveD();
                hero.setFangxiang(3);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_J) {
            hero.moveJ();
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            this.repaint();
        }
    }
}
