package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class alertBox {
    public static void display(String title, String message){
        // make a window object
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        // get message to show on window
        Label label = new Label();
        label.setText(message);

        //  make a close button
        Button button = new Button("Ok");
        button.setOnAction( e -> window.close());

        // add objects to a layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, button);
        layout.setAlignment(Pos.CENTER);

        // layout properties
        Scene scene = new Scene(layout, 350, 150);
        window.setScene(scene);
        window.showAndWait();
    }
}

