#include<stdio.h>
int main()
{
 	int i, j, k, rows; 
 	printf("Please Enter Number of rows =  ");
 	scanf("%d", &rows);

	k = rows * 2 - 1;
    i = 1;

	while(i <= k)
	{
        j = 1;
		while(j <= k)
		{
			if(j == i || j == (k - i + 1))
			{
				printf("*");
			}
			printf(" ");
            j++;
		}
		printf("\n");
        i++;
	}
 	return 0;
}
