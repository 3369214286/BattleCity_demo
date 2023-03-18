package lx.Tank.demo1;

public class Tank {
    private int x;
    private int y;
    private int fangxiang;
    private int leixing;
    private int buchang = 3;
    private boolean isLive = true;

    public Tank(int x, int y, int fangxiang, int leixing) {
        this.x = x;
        this.y = y;
        this.fangxiang = fangxiang;
        this.leixing = leixing;
    }

    public boolean getisLive() {
        return isLive;
    }

    public void setisLive(boolean live) {
        isLive = live;
    }

    public int getBuchang() {
        return buchang;
    }

    public void setBuchang(int buchang) {
        this.buchang = buchang;
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

    public int getFangxiang() {
        return fangxiang;
    }

    public void setFangxiang(int fangxiang) {
        this.fangxiang = fangxiang;
    }

    public int getLeixing() {
        return leixing;
    }

    public void setLeixing(int leixing) {
        this.leixing = leixing;
    }

    public void moveW() {
        this.y -= this.buchang;
    }

    public void moveS() {
        this.y += this.buchang;
    }

    public void moveA() {
        this.x -= this.buchang;
    }

    public void moveD() {
        this.x += this.buchang;
    }

}
