package algorithms;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static algorithms.SimpleAnomalyDetector.*;


public class Commands {

    // Default IO interface
    public interface DefaultIO {
        public String readText();

        public void write(String text);

        public float readVal();

        public void write(float val);

        // you may add default methods here
    }

    // the default IO to be used in all commands
    DefaultIO dio;

    public Commands(DefaultIO dio) {
        this.dio = dio;
    }

    // you may add other helper classes here


    // the shared state of all commands
    private class SharedState {

        // implement here whatever you need
        private TimeSeries ts_train;
        private TimeSeries ts_test;
        private SimpleAnomalyDetector ad = new SimpleAnomalyDetector();
        private List<AnomalyReport> arlAR = new ArrayList<>();
        private float FP;
        private float TP;
        private float N;


        public TimeSeries getTs_train() {
            return ts_train;
        }

        public void setTs_train(TimeSeries ts_train) {
            this.ts_train = ts_train;
        }

        public TimeSeries getTs_test() {
            return ts_test;
        }

        public void setTs_test(TimeSeries ts_test) {
            this.ts_test = ts_test;
        }
    }

    private SharedState sharedState = new SharedState();


    // Command abstract class
    public abstract static class Command {

        protected String description;

        public Command(String description) {
            this.description = description;
        }

        public abstract void execute() throws IOException;
    }

    // Command class for example:
    public class ExampleCommand extends Command {

        public ExampleCommand() {
            super("this is an example of command");
        }

        @Override
        public void execute() {
            dio.write(description);
        }
    }


    // --------------------------------------- menu ---------------------------------------------------------

    public void commandStart() { //Prints the menu for the client
        dio.write(
                "Welcome to the Anomaly Detection Server.\n" +
                        "Please choose an option:\n" +
                        "1. upload a time series csv file\n" +
                        "2. algorithm settings\n" +
                        "3. detect anomalies\n" +
                        "4. display results\n" +
                        "5. upload anomalies and analyze results\n" +
                        "6. exit\n"
        );
    }


    // --------------------------------------- 1 ---------------------------------------------------------

    // *****************   train   *****************

    public class command_train extends Command {

        public command_train() {
            super("upload csv train files");
        }

        TimeSeries ts_train;

        @Override
        public void execute() throws IOException {
            dio.write("Please upload your local train CSV file.\n");
            BufferedWriter pw = new BufferedWriter(new FileWriter("anomalyTrain.csv"));
            String s = dio.readText();
            int i = 0;
            while (true) {
                s = dio.readText();
                if (s.equals("done")) {
                    break;
                }
                pw.write(s + "\n");
                //pw.print("\n");
            }
            pw.close();
            ts_train = new TimeSeries("anomalyTrain.csv");
            //new SharedState().setTs_train(ts_train);
            sharedState.setTs_train(ts_train);

            dio.write("Upload complete.\n");
        }

    }

    // *****************   test   *****************

    public class command_test extends Command {

        public command_test() {
            super("upload csv test files");
        }

        TimeSeries ts_test;


        @Override
        public void execute() throws IOException {
            dio.write("Please upload your local test CSV file.\n");

            BufferedWriter pw = new BufferedWriter(new FileWriter("anomalyTest.csv"));
            String s;
            while (true) {
                s = dio.readText();
                if (s.equals("done")) {
                    break;
                }
                sharedState.N++;
                pw.write(s + "\n");
            }
            pw.close();
            ts_test = new TimeSeries("anomalyTest.csv");
            sharedState.setTs_test(ts_test);


            dio.write("Upload complete.\n");
        }
    }

    // ------------------------------------- 2 -----------------------------------------------------------

    public class command2 extends Command {

        public command2() {
            super("algorithm settings");
        }

        @Override
        public void execute() throws IOException {

            dio.write("The current correlation threshold is " + corOffset + "\n");

            boolean flag = false;

            while (!flag) {
                dio.write("Type a new threshold\n");
                float newTH = dio.readVal();

                if ((newTH >= 0) && (newTH <= 1)) {
                    corOffset = newTH;
                    flag = true;
                } else {
                    dio.write("Please choose a value between 0 and 1.\n");
                }
            }
        }
    }


    // ------------------------------------- 3 -----------------------------------------------------------

    public class command3 extends Command {

        public command3() {
            super("detect anomalies");
        }

        @Override
        public void execute() throws IOException {
            sharedState.ad.learnNormal(sharedState.getTs_train());
            sharedState.arlAR = sharedState.ad.detect(sharedState.getTs_test());

            dio.write("anomaly detection complete.\n");
        }
    }


    // ------------------------------------- 4 -----------------------------------------------------------

    public class command4 extends Command {

        public command4() {
            super("display results");
        }

        @Override
        public void execute() throws IOException {
            sharedState.arlAR = sharedState.ad.detect(sharedState.getTs_test());

            for (AnomalyReport ar : sharedState.arlAR) {
                dio.write(ar.timeStep + "\t" + " " + ar.description + "\n");
            }
            dio.write("Done\n");
        }

    }


    // ------------------------------------- 5 -----------------------------------------------------------

    float afterDot(float num) {

        float x = num * 1000;
        int y = (int) x;
        x = y;

        return (x / 1000);

    }

    public class command5 extends Command {

        public command5() {
            super("analyze results");
        }


        @Override
        public void execute() throws IOException {
            float P = 0;
            float N = sharedState.N - 1;
            sharedState.FP = 0;
            sharedState.TP = 0;
            float B = 0;
            float count = 0;
            List<String> listT = new ArrayList<>();

            dio.write("Please upload your local anomalies file.\n" +
                    "Upload complete.\n");
            while (true) {

                String s = dio.readText();
                if (s.equals("")) {
                    s = dio.readText();
                }
                if (s.equals("done")) {
                    break;
                }
                String[] arr = s.split(",");
                float Minus = Integer.parseInt(arr[1]) - Integer.parseInt(arr[0]) + 1;

                N = N - Minus;

                for (AnomalyReport ar : sharedState.arlAR) {
                    if ((ar.timeStep >= Integer.parseInt(arr[0])) && (ar.timeStep <= Integer.parseInt(arr[1]))) {

                        if ((B + 1) == ar.timeStep) {
                            B = ar.timeStep;
                            continue;

                        } else {
                            if (listT.contains(ar.description)) {
                                listT.remove(ar.description);
                                sharedState.FP--;
                            } else {
                                sharedState.TP++;
                                B = ar.timeStep;
                                listT.add(ar.description);
                            }
                        }
                    } else {
                        if (listT.contains(ar.description)) {
                            continue;
                        } else {
                            if ((count + 1) == ar.timeStep) {
                                count =  ar.timeStep;
                                        continue;
                            }
                            else
                                {
                                    sharedState.FP++;
                                    listT.add(ar.description);
                                    count = ar.timeStep;
                                }
                            }
                        }
                    }
                    P++;
                }
                float TrueP = sharedState.TP / P;
                TrueP = afterDot(TrueP);

                float FalseP = sharedState.FP / N;
                FalseP = afterDot(FalseP);

                dio.write("True Positive Rate: " + TrueP + "\n");
                dio.write("False Positive Rate: " + FalseP + "\n");

            }
        }


    }


