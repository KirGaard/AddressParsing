package kirgaard.addressparsing.Controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
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
    @FXML private Label error;
    @FXML private TextField inputField;
    @FXML private ComboBox autofill;

    ObservableList autofillItems;

    @FXML
    public void initialize(){
        System.out.println("Main scene is initialized");
        autofillItems = autofill.getItems();
    }

    @FXML
    public void onAddressUpdated(){
        Address address;
        try {
            address = Address.parse(inputField.getText());
        } catch (NoMatchFoundException e) {
            error.setText("No match found");
            return;
        }

        if (address == null){
            error.setText("No match found");
            return;
        }

        setLabels(address);
        updateAutofill(address);
    }

    private void setLabels(Address address){
        error.setText("");
        street.setText(address.street);
        house.setText(address.house);
        floor.setText(address.floor);
        door.setText(address.side);
        additionalCity.setText(address.additionalCity);
        postcode.setText(address.postcode);
        city.setText(address.city);
    }
    private void updateAutofill(Address address){

    }
}
