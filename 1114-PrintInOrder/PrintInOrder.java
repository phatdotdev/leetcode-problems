
import java.util.concurrent.CountDownLatch;

public class PrintInOrder {

    private CountDownLatch latch1 = new CountDownLatch(1), latch2 = new CountDownLatch(1);

    // public Foo() {

    // }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        latch1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        latch1.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        latch2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        latch2.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

/*
 * Semaphore run2 = new Semaphore(0);
 * Semaphore run3 = new Semaphore(0);
 * 
 * public Foo() {
 * 
 * }
 * 
 * public void first(Runnable printFirst) throws InterruptedException {
 * 
 * // printFirst.run() outputs "first". Do not change or remove this line.
 * printFirst.run();
 * run2.release();
 * }
 * 
 * public void second(Runnable printSecond) throws InterruptedException {
 * run2.acquire();
 * // printSecond.run() outputs "second". Do not change or remove this line.
 * printSecond.run();
 * run3.release();
 * }
 * 
 * public void third(Runnable printThird) throws InterruptedException {
 * run3.acquire();
 * // printThird.run() outputs "third". Do not change or remove this line.
 * printThird.run();
 * }
 */