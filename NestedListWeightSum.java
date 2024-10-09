// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        Queue<NestedInteger> q = new LinkedList<>();

        for (NestedInteger el : nestedList) {
            q.add(el);
        }

        int result = 0;
        int depth = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                NestedInteger curr = q.poll();

                if (curr.isInteger())
                    result += curr.getInteger() * depth;

                else {
                    for (NestedInteger el : curr.getList())
                        q.add(el);
                }
            }

            depth++;
        }

        return result;
    }
}