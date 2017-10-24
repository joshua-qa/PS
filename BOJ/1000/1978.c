#include <stdio.h>
int arrNum[101];
int sosu[11] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};

int sosu_get(int arrNum[], int N) {
	int sosu_count = 0;
	int sosu_flag = 0;
	for(int i=0;i<N;i++) {
		int count = 0;
		while(count < 11) {
			if(arrNum[i] % sosu[count] == 0) {
				count++;
				sosu_flag = 0;
			} else {
				sosu_flag = 1;
			}
		}
		count = 0;
		if(sosu_flag == 0) {
			sosu_count++;
		}
	}
}

int main() {
	int N;
	for(int i = 0; i < N; i++) {
		scanf("%d", &arrNum[i]);
	}

	printf("%d", sosu_get(arrNum, N));

	return 0;
}