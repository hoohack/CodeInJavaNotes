package chapter18;

public class ClientLogger implements ClientListener {

    @ClientAdded
    public void clientAdded(ClientEvent event) {
        System.out.println(event.getIp() + " added...");
    }

    @ClientRemoved
    public void clientRemoved(ClientEvent event) {
        System.out.println(event.getIp() + " removed...");
    }
}
