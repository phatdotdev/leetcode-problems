/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function (s) {
  let longestSubstring = "";
  for (let i = 0; i < s.length; i++) {
    let left = (right = i);
    while (s[left] === s[left - 1]) left--;
    while (s[right] === s[right + 1]) right++;
    while (left > 0 && right < s.length - 1 && s[left - 1] === s[right + 1]) {
      left -= 1;
      right += 1;
    }
    let substring = s.slice(left, right + 1);
    if (substring.length > longestSubstring.length) {
      longestSubstring = substring;
    }
  }
  return longestSubstring;
};
