package lx.Tank.demo1;

public class Node {
    private int x;
    private int y;
    private int fangxiang;

    public Node(int x, int y, int fangxiang) {
        this.x = x;
        this.y = y;
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

    public int getFangxiang() {
        return fangxiang;
    }

    public void setFangxiang(int fangxiang) {
        this.fangxiang = fangxiang;
    }
}
