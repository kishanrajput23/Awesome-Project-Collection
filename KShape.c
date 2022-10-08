#include <stdio.h>

int main()
{
    int i, j, rows, alphabet;
    
    printf("Enter K Shape Alphabets Pattern Rows = ");
    scanf("%d",&rows);

    printf("\nThe K Shape Alphabets/Characters Pattern\n"); 
    
    for (i = rows - 1; i >= 0; i-- ) 
	{
		alphabet = 65;
		for (j = 0 ; j <= i; j++ ) 	
		{
			printf("%c ", alphabet + j);
		}
		printf("\n");
	}
		
	for (i = 1 ; i < rows; i++ ) 
	{
		alphabet = 65;
		for (j = 0 ; j <= i; j++ ) 	
		{
			printf("%c ", alphabet + j);
		}
		printf("\n");
	}
    return 0;
}
