// Java program to construct an expression tree
 
import java.util.Stack;
 
// Java program for expression tree
class Node {
 
    String value;
    Node left, right;
 
    Node(String item) {
        value = item;
        left = right = null;
    }
}
 
class ExpressionTree {
 
    // A utility function to check if 'c'
    // is an operator
 
    boolean isOperator(String E) {
        if (E.equals("+")|| E.equals("-")
            || E.equals("*") || E.equals("/")
            || E.equals("%")) {
            return true;
        }
        return false;
    }
 
    // Utility function to do inorder traversal
    void postorder(Node t) {
        if (t != null) {
            postorder(t.left);
            postorder(t.right);
            System.out.print(t.value);
        }
    }
    
 
    // Returns root of constructed tree for given
    // postfix expression
    Node constructTree(String postfix[]) {
        Stack<Node> stack = new Stack<Node>();
        Node root, t1, t2;
 
        // Traverse through every character of
        // input expression
        for (int i = 0; i < postfix.length; i++) {
            if (postfix[i]!=null){
                // If operand, simply push into stack
            if (!isOperator(postfix[i])) {
                root = new Node(postfix[i]);
                stack.push(root);
            } else // operator
            {
                root = new Node(postfix[i]);
 
                // Pop two top nodes
                // Store top
                t1 = stack.pop();      // Remove top
                t2 = stack.pop();
 
                //  make them children
                root.right = t1;
                root.left = t2;
 
                // System.out.println(t1 + "" + t2);
                // Add this subexpression to stack
                stack.push(root);
            }
        }

            }
        //  only element will be root of expression
        // tree
        root = stack.peek();
        stack.pop();
 
        return root;
    }
    
    public float operacion(String operador, Float n1, Float n2) {
        float resultado;
        if (operador.equals("+")){
            resultado=n1+n2;
            
        }
        else if (operador.equals("-")){
            resultado=n1-n2;
            
        }
        else if (operador.equals("*")){
            resultado=n1*n2;
            
        }
        else if (operador.equals("/")){
            resultado=n1/n2;
            
        }
        else{
            resultado=(n1*n2)/100;}
        return resultado;
            
        
    }

    public float resolver(Node E) {
        float n1;
        float n2;
        if (!isOperator(E.left.value) && !isOperator(E.right.value)){
            n1=Float.parseFloat(E.left.value);
            n2=Float.parseFloat(E.right.value);
        }

        else if(isOperator(E.left.value) && !isOperator(E.right.value)){
            n1=resolver(E.left);
            n2=Float.parseFloat(E.right.value);
        }

        else if(!isOperator(E.left.value) && isOperator(E.right.value)){
            n1=Float.parseFloat(E.left.value);
            n2=resolver(E.right);
        }

        else{
            n1=resolver(E.left);
            n2=resolver(E.right);
        }
        return operacion(E.value, n1, n2);

        
    }

        
    
 
       public static void main(String args[]) {
 
        ExpressionTree et = new ExpressionTree();
        csv csv=new csv();
        String operacion="-3*(4+5)";
        Tolist tolist=new Tolist(operacion); 
        postfija post=new postfija(tolist.create());
        Node root = et.constructTree(post.convertir());
        Float resultado=et.resolver(root);
        System.out.println(resultado);
        csv.escribir(operacion,Float.toString(resultado));
        csv.leer();
    }
}
