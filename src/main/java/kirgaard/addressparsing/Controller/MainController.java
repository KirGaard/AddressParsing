package Controller;

import Model.Address;
import Model.Exceptions.NoMatchFoundException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {
    @FXML private Label street;
    @FXML private Label house;
    @FXML private Label floor;
    @FXML private Label door;
    @FXML private Label additionalCity;
    @FXML private Label postcode;
    @FXML private Label city;
    @FXML private TextField inputField;

    @FXML
    public void initialize(){
        System.out.println("Main scene is initialized");
    }

    @FXML
    public void onAddressUpdated(){
        Address address;
        try {
            address = Address.parse(inputField.getText());
        } catch (NoMatchFoundException e) {
            return;
        }

        if (address == null){
            return;
        }

        street.setText(address.street);
        house.setText(address.house);
        floor.setText(address.floor);
        door.setText(address.side);
        additionalCity.setText(address.additionalCity);
        postcode.setText(address.postcode);
        city.setText(address.city);
    }
}
