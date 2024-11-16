library: library.c lib/book.c lib/member.c lib/common.c lib/library.h
	@gcc -c lib/*.c
	@ar -r lib/library.a *.o
	@gcc library.c -o library lib/library.a
#clean
	@rm *.o