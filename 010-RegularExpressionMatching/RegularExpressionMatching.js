/**
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
var isMatch = function (s, p) {
  let dp = Array.from({ length: s.length + 1 }, () =>
    Array(p.length + 1).fill(false)
  );

  dp[0][0] = true;
  let i, j;
  for (j = 1; j <= p.length; j++) {
    if (p[j - 1] === "*") {
      dp[0][j] = dp[0][j - 2];
    }
  }
  for (i = 1; i <= s.length; i++) {
    for (j = 1; j <= p.length; j++) {
      if ((p[j - 1] >= "a" && p[j - 1] <= "z") || p[j - 1] === ".") {
        dp[i][j] =
          dp[i - 1][j - 1] && (p[j - 1] === s[i - 1] || p[j - 1] === ".");
      } else if (p[j - 1] == "*") {
        dp[i][j] = dp[i][j - 2];
        if (s[i - 1] === p[j - 2] || p[j - 2] === ".") {
          dp[i][j] = dp[i][j] || dp[i - 1][j];
        }
      }
    }
  }
  console.log(dp);
  return dp[s.length][p.length];
};
isMatch("aaa", "a*");
