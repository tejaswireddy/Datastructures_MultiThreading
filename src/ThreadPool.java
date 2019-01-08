//We will dem,onstrate a program that uses ThreadPool here
//Thread pool as name suggests contains number of threads which work on tasks assigned.
//Each thread in thread pool will pick a task works on it and picks another one after it completes working on existing task
//The number of threads in thread pool are like workers in a facrory and tasks are nothing but work assigned to them

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable{

   private int id;

   public Processor(int id){
       this.id=id;
   }
    @Override
    public void run() {


       System.out.println("Processing id : "+ id);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Completed id : "+ id);


    }
}
public class ThreadPool {

    public static void main(String[] args){

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for(int i=0;i<5;i++){
            executor.submit(new Processor(i));
        }

        executor.shutdown();

        //System.out.println("All tasks submitted");

        try {
            executor.awaitTermination(10, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("All tasks completed");
    }
}
