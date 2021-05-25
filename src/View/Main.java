package View;

import Model.myDecoder;
import com.sun.glass.ui.View;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println("1");
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        System.out.println("2");
        primaryStage.setTitle("Hello World");
        System.out.println("3");
        primaryStage.setScene(new Scene(root, 1000, 600));
        System.out.println("4");

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
