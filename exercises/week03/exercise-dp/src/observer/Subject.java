package observer;

public interface Subject {
    void subscribeObserver(Observer observer);

    void unSubscribeObserver(Observer observer);

    void notifyObservers();

    String subjectDetails();
}
