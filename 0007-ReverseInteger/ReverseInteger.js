/**
 * @param {number} x
 * @return {number}
 */
var reverse = function (x) {
  let isNegative = x < 0;
  let limits = 2 ** 31;
  let num = isNegative ? -x : x;
  let number = 0;
  while (num > 0) {
    number = number * 10 + (num % 10);
    num = Math.floor(num / 10);
    if (number > limits) return 0;
  }
  return isNegative ? -number : number;
};

console.log(reverse(123));
