/* C program to Print Box Number Pattern of 1 and 0 */

#include<stdio.h>
 
int main()
{
    int i, j, rows, columns;
     
    printf(" \nPlease Enter the Number of Rows : ");
    scanf("%d", &rows);
    
    printf(" \nPlease Enter the Number of Columns : ");
    scanf("%d", &columns);
     
    for(i = 1; i <= rows; i++)
    {
    	for(j = 1; j <= columns; j++)
		{
			if(i == 1 || i == rows || j == 1 || j == columns)
			{
				printf("1");
			}
			else
			{
				printf("0");
			}       	
        }
        printf("\n");
    }
    return 0;
}
