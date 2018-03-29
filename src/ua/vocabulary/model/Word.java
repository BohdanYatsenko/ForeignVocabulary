package ua.vocabulary.model;

public class Word {
    private String learn;
    private String know;

    Word() {
        super();
    }

    Word(String learn, String know) {
        this.learn = learn;
        this.know = know;
    }

    @Override
    public String toString() {
        return "Word{" + "learn='" + learn + '\'' + ", know='" + know + '\''
                + '}';
    }

    public String getLearn() {
        return learn;
    }

    public void setLearn(String learn) {
        this.learn = learn;
    }

    public String getKnow() {
        return know;
    }

    public void setKnow(String know) {
        this.know = know;
    }
}
