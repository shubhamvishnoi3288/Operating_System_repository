// Online C compiler to run C online.
// Write C code in this online editor and run it.

#include <stdio.h>
#include <conio.h>
int main() {
    int i,j,n,bt[100],wt[100],tat[100];
    float awt,atat;
    clrscr();
    printf("Enter the no. of process : ");
    scanf("%d",&n);
    printf("Enter the burst time for process : \n");
    for(i=0;i<n;i++){
	printf("P[%d] : ",i+1);
	scanf("%d",&bt[i]);
    }

    wt[0]=0;
    //waiting time
    for(i=1;i<n;i++){
	wt[i]=bt[i-1]+wt[i-1];
    }
    //turn around time
    for(i=0;i<n;i++){
	tat[i]=wt[i]+bt[i];
    }
    //average waiting time
    awt=0;
    for(i=0;i<n;i++){
	awt=wt[i]+awt;
    }
    //average turn around time
    atat=0;
    for(i=0;i<n;i++){
	atat=atat+tat[i];
    }
    awt=awt/n;
    atat=atat/n;
    printf("Waiting time : \n");
     for(i=0;i<n;i++){
       printf("P[%d] : %d \n",i+1,wt[i]);
    }
    printf("\nTurn around time : \n");
     for(i=0;i<n;i++){
	printf("P[%d] : %d \n",i+1,tat[i]);
    }
    printf("\nAverage waiting time : %f",awt);
    printf("\nAverage turn around time : %f",atat);
    getch();
}