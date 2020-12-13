import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int B = scan.nextInt();
		int C = scan.nextInt();
		System.out.print("Enter the no. of process : ");
		int no_of_process = scan.nextInt();
		int[] allocationA = new int[no_of_process];
		int[] allocationB = new int[no_of_process];
		int[] allocationC = new int[no_of_process];
		int[] maxNeedA = new int[no_of_process];
		int[] maxNeedB = new int[no_of_process];
		int[] maxNeedC = new int[no_of_process];
		int totalAllocationA=0,totalAllocationB=0,totalAllocationC=0,availableA=0,availableB=0,availableC=0,flag=1,i=0,cycle=1;
		int[] remainingNeedA = new int[no_of_process];
		int[] remainingNeedB = new int[no_of_process];
		int[] remainingNeedC = new int[no_of_process];
		System.out.println("Allocation Table : ");
		for(i=0; i<no_of_process; i++){
		    allocationA[i] = scan.nextInt();
		    allocationB[i] = scan.nextInt();
		    allocationC[i] = scan.nextInt();
		}
		System.out.println("Max Table : ");
		for(i=0; i<no_of_process; i++){
		    maxNeedA[i] = scan.nextInt();
		    maxNeedB[i] = scan.nextInt();
		    maxNeedC[i] = scan.nextInt();
		}
		for(i=0; i<no_of_process; i++){
		   totalAllocationA += allocationA[i];
		   totalAllocationB += allocationB[i];
		   totalAllocationC += allocationC[i];
		}
		availableA = A - totalAllocationA;
		availableB = B - totalAllocationB;
		availableC = C - totalAllocationC;
		for(i=0; i<no_of_process; i++){
		    remainingNeedA[i] = maxNeedA[i] - allocationA[i];
		    remainingNeedB[i] = maxNeedB[i] - allocationB[i];
		    remainingNeedC[i] = maxNeedC[i] - allocationC[i];
		}
		while(flag == 1){
		    flag=0;
		    for(i=0; i<no_of_process; i++){
		        if(availableA>=remainingNeedA[i]&&availableB>=remainingNeedB[i]&&availableC>=remainingNeedC[i]){
		            availableA += allocationA[i];
		            availableB += allocationB[i];
		            availableC += allocationC[i];
		            flag = 1;
		            remainingNeedA[i] = Integer.MAX_VALUE;
		            remainingNeedB[i] = Integer.MAX_VALUE;
		            remainingNeedC[i] = Integer.MAX_VALUE;
		            
		        }
		        if(availableA==A&&availableB==B&&availableC==C) {
		            cycle = 0;
		            flag =0;
		        }
		    }
		}
		if(cycle == 0) System.out.print("Safe state");
		else System.out.println("Unsafe");
	}
}