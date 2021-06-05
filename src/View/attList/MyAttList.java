package View.attList;

import View.btest.MyButtonsController;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyAttList  extends AnchorPane {
   // List<String> myAttributesList;

    public ListView attlist;
    public Button attXml;
    public StringProperty attXmlpath;


    public MyAttList() {
        super();
        FXMLLoader fxml = new FXMLLoader();
        try {
            AnchorPane ap = fxml.load(getClass().getResource("AttList.fxml").openStream());
            MyAttListController MyAcontroller = fxml.getController();
            //myAttributesList = new ArrayList<>();

            this.attlist = MyAcontroller.attList;
            attXml = MyAcontroller.attXml;
            attXmlpath = MyAcontroller.attXmlPath;


            /*myAttributesList.addAll(MyAcontroller.myAList);
            same same :  MyAcontroller.myAList.forEach(a->myAttributesList.add(a));
            */
            this.getChildren().add(ap);

        } catch (IOException e) {e.printStackTrace();}
    }
}
