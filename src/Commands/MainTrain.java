package Commands;


import Algorithms.zScore;

import java.util.ArrayList;

public class MainTrain {

//	public static float[] getcol(float[][] data , int column ,int line  ){
//
//		float[] newArr=new float[line];
//
//		for (int i=0;i<line;i++){
//			newArr[i]=data[i][column];
//		}
//		return newArr;
//
//	}

	public static void main(String[] args) {


//		float[][] arrr = new float[4][4];
//		int naum=1;
//		for(int i=0 ; i<arrr.length;i++) {
//			for(int j=0 ; j<arrr.length;j++) {
//				arrr[i][j]=naum;
//				System.out.println(arrr[i][j]);
//				naum++;
//			}
//			System.out.println("shura");
//		}
//
//		System.out.println(" --------------------- ");
//		float[] A = getcol(arrr,0,3);
//
//		for(int i=0 ; i<A.length;i++) {
//
//				System.out.println(A[i]);
//		}





		zScore z = new zScore();
		TimeSeries train = new TimeSeries("reg_flight.csv");
		TimeSeries test = new TimeSeries("anomaly_flight.csv");

		z.learnNormal(train);
		ArrayList<AnomalyReport> arr = (ArrayList<AnomalyReport>) z.detect(test);


		for(AnomalyReport a : arr){
			System.out.println(a.description +" "+  a.timeStep);
		}

	}



}
