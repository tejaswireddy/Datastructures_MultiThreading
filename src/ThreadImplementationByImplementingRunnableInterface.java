//this is the second method of how we can implement a thread i.e by implementing Runnable interface

public class ThreadImplementationByImplementingRunnableInterface {

    static class Runner implements Runnable{

        @Override
        public void run() {
            for(int i=0;i<10;i++){
                System.out.println(i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args){

       Thread t1 = new Thread(new Runner());
       t1.start();
        Thread t2 = new Thread(new Runner());
        t2.start();


    }
}
