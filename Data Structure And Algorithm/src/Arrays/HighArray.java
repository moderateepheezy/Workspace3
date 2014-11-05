package Arrays;

public class HighArray {
	private double a[];
	private int nElems;
	
	public HighArray(int max){
		a = new double[max];
		nElems = 0;
	}
	
	public boolean find(double searchKey){
		int j;
		for(j = 0; j < nElems; j++){
			if(a[j] == searchKey){
				break;
			}
		}
		if(j == nElems){
			return false;
		}
		else{
			return true;
		}
	}
	/*public int  find(double searchKey){
	int lowerBound = 0;
	int upperBound = nElems-1;
	int curIn;
	while(true)
	{
	curIn = (lowerBound + upperBound) /2;
	if(a[curIn]==searchKey)
	return curIn;
	//
	else if(lowerBound > upperBound)
	return nElems;
	//
	else
	//
	{
	if(a[curIn] < searchKey)
	lowerBound = curIn + 1; //
	else
	upperBound = curIn - 1; //
	} // end else divide range
	} // end while
	}*/
	
	public void insert(double value){
		a[nElems] = value;
		nElems++;
	}
	
	public boolean delete(double value){
		int j;
		for(j = 0; j < nElems; j++){
			if(a[j] == value){
				break;
			}
		}
		if(j == nElems){
			return false;
		}
		else{
			for(int k = j; k < nElems; k++){
				a[k] = a[k + 1];
				nElems--;
			}
				return true;
		}
	}
	
	public void display(){
		for(int j = 0; j < nElems; j++){
			System.out.println(a[j]);
		}
	}
}
