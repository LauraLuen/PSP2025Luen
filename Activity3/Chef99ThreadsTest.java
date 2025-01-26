package unit2;

import org.junit.Test;
import static org.junit.Assert.*;

public class Chef99ThreadsTest {

    @Test
    public void testOrderCount() throws InterruptedException {
       
        Chef99Threads chefCooking = new Chef99Threads("Arguiñano", "Marmitako", 500);

        Thread[] threads = new Thread[99];
        for (int i = 0; i < 99; i++) {
            threads[i] = new Thread(chefCooking);
        }


        for (Thread thread : threads) {
            thread.start();
        }


        for (Thread thread : threads) {
            thread.join();
        }

        assertEquals(99, Chef99Threads.getOrderCount());
    }
}
