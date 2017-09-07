#include <algorithm>
#include <cstdio>

using namespace std;

int ans, curr;
int main(void) {
	int x, p[8];

	scanf("%d", &x);

	for (int i = 0; i < x; i++) {
		scanf("%d", p+i);
	}

	sort(p, p + x);

	do {
		curr = 0;
		for (int i = 0; i < x-1; i++) {
			curr += abs(p[i] - p[i + 1]);
			ans = max(ans, curr);
		}
	} while (next_permutation(p, p+x));

	printf("%d", ans);
}