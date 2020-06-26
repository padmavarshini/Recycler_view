package info.androidhive.recyclerview;

/**
 * Created by Lincoln on 15/01/16.
 */
public class Wedding {
    private String Person1, Person2, date;

    public Wedding() {
    }

    public Wedding(String Person1, String Person2, String date) {
        this.Person1 = Person1;
        this.Person2 = Person2;
        this.date = date;
    }

    public String getPerson1() {
        return Person1;
    }

    public void setPerson1(String Person1) {
        this.Person1 = Person1;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPerson2() {
        return Person2;
    }

    public void setPerson2(String Person2) {
        this.Person2 = Person2;
    }



}

