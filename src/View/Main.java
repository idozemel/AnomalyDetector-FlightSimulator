package View;

import Model.Model;
import Model.myDecoder;
import ViewModel.ViewModel;
import com.sun.webkit.Timer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//Noder neder
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Model m = new Model();
        ViewModel vm = new ViewModel(m);
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Erez Beizim Sheli");
        primaryStage.setScene(new Scene(root, 640, 400));
        primaryStage.show(); //Beizim sheli
    }


    public static void main(String[] args) {
      //myDecoder d = new myDecoder();
       //d.ShoterDecoder();

        launch(args);
    }
}
