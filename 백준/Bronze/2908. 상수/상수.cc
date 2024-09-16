#include <iostream>
#include <string>
using namespace std;
int main() {
	string n1, n2;
	char tmp;
	int num1, num2;

	cin >> n1 >> n2;

	tmp = n1[0];
	n1[0] = n1[2];
	n1[2] = tmp;

	tmp = n2[0];
	n2[0] = n2[2];
	n2[2] = tmp;

	num1 = stoi(n1);
	num2 = stoi(n2);

	cout << (num1 > num2 ? num1 : num2);
}