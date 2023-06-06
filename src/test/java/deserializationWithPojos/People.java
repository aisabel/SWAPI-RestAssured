package deserializationWithPojos;

import java.util.List;

public class People {
    private String count;
    private String next;
    private String previous;

    private List<PeopleResults> results;
    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }
    public List<PeopleResults> getResults() {
        return results;
    }
    public void setPeopleResults(List<PeopleResults> peopleResults) {
        this.results = peopleResults;
    }

}
