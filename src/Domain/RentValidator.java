package Domain;

public class RentValidator {
    public void validate(Rent rent) {
        if (rent.getDaynr() <= 0) {
            throw new RuntimeException("The number of Days must be at least 1.");
        }
    }
}
