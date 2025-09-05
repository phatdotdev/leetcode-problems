/**
 * @param {string} s
 * @return {number}
 */
var myAtoi = function (s) {
  let res = 0,
    sign = 0,
    index = 0;
  let [negativeLimit, positiveLimit] = [-(2 ** 31), 2 ** 31 - 1];
  while (index < s.length) {
    while (s[index] === " " && index < s.length) index++;
    if (s[index] === "+") {
      if (sign === 0) sign = 1;
      else return 0;
      index++;
    }
    if (s[index] === "-") {
      if (sign === 0) sign = -1;
      else return 0;
      index++;
    }
    if (s[index] >= "0" && s[index] <= "9") {
      while (s[index] >= "0" && s[index] <= "9") {
        res = res * 10 + Number(s[index]);
        index++;
      }
      return sign == -1
        ? Math.max(-res, negativeLimit)
        : Math.min(res, positiveLimit);
    } else return 0;
  }
  return 0;
};
