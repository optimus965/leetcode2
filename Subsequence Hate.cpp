#include <iostream>
using namespace std;
int main() {
    int n;
    cin >> n;
    int ans = 1e9;
    for(int i =0;i < n;i++) {
        string s;
        cin >> s;
        int arr[1001][2];
        arr[0][0] = (s[0] == '0');
        arr[0][1] = (s[0] == '1');
        int count0 = arr[0][0];
        int count1 =arr[0][1];
        for(int  j =1; j < s.size();j++) {
            arr[j][0] = arr[j - 1][0] + (s[j] == '0');
            arr[j][1] = arr[j - 1][1] + (s[j] == '1');
            if(s[j] == '0') {
                count0++;
            }
            else {
                count1++;
            }
        }
        ans = 1e9;
        ans  = min(arr[s.size() - 1][0],arr[s.size() - 1][1]);
        for(int j =0;j < s.size();j++) {
            ans = min(ans,arr[j][0] + (count1 - arr[j][1]));
            ans = min(ans,arr[j][1] + (count0 - arr[j][0]));

        }
        cout << ans << endl;
    }
    
}
