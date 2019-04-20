package UI;

import Domain.Rent;
import Service.RentService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;



public class RentController {

    private RentService RentService;


    public void setService(RentService rentService) {
        this.rentService = rentService;
    }

    private ObservableList<Rent> rents = FXCollections.observableArrayList();

    @FXML
    private void initialize() {

        Platform.runLater(() -> {
            rents.addAll(rentService.getAll());
            tableViewRents.setItems(rents);
        });
    }


    public void AddRent(ActionEvent actionEvent) {
        try {
            Integer id = Integer.parseInt(txtRentId.getText());
            Integer carID = Integer.parseInt(txtRentCarId.getText());
            Integer rentalDays = Integer.parseInt(txtRentDayNr.getText());
            Integer usedKm = Integer.parseInt(txtRentUsedKm.getText());

            rentsService.add(id, carID, rentalDays,usedKm);

            rents.clear();
            rents.addAll(rentsService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }