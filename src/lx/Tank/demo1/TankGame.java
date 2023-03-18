package lx.Tank.demo1;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Scanner;

public class TankGame extends JFrame {
    static MyPanel mp = null;

    public TankGame() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("是继续游戏还是重新开始：1-重新，0-继续：");
        int i = scanner.nextInt();
        mp = new MyPanel(i);
        new Thread(mp).start();
        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(1200, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    Recorder.keepRecorder();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } finally {
                    System.exit(0);
                }
            }
        });
    }

    public static void main(String[] args) throws IOException {
        new TankGame();
    }
}
