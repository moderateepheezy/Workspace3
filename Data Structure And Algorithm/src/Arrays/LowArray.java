package Arrays;

public class LowArray {
	private double[] a;
	
	public LowArray(int size){
		a = new double[size];
	}
	
	public void setElem(int index, double value){
		a[index] = value;
	}
	
	public double getElem(int index){
		return a[index];
	}
}
