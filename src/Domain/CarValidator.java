package Domain;

public class CarValidator {

    public void validate(Car car) {
        if (car.getId() == null) {
            throw new RuntimeException("The car doesn't exist.");
        }
    }
}

