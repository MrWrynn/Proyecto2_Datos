 import java.util.Stack;
 
/**
 * @author GeeksforGeeks
 * @author Jose Cruz
 */

class Node { //nodo del arbol
 
    String value; 
    Node left, right; // tiene un enlace a la derecha y a la izquierda
 
    Node(String item) {
        value = item;
        left = right = null;
    }
}
 
class ExpressionTree {
 
    /**
     * analiza si una cadena es un operador
     * @param E Cadena que se analizara 
     * @return verdadero si es un operador, falso cualquier otro caso
     */
    boolean isOperator(String E) {
        if (E.equals("+")|| E.equals("-")
            || E.equals("*") || E.equals("/")
            || E.equals("%")) {
            return true;
        }
        return false;
    } 

    
    /**
     * construye el arbol de expresion
     * @param postfix lista en notacion postfija
     * @return la raiz del arbol de expresion
     */
    Node constructTree(String postfix[]) {
        Stack<Node> stack = new Stack<Node>();
        Node root, t1, t2;
 
   
        for (int i = 0; i < postfix.length; i++) {
            if (postfix[i]!=null){ // mientras se obtenga algo que no es vacio 
               
            if (!isOperator(postfix[i])) { // si es un numeor
                root = new Node(postfix[i]); //se agrega como un nuevo nodo
                stack.push(root); // agrego el nodo a la pila
            } else // si es un operador
            {
                root = new Node(postfix[i]); // lo agrego como un nuevo nodo
 
               // agrego a la derecha el primer elemento de la pila y a la izquierda el segundo
                t1 = stack.pop();      
                t2 = stack.pop();
 
                root.right = t1;
                root.left = t2;
               
                stack.push(root); // agrego el nuevo nodo a la pila
            }
        }

            }
   
        root = stack.peek(); // al finalizar la raiz es la cima de la pila
        stack.pop();
 
        return root;
    }
    /**
     * opera 2 elementos obtenidos del arbol
     * @param operador operacion matematica a realizar 
     * @param n1 numero obtenido de la izquierda del arbol
     * @param n2 numero obtenido de la derecha
     * @return
     */
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
    /**
     * resuelve de manera recursica todo el arbol 
     * @param E Nodo que servira como raiz desde donde operar, permite dividir en subarboles
     * @return retorna el resultado de operar el arbol de expresion
     */
    public float resolver(Node E) {
        float n1;
        float n2;

        // hay 4 casos posibles, izquierda y derecha numeros
        if (!isOperator(E.left.value) && !isOperator(E.right.value)){
            n1=Float.parseFloat(E.left.value);
            n2=Float.parseFloat(E.right.value);
        }

        // izquierda operador(se resuelve por recursividad) y derecha numero 
        else if(isOperator(E.left.value) && !isOperator(E.right.value)){
            n1=resolver(E.left);
            n2=Float.parseFloat(E.right.value);
        }
        // caso anterior pero invirtiendo izquierda y derecha
        else if(!isOperator(E.left.value) && isOperator(E.right.value)){
            n1=Float.parseFloat(E.left.value);
            n2=resolver(E.right);
        }
        // ambos son operadores
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
