package test;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import test.Commands.Command;
import test.Commands.DefaultIO;


public class CLI {

    ArrayList<Command> commands;
    DefaultIO dio;
    Commands c;

    public CLI(DefaultIO dio) {
        this.dio = dio;
        c = new Commands(dio);
        commands = new ArrayList<>();


        // example: commands.add(c.new ExampleCommand());
        // implement
    }


    public void start()  {
        // implement

        while (true) {

            c.commandStart(); //Prints the menu for the client

            float val = this.dio.readVal();

            switch ((int) val) {

                case 1 : {

                    Command train = c.new command_train();
                    try {
                        train.execute();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    commands.add(train);

                    Command test = c.new command_test();
                    try {
                        test.execute();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    commands.add(test);
                    break;
                }

                case 2 : {

                    Command tresh = c.new command2();
                    try {
                        tresh.execute();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    commands.add(tresh);
                    break;
                }

                case 3 : {

                    Command anomalies = c.new command3();
                    try {
                        anomalies.execute();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    commands.add(anomalies);
                    break;
                }

                case 4: {
                    Command corfeatures = c.new command4();
                    try {
                        corfeatures.execute();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    commands.add(corfeatures);
                    break;
                }

                case 5 : {
                    Command analyze = c.new command5();
                    try {
                        analyze.execute();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    commands.add(analyze);
                    break;
                }

                case 6 : {
                    return;
                }
            }
        }
    }

    // ---------------------------------------------------------------------------------------------

















}
