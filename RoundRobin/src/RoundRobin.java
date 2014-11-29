import java.util.*;

public class RoundRobin {
	
	private int number_of_process;
	private int quantum;
	private int[] burst_time = new int[quantum];
	
	public RoundRobin() {
	}
	
	public RoundRobin(int brt[],int q, int n) {
		burst_time = brt;
		number_of_process = n;
		quantum = q;
	}
	public void process() {
		int sum = 0;
		int[] a = new int [number_of_process];
		int[] waiting_time = new int [number_of_process];
		int[] Turnaround_time = new int [number_of_process];
		
		for(int i=0; i < number_of_process; ++i)
			a[i] = burst_time[i];
		for (int i = 0; i < number_of_process; i++)
			waiting_time[i] = 0;
		
		do
		{
			for (int l = 0; l < number_of_process; l++) {
				if(burst_time[l]>quantum)
				{
					burst_time[l]-=quantum;
					for(int j = 0 ; j < number_of_process; j++){
						if((j!=l)&&(burst_time[j]!=0))
							waiting_time[j]+=quantum;
					}
				}
				else
				{
					for(int j = 0; j < number_of_process; j++)
					{
						if((j!=l)&&(burst_time[j]!=0))
							waiting_time[j]+=burst_time[l];
					}
					burst_time[l]=0;
				}
			}
			sum=0;
			for(int k = 0; k < number_of_process; k++)
				sum=sum+burst_time[k];
		}
		while(sum!=0);
		
		for (int i = 0; i < quantum; i++) {
			Turnaround_time[i] = waiting_time[i] + a[i];
		}
		
		System.out.println("process\t\tBT\tWT\tTAT");
		
		for(int i = 0; i < number_of_process; i++){
			System.out.println("process"+(i+1)+"\t"+a[i]+"\t"+waiting_time[i]+"\t"+Turnaround_time[i]);
		}
		
		float avarage_waiting_time = 0;		
		float avarage_turnaround_time = 0;
		
		for (int i = 0; i < Turnaround_time.length; i++) {
			avarage_turnaround_time += Turnaround_time[i];
		}
		for (int i = 0; i < waiting_time.length; i++) {
			avarage_waiting_time+= waiting_time[i];
		}
		
		System.out.println("Avarage Waiting Time : " + avarage_waiting_time/number_of_process);
		System.out.println("Avarage TurnAround Time : " + avarage_turnaround_time/number_of_process);
	}

}
