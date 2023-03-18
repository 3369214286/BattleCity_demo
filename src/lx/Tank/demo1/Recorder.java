package lx.Tank.demo1;

import java.io.*;
import java.util.Vector;

public class Recorder {
    private static int jishu = 0;
    private static BufferedWriter bufferedWriter = null;
    private static BufferedReader bufferedReader = null;
    private static String str = "src\\myRecorder.txt";
    private static Vector<EnemyTank> vector = null;
    private static Vector<Node> nodes = new Vector<>();

    public static void setVector(Vector<EnemyTank> vector) {
        Recorder.vector = vector;
    }

    public static Vector<Node> getNodes() throws IOException {
        bufferedReader = new BufferedReader(new FileReader(str));
        jishu = Integer.parseInt(bufferedReader.readLine());
        String s = "";
        while ((s = bufferedReader.readLine()) != null) {
            String[] ss = s.split(" ");
            Node node = new Node(Integer.parseInt(ss[0]), Integer.parseInt(ss[1]), Integer.parseInt(ss[2]));
            nodes.add(node);
        }
        return nodes;
    }

    public static Vector<EnemyTank> getVector() {
        return vector;
    }

    public static void keepRecorder() throws IOException {
        bufferedWriter = new BufferedWriter(new FileWriter(str));
        bufferedWriter.write(jishu + "\r\n");
        for (int i = 0; i < vector.size(); i++) {
            EnemyTank enemyTank = vector.get(i);
            if (enemyTank.getisLive()) {
                bufferedWriter.write(enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getFangxiang() + "\r\n");
            }
        }
        if (bufferedWriter != null) {
            bufferedWriter.close();
        }
    }

    public static String getStr() {
        return str;
    }

    public static int getJishu() {
        return Recorder.jishu;
    }

    public static void setJishu(int jishu) {
        Recorder.jishu = jishu;
    }

    public static void addjishu() {
        Recorder.jishu++;
    }
}
