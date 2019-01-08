//There are two ways of implementing threads
//1)extending Thread class 2)implementing runnable interface/pass runnable as an object to thread class


//Now in this we will be seeing the first approach
class Runner extends Thread{

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class ThreadImplementationByExtendingThreadClass {

    public static void main(String[] args){
        Runner thread1 = new Runner();//these two threads run parallely
        Runner thread2 = new Runner();
        thread1.start();
        thread2.start();

    }
}
