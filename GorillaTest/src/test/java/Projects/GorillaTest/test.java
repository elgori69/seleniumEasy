package Projects.GorillaTest;


public class test {
	
public static void main (String args[]) {
	int[] arr= {1,2,2,3};
	//ReverseStringToCharArray("Rene");
	NonDuplicate(arr);
	
}

//Program to Reverse a String
public static void ReverseStringToCharArray(String a) {
	
	char[] var= a.toCharArray();
	
	for (int i=var.length-1; 0<=i;i--) {
		
		System.out.print(var[i]);
	}
}

//Program to avoid duplicate numbers

public static void NonDuplicate(int []arr) {
	
for(int i=0; i<arr.length; i++) {
	for(int b=i+1; b<arr.length; b++) {

	System.out.println("I es " +arr[i]+ " y B es "+ arr[b]);
	
	
			
		}
	
	
}
	
	
}


}

