package Arrays;

public class HighArrayApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int maxSize = 100;
		HighArray arr = new HighArray(maxSize);
		
		arr.insert(77);
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);
		
		System.out.println("displaying all the element in the array before performing operation");
		arr.display();
		
		int searchKey = 66;
		
		if(arr.find(searchKey)){
			System.out.println("Found " + searchKey);
		}
		else{
			System.out.println("Can not find " + searchKey);
		}
		
		arr.delete(66);
		System.out.println("displaying all the element in the array after deleting fromthe array");
		
		arr.display();
	}

}
