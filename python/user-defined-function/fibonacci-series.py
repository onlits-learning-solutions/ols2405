def fibonacci(n):
    f1 = 0
    f2 = 1

    fib = [f1, f2]
    print(f"The fibonacci series up {n} terms:")
    for i in range(3, n + 1):
        fn = f1 + f2
        fib.append(fn)
        f1 = f2
        f2 = fn

    return fib


n = int(input("Enter number of terms: "))
fib = fibonacci(n)
for f in fib:
    print(f, end=" ")
print()