package com.calendly.calendly.View;

import com.calendly.calendly.Main;
import com.calendly.calendly.Model.Dipendente;
import com.calendly.calendly.Model.Servizi;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.LinkedList;
import java.util.Objects;

public class Card extends AnchorPane {
    private Integer identifier;
    private VBox parent;
    private Object obj;

    private String IMAGE_USER = "img/user.png";
    private String IMAGE_SERVIZI = "";


    public Card(Object obj, VBox parent) {
        super();
        this.maxWidth(100);
        this.prefWidth(100);

        this.parent = parent;
        this.obj = obj;

        setLayout();
    }



    private void setLayout() {

        //Le variabili da impostare nell'if-elseif-else per riconoscere la classe
        String identifier = null;
        String imagePath = null;
        LinkedList<Label> labelsKey = new LinkedList<>();
        LinkedList<Label> labelsValue = new LinkedList<>();

        if (obj.getClass().equals(Dipendente.class)) {
            imagePath = IMAGE_USER ;
            Dipendente dip = (Dipendente) obj;
            identifier = dip.getId();

            Label primaRiga = new Label("ID:");
            Label secondaRiga = new Label("Dipendente:");
            Label terzaRiga = new Label("Ruolo:");
            Label quartaRiga = new Label("Salario:");

            labelsKey.add(primaRiga);       labelsValue.add(new Label(dip.getId()));
            labelsKey.add(secondaRiga);     labelsValue.add(new Label(dip.getName() + " " + dip.getLastName()));
            labelsKey.add(terzaRiga);       labelsValue.add(new Label(dip.getRole()));
            labelsKey.add(quartaRiga);      labelsValue.add(new Label(dip.getSalary()));

        } else if (obj.getClass().equals(Servizi.class)) {
            System.out.println("ricordati di impostarlo");
            return;







        } else {
            System.out.println("Imposta bene il riconoscimento degli oggetti in Dipendenti.setLayout()");
            return;
        }




        // ------------------- NON TOCCARE SOTTO --------------------

        CustomButton edit = new CustomButton("Modifica","img/edit.png", "Modifica i dati della scheda selezionata");
        edit.getStyleClass().add("thirdButton");

        String finalIdentifier = identifier;
        edit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println(finalIdentifier + "  " + Integer.parseInt(finalIdentifier));
                Dialog.getInstance().requestDialog(
                        Dialog.from.DIPENDENTI,
                        Dialog.actions.MODIFICA,
                        Integer.parseInt(finalIdentifier),
                        (AnchorPane) parent.getParent().getParent().getParent().getParent() );
            }
        });


        ImageView imageView = new ImageView();
        try {
            Image image = new Image(Objects.requireNonNull(Main.class.getResourceAsStream(imagePath)));
            imageView.setImage(image);
            imageView.setFitWidth(50);
            imageView.setFitWidth(50);
            imageView.setPreserveRatio(true);
        } catch (Exception e) {
            System.out.println(e);
        }

        VBox vboxKeys = new VBox(1);
        VBox vboxValues = new VBox(1);
        LinkedList[] groups = new LinkedList[]{labelsKey, labelsValue};


        HBox hBox = new HBox(imageView, vboxKeys, vboxValues);
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setPadding(new Insets(0, 0, 0, 5));


        for (LinkedList g : groups)
            for (Object l : g) {
                Label label = (Label) l;
                label.setFont(new Font(15));
                label.setWrapText(false);
                label.maxWidthProperty().bind(parent.widthProperty().divide(4.5));
                label.getStyleClass().add("text-ellipsis");
                label.setTextOverrun(OverrunStyle.ELLIPSIS);

                if (groups[0].equals(g))
                    vboxKeys.getChildren().add(label);
                else
                    vboxValues.getChildren().add(label);
                }

        vboxKeys.setFillWidth(true);
        vboxValues.setFillWidth(true);

        vboxKeys.setPadding(new Insets(15, 5, 15, 15));
        vboxValues.setPadding(new Insets(15, 15, 15, 5));

        
        this.getChildren().addAll(edit, hBox);
        AnchorPane.setRightAnchor(edit, hBox.getWidth()+1);
        AnchorPane.setTopAnchor(edit, 1.0);
        edit.toFront();
        this.prefWidthProperty().bind(parent.widthProperty().divide(2).subtract(15));

        this.getStyleClass().add("card-info");
    }


}
