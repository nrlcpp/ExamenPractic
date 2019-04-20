package Domain;

import java.util.List;

public class Rent extends Entity {
    private static final String carID = String.valueOf(0);
    private String id;
    private String carId;
    private int Daynr;
    private double coverdKm;

    public Rent(String id, String carId, int Daynr, double coverdKm) {
        super(id);
        this.id = id;
        this.carId = carId;
        this.Daynr = Daynr;
        this.coverdKm = coverdKm;
    }

    public Rent() {
        super(carID);
    }

    public String getId() {
        return id;
    }

    @Override
    public List<String> getAllFields() {
        return null;
    }

    @Override
    public double CurrentKm() {
        return 0;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public int getDaynr() {
        return Daynr;
    }

    public void setDaynr(int daynr) {
        this.Daynr = daynr;
    }

    public double getCoverdKm() {
        return coverdKm;
    }

    public void setCoverdKm(double coverdKm) {
        this.coverdKm = coverdKm;
    }
}
