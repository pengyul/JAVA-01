import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader{
    public static void main(String[] args) {
        try {
            Class clazz = new MyClassLoader().findClass("Hello");
            if(clazz != null) {
                Object object = clazz.newInstance();
                Method method = clazz.getMethod("hello");
                method.invoke(object);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Path path = Paths.get("Week_01/WednesdayQuestion2/Hello.xlass");
        try {
            byte[] data = Files.readAllBytes(path); //获取文件所有字节
            data = convert(data);
            return this.defineClass("Hello", data, 0, data.length);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 字节数组每个字节取反转换
     * @param bytes 原数组
     * @return 取反数组
     */
    private byte[] convert(byte[] bytes){
        for (int i =0; i < bytes.length; i++){
            bytes[i] = (byte)~bytes[i];
        }
        return bytes;
    }
}
