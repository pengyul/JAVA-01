/**
 * 通过Thread join方法阻塞主线程
 */
public class CreateThread4 implements Runnable{
    private int result;
    @Override
    public void run() {
        result = add(1,1);
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
        CreateThread4 t = new CreateThread4();
        Thread thread = new Thread(t);
        System.out.println("开启子线程");
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("退出子线程，返回值：" + t.result);
        System.out.println("退出主线程");
    }
}
