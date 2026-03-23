package com.example.RBT;

public class RedBlackTreeFixed<T extends Comparable<T>> {
    private final Node<T> NIL = new Node<>(null, Color.BLACK);
    private Node<T> root = NIL;

    public RedBlackTreeFixed() {
        NIL.left = NIL;
        NIL.right = NIL;
        NIL.parent = NIL;
    }

    public void insert(T value) {
        Node<T> node = new Node<>(value, Color.RED);
        node.left = NIL;
        node.right = NIL;
        Node<T> p = NIL;
        Node<T> cur = root;
        while (cur != NIL) {
            p = cur;
            if (value.compareTo(cur.value) > 0) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        node.parent = p;
        if (p == NIL) {
            root = node;
            root.parent = NIL;
        } else if (value.compareTo(p.value) > 0) {
            p.right = node;
        } else {
            p.left = node;
        }
        insertFixUp(node);
    }

    private void insertFixUp(Node<T> node) {
        if (node == root) {
            node.color = Color.BLACK;
            return;
        }
        if (Color.BLACK.equals(node.parent.color)) {
            return;
        }
        Node<T> g = node.parent.parent;
        Node<T> p = node.parent;
        if (p == g.left) {
            if (Color.RED.equals(g.right.color)) {
                g.left.color = Color.BLACK;
                g.right.color = Color.BLACK;
                g.color = Color.RED;
                insertFixUp(g);
            } else {
                if (node == p.left) {
                    p.color = Color.BLACK;
                    g.color = Color.RED;
                    rightRotate(g);
                } else {
                    leftRotate(p);
                    p = node;
                    p.color = Color.BLACK;
                    g.color = Color.RED;
                    rightRotate(g);
                }
            }
        } else {
            if (Color.RED.equals(g.left.color)) {
                g.left.color = Color.BLACK;
                g.right.color = Color.BLACK;
                g.color = Color.RED;
                insertFixUp(g);
            } else {
                if (node == p.right) {
                    p.color = Color.BLACK;
                    g.color = Color.RED;
                    leftRotate(g);
                } else {
                    rightRotate(p);
                    p = node;
                    p.color = Color.BLACK;
                    g.color = Color.RED;
                    leftRotate(g);
                }
            }
        }
        root.color = Color.BLACK;
    }

    public void delete(T value) {
        Node<T> cur = root;
        while (cur != NIL) {
            int compare = value.compareTo(cur.value);
            if (compare > 0) {
                cur = cur.right;
            } else if (compare < 0) {
                cur = cur.left;
            } else {
                break;
            }
        }
        if (cur == NIL) {
            return;
        }

        Node<T> fixNode;
        Node<T> fixParent;
        Color deletedColor;

        if (cur.left == NIL) {
            fixNode = cur.right;
            fixParent = cur.parent;
            deletedColor = cur.color;
            transplant(cur, cur.right);
        } else if (cur.right == NIL) {
            fixNode = cur.left;
            fixParent = cur.parent;
            deletedColor = cur.color;
            transplant(cur, cur.left);
        } else {
            Node<T> pre = predecessor(cur);
            deletedColor = pre.color;
            fixNode = pre.left;
            fixParent = pre.parent;

            cur.value = pre.value;
            transplant(pre, pre.left);
        }

        if (deletedColor == Color.BLACK) {
            deleteFixup(fixNode, fixParent);
        }
    }

    private void deleteFixup(Node<T> x, Node<T> parent) {
        while (x != root && x.color == Color.BLACK) {
            if (x == parent.left) {
                Node<T> s = parent.right;
                if (s.color == Color.RED) {
                    s.color = Color.BLACK;
                    parent.color = Color.RED;
                    leftRotate(parent);
                    s = parent.right;
                }
                if (s.left.color == Color.BLACK && s.right.color == Color.BLACK) {
                    s.color = Color.RED;
                    x = parent;
                    parent = x.parent;
                } else {
                    if (s.right.color == Color.BLACK) {
                        s.left.color = Color.BLACK;
                        s.color = Color.RED;
                        rightRotate(s);
                        s = parent.right;
                    }
                    s.color = parent.color;
                    parent.color = Color.BLACK;
                    s.right.color = Color.BLACK;
                    leftRotate(parent);
                    x = root;
                }
            } else {
                Node<T> s = parent.left;
                if (s.color == Color.RED) {
                    s.color = Color.BLACK;
                    parent.color = Color.RED;
                    rightRotate(parent);
                    s = parent.left;
                }
                if (s.left.color == Color.BLACK && s.right.color == Color.BLACK) {
                    s.color = Color.RED;
                    x = parent;
                    parent = x.parent;
                } else {
                    if (s.left.color == Color.BLACK) {
                        s.right.color = Color.BLACK;
                        s.color = Color.RED;
                        leftRotate(s);
                        s = parent.left;
                    }
                    s.color = parent.color;
                    parent.color = Color.BLACK;
                    s.left.color = Color.BLACK;
                    rightRotate(parent);
                    x = root;
                }
            }
        }
        x.color = Color.BLACK;
    }

    private void transplant(Node<T> deleteNode, Node<T> curNode) {
        if (deleteNode.parent == NIL) {
            root = curNode;
        } else if (deleteNode == deleteNode.parent.left) {
            deleteNode.parent.left = curNode;
        } else {
            deleteNode.parent.right = curNode;
        }
        curNode.parent = deleteNode.parent;
    }

    private Node<T> predecessor(Node<T> x) {
        if (x.left != NIL) {
            Node<T> cur = x.left;
            while (cur.right != NIL) {
                cur = cur.right;
            }
            return cur;
        }

        Node<T> p = x.parent;
        while (p != NIL && x == p.left) {
            x = p;
            p = p.parent;
        }
        return p;
    }

    private void leftRotate(Node<T> node) {
        Node<T> g = node.parent;
        Node<T> r = node.right;
        node.right = r.left;
        if (r.left != NIL) {
            r.left.parent = node;
        }
        r.left = node;
        node.parent = r;
        if (g == NIL) {
            root = r;
        } else if (g.left == node) {
            g.left = r;
        } else {
            g.right = r;
        }
        r.parent = g;
    }

    private void rightRotate(Node<T> node) {
        Node<T> g = node.parent;
        Node<T> l = node.left;
        node.left = l.right;
        if (l.right != NIL) {
            l.right.parent = node;
        }
        l.right = node;
        node.parent = l;
        if (g == NIL) {
            root = l;
        } else if (g.left == node) {
            g.left = l;
        } else {
            g.right = l;
        }
        l.parent = g;
    }

    private static class Node<T extends Comparable<T>> {
        private Color color;
        private T value;
        private Node<T> left;
        private Node<T> right;
        private Node<T> parent;

        private Node(T value, Color color) {
            this.value = value;
            this.color = color;
        }
    }
    public String toAsciiArt() {
        if (root == NIL) {
            return "(empty)\n";
        }
        return buildTopDownAscii();
    }

    public void printAsciiArt() {
        System.out.print(toAsciiArt());
    }

    public boolean isValidRBTree() {
        if (root == NIL) {
            return true;
        }
        if (root.color != Color.BLACK) {
            return false;
        }
        return validateNode(root, null, null) >= 0;
    }

    private int validateNode(Node<T> node, T min, T max) {
        if (node == NIL) {
            return 1;
        }
        if (min != null && node.value.compareTo(min) <= 0) {
            return -1;
        }
        if (max != null && node.value.compareTo(max) >= 0) {
            return -1;
        }
        if (node.color == Color.RED) {
            if (node.left.color == Color.RED || node.right.color == Color.RED) {
                return -1;
            }
        }

        int leftBlackHeight = validateNode(node.left, min, node.value);
        if (leftBlackHeight < 0) {
            return -1;
        }
        int rightBlackHeight = validateNode(node.right, node.value, max);
        if (rightBlackHeight < 0 || leftBlackHeight != rightBlackHeight) {
            return -1;
        }

        return leftBlackHeight + (node.color == Color.BLACK ? 1 : 0);
    }

    private String buildTopDownAscii() {
        java.util.List<NodeLayout> layouts = new java.util.ArrayList<>();
        java.util.Map<Node<T>, NodeLayout> layoutByNode = new java.util.IdentityHashMap<>();
        int[] cursor = {0};
        int maxDepth = buildLayouts(root, 0, cursor, layouts, layoutByNode);

        int width = Math.max(cursor[0], 1);
        int lineCount = Math.max(1, maxDepth * 2 - 1);
        java.util.List<char[]> lines = new java.util.ArrayList<>(lineCount);
        for (int i = 0; i < lineCount; i++) {
            lines.add(blankLine(width));
        }

        for (NodeLayout layout : layouts) {
            int lineIndex = layout.depth * 2;
            writeAt(lines.get(lineIndex), layout.label, layout.x);
        }

        for (NodeLayout layout : layouts) {
            Node<T> node = layout.node;
            int connectorLine = layout.depth * 2 + 1;
            if (connectorLine >= lineCount) {
                continue;
            }
            int parentCenter = layout.x + (layout.label.length() / 2);
            if (node.left != NIL) {
                NodeLayout leftLayout = layoutByNode.get(node.left);
                if (leftLayout != null) {
                    int childCenter = leftLayout.x + (leftLayout.label.length() / 2);
                    int pos = (parentCenter + childCenter) / 2;
                    lines.get(connectorLine)[pos] = '/';
                }
            }
            if (node.right != NIL) {
               NodeLayout rightLayout = layoutByNode.get(node.right);
                if (rightLayout != null) {
                    int childCenter = rightLayout.x + (rightLayout.label.length() / 2);
                    int pos = (parentCenter + childCenter) / 2;
                    lines.get(connectorLine)[pos] = '\\';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char[] line : lines) {
            sb.append(new String(line).stripTrailing()).append('\n');
        }
        return sb.toString();
    }

    private String nodeLabel(Node<T> node) {
        if (node == NIL) {
            return "";
        }
        return String.valueOf(node.value) + (node.color == Color.RED ? "(R)" : "(B)");
    }

    private int buildLayouts(Node<T> node,
                             int depth,
                             int[] cursor,
                             java.util.List<NodeLayout> layouts,
                             java.util.Map<Node<T>, NodeLayout> layoutByNode) {
        if (node == NIL) {
            return depth;
        }

        int maxDepth = depth + 1;
        if (node.left != NIL) {
            maxDepth = Math.max(maxDepth, buildLayouts(node.left, depth + 1, cursor, layouts, layoutByNode));
        }

        String label = nodeLabel(node);
        int x = cursor[0];
        cursor[0] += label.length() + 1;
        NodeLayout layout = new NodeLayout(node, label, x, depth);
        layouts.add(layout);
        layoutByNode.put(node, layout);

        if (node.right != NIL) {
            maxDepth = Math.max(maxDepth, buildLayouts(node.right, depth + 1, cursor, layouts, layoutByNode));
        }

        return maxDepth;
    }

    private char[] blankLine(int width) {
        char[] line = new char[width];
        java.util.Arrays.fill(line, ' ');
        return line;
    }

    private void writeAt(char[] line, String text, int start) {
        if (start < 0) {
            start = 0;
        }
        for (int i = 0; i < text.length() && start + i < line.length; i++) {
            line[start + i] = text.charAt(i);
        }
    }

    private class NodeLayout {
        private final Node<T> node;
        private final String label;
        private final int x;
        private final int depth;

        private NodeLayout(Node<T> node, String label, int x, int depth) {
            this.node = node;
            this.label = label;
            this.x = x;
            this.depth = depth;
        }
    }
}
