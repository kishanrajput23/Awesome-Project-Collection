#include<iostream>
using namespace std ;
void stockProfit(int arr[],int size){
	int min=arr[0], max,low=0;
	//loop to find the min and then update the lowest point
	for(int i=low;i<size;i++){
		if(arr[i]<min){
			min=arr[i];
		//	cout<<min<<endl;
			max=arr[i];
			low=i;
			
			
		}
		
	}
	//As the lowest point is found then this loop will start searching for maximum and loop starts from the newly created lowest
	for(int i=low;i<size;i++){
	
		if(arr[i]>max){
			max=arr[i];
		
		}
	}
		if(low==size-1){
		cout<<0;
		
}
	else{

	int profit=max-low;
	cout<<profit;	}
}
int main(){
	int size=6, arr[size]={7,1,5,3,6,4};
	stockProfit(arr,size);
}
