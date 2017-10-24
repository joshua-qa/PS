#include <stdio.h>
#include <string.h>

int main() {
	int A, B;
	int D[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	char Y[7][4];
	strcpy(Y[0], "SUN");
	strcpy(Y[1], "MON");
	strcpy(Y[2], "TUE");
	strcpy(Y[3], "WED");
	strcpy(Y[4], "THU");
	strcpy(Y[5], "FRI");
	strcpy(Y[6], "SAT");
	
	int day = 0;
	int day2 = 0;
	
	scanf("%d %d", &A, &B);
	if (A == 1) {
		day = day + B;
	} else {
		for (int i = 0; i < A-1; i++) {
			day = day + D[i];
		}
		day = day + B;
	}
	
	day2 = day % 7;
	
	printf("%s", Y[day2]);
	
	return 0;
}