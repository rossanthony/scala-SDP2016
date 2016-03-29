package observerpattern;

import observer.Commentary;

import java.util.Observable;

public class CommentaryObjectObservable extends Observable implements Commentary {
    private final String subjectDetails;
    private String desc;

    public CommentaryObjectObservable(String subjectDetails) {
        this.subjectDetails = subjectDetails;
    }

    @Override
    public void setDesc(String desc) {
        this.desc = desc;
        setChanged();
        notifyObservers(desc);
    }

    public String subjectDetails() {
        return subjectDetails;
    }
}
