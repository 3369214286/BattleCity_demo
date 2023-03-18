package lx.Tank.demo1;

import java.util.Vector;

public class Hero extends Tank {
    private Vector<Dullet> vector = new Vector<>();
    private boolean isLive = true;

    public Hero(int x, int y, int fangxiang, int leixing) {
        super(x, y, fangxiang, leixing);
    }

    public Vector<Dullet> getVector() {
        return vector;
    }

    public void setVector(Dullet vector) {
        this.vector.add(vector);
    }

    public void moveJ() {
        if (this.vector.size() == 5) {
            return;
        }
        Dullet dullet = null;
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
        this.vector.add(dullet);
        new Thread(dullet).start();
    }
}
