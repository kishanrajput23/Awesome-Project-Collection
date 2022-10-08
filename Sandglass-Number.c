#include <stdio.h>

int main()
{
    int i = 1, j, k, rows;
    
    printf("Enter Sandglass Number Pattern Rows = ");
    scanf("%d",&rows);

    printf("\nThe Sandglass Number Pattern\n"); 

	do
    {
    	j = 1;
    	do	
		{
			printf(" ");

        } while( j++ < i);

        k = i;
        do
        {
			printf("%d ", k);

		} while( ++k <= rows );
		printf("\n");

	} while( ++i <= rows);
    
    i = rows - 1;
    do
    {
        j = 1;
    	do
		{
			printf(" ");
			
        } while( j++ < i);

        k = i;
        do
        {
			printf("%d ", k);

        } while( ++k <= rows );
		printf("\n");

	} while( --i >= 1);
		
    return 0;
}
Enter Sandglass N
