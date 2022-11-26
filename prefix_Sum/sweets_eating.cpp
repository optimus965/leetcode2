#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int main() {
    int n,maxsweets;
    cin >> n >> maxsweets;
    vector<int> v(n,0);
    for(int i =0;i < n;i++) {
        cin >> v[i];
    }
    sort(v.begin(),v.end());
    long long ans =0;
    vector<int> a(n);
    for(int i =0;i < n;i++) {
        a[i%maxsweets] += v[i];
        ans += a[i%maxsweets];
        cout << ans << " ";
    }
    return 0;
}
