/* C program to Print Hollow Box Number Pattern */

#include<stdio.h>
 
int main()
{
    int i, j, rows, columns;
    i = 1;
     
    printf(" \nPlease Enter the Number of Rows : ");
    scanf("%d", &rows);
    
    printf(" \nPlease Enter the Number of Columns : ");
    scanf("%d", &columns);
     
    while(i <= rows)
    {
    	j = 1;
    	while(j <= columns)
		{
			if(i == 1 || i == rows || j == 1 || j == columns)
			{
				printf("1");
			}
			else
			{
				printf(" ");
			}  
			j++;     	
        }
        i++;
        printf("\n");
    }
    return 0;
}
