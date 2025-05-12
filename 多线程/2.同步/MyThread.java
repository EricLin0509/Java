public class MyThread extends Thread {
    Mydata mydata; // 增加共享变量
    
    // 添加构造函数
    public MyThread(Mydata mydata) {
        this.mydata = mydata;
    }

    @Override
    public void run() {
        // 移除局部变量 mydata = new Mydata();
        for (int i = 0; i < 10000; i++) {
            mydata.add();
        }
    }
}