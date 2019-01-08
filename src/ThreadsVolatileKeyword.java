//Here we are trying to explain volatile keyword
//We are going to discuss a problem here when we have multiple threads running when one thread tries to make changes to another thread.The changes made by other thread may not be
//recognized by first thread because of catching and it might think no other process can actully make a change to its implementation
//This was a problrm in older versions of java
//volatile keyword would tell the tr=hread that a particular variable is volatile to changes by any other thraeds.


//Here we have two threads running.you might wonder where its only one thread which is process1
//Actually main method is one thread which spawns another thread which is process1
//The variable in Processor class result might not recognize the changes made by main thread which is invoking shutdown method to make changes to result variable.
//Volatile helps process1 thread to knowthat result can be changed by any other thread.

//Please run the program with and without the volatile keyword to see the difference(Note:you might not see any differences if you are using the latest versions of java)


import java.util.Scanner;

public class ThreadsVolatileKeyword {

 static class Processor extends Thread{

        private volatile boolean result = true;

        @Override
        public void run() {
            while (result){
                System.out.println("Hello");
            }
        }

        public void shutdown(){
             result = false;

        }
    }

    public static void main(String[] args){

        Processor process1 = new Processor();
        process1.start();

        System.out.println("Press return key to stop");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();

        process1.shutdown();



    }
}
