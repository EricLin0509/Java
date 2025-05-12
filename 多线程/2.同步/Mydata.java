public class Mydata {
    private int num = 0;

    public synchronized void add() {
        num++;
    }

    public int getNum() {
        return num;
    }
}