package com.calendly.calendly.Controller;
import com.calendly.calendly.SceneHandler;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class WelcomePageController {

    @FXML
    private Pane pane;

    @FXML
    private Button continueButton;

    @FXML
    private StackPane stackPane;

    @FXML
    void actionContinueButton(ActionEvent event) {
        //TODO quando premuto, passa alla schermata di creazione dell'account proprietario + animazione
        SceneHandler.getInstance().launchLogin();
    }

    //--------------------------
    private Stage stage;

    public void init(Stage stage) {
        if (stage == null)
            return;
        this.stage = stage;

        configPane();
        configContinueButton();
        configStackPane();
    }

    private void configPane() { }

    private void configStackPane() {
        Platform.runLater(() -> {
            this.setLayoutStackPane();
        });

        pane.layoutBoundsProperty().addListener((observable -> {
            this.setLayoutStackPane();
        }));

        stackPane.setAlignment(Pos.CENTER);
    }

    private void setLayoutStackPane() {
        double width  = stackPane.getWidth();
        double height = stackPane.getHeight();

        double x = pane.getWidth()/2 - width/2;
        double y = pane.getHeight()/2 - height/2;

        stackPane.resizeRelocate(x, y, width, height);
    }


    private void configContinueButton() {
        continueButton.prefWidthProperty().bind(stackPane.widthProperty().divide(3).multiply(2.5));
        continueButton.prefHeightProperty().bind(stackPane.heightProperty().divide(5).multiply(0.3));
    }



}
