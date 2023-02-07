package kirgaard.addressparsing.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import kirgaard.addressparsing.Model.Address;
import kirgaard.addressparsing.Model.Exceptions.NoMatchFoundException;

public class MainController {
    @FXML private Label street;
    @FXML private Label house;
    @FXML private Label floor;
    @FXML private Label door;
    @FXML private Label additionalCity;
    @FXML private Label postcode;
    @FXML private Label city;
    @FXML private TextField inputField;
    @FXML private Label error;

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
            error.setText("No match found");
            return;
        }

        error.setText("");
        street.setText(address.street);
        house.setText(address.house);
        floor.setText(address.floor);
        door.setText(address.side);
        additionalCity.setText(address.additionalCity);
        postcode.setText(address.postcode);
        city.setText(address.city);
    }
}
