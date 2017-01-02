#include <stdio.h>
int count = 0;

void MOD (int n) {
	if (n == 1) {
		return;
	} else if (n % 3 == 0) {
		count++;
		MOD(n/3);
	} else if (n % 2 == 0) {
		count++;
		if((n-1) % 3 == 0) {
			MOD(n/3);
		}
		MOD(n/2);
	} else {
		count++;
		MOD(n-1);
	}
}

int main() {
	int N;
	scanf("%d", &N);

	MOD(N);

	printf("%d", count);

	return 0;
}