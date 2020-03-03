public class Test {
    /*private static final int COUNT=10_0000_0000;
    public static void main(String[] args) throws InterruptedException {
        myThread();
        System.out.println();
        time();
        System.out.println();
    }
    private static void myThread() throws InterruptedException {
        double begin=System.currentTimeMillis();
        Thread thread=new Thread(){
            @Override
            public void run() {
                int a=0;
                for(int i=0;i<COUNT;i++){
                    a--;
                }
            }
    };

        thread.start();
        int b=0;
        for(int i=0;i<COUNT;i++){
            b--;
        }
        thread.join();
        double end=System.currentTimeMillis();
        System.out.printf("并发时间：%f毫秒",end-begin);
    }
    private static void time(){
        int a=0;
        double begin=System.currentTimeMillis();
        for(int i=0;i<COUNT;i++){
            a--;
        }
        for(int j=0;j<COUNT;j++){
            a--;
        }
        double end=System.currentTimeMillis();
        System.out.printf("串行时间：%s毫秒",end-begin);
    }*/
    /*private static class MyRunnable implements  Runnable{

        @Override
        public void run() {

            for(int i=0;i<10;i++){
                System.out.println(Thread.currentThread().isInterrupted());
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        MyRunnable r=new MyRunnable();
        Thread thread=new Thread(r,"李四");
        System.out.println("李四开始交易");
        thread.start();
        //thread.sleep(100);
        //System.out.println("有内鬼终止交易");
        //r.isQuit=true;
        thread.interrupt();
    }*/

    public static void main(String[] args) throws InterruptedException {
        /*Runnable r=()->{
            for(int i=0;i<5;i++){
                System.out.println(Thread.currentThread().getName()+":我正在工作");
                try {
                    Thread.currentThread().sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("工作完成");
        };*/
        /*Thread t1=new Thread(r,"张三");
        Thread t2=new Thread(r,"王五");
        System.out.println("先让张三完成再让王五开始");
        t1.start();
        t1.join();
        System.out.println("张三已经完成,王五可以开始了");
        t2.start();
        t2.join();
        System.out.println("王五也完成了");*/
        /*for(Thread.State state:Thread.State.values()){
            System.out.println(state);
        }*/
        /*Thread t=new Thread(()->{
            for(int i=0;i<10000;i++){

            }
        },"张三");
        System.out.println(t.getName()+":"+t.getState());
        t.start();
        while(t.isAlive()){
            System.out.println(t.getName()+":"+t.getState());
        }
        System.out.println(t.getName()+":"+t.getState());*/
        Counter c=new Counter();
        Runnable r=()->{
            for(int i=0;i<500;i++){
                c.decement();
            }
        };
        Thread t1=new Thread(r);
        Thread t2=new Thread(r);
        t1.start();
        t2.start();
        for(int i=0;i<1000;i++){
            c.increment();
        }
        t1.join();
        t2.join();
        System.out.println(c.val());
    }
    private static class Counter{
        int n=0;
        public void increment(){
            n++;
        }
        public void decement(){
            n--;
        }
        public int val(){
            return n;
        }
    }
}
