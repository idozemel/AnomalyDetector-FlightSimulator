package View.attributesList;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MyAttList  extends AnchorPane {
   // List<String> myAttributesList;

    //public ListView attlist;
    public Button attXml;
    public StringProperty attXmlpath;
    public ObservableList<String> list;
    public MyAttListController MyAcontroller;


    public MyAttList() {
        super();
        FXMLLoader fxml = new FXMLLoader();
        list = FXCollections.observableArrayList();
        try {
            AnchorPane ap = fxml.load(getClass().getResource("AttList.fxml").openStream());
            MyAcontroller = fxml.getController();
            //myAttributesList = new ArrayList<>();

           // this.attlist = MyAcontroller.attList;
            attXml = MyAcontroller.attXml;
            attXmlpath = MyAcontroller.attXmlPath;
            list = MyAcontroller.list;


            /*myAttributesList.addAll(MyAcontroller.myAList);
            same same :  MyAcontroller.myAList.forEach(a->myAttributesList.add(a));
            */
            this.getChildren().add(ap);

        } catch (IOException e) {e.printStackTrace();}
    }
}
