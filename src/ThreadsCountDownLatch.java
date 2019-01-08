//CountDownLatch is one of the thread safe classes
//With use of CountDownLatch we can reduce the usage of certain keywords/methods like synchronized/notify etc because countdownlatch keeps ctrack on the number of threads
//currently executed completed etc.


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ThreadM implements Runnable{

    CountDownLatch latch;

    public ThreadM(CountDownLatch latch) {
        this.latch = latch;
    }


    @Override
    public void run() {

        System.out.println("Started");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        latch.countDown();
    }
}

public class ThreadsCountDownLatch {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(3);

        ExecutorService executor = Executors.newFixedThreadPool(3);


        for (int i = 0; i < 3; i++)

        {
            executor.submit(new ThreadM(latch));
        }

        latch.await();

        System.out.println("Completed");

    }

}
