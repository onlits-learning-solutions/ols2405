library: library.c lib/book.c lib/member.c lib/common.c lib/library.h
	cd lib
	gcc -c *.c
	ar -r library.a *.o
	cd ..
	gcc library.c -o library lib/library.a