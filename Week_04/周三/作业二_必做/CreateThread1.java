import java.util.concurrent.*;

/**
 * 通过线程池提交callable
 */
public class CreateThread1 {
    public static void main(String[] args) {
        System.out.println("启动主线程");
        // callable
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return add(1, 1);
            }
        };

        //1、线程池 submit Callable
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        System.out.println("启动子线程");
        Future<Integer> future = executorService.submit(callable);
        try {
            int result = future.get();
            System.out.println("退出子线程，返回值：" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
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
