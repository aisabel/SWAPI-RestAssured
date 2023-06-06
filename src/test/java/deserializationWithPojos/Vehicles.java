package deserializationWithPojos;

import java.util.List;

public class Vehicles {

    private String count;
    private String next;
    private String previous;



    private List<VehiclesResults> results;
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

    public List<VehiclesResults> getResults() {
        return results;
    }

    public void setResults(List<VehiclesResults> results) {
        this.results = results;
    }


}
