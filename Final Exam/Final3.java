//Student   Name: Woohyeon Baek
//Student Number: 2017-15782

//Do not import any java libraries
//Do not write extra classes
public class Final3 {
    public Node root;
    //Do not create any field varable

    public Final3(String s) {
        //handle case s = "" and passing root to report(FinalNode n)
        if(s.isEmpty()) return;
        //Modify as you wish
        root = new Node();
        root.label = s.charAt(0);
        int temp = decode(root, s, 1);
    }

    private int decode(Node curr, String str, int n) {
        //Modify return type and parameter as you wish to build tree recursively
        //Modify as you wish
        if(str.charAt(n) == curr.label) return n + 1;

        curr.left = new Node();
        curr.left.label = str.charAt(n);
        int m = decode(curr.left, str, n + 1);

        curr.right = new Node();
        curr.right.label = str.charAt(m);
        int t = decode(curr.right, str, m + 1);

        return t + 1;
    }

    public Node getRoot() { return root; }

    public String encode(Node otherTreeRoot) { //you may change parameter name
        if(otherTreeRoot == null) return "";
        //Modify as you wish
        return otherTreeRoot.label + encode(otherTreeRoot.left) + encode(otherTreeRoot.right) + otherTreeRoot.label;
    }
    //Do not write any other method than provided
}