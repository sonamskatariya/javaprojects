package callCentre;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import static java.lang.Thread.sleep;


public class CallCenter {

    /*
       Add additional static member variables here
       (Static member variables are members of the class,
       and are shared by all the objects of the class.)
     */


    /*
       When admittedNewCustomer is -1 it means the greeter is available;
       A new customer will set it to her customer ID upon calling in.
     */
    private static int admittedNewCustomer = -1;

    /*
       newCustomerLock is used to synchronize the access to the
       shared variable admittedNewCustomer.
     */
    private static final ReentrantLock newCustomerLock = new ReentrantLock();

    /*
      The conditional variable free is used to indicate that the
      greeter is available and not greeting any customer.
     */
    private static final Condition free = newCustomerLock.newCondition();

    /*
      The conditional variable busy is used to indicate that the
      greeter is busy greeting a new customer.
     */
    private static final Condition busy = newCustomerLock.newCondition();

    /*
       N is the total number of customers that each agent will serve in
       this simulation.
       (Note that an agent can only serve one customer at a time.)
     */
    private static final int CUSTOMERS_PER_AGENT = 5;

    /*
       NUMBER_OF_AGENTS specifies the total number of agents.
     */
    private static final int NUMBER_OF_AGENTS = 3;

    /*
       NUMBER_OF_CUSTOMERS specifies the total number of customers to create
       for this simulation.
     */
    private static final int NUMBER_OF_CUSTOMERS = NUMBER_OF_AGENTS * CUSTOMERS_PER_AGENT;

    /*
      the number of threads should be significantly greater than NUMBER_OF_AGENTS
      to allow simulating also the greeter and multiple concurrent customers.
     */
    private static final int NUMBER_OF_THREADS = 10;


    /*
       The class for simulating a customer service agent.
     */
    public static class Agent implements Runnable {
        /*
           Please add your implementation of the Agent class.
           Feel free to add any additional member variables, modify
           the constructor, and/or add any additional member methods.
         */

        /*
           ID of the agent.
         */
        private final int ID;

        /*
           The constructor.
           (Feel free to modify.)
         */
        public Agent(int i) {
            ID = i;
        }

        /*
           Your Agent implementation must call this method to serve a customer.
           You must NOT modify this method.
         */
        public void serve(int customerID) {
            System.out.println("Agent " + ID + " is serving customer " + customerID);
            try {
                /*
                   Simulate busy serving a customer by sleeping for 25 milliseconds.
                */
                sleep(25);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
        }

        public void run() {
          /*
              Please add your implementation of the run method here.
           */
        }
    }


    /*
        The class for simulating the greeter service.
     */
    public static class Greeter implements Runnable{
        /*
            Please add your implementation of the Greeter class here.
            Feel free to add any member variable, add the constructor,
            and/or add any additional member methods.
         */

        /*
            Your Greeter implementation must call this method to greet
            a new customer. You must NOT modify this method.
         */
        public void greet(int i, int t){
            System.out.println("The expected waiting time for Customer "+i+" is "+t+" minutes.");
        }

        public void run(){
         /*
             Please add your implementation of the run method.
          */
        }

    }

    /*
        The customer class.
        You must NOT modify this class.
     */
    public static class Customer implements Runnable {

        /*
           The ID of the customer.
         */
        private final int ID;

        /*
           The constructor that initializes the customer ID.
         */
        public Customer (int i){
            ID = i;
        }

        public void run(){

            newCustomerLock.lock();

            /*
                Inside the try block is the critical section
                of this method.
             */
            try {

                /*
                    The variable admittedNewCustomer is not -1 means
                    there was another new customer who set this variable
                    and the greeter is currently greeting that customer.
                    We must wait for the greeter.
                 */
                while (admittedNewCustomer != -1) {
                    free.await();
                }

                /*
                   We now have the mutex lock and can access the shared
                   variable admittedNewCustomer
                 */
                admittedNewCustomer = ID;

                /*
                   We let the greeter know that we have arrived and
                   that it should get busy greeting us now.
                 */
                busy.signal();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }finally {
                /*
                    Release the mutex lock.
                 */
                newCustomerLock.unlock();
            }
        }
    }

    /*
        You must NOT modify the main method.
     */
    public static void main(String[] args){
        //create an executor of 10 threads
        ExecutorService es = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        es.submit(new Greeter());

        for (int i=1; i<=NUMBER_OF_AGENTS; i++){
            es.submit(new Agent(i));
        }

        /*
            Wait a little bit here to ensure that the greeter task
            and all agent tasks have been scheduled before submitting
            any customer task.
         */
        try {
            sleep(1000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i=1; i<=NUMBER_OF_CUSTOMERS; i++){
            es.submit(new Customer(i));
            /*
                For this simulation, a new customer call arrives every
                5 milliseconds.
             */
            try {
                sleep(5);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /*
            Shutdown the Executor so that the program can exit.
         */
        es.shutdown();

    }

}
