import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.System.*;

public class ThreadsMultipleLocksSynchronizedCodeBlocks {

    private List<Integer> list1 = new ArrayList<Integer>();
    private List<Integer> list2 = new ArrayList<Integer>();

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    Random random = new Random();

    public  void  stageone() {

        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            list1.add(random.nextInt(100));


        }
    }

    public void stagetwo() {

        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            list2.add(random.nextInt(100));


        }
    }

    private void process() {
        for (int i = 0; i < 1000; i++) {
            stageone();
            stagetwo();

        }
    }

    public void main(){

        System.out.println("starting...");

         long startTime = currentTimeMillis();

         Thread t1 = new Thread(new Runnable() {
             @Override
             public void run() {
               process();
             }
         });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
               process();
            }
        });

  t1.start();
  t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        long endTime = currentTimeMillis();

        System.out.println("Total time"+ (endTime-startTime));
        System.out.println("List1 size"+list1.size());
        System.out.println("List2 size"+list2.size());


    }

}
