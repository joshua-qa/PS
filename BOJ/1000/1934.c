#include <stdio.h>
int gcd_a[1000], gcd_b[1000];

int gcd (int A, int B) {
	if(A % B == 0) {
		return B;
	} else if (A > B) {
		return gcd(B, A%B);
	} else {
		return gcd(A, B%A);
	}
}

int main() {
	int N;
	scanf("%d", &N);

	for(int i = 0; i < N; i++) {
		scanf("%d %d", &gcd_a[i], &gcd_b[i]);
	}

	for(int j = 0; j < N; j++) {
		int C = (gcd_a[j] * gcd_b[j]) / gcd(gcd_a[j], gcd_b[j]);
		printf("%d\n", C);
	}

	return 0;
}