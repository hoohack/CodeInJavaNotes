package chapter18;

public interface ClientListener {

    void clientAdded(ClientEvent event);
    void clientRemoved(ClientEvent event);

}
