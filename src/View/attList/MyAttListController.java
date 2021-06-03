package View.attList;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;


public class MyAttListController{
    @FXML
    ListView<String> attList;
    List<String> myAList;
    public MyAttListController() {

        myAList = new ArrayList<>();
        attList = new ListView<>();
        LoadData();
    }

    public void LoadData(){
        /*
            load the date from XML to the list here.
         */
        String a = "zehava";
        String b = "yona";
        String c = "ido";
        String d = "erez";

        myAList.add(a);
        myAList.add(b);
        myAList.add(c);
        myAList.add(d);

        attList.getItems().addAll(myAList);
    }
}
