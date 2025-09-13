/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function (l1, l2) {
  let dummy = new ListNode(0);
  let current = dummy;
  let carry = 0;

  while (l1 !== null || l2 !== null) {
    let total = carry;
    if (l1 !== null) {
      total += l1.val;
      l1 = l1.next;
    }
    if (l2 !== null) {
      total += l2.val;
      l2 = l2.next;
    }

    current.next = new ListNode(total % 10);
    carry = Math.floor(total / 10);
    current = current.next;
  }

  if (carry > 0) {
    current.next = new ListNode(carry);
  }

  return dummy.next;
};
