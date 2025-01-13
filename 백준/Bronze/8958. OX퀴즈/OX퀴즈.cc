#include <iostream>
#include <cstring>
using namespace std;

int main() {
	int n, score = 0, combo = 0;
	char OX[80];
	
	cin >> n;
	
	for (n; n > 0; n--) {
		cin >> OX;
		
		score = 0;
		combo = 0;
		
		for (int i = 0; i < strlen(OX); i++) {
			if (OX[i] == 'O') {
				combo++;
				score += combo;
			}
			else {
				combo = 0;
			}
		}
		cout << score << "\n";
	}
}