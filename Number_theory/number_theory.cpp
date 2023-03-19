#include<iostream>
#include <bitset>
#include <vector>
typedef long long ll;
ll sieve_size;
using namespace std;
vector<ll> p;
bitset<(int)1e7> bs;
void sieve(ll upperbound) {
    sieve_size = upperbound + 1;
    bs.set();
    bs[0] = bs[1] = 0;
    for(ll i = 2; i < sieve_size;i++) {
        if(bs[i]) {
            for(ll j = i*i;j < sieve_size;j = j + i) {
                bs[j] = 0;
            }
            p.push_back(i);
        }
    }
}
bool isprime(ll N) {
    if(N < sieve_size) return bs[N];
    for(int i =0;i < (int)p.size() && p[i]*p[i] <= N;i++) {
        if(N%p[i] == 0) {
            return false;
        }
    }
    return true;
}
vector<ll> primeFactors(ll n) {
    vector<ll> factors;
    for(int i =0;i < (int)p.size() && (p[i]*p[i] <= n);i++) {
        while(n%p[i] == 0) {
            n = n/p[i];
            factors.push_back(p[i]);
        }
    }
    if(n != 1) {
        factors.push_back(n);
    }
    return factors;
}
int numDiv(ll n) {
    int ans = 1;
    for(int i =0;(i < (int)p.size()) && (p[i]*p[i] <= n);i++) {
        int power =0;
        while(n%p[i] == 0) {
            n = n/p[i];
            power++;
        }     
        ans = ans*(power + 1);
    }
  
    return (n != 1)? 2*ans:ans;
}
ll sumDiv(ll n) {
    ll ans = 1;
    for(int i =0;i < (int)p.size() && (p[i]*p[i] <= n);i++) {
        ll multiplier = p[i],total = 1;
        while(n%p[i] == 0) {
            n = n/p[i];
            total = total + multiplier;
            multiplier = multiplier*p[i];
        }
        ans = ans*total;
    }
    if(n != 1) {
        ans = ans*(n + 1);
    }
    return ans;
}
ll eulerphi(ll n) {
    ll ans = n;
    for(int i =0;i < (int)p.size() && (p[i]*p[i]) <= n;++i) {
        if(n%p[i] == 0) {
            ans = ans - ans/p[i];
        }
        while(n%p[i] == 0) {
            n = n/p[i];
        }
    }
    if(n != 1) {
        ans = ans - ans/n;
    }
    return ans;
}
int gcd(int a,int b) {
    if(b== 0) {
        return a;
    }
    return gcd(b,a%b);
}
int main() {
    sieve((int)1e6);
    cout << numDiv(60ll) << "\t" << sumDiv(60ll) << "\t" << eulerphi(36);
    return 0;
}
