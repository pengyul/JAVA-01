import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 通过new一个Thread，传入一个FutureTask对象
 */
public class CreateThread2 {
    public static void main(String[] args) {
        System.out.println("启动主线程");
        // callable
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return add(1, 1);
            }
        };

        // futureTask
        FutureTask<Integer> futureTask = new FutureTask<>(callable);

        System.out.println("启动子线程");
        new Thread(futureTask).start();
        try {
            int result = futureTask.get();
            System.out.println("退出子线程，返回值：" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("退出主线程");
    }

    private static int add(int i, int j){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i + j;
    }

}
