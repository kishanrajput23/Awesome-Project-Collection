#include <stdio.h>

int main()
{
	int rows;

	printf("Enter V Shape Number Pattern Rows = ");
	scanf("%d", &rows);

	printf("Printing the V Shape Number Pattern\n");

	for (int i = 1; i <= rows; i++)
	{
		for (int j = 1; j <= i; j++)
		{
			printf("%d", j);
		}
		for (int k = 1; k <= 2 * (rows - i); k++)
		{
			printf(" ");
		}
		for (int l = i; l >= 1; l--)
		{
			printf("%d", l);
		}
		printf("\n");
	}
}
