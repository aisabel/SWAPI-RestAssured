package deserializationWithPojos;

import java.util.List;

public class Species {
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

    public List<SpeciesResults> getResults() {
        return results;
    }

    public void setResults(List<SpeciesResults> results) {
        this.results = results;
    }

    private String count;
    private String next;
    private String previous;
    private List<SpeciesResults> results;
}
