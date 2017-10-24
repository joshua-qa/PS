#include <stdio.h>

int main() {
	int N;
	scanf("%d", &N);
	int cycle = 1;
	int newNum = 0;
	int newNum_temp = 0;
	int newNum_origin = 0;

	newNum_temp = (N / 10) + (N % 10); // 2+6 = 8
	newNum = ((N % 10)*10) + (newNum_temp % 10); // 68

	while (newNum != N) {
		newNum_temp = (newNum / 10) + (newNum % 10); // 6+8 = 14
		newNum = ((newNum % 10)*10) + (newNum_temp % 10);

		cycle++;
	}

	printf("%d", cycle);

	return 0;
}