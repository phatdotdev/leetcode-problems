#include <string>
#include <vector>
using namespace std;

class Solution{
    public:
        string convert(string s, int numRows) {
        if (numRows == 1 || (int)s.size() <= numRows) return s;

        vector<string> rows(numRows);
        int currentRow = 0;
        bool goingDown = false;

        for (char c : s) {
            rows[currentRow].push_back(c);
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            currentRow += goingDown ? 1 : -1;
        }

        string result;
        for (auto &line : rows) {
            result += line;
        }
        return result;
    }
};
