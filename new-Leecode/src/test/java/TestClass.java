import com.example.structure.ListNode;
import com.example.structure.TreeNode;
import org.w3c.dom.Node;

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

}
