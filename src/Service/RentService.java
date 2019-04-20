package Service;

import Domain.Car;
import Domain.IdException;
import Domain.Rent;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;

public class RentService {
    private Object rentRepository;
    private sample.Repository.IRepository<Rent> bookingRepository;
    private sample.Repository.IRepository<Car> carRepository;

    public RentService(sample.Repository.IRepository<Rent> bookingRepository, sample.Repository.IRepository<Car> carRepository) {
        this.rentRepository = rentRepository;
        this.carRepository = carRepository;
    }


    public void add(String id, String carId, int dayNr, double coverdKm) {

        Car existingCar = carRepository.findById(id);
        if (existingCar == null) {
            throw new IdException("There is no car with the given id!");
        }

        Rent rent = new Rent();
        rentRepository.upsert(id, carId, dayNr, coverdKm);
    }


}
