#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

int solution(int cacheSize, vector<string> cities) {
	int answer = 0;

	if (cacheSize == 0) {
		return cities.size() * 5;
	}
	vector<string> cache;

	for (int i = 0; i < cities.size(); i++)
	{
		transform(cities[i].begin(), cities[i].end(), cities[i].begin(), ::tolower);
		
		if (cache.size() > 0 && find(cache.begin(), cache.end(), cities[i]) != cache.end()) {
			cache.erase(remove(cache.begin(), cache.end(), cities[i]), cache.end());
			
			cache.push_back(cities[i]);
			answer += 1;
		}
		else {
			if (cache.size() == cacheSize) {
				cache.erase(cache.begin());
			}
			cache.push_back(cities[i]);
			answer += 5;
		}
	}

	return answer;
}

int main() {

	int n = 2;

	vector<string> a1;
	a1.push_back("Jeju");
	a1.push_back("Pangyo");
	a1.push_back("NewYork");
	a1.push_back("newyork");

	int result = solution(n, a1);

	printf("%d", result);

	return 0;
}