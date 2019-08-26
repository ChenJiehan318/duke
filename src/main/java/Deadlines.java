public class Deadlines extends Task {

    public Deadlines(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "D | " + this.getStatusNumber() + " | " + this.description + " | " + this.time;
    }
}
