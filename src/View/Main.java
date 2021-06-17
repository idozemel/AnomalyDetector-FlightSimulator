package View;

import Model.Model;
import Model.myDecoder;
import ViewModel.ViewModel;
import com.sun.glass.ui.View;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


        FXMLLoader fxml = new FXMLLoader();
        AnchorPane root = fxml.load(getClass().getResource("sample.fxml").openStream());
        primaryStage.setTitle("GUI");
        primaryStage.setScene(new Scene(root, 900, 600));
        ViewController vc =fxml.getController();
        Model model = new Model(new SimpleIntegerProperty(0));
        // new SimpleIntegerProperty(0)
        ViewModel vm = new ViewModel(model);
        vc.init(vm);

        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
