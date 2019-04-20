package Service;

import Domain.Car;
import Domain.CarValidator;
import Domain.Rent;

import java.util.List;

public class CarService {

        private sample.Repository.IRepository<Rent> repository;

        /**
         * Constructs a service.
         * @param repository the backing repository.
         */
        public CarService(sample.Repository.IRepository<Rent> repository) {
            this.repository = repository;
        }

        /**
         * Adds an invoice with the given fields.
         * @param id the id - must be unique.
         * @param model the description
         * @param kilometrajAchizitie
         * @param price the price for rent per day
         */
        public void add(String id, String model, double kilometrajAchizitie, double price) {
            Rent car = new Rent(id, model, (int) kilometrajAchizitie, price);
            repository.upsert(car);
        }

        /**
         * Gets the sum of all invoices in a given day.
         * @param id the given id.
         * @return the currentKm.
         */
        public double getCurrentKm(String id) {
            CarValidator validator = new CarValidator();
            Car dummy = new Car(null, null, 0);
            validator.validate(dummy);

            double currentKm = 0;
            for (Rent rent : repository.getAll()) {
                if (rent.getId().equals(id)) {
                    currentKm += rent.CurrentKm();
                }
            }
            return currentKm;
        }

        /**
         * Gets a list of all invoices.
         * @return a list of all invoices.
         */
        public List<Rent> getAll() {
            return repository.getAll();
        }
    }


