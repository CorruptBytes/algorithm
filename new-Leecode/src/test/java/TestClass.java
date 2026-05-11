import com.example.structure.ListNode;
import com.example.structure.TreeNode;
import org.w3c.dom.Node;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.IntFunction;
import java.util.logging.Level;

public class TestClass {
    //非原地解法
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[(i + k) % n] = nums[i];
        }
        System.arraycopy(res,0,nums,0,n);
    }
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int mul = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = mul;
            mul *= nums[i];
        }
        mul = 1;
        for (int i = 0; i < n; i++) {
            res[i] = res[i] * mul;
            mul *= nums[i];
        }
        return res;
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) nums[i] = n + 1;
        }
        for (int i = 0; i < n; i++) {
            int pivot = nums[i];
            if (pivot != 0) {
                pivot = Math.abs(pivot);
                if (0 < pivot && pivot <= n) {
                    nums[pivot - 1] = -Math.abs(nums[pivot - 1]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) return i + 1;
        }
        return n + 1;
    }
    //先标记，再置零。
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                Arrays.fill(matrix[i],0);
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
    //易得沿逆对角线交换对称元素后，再按行反转，就是旋转后的图像
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                matrix[i][j] = matrix[i][j] ^ matrix[j][i];
                matrix[j][i] = matrix[i][j] ^ matrix[j][i];
                matrix[i][j] = matrix[i][j] ^ matrix[j][i];
            }
        }
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                matrix[j][i] = matrix[j][i] ^ matrix[j][n - i - 1];
                matrix[j][n - i - 1] = matrix[j][i] ^ matrix[j][n - i - 1];
                matrix[j][i] = matrix[j][i] ^ matrix[j][n - i - 1];
            }
        }
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] > target) return false;
            boolean success = binarySearch(matrix[i],target);
            if (success) return true;
        }
        return false;
    }

    public boolean binarySearch(int[] line,int target) {

        int l = 0, r = line.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int pivot = line[mid];
            if (pivot == target) {
                return true;
            } else if (pivot < target) {
                l = mid + 1;
            } else if (pivot > target) {
                r = mid - 1;
            }
        }
        return false;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        //先遍历一遍链表确定链表长度，辅助找出回文链表的中间节点
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int midIndex = len / 2 - 1;
        cur = head;
        while (midIndex-- > 0) {
            cur = cur.next;
        }
        ListNode midHead = cur.next;
        if (len % 2 != 0 && midHead != null){
            midHead = midHead.next;
        }
        reverse(head,cur);
        while (midHead != null) {
            if (cur.val != midHead.val) return false;
            cur = cur.next;
            midHead = midHead.next;
        }
        return true;
    }

    //快慢指针
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (fast != slow) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            //保存下一个需要交换的节点
            ListNode temp = cur.next.next;
            //两两交换
            pre.next = cur.next;
            pre.next.next = cur;
            cur.next = temp;
            //更新节点
            pre = cur;
            cur = temp;
        }
        return dummy.next;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0,head);
        ListNode tail = head;
        ListNode pre = dummy;
        while (tail != null) {
            head = tail;
            for (int i = 1; i < k && tail != null; i++) {
                tail = tail.next;
            }
            if (tail == null) return dummy.next;
            reverse(head,tail);
            pre.next = tail;
            pre = head;
            tail = head.next;
        }
        return dummy.next;
    }

    public void reverse(ListNode head,ListNode tail) {
        ListNode pre = tail.next;
        ListNode cur = head;
        while (pre != tail) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0,head);
        ListNode tail = head;
        ListNode target = tail.next;
        while (target != null) {
            //如果目标节点的值大于尾节点，不需要再遍历，该节点就是新的尾节点
            if (target.val >= tail.val) {
                tail = tail.next;
                target = tail.next;
                continue;
            }
            //辅助遍历排序的节点
            ListNode pre = dummy;
            ListNode cur = dummy.next;
            //先摘出目标排序节点
            tail.next = target.next;
            while (cur != tail) {
                if (target.val <= cur.val) {
                    break;
                }
                pre = cur;
                cur = cur.next;
            }
            //插入节点
            ListNode temp = pre.next;
            pre.next = target;
            target.next = temp;
            //更新target
            target = tail.next;
        }
        return dummy.next;
    }
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        Node dummy = new Node(0);
        Node pre = dummy;
        Node cur = head;
        Map<Node,Node> map = new HashMap<>();
        while (cur != null) {
            Node newNode = map.get(cur);
            if (newNode == null) {
                newNode = new Node(cur.val);
                map.put(cur,newNode);
            }
            if (cur.random != null) {
                Node random = map.get(cur.random);
                if (random == null) {
                    random = new Node(cur.random.val);
                    map.put(cur.random,random);
                }
                newNode.random = random;
            }
            cur = cur.next;
            pre.next = newNode;
            pre = pre.next;
        }
        return dummy.next;
    }
    //两两归并
    public ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        if (size == 0) return null;
        while (size > 1) {
            int index = 0;
            int n = size;
            for (int i = 1; i < n; i += 2) {
                lists[index++] = mergeTwoLists(lists[i],lists[i - 1]);
                size--;
            }
            if (n % 2 == 1) lists[index] = lists[n - 1];
        }
        return lists[0];
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                pre.next = list2;
                list2 = list2.next;
            } else {
                pre.next = list1;
                list1 = list1.next;
            }
            pre = pre.next;
        }
        if (list1 != null) {
            pre.next = list1;
        } else {
            pre.next = list2;
        }
        return dummy.next;
    }

    class LRUCache {
        LinkedHashMap<Integer,Integer> cache;
        public LRUCache(int capacity) {
            cache = new LinkedHashMap<>(capacity,1,true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    return size() > capacity;
                }
            };
        }

        public int get(int key) {
            return cache.getOrDefault(key,-1);
        }

        public void put(int key, int value) {
            cache.put(key, value);
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root,res);
        return res;
    }

    public void inorderTraversal(TreeNode root,List<Integer> res) {
        if (root == null) return;
        inorderTraversal(root.left,res);
        res.add(root.val);
        inorderTraversal(root.right,res);
    }

    public int maxDepth(TreeNode root) {
        return getDepth(root);
    }
    public int getDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = Math.max(getDepth(root.left), getDepth(root.right)) + 1;
        return depth;
    }

    public TreeNode invertTree(TreeNode root) {
        invertNode(root);
        return root;
    }
    public void invertNode(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertNode(root.left);
        invertNode(root.right);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return testNode(root.left,root.right);
    }

    public boolean testNode(TreeNode left,TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;;
        if (left.val != right.val) return false;
        return testNode(left.left,right.right) && testNode(left.right,right.left);
    }

    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }
    public int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left) + 1;
        int right = depth(root.right) + 1;
        max = Math.max(max,left + right - 2);
        return Math.max(left,right);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();
    if (root != null) queue.offer(root);
    while (!queue.isEmpty()) {
        int size = queue.size();
        List<Integer> list = new ArrayList<>();
        while (size-- > 0) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        res.add(list);
    }
    return res;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return createNode(nums,0,nums.length - 1);
    }
    public TreeNode createNode(int[] nums,int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createNode(nums,start,mid - 1);
        root.right = createNode(nums,mid + 1,end);
        return root;
    }
    Integer pre = null;
    public boolean isValidBST(TreeNode root) {
        return inorderTraversal1(root);
    }

    public boolean inorderTraversal1(TreeNode root) {
        if (root == null) return true;

        boolean check =  inorderTraversal1(root.left);

        if (pre != null && root.val <= pre) {
            return false;
        }
        pre = root.val;
        check = check ? inorderTraversal1(root.right) : check;
        return check;
    }

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) return root.val;
            root = root.right;
        }
        return Integer.MIN_VALUE;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root,0,res);
        return res;
    }
    public void traversal(TreeNode root,int level,List<Integer> res) {
        if (root == null) return;
        if (level == res.size()) {
            res.add(root.val);     // 第一次到这一层
        } else {
            res.set(level, root.val); // 覆盖成更右的
        }
        traversal(root.left,level + 1,res);
        traversal(root.right,level + 1,res);
    }
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        if (root.left != null) {
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode tail = root.right;
            while (tail.right != null) {
                tail = tail.right;
            }
            tail.right = temp;
        }
        flatten(root.right);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return createNode(preorder,0,preorder.length - 1,inorder,0,inorder.length - 1);
    }

    private TreeNode createNode(int[] preorder, int start1, int end1, int[] inorder, int start2, int end2) {
        if (start1 > end1) return null;
        int val = preorder[start1];
        TreeNode root = new TreeNode(val);
        int index = start2;
        while (index <= end2) {
            if (inorder[index] == val) {
                break;
            }
            index++;
        }
        int len = index - start2;
        root.left = createNode(preorder,start1 + 1,start1 + len,inorder,start2,index - 1);
        root.right = createNode(preorder,start1 + len + 1,end1,inorder,index + 1,end2);
        return root;
    }
    //可不可以模仿前缀和
    private int ans;
    public int pathSum(TreeNode root, int targetSum) {
        // key：从根到 node 的节点值之和
        // value：节点值之和的出现次数
        // 注意在递归过程中，哈希表只保存根到 node 的路径的前缀的节点值之和
        Map<Long, Integer> cnt = new HashMap<>();
        cnt.put(0L, 1);
        dfs(root, 0, targetSum, cnt);
        return ans;
    }

    // s 表示从根到 node 的父节点的节点值之和（node 的节点值尚未计入）
    private void dfs(TreeNode node, long s, int targetSum, Map<Long, Integer> cnt) {
        if (node == null) {
            return;
        }

        s += node.val;
        // 把 node 当作路径的终点，统计有多少个起点
        ans += cnt.getOrDefault(s - targetSum, 0);

        cnt.merge(s, 1, Integer::sum); // cnt[s]++
        dfs(node.left, s, targetSum, cnt);
        dfs(node.right, s, targetSum, cnt);
        cnt.merge(s, -1, Integer::sum); // cnt[s]-- 恢复现场（撤销 cnt[s]++）
    }
    //使用全局变量记录公共祖先
    TreeNode ancestor = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        searchTargetNode(root,p,q);
        return ancestor;
    }

    public boolean searchTargetNode(TreeNode root,TreeNode p,TreeNode q) {
        if (root == null) return false;
        boolean isTargetNode = root == q || root == p;
        boolean left = searchTargetNode(root.left,p,q);
        boolean right = searchTargetNode(root.right,p,q);
        if (ancestor == null) {
            if (left && right) ancestor = root;
            if ((left || right) && (root == p || root == q)) ancestor = root;
        }
        return left || right || isTargetNode;
    }
    int count = 0;
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(grid,i + 1,j);
        dfs(grid,i - 1,j);
        dfs(grid,i,j - 1);
        dfs(grid,i, j + 1);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            map.computeIfAbsent(prerequisite[1],(k) -> new ArrayList<>()).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()) {
            int selectCourse = queue.poll();
            count++;
            for (Integer course : map.get(selectCourse)) {
                inDegree[course]--;
                if (inDegree[course] == 0) {
                    queue.offer(course);
                }
            }
        }
        return count == numCourses;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtracking(nums,list,res,used);
        return res;
    }
    public void backtracking(int[] nums,List<Integer> list,List<List<Integer>> res,boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            list.add(nums[i]);
            used[i] = true;
            backtracking(nums,list,res,used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public class P78{
        public List<List<Integer>> subsets(int[] nums) {
            List<Integer> list = new ArrayList<>();
            List<List<Integer>> res = new ArrayList<>();
            backtracking(nums,0,list,res);
            return res;
        }
        public void backtracking(int[] nums,int start,List<Integer> list,List<List<Integer>> res) {
            res.add(new ArrayList<>(list));
            if (start >= nums.length) return;
            for (int i = start; i < nums.length; i++) {
                list.add(nums[i]);
                backtracking(nums,i + 1,list,res);
                list.remove(list.size() - 1);
            }
        }
    }
    public class P17 {
        public List<String> letterCombinations(String digits) {
            String[] map = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
            List<String> res = new ArrayList<>();
            backtracking(digits,0,new StringBuilder(),res,map);
            return res;
        }

        public void backtracking(String digits,int index, StringBuilder sb, List<String> res,String[] map) {
            if (digits.length() == sb.length()) {
                res.add(sb.toString());
                return;
            }
            String s = map[digits.charAt(index) - '2'];
            int len = s.length();
            for (int i = 0; i < len; i++) {
                sb.append(s.charAt(i));
                backtracking(digits,index + 1,sb,res,map);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public class P39 {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            backtracking(candidates,target,0,new ArrayList<>(),res,0);
            return res;
        }

        public void backtracking(int[] candidates, int target, int sum, List<Integer> list, List<List<Integer>> res,int start) {
            if (target == sum) {
                res.add(new ArrayList<>(list));
                return;
            }
            if (sum > target) {
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                list.add(candidates[i]);
                backtracking(candidates,target,sum + candidates[i],list,res,i);
                list.remove(list.size() - 1);
            }
        }
        public class P22{
            public List<String> generateParenthesis(int n) {
                List<String> res = new ArrayList<>();
                backtracking(n,new StringBuilder(),0,0,res);
                return res;
            }
            public void backtracking(int n,StringBuilder sb,int left, int right,List<String> res) {
                if (left == n && left == right) {
                    res.add(sb.toString());
                    return;
                }
                if (right > left || left > n) return;
                sb.append('(');
                backtracking(n,sb,left + 1,right,res);
                sb.deleteCharAt(sb.length() - 1);
                sb.append(')');
                backtracking(n,sb,left,right + 1,res);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public class P79 {
        boolean exist = false;
        public boolean exist(char[][] board, String word) {
            int m = board.length;
            int n = board[0].length;
            boolean[][] used = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    backtracking(board,word,i,j,0,used);
                    if (exist) return true;
                }
            }
            return false;
        }

        public void backtracking(char[][] board,String word,int i, int j, int index,boolean[][] used) {
            if (index == word.length()) {
                exist = true;
                return;
            }
            int m = board.length;
            int n = board[0].length;
            if (i < 0 || i >= m || j < 0 || j >= n || used[i][j] || exist || board[i][j] != word.charAt(index)) return;
            used[i][j] = true;
            backtracking(board,word,i + 1,j,index + 1,used);
            backtracking(board,word,i - 1,j,index + 1,used);
            backtracking(board,word,i,j - 1,index + 1,used);
            backtracking(board,word,i,j + 1,index + 1,used);
            used[i][j] = false;
        }
    }
    public class P131{
        public List<List<String>> partition(String s) {
            List<String> list = new ArrayList<>();
            List<List<String>> res = new ArrayList<>();
            backtracking(s,0,list,res);
            return res;
        }

        public void backtracking(String s,int start,List<String> list,List<List<String>> res) {
            int len = s.length();
            if (start == len) {
                res.add(new ArrayList<>(list));
                return;
            }
            for (int i = start; i < len; i++) {
                String sub = s.substring(start,i + 1);
                if (!isPartition(sub)) {
                    continue;
                }
                list.add(sub);
                backtracking(s,i + 1,list,res);
                list.remove(list.size() - 1);
            }
        }
        public boolean isPartition(String s) {
            int len = s.length();
            for (int i = 0; i < len / 2; i++) {
                if (s.charAt(i) != s.charAt(len - i - 1)) return false;
            }
            return true;
        }
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp,n);
        dp[1] = 1;
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            int j = 1;
            while (i - (j * j) >= 0) {
                dp[i] = Math.min(dp[i - j * j] + 1,dp[i]);
                j++;
            }
        }
        return dp[n];
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-": {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                    break;
                }
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/": {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a / b);
                    break;
                }
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    class MinStack {
        Stack<Integer> min = new Stack<>();
        Stack<Integer> stack = new Stack<>();
        public MinStack() {
            min.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            stack.push(val);
            min.push(min.peek() < val ? min.peek() : val);
        }

        public void pop() {
            stack.pop();
            min.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }
    public String decodeString(String s) {
        int n = s.length();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < n) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int k = c - '0';
                i++;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    k = k * 10 + (s.charAt(i) - '0');
                    i++;
                }
                //跳过左括号
                i++;
                int start = i;
                int left = 1;
                int right = 0;
                while (i < n && left != right) {
                    if (s.charAt(i) == '[') left++;
                    if (s.charAt(i) == ']') right++;
                    i++;
                }
                String sub = decodeString(s.substring(start,i - 1));
                for (int j = 0; j < k; j++) {
                    sb.append(sub);
                }
            } else {
                sb.append(c);
                i++;
                while (i < n && Character.isLetter(s.charAt(i))) {
                    sb.append(s.charAt(i));
                    i++;
                }
            }
        }
        return sb.toString();
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        for (int i = n - 2; i >= 0; i--) {

            for (int j = i + 1; j < n; j += res[j]) {
                if (temperatures[j] > temperatures[i]) {
                    res[i] = j - i;
                    break;
                }
                if (res[j] == 0) {
                    break;
                }
            }
        }
        return res;
    }

    public int findKthLargest(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        return quickSearch(nums,nums.length - k,l,r);

    }
    public int quickSearch(int[] nums,int k, int l, int r) {
        if (l == r) return nums[l];
        int pivot = nums[l];
        int i = l - 1,j = r + 1;
        while (i < j) {
            do {i++;} while (nums[i] < pivot);
            do {j--;} while (nums[j] > pivot);
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        if (k <= j) {
           return quickSearch(nums,k,l,j);
        } else return quickSearch(nums,k,j + 1,r);
    }

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int pivot = nums[0];
        if (pivot <= nums[r]) return pivot;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= pivot) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min = prices[0];
        int max = 0;
        for (int i = 0; i < n; i++) {
            min = Math.min(min,prices[i]);
            max = Math.max(max,prices[i] - min);
        }
        return max;
    }

    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                return e2.getValue() - e1.getValue();
            }
        });
        queue.addAll(map.entrySet());
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll().getKey();
        }
        return res;
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        for (int i = 0; i <= max && max < n; i++) {
            max = Math.max(i + nums[i],max);
        }
        return max >= n - 1;
    }

    public int jump(int[] nums) {
        int cover = 0 + nums[0];
        int count = 0;
        int max = 0;
        if (nums.length == 1) {
            return 0;
        }
        for (int i = 0; i<=cover;i++) {
            max = Math.max(max,i + nums[i]);
            if (i == cover) {
                count++;
                cover = max;
            }
            if (cover >= nums.length - 1) {
                count++;
                return count;
            }
        }
        return count;
    }
    public List<Integer> partitionLabels(String s) {
        int[] map = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map[c -'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int i = 0;
        while (i < n) {
            char c = s.charAt(i);
            int endIndex = map[c - 'a'];
            int start = i;
            while (i <= endIndex) {
                endIndex = Math.max(map[s.charAt(i) - 'a'],endIndex);
                i++;
            }
            res.add(i - start);
        }
        return res;
    }

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int dp1 = 1;
        int dp2 = 2;
        int res = 3;
        for (int i = 0; i < n - 3; i++) {
            dp1 = dp2;
            dp2 = res;
            res = dp1 + dp2;
        }
        return res;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> layer = new ArrayList<>();
            List<Integer> preLayer = res.get(i - 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    layer.add(1);
                } else {
                    layer.add(preLayer.get(j) + preLayer.get(j - 1));
                }
            }
            res.add(layer);
        }
        return res;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1],dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    break;
                }
                if (dp[i - coin] != -1) {
                    dp[i] = dp[i] == -1 ? dp[i - coin] + 1 : Math.min(dp[i - coin] + 1,dp[i]);
                }
            }
        }
        return dp[amount];
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                if (i - word.length() >= 0 && dp[i - word.length()]) {
                    String sub = s.substring(i - word.length(),i);
                    if (word.equals(sub)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[n];
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public int maxProduct(int[] nums) {
        int min = 1;
        int max = 1;
        int res = nums[0];
        for (int num : nums) {
            int temp = max;
            max = Math.max(num,Math.max(num * max,min * num));
            min = Math.min(num,Math.min(num * temp,min * num));
            res = Math.max(res,max);
        }
        return res;
    }
    boolean can = false;
    public boolean canPartition(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max,num);
        }
        if ((sum & 1) == 1 || max << 1 > sum) return false;
        backtracking(nums,sum >> 1,0,0);
        return can;
    }

    public void backtracking(int[] nums,int target,int sum,int start) {
        if (target == sum) can = true;
        if (sum > target || can) return;
        for (int i = start; i < nums.length; i++) {
            backtracking(nums,target,sum + nums[i],i + 1);
        }
    }

    public int longestValidParentheses(String s) {
        int n = s.length();
        int left = 0;
        int right = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else right++;
            if (right > left) {
                left = 0;
                right = 0;
            }
            if (left == right) max = Math.max(max,left * 2);
        }
        left = 0;
        right = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else right++;
            if (left > right) {
                left = 0;
                right = 0;
            }
            if (left == right) max = Math.max(max,left * 2);
        }
        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (!set.add(s.charAt(i))) {
                set.remove(s.charAt(i - set.size()));
                i--;
            }
            max = Math.max(max,set.size());
        }
        return max;
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j],dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        int max = 0;
        int lMax = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) continue;
            char c = s.charAt(i);
            int l = i;
            int r = i;
            while (l >= 0 && s.charAt(l) == c) {
                l--;
            }
            while (r < n && s.charAt(r) == c) {
                r++;
            }
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            l++;
            r--;
            if (r - l + 1 > max) {
                max = r - l + 1;
                lMax = l;
            }
        }
        return s.substring(lMax,lMax + max);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1],Math.min(dp[i - 1][j],dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }

    public int singleNumber(int[] nums) {
        int n = 0;
        for (int num : nums) {
            n ^= num;
        }
        return n;
    }

    public int majorityElement(int[] nums) {
        int count = 1;
        int res = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (res == nums[i]) {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else {
                    res = nums[i];
                    count = 1;
                }
            }
        }
        return res;
    }
    //一次扫描
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0;
        int p1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                p1++;
            } else if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if (p0 < p1) {
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                p0++;
                p1++;
            }
        }
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]){
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i + 1);

    }
    public void swap(int[] nums,int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] =temp;
    }
    public void reverse(int[] nums, int start) {
        int l = start, r = nums.length - 1;
        while (l < r) {
            swap(nums,l,r);
            l++;
            r--;
        }
    }

    public static int tableSizeFor(int cap) {
        if (cap <= 0) return 1;
        cap -= 1;
        cap |= cap >>> 1;
        cap |= cap >>> 2;
        cap |= cap >>> 4;
        cap |= cap >>> 8;
        cap |= cap >>> 16;
        return cap + 1;
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        //初始化棋盘
        List<StringBuilder> square = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append('.');
            }
            square.add(sb);
        }
        //用于判断哪一列还没有棋子
        boolean[] used = new boolean[n];
        backtracking(square,n,used,res,0);
        return res;
    }
    public void backtracking(List<StringBuilder> square,int n, boolean[] used,List<List<String>> res,int i) {
        if (i == n) {
            res.add(square.stream().map(StringBuilder::toString).toList());
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!isValid(square,i,j,n) || used[j]) {
                continue;
            }
            square.get(i).setCharAt(j,'Q');
            used[j] = true;
            backtracking(square,n,used,res,i + 1);
            square.get(i).setCharAt(j,'.');
            used[j] = false;
        }
    }
    public boolean isValid(List<StringBuilder> square,int r,int c,int n) {
        for (int i = r + 1, j = c + 1; i < n && j < n; i++,j++) {
            if (square.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--,j--) {
            if (square.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        for (int i = r + 1, j = c - 1; i < n && j >= 0; i++,j--) {
            if (square.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        for (int i = r - 1, j = c + 1; i >= 0 && j < n; i--,j++) {
            if (square.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }
}
