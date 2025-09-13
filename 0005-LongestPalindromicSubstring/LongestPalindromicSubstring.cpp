#include <string>
#include <array>

using namespace std;

class Solution {
public:
    string longestPalindrome(string s) {
        string t = "^#";
        for(int i = 0; i < s.length(); i++){
            t += s[i];
            t += "#";
        }
        t += "$";
        int P[t.length()];
        fill(P, P + t.length(), 0);
        int center = 0, right = 0;
        for(int i = 1; i < t.length(); i++){
            int mirror = 2 * center - i;
            if(i < right){
                P[i] = min(right - i, P[mirror]);
            }
            while(i-1-P[i] >= 0 && i+1+P[i] < t.length() && t[i-1-P[i]] == t[i+1+P[i]]){
                P[i]++;
            }
            if(i + P[i] > right){
                right = i + P[i];
                center = i;
            }
        }
        int maxLength = 0, centerIndex = 0;
        for(int i = 0; i < t.length(); i++){
            if(maxLength < P[i]){
                maxLength = P[i];
                centerIndex = i;
            }
        }
        return s.substr((centerIndex - maxLength) / 2, maxLength);
    }
};