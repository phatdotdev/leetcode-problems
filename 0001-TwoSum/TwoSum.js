/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (nums, target) {
  const seen = {};
  let indices = [];
  for (let i = 0; i < nums.length; i++) {
    const complement = target - nums[i];
    if (seen[complement] !== undefined) {
      indices = [seen[complement], i];
      break;
    } else {
      seen[nums[i]] = i;
    }
  }
  return indices;
};
