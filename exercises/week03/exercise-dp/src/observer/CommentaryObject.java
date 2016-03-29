package observer;

import java.util.List;

public class CommentaryObject implements Subject {

    public CommentaryObject(List<Observer> subscribers, String title) {
    }

    @Override
    public void subscribeObserver(Observer observer) {

    }

    @Override
    public void unSubscribeObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {

    }

    @Override
    public String subjectDetails() {
        return null;
    }
}
