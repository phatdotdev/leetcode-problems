/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = (s) => {
  const seen = Array(256).fill(-1);
  let left = 0;
  let right = 0;
  let maxLength = 0;
  let n = s.length;
  while (right < n) {
    let ascii = s[right].charCodeAt(0);

    if (seen[ascii] !== -1 && seen[ascii] >= left) {
      left = seen[ascii] + 1;
    }
    let windowLength = right - left + 1;
    maxLength = Math.max(maxLength, windowLength);

    seen[ascii] = right;
    right++;
  }
  return maxLength;
};
