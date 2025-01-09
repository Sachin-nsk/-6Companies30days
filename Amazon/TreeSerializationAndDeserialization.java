/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {

    public String serialize(TreeNode root) {
        StringBuilder out = new StringBuilder();
        serialize(root, out);
        return out.toString();
    }

    public TreeNode deserialize(String data) {
        Scanner in = new Scanner(data);
        return deserialize(in);
    }

    private void serialize(TreeNode root, StringBuilder out) {
        if (root != null) {
            out.append(root.val).append(' ');
            serialize(root.left, out);
            serialize(root.right, out);
        } else {
            out.append("# ");
        }
    }

    private TreeNode deserialize(Scanner in) {
        if (!in.hasNext())
            return null;
        String val = in.next();
        if (val.equals("#"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserialize(in);
        root.right = deserialize(in);
        return root;
    }
}


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));