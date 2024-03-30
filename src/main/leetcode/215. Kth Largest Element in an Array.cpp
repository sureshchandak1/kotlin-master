#include<bits/stdc++.h>
using namespace std;

/*
*   https://leetcode.com/problems/kth-largest-element-in-an-array/
*/
public:
    int findKthLargest(vector<int>& nums, int k) {

        int size = nums.size();
        if (size == 1) {
            return nums[0];
        }

        priority_queue<int, vector<int>, greater<int> > pq;

        for (int i = 0; i < k; i++) {
            pq.push(nums[i]);
        }

        for (int i = k; i < size; i++) {
            if (nums[i] > pq.top()) {
                pq.pop();
                pq.push(nums[i]);
            }
        }

        return pq.top();
    }

int main() {

    return 0;
}