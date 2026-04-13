int add(int a, int b)
{
    return a + b;
}

int factorial(int n)
{
    int f = 1;
    if(n==1 || n==0)
        return 1;

    for(int i=1; i<=n; i++)
    {
        f *= i;
    }

    return f;
}