#include <stdio.h>

int sort_min(int arrNum[]) {
	int a = x;
	for(i=0;i<4;i++) {
		if(a > arrNum[i]) {
			a = arrNum[i];
		}
	}
	return a;
}

int main() {
	int X, Y, W, H;
	scanf("%d %d %d %d", &X, &Y, &W, &H);

	int arrNum[4] = {X, Y, W-X, H-Y};
	printf("%d", sort_min(arrNum));

	return 0;
}