package View.attList;

import View.btest.MyButtonsController;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyAttList  extends AnchorPane {
    List<String> myAttributesList;

    public MyAttList() {
        super();
        FXMLLoader fxml = new FXMLLoader();
        try {
            AnchorPane ap = fxml.load(getClass().getResource("AttList.fxml").openStream());
            MyAttListController MyAcontroller = fxml.getController();
            myAttributesList = new ArrayList<>();

            myAttributesList.addAll(MyAcontroller.myAList);
            
          // same same :  MyAcontroller.myAList.forEach(a->myAttributesList.add(a));


            /*
            speed=new SimpleDoubleProperty();
            timeSlider=new SimpleDoubleProperty();
            path=new SimpleStringProperty();
            speed.setValue(Double.parseDouble(MyBcontroller.speed.getText()));
            timeSlider.setValue(MyBcontroller.timeSlider.getValue());
            path.setValue(MyBcontroller.path.getValue());
            */
            this.getChildren().add(ap);

        } catch (IOException e) {e.printStackTrace();}
    }
}
