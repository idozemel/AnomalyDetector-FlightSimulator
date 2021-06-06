package View.panel;


import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class panel extends AnchorPane {


    public panelController pncontroller;

   public panel(){

           super();
           FXMLLoader fxml = new FXMLLoader();
       AnchorPane ap=null;
           try {
               ap = fxml.load(getClass().getResource("Buttons.fxml").openStream());


           } catch (IOException e) {e.printStackTrace();}

           if(ap!=null){
               pncontroller = fxml.getController();
               this.getChildren().add(ap);
           }else {
               pncontroller=null;
           }

   }



}
