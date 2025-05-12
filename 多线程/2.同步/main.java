public class main {
    public static void main(String[] args) {
        Mydata mydata = new Mydata();
        Thread[] threads = new Thread[10]; // 保存线程引用
        
        for (int i = 0; i < 10; i++) {
            threads[i] = new MyThread(mydata); // 传递共享对象
            threads[i].start();
        }
        
        // 等待所有线程完成
        for (Thread t : threads) {
            try {
                t.join(); // 等待线程完成
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println(mydata.getNum());
    }
}