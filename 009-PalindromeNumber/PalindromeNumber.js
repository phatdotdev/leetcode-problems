/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function (x) {
  if (x < 0) return false;
  if (x == 0) return true;
  let reversed = 0;
  let original = x;
  while (x > 0) {
    reversed = reversed * 10 + (x % 10);
    x = parseInt(x / 10);
  }
  return reversed === original;
};

console.log(isPalindrome(222));
