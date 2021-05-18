package View.joystick;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

public class MyJoystick extends Canvas {
     Canvas joystick;
     double mx,my;

    void moveJoystick (){
    //Aileron X & Elevators Y
        GraphicsContext gc = joystick.getGraphicsContext2D();
        mx = joystick.getWidth()/2;
        my = joystick.getHeight()/2;
        gc.clearRect(0,0,joystick.getWidth(),joystick.getHeight());
    }


}
