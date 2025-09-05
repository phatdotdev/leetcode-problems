/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
var convert = function (s, numRows) {
  if (numRows === 1 || s.length <= numRows) return s;

  let result = "";
  let cycleLen = 2 * (numRows - 1);

  for (let row = 0; row < numRows; row++) {
    for (let j = 0; j + row < s.length; j += cycleLen) {
      result += s[j + row];
      if (row !== 0 && row !== numRows - 1 && j + cycleLen - row < s.length) {
        result += s[j + cycleLen - row];
      }
    }
  }

  return result;
};

(s = "PAYPALISHIRING"), (numRows = 3);
console.log(convert(s, numRows));
