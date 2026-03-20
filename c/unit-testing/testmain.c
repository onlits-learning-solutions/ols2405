#include <CUnit/Basic.h>
#include "unittest.h"

void test_add(void);

int main(void)
{
    CU_initialize_registry();
    CU_pSuite suite = CU_add_suite("math_test_suite", 0, 0);
    CU_add_test(suite, "test of add()", test_add);

    CU_basic_run_tests();
    CU_cleanup_registry();

    return 0;
}

void test_add(void)
{
    int a = 10, b = 20; // Arrange
    int c = add(a, b);  // Act
    CU_ASSERT(c == 30); // Assert

    CU_ASSERT(add(-10, -20) == -30);
    CU_ASSERT(add(1073741823, 1073741824) == 2147483647);
}