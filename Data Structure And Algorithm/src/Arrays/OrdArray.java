package Arrays;

public class OrdArray {
	private double[] a;
	private int nElems;
	
	public OrdArray(int max){
		nElems = 0;
	}
	
	public int size(){
		return nElems;
	}
	
	public int find(double searchKey){
		int lowerBound = 0;
		int higherBound = nElems - 1;
		int curIn;
		
		while(true){
			curIn = (lowerBound + higherBound) /2;
			if(a[curIn] ==  searchKey){
				return curIn; // found it
			}
			else if(lowerBound > higherBound){
				return nElems;//can't find it
			}
			else{// divide range
				if(a[curIn] <  searchKey){
					lowerBound = curIn + 1; //it's in the upper
				}
				else{
					higherBound = curIn - 1; //it's in the lower half
				}//end else divide range
			}//end while
		}
	}
	
	public void insert(double value){
		int j;
		for(j = 0; j < nElems; j++){ // find where it goes
			if(a[j] > value){ //linear search
				break;
			}
		}
		for(int k = nElems; k > j; k --){// move higher up ones
			a[k] = a[k - 1]; 
			a[j] = value; // 	insert it
			nElems++; // increment size
		}
	}
	
	public boolean delete(double value){
		int j = find(value);
		if(j == nElems){
			return false;
		}
		else{
			for(int k = j; k < nElems; k++){
				a[k] = a[k + 1];
				nElems --;
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
