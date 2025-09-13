
struct ListNode {
    int val;
    ListNode *next;
    ListNode(): val(0),next(nullptr){};
    ListNode(int x): val(x), next(nullptr){};
    ListNode(int x, ListNode* next):val(x), next(next){};
};

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* dummy = new ListNode(0);
        ListNode* current = dummy;
        int total = 0, carry = 0;
        while(l1 || l2){
            total = carry;
            if(l1){
                total += l1->val;
                l1 = l1->next;
            }
            if(l2){
                total += l2->val;
                l2 = l2->next;
            }
            current->next =  new ListNode(total % 10);
            carry = total / 10;
            current = current->next;
        }
        if(carry > 0){
            current->next = new ListNode(carry);
        }
        return dummy->next;
    }
};