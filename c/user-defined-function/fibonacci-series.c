#include <stdio.h>
#include <stdlib.h>

int *fibonacci(int n);

int main(void)
{
    int n;
    printf("Enter number of terms: ");
    scanf("%d", &n);
    int *fib;
    fib = fibonacci(n);
    printf("The fibonacci series upto %d terms:\n", n);
    for (int i = 0; i < n; i++)
    {
        printf("%d ", fib[i]);
    }
    printf("\n");
    return 0;
}

int *fibonacci(int n)
{
    int f1 = 0, f2 = 1, fn;
    int *fib = calloc(n, sizeof(int));
    fib[0] = f1;
    fib[1] = f2;
    for (int i = 2; i < n; i++)
    {
        fn = f1 + f2;
        fib[i] = fn;
        f1 = f2;
        f2 = fn;
    }
    return fib;
}