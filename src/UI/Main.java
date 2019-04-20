package UI;

import Domain.Rent;
import Domain.RentValidator;
import Repository.RentRepository;
import Service.RentService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main {
    public static void main(String[] args) {

        RentValidator rentValidator = new RentValidator();

        RentRepository rentRepository = new RentRepository(rentValidator);

        RentService facturaService = new RentService(rentRepository);

        Console console = new Console(facturaService);
        console.run();
    }


}