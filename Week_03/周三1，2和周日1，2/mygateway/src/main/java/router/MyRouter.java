package router;

import java.util.List;
import java.util.Random;

public class MyRouter implements HttpEndpointRouter{
    @Override
    public String route(List<String> endpoints) {
        Random r = new Random();
        return endpoints.get(r.nextInt(endpoints.size()));
    }

    public static void main(String[] args) {
        Random r = new Random();
        System.out.println(r.nextInt(1));
    }
}
