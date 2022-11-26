#include <iostream>
#include <vector>
#include <algorithm>
#define ll long long
using namespace std;
int main() {
    int size,queries;
    cin >> size >> queries;
    vector<int> v(size);
    vector<int> v1(size + 1);
    for(int i =0;i < size;i++) {
        cin >> v[i];
    }
    sort(v.begin(),v.end());
    for(int i =0;i < queries;i++) {
        int x,y;
        cin >> x >> y;
        x--;
        v1[x]++;
        v1[y]--;
    }
    for(int &c:v1) {
        cout << c << "\t";
    }
    cout << "\n";
    for(int i = 0;i < size;i++) {
        v1[i + 1] = v1[i] + v1[i + 1];
    }
    for(int &c:v1) {
        cout << c << "\t";
    }
    cout << "\n";
    sort(v1.begin(),v1.end());
    ll ans =0;
    for(int i =0;i < size;i++) {
        ans += (1ll*v[i]*v1[i + 1]);
    }
    cout << ans << endl;
    return 0;
}
