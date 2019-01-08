//Here we will be dealing with a problem which is when two threads are accessing the same variable we cannot get the expected result
//since both variables are making change to a certain variable at the same time

//Please run the program with and without synchronized keyword ro see the difference
//any method with synchronixed keyword helps threads running this method acquire intrinsic lock so that means it will be allowed to use by one thread at a time.


public class ThreadsSynchronizedKeyword {
    private int count = 0;

    public static void main(String[] args) {

        ThreadsSynchronizedKeyword t = new ThreadsSynchronizedKeyword();
        t.dowork();
    }

    public synchronized int increment(){
        return count++;
    }


     public void dowork(){
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0;i<10000;i++){
                        increment();
                    }
                }
            });

         Thread t2 = new Thread(new Runnable() {
             @Override
             public void run() {
                 for (int i=0;i<10000;i++){
                     increment();
                 }
             }
         });

         t1.start();
         t2.start();


         try {
             t1.join();//wait untill t1 completed its execution
             t2.join();// wait untill t2 completed its execution
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

         System.out.println(count);
        }


    }



