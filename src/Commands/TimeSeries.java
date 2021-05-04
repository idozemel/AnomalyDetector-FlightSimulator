package Commands;


// zehava liviyev ~ 322759366

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TimeSeries {

	public String[] name;
	public float[][] data;
	public int Lines_num;
	public int Features_num;


	public float[] Get(float[][] data , int index ){

		float[] newArr=new float[this.getLines_num()];

		for (int i=0;i<data.length;i++){
			newArr[i]=data[i][index];
		}
		return newArr;
	}

	public void addRow(String line){

		if(this.data==null){

			float[][] newData = new float[1][this.getFeatures_num()];

			String[] ll = line.split(",");
			for (int a=0;a<ll.length;a++){
				newData[0][a]=Float.parseFloat(ll[a]);
			}

			this.setLines_num(1);
			this.setData(newData);

		}else {
			int len=this.getLines_num()+1;

			float[][] temp=new float[len][this.getFeatures_num()];

			for (int i=0;i<this.getLines_num();i++){
				for (int j=0; j<this.getFeatures_num();j++){
					temp[i][j]=this.data[i][j];
				}
			}
			String[] ll = line.split(",");
			for (int a=0;a<ll.length;a++){
				temp[len-1][a]=Float.parseFloat(ll[a]);
			}
			this.setLines_num(len);

			this.setData(temp);
		}
	}


	public String[] getName() {
		return name;
	}

	public void setName(String[] name) {

		setLines_num(name.length);

		if(this.name==null){
			String[] naaame =new String[name.length];

			for(int i=0;i<name.length;i++) {
				naaame[i] = name[i];
			}
			this.name=naaame;
		}
		else {
			for (int i = 0; i < name.length; i++) {
				//this.name[i] = name[i];
				this.name[i]=name[i];
			}
		}
	}


	public int getLines_num() {
		return Lines_num;
	}

	public void setLines_num(int lines_num) {
		Lines_num = lines_num;
	}

	public int getFeatures_num() {
		return Features_num;
	}

	public void setFeatures_num(int features_num) {
		Features_num = features_num;
	}

	public float[][] getData() {
		return data;
	}

	public void setData(float[][] data) {
		this.data = data;
	}



	public TimeSeries(String csvFileName) {

		Scanner S = null;
		try {
			S = new Scanner(new FileReader(csvFileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


		int counts = 0;               // the fitchers
		String fi = S.nextLine();
		String[] fit = fi.split(",");
		this.setName(fit);

		this.setFeatures_num(fit.length);


		while (S.hasNextLine()){
			addRow(S.nextLine());
		}
	}


}
