package lx.Tank.demo1;

public class Dullet implements Runnable {
    private int x;
    private int y;
    private int fangxiang;
    private int buchang = 10;
    private boolean isLive = true;

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public Dullet(int x, int y, int fangxiang) {
        this.x = x;
        this.y = y;
        this.fangxiang = fangxiang;
    }

    public int getFangxiang() {
        return fangxiang;
    }

    public void setFangxiang(int fangxiang) {
        this.fangxiang = fangxiang;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            switch (this.fangxiang) {
                case 0:
                    this.y -= this.buchang;
                    break;
                case 1:
                    this.y += this.buchang;
                    break;
                case 2:
                    this.x -= this.buchang;
                    break;
                case 3:
                    this.x += this.buchang;
                    break;
            }
            if (!(x >= 0 && x <= 900 && y >= 0 && y <= 900)) {
                this.isLive = false;
                break;
            }
        }
    }
}
