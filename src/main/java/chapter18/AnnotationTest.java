package chapter18;

/**
 * 自定义注解
 */
public class AnnotationTest {

    public static void main(String[] args) throws Exception {

        ClientQueue queue = new ClientQueue();
        ClientLogger logger = new ClientLogger();

        queue.addClientListener(logger);

        Client client1 = new Client("127.0.0.1", "abc");
        Client client2 = new Client("127.0.0.2", "mcjin");
        queue.add(client1);
        queue.add(client2);

        queue.remove(client1);

        // 模拟编译器
        final ParseAnnotation ps = new ParseAnnotation();
        ps.parseMethod(ClientLogger.class);
    }

}
