quote = input("Write a quote below:\n")
file = open('quotes.txt', 'wt')
file.write(quote)
file.close()
