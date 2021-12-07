/*
 * TASLockTest.java
 * JUnit based test
 *
 * Created on May 1, 2006, 3:03 PM
 */

package tamp.appendix2.Hardware.hardware;
/*
 * TASTest.java
 * JUnit based test
 *
 * Created on January 12, 2006, 8:27 PM
 */

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TASLockTest extends TestCase {
    private final static int THREADS = 8;
    private final static int COUNT = 8 * 1024;
    private final static int PER_THREAD = COUNT / THREADS;
    Thread[] thread = new Thread[THREADS];
    int counter = 0;

    TASLock instance = new TASLock();

    public TASLockTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(TASLockTest.class);

        return suite;
    }

    public void testParallel() throws Exception {
        System.out.println("parallel");
        ThreadID.reset();
        for (int i = 0; i < THREADS; i++) {
            thread[i] = new MyThread();
        }
        for (int i = 0; i < THREADS; i++) {
            thread[i].start();
        }
        for (int i = 0; i < THREADS; i++) {
            thread[i].join();
        }

        assertEquals(counter, COUNT);
    }

    class MyThread extends Thread {
        public void run() {
            for (int i = 0; i < PER_THREAD; i++) {
                instance.lock();
                try {
                    counter = counter + 1;
                } finally {
                    instance.unlock();
                }
            }
        }
    }
}