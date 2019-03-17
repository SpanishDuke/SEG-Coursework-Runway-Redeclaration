package Interface;

import Data.Obstacle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddObstacleOnRunwayController
{
    InterfaceController controller;
    @FXML
    private Button addRunwayButton;
    @FXML
    private TextField distToCenter;
    @FXML
    private TextField distToLeftT;
    @FXML
    private TextField distToRightT;

    public void handleCloseButtonAction(ActionEvent event)
    {
        if(!distToCenter.getText().trim().isEmpty() && !distToLeftT.getText().trim().isEmpty() && !distToRightT.getText().trim().isEmpty())
        {
            controller.getObstacleFromComboBox().setDistToCentreline((Integer.parseInt(distToCenter.getText().trim())));
            controller.getObstacleFromComboBox().setDistToThreshold1((Integer.parseInt(distToLeftT.getText().trim())));
            controller.getObstacleFromComboBox().setDistToThreshold2((Integer.parseInt(distToRightT.getText().trim())));
            ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
        }
        else
        {
            Alert warningAlert = new Alert(Alert.AlertType.WARNING);
            warningAlert.setContentText("There are spaces left empty. Please try again.");
            warningAlert.showAndWait();
        }
    }

    @FXML
    public void initialize()
    {
        addRunwayButton.setOnAction(this::handleCloseButtonAction);
    }

    public void setController(InterfaceController controller)
    {
        this.controller = controller;
    }
}