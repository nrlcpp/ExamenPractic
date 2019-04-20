package UI;

import Domain.Car;
import Service.CarService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.awt.event.ActionEvent;

public class CarController {
    private CarService carService;

    public void setService(CarService carService) {
        this.carService = carService;
    }

    private ObservableList<Car> cars = FXCollections.observableArrayList();

    @FXML
    private void initialize() {

        Platform.runLater(() -> {
            cars.addAll(carService.getAll());
            tableViewCars.setItems(cars);
        });
    }

    public void btnAddCar(ActionEvent actionEvent) {
        try {
            Integer id = Integer.parseInt(txtCarId.getText());
            String model = txtCarModel.getText();
            Integer baseKm = Integer.parseInt(txtCarKilometrajAchizitie.getText());
            double rentPrice = Double.parseDouble(txtCarPrice.getText());

            carService.add(id, model, baseKm, rentPrice);

            cars.clear();
            cars.addAll(carService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }


    public void btnCarUndoClick(ActionEvent actionEvent) {
        carService.undo();
        cars.clear();
        cars.addAll(carService.getAll());
    }

    public void btnCarRedoClick(ActionEvent actionEvent) {
        carService.redo();
        cars.clear();
        cars.addAll(carService.getAll());
    }

}
}
