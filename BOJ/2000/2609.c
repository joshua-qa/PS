#include <stdio.h>
int gcdtmp = 0;
int gcdtmp2 = 0;
int GCD(int A, int B) {
    if (A % B == 0 || B % A == 0) {
        exit(1);
    } else if (A > B) {
        gcdtmp = A % B;
        gcdtmp2 = gcdtmp;
        GCD(B, gcdtmp);
    } else if (A < B) {
        gcdtmp = B % A;
        gcdtmp2 = gcdtmp;
        GCD(A, gcdtmp);
    }
    return gcdtmp2;
}

int main() {
    int A, B;
    scanf("%d %d", &A, &B);
    printf("%d\n", GCD(A, B));
    printf("%d", (A*B) / GCD(A, B));

    return 0;
}