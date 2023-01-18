package Projects.GorillaTest;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class test {
	
public static void main (String args[]) {
	int[] arr= {1,2,2,3};
	//ReverseStringToCharArray("Rene");
	//NonDuplicate(arr);
	
	String str="Rene";
	char n=3;
	
	MissingChar(str,n);
	
	
	
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

public static void MissingChar(String str, char n) {
	
char[] var= str.toCharArray();	

System.out.println(var[3]);
}


}

