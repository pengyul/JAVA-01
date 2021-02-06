import java.util.concurrent.*;

/**
 * 通过线程池提交一个FutureTask
 */
public class CreateThread3 {
    public static void main(String[] args) {
        System.out.println("开启主线程");
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return add(1, 1);
            }
        };

        // futureTask
        FutureTask<Integer> futureTask = new FutureTask<>(callable);

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        System.out.println("开启子线程");
        executorService.submit(futureTask);
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
