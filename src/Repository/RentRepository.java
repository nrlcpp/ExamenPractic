package Repository;

import Domain.Rent;
import Domain.RentValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RentRepository {
    private Map<String, Rent> storage = new HashMap<>();
    private RentValidator validator;

    public RentRepository(RentValidator validator) {
        this.validator = validator;
    }

    public Rent findById(String id) {
        return storage.get(id);
    }

    /**
     * Adds or updates a rent if it already exists.
     * @param rent the rent to add or update
     */
    public void upsert(Rent rent) {
        validator.validate(rent);
        storage.put(rent.getId(), rent);
    }

    /**
     * Removes a cake with a given id.
     * @param id the id.
     * @throws RuntimeException if there is no cake with the given id.
     */
    public void remove(String id) {
        if (!storage.containsKey(id)) {
            throw new RuntimeException("There is no object with the given id to remove.");
        }

        storage.remove(id);
    }

    public List<Rent> getAll() {
        return new ArrayList<>(storage.values());
    }
}
