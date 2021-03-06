package Repository;

import Domain.Car;
import Domain.CarValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarRepository {
    private Map<String, Car> storage = new HashMap<>();
    private CarValidator validator;

    public CarRepository(CarValidator validator) {
        this.validator = validator;
    }

    public Car findById(String id) {
        return storage.get(id);
    }

    /**
     * Adds or updates a cake if it already exists.
     * @param car the cake to add or update.
     */
    public void upsert(Car car) {
        validator.validate(car);
        storage.put(car.getId(), car);
    }

    /**
     * Removes a cake with a given id.
     * @param id the id.
     * @throws RuntimeException if there is no cake with the given id.
     */
    public void remove(String id) {
        if (!storage.containsKey(id)) {
            throw new RuntimeException("There is no car with the given id to remove.");
        }

        storage.remove(id);
    }

    public List<Car> getAll() {
        return new ArrayList<>(storage.values());
    }
}

