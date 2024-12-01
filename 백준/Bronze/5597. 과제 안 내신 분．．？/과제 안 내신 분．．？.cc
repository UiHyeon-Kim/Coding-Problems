#include <iostream>
using namespace std;
int main(void) {
	int arr[31] = { 0 };

	for (int i = 1; i <= 28; i++) { // 28개의 값 입력 받기 위한 변수 i
		int n; // n을 통해 값을 입력받음
		cin >> n; // n 값 입력
		arr[n]++; // 입력 받은 값의 배열 값을 1로 만듬
	}

	for (int i = 1; i <= 30; i++) { 
		if (arr[i] == 0) cout << i << endl; // arr[] = 0인 값 출력
	}
}