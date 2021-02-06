import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

/**
 * 利用CountDownLatch
 */
public class CreateThread5 implements Runnable{
    private int result;
    private CountDownLatch countDownLatch;
    public CreateThread5(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        result = add(1,1);
        countDownLatch.countDown();
    }

    private static int add(int i, int j){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i + j;
    }

    public static void main(String[] args) {
        System.out.println("开启主线程");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        CreateThread5 t = new CreateThread5(countDownLatch);
        System.out.println("开启子线程");
        CompletableFuture<Void> completableFuture =
                CompletableFuture.runAsync(t);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("子线程退出，返回值：" + t.result);
        System.out.println("主线程退出");
    }
}
