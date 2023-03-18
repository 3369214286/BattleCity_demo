package lx.Tank.demo1;

import java.util.Random;
import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {
    private Vector<Dullet> vector = new Vector<>();
    private Vector<EnemyTank> enemyTankVector = new Vector<>();

    public EnemyTank(int x, int y, int fangxiang, int leixing) {
        super(x, y, fangxiang, leixing);
    }

    public Vector<EnemyTank> getEnemyTankVector() {
        return enemyTankVector;
    }

    public void setEnemyTankVector(Vector<EnemyTank> enemyTankVector) {
        this.enemyTankVector = enemyTankVector;
    }

    public Vector<Dullet> getVector() {
        return vector;
    }

    public void setVector(Vector<Dullet> vector) {
        this.vector = vector;
    }

    public boolean isTankTank() {
        EnemyTank enemyTank1 = null;
        switch (this.getFangxiang()) {
            case 0:
                for (int i = 0; i < enemyTankVector.size(); i++) {
                    enemyTank1 = enemyTankVector.get(i);
                    if (enemyTank1 != this) {
                        if (this.getX() >= enemyTank1.getX() &&
                                this.getX() <= enemyTank1.getX() + 60 &&
                                this.getY() >= enemyTank1.getY() &&
                                this.getY() <= enemyTank1.getY() + 60) {
                            return false;
                        }
                        if (this.getX() + 60 >= enemyTank1.getX() &&
                                this.getX() + 60 <= enemyTank1.getX() + 60 &&
                                this.getY() >= enemyTank1.getY() &&
                                this.getY() <= enemyTank1.getY() + 60) {
                            return false;
                        }
                    }
                }
                break;
            case 1:
                for (int i = 0; i < enemyTankVector.size(); i++) {
                    enemyTank1 = enemyTankVector.get(i);
                    if (enemyTank1 != this) {
                        if (this.getX() >= enemyTank1.getX() &&
                                this.getX() <= enemyTank1.getX() + 60 &&
                                this.getY() + 60 >= enemyTank1.getY() &&
                                this.getY() + 60 <= enemyTank1.getY() + 60) {
                            return false;
                        }
                        if (this.getX() + 60 >= enemyTank1.getX() &&
                                this.getX() + 60 <= enemyTank1.getX() + 60 &&
                                this.getY() + 60 >= enemyTank1.getY() &&
                                this.getY() + 60 <= enemyTank1.getY() + 60) {
                            return false;
                        }
                    }
                }
                break;
            case 2:
                for (int i = 0; i < enemyTankVector.size(); i++) {
                    enemyTank1 = enemyTankVector.get(i);
                    if (enemyTank1 != this) {
                        if (this.getX() >= enemyTank1.getX() &&
                                this.getX() <= enemyTank1.getX() + 60 &&
                                this.getY() >= enemyTank1.getY() &&
                                this.getY() <= enemyTank1.getY() + 60) {
                            return false;
                        }
                        if (this.getX() >= enemyTank1.getX() &&
                                this.getX() <= enemyTank1.getX() + 60 &&
                                this.getY() + 60 >= enemyTank1.getY() &&
                                this.getY() + 60 <= enemyTank1.getY() + 60) {
                            return false;
                        }
                    }
                }
                break;
            case 3:
                for (int i = 0; i < enemyTankVector.size(); i++) {
                    enemyTank1 = enemyTankVector.get(i);
                    if (enemyTank1 != this) {
                        if (this.getX() + 60 >= enemyTank1.getX() &&
                                this.getX() + 60 <= enemyTank1.getX() + 60 &&
                                this.getY() >= enemyTank1.getY() &&
                                this.getY() <= enemyTank1.getY() + 60) {
                            return false;
                        }
                        if (this.getX() + 60 >= enemyTank1.getX() &&
                                this.getX() + 60 <= enemyTank1.getX() + 60 &&
                                this.getY() + 60 >= enemyTank1.getY() &&
                                this.getY() + 60 <= enemyTank1.getY() + 60) {
                            return false;
                        }
                    }
                }
                break;
        }
        return true;
    }

    @Override
    public void run() {
        while (true) {
            Dullet dullet = null;
            Random random = null;
            if (vector.size() == 5) {
                continue;
            }
            switch (this.getFangxiang()) {
                case 0:
                    dullet = new Dullet(this.getX() + 30, this.getY(), this.getFangxiang());
                    break;
                case 1:
                    dullet = new Dullet(this.getX() + 30, this.getY() + 60, this.getFangxiang());
                    break;
                case 2:
                    dullet = new Dullet(this.getX(), this.getY() + 30, this.getFangxiang());
                    break;
                case 3:
                    dullet = new Dullet(this.getX() + 60, this.getY() + 30, this.getFangxiang());
                    break;
            }
            vector.add(dullet);
            new Thread(dullet).start();


            switch (this.getFangxiang()) {
                case 0:
                    for (int i = 0; i < 30; i++) {
                        if (this.getY() >= 0 && this.isTankTank()) {
                            this.moveW();
                        } else {
                            break;
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < 30; i++) {
                        if (this.getY() <= 1000 && this.isTankTank()) {
                            this.moveS();
                        } else {
                            break;
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 30; i++) {
                        if (this.getX() >= 0 && this.isTankTank()) {
                            this.moveA();
                        } else {
                            break;
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 30; i++) {
                        if (this.getX() <= 1000 && this.isTankTank()) {
                            this.moveD();
                        } else {
                            break;
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
            }
            random = new Random();
            this.setFangxiang(random.nextInt(4));
        }
    }
}
