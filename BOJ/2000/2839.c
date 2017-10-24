#include <stdio.h>
int count;

void sugar(int num) {
	if (num == 4 || num == 7) {
		count = -1;
		return;
	}
	else if (num % 5 == 0) {
		count = num / 5;
		return;
	}
	else if (num < 13 && num % 3 == 0) {
		count = num / 3;
		return;
	}
	else if (num > 12 && num % 5 == 4) {
		count = (num / 5) + 2;
		return;
	}
	else if (num > 12 && num % 5 == 3) {
		count = (num / 5) + 1;
		return;
	}
	else if (num > 12 && num % 5 == 2) {
		count = (num / 5) + 2;
		return;
	}
	else if (num > 12 && num % 5 == 1) {
		count = (num / 5) + 1;
		return;
	}
}

int main()
{
	int num;
	scanf("%d", &num);

	sugar(num);
	printf("%d", count);

	return 0;
}