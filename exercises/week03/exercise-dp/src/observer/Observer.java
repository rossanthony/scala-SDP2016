package observer;

public interface Observer {
    void update(String desc);

    void subscribe();

    void unSubscribe();
}