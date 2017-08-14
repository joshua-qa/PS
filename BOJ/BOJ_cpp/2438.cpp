#include <iostream>
using namespace std;

int main() {
    int x;
    cin >> x;
    string s;

    for(int i = 0; i < x; i++) {
        for(int j = 0; j <= i; j++) {
            s += "*";
        }
        s += "\n";
    }

    cout << s << endl;
    return 0;
}