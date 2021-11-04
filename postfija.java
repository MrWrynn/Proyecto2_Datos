import java.util.Stack;

/**
 * cambia de notacion infija a notacion postfija
 * @author Jose Cruz
 * @author Brad Miller y David Ranum
 */
public class postfija {
    String[] entrada;
    Stack<String>pila; // pila que facilita la operacion 
    /**
     * 
     * @param operacion lista con la operacion matematica
     */
     postfija(String[] operacion){
         entrada=operacion;
         pila=new <String>Stack();
       
    }
    /**
     * 
     * @param E operador cuya importancia se va a analizar 
     * @return la importancia del operador expresada con un valor entero
     */

    int importancia(String E) {
        if(E.equals("(")){
            return 0;
        }
        else if (E.equals("+") || E.equals("-")){
            return 1;

        } return 2;
    }

        
    /**
     * convierte de infija a postija
     * @return devuelve la lista en notacion postfija
     */
    public String[] convertir() {
        String[] salida=new String[entrada.length]; // arreglo que sera el resultado
        int posicion=0;// posición en la lista donde se agregara el simbolo
        for (int i=0;i<entrada.length;i++){
           String E=entrada[i]; // toma los simbolos de la lista
            if(E!=null){
                if(E.equals("(")){ // si es un ( se agrega a la pila
                    pila.push(E);
                }
    
                else if(E.equals(")")){ // si es un ) retiro elementos de la pila hasta llegar a un (
                    while (!pila.isEmpty() && !pila.peek().equals("(")){
                        String aux=pila.pop();
                        salida[posicion]=aux;
                        posicion++;
                    }
                    pila.pop(); // elimino el (

                }
    
                else if (E.equals("+")|| E.equals("-")
                    || E.equals("*") || E.equals("/")
                    || E.equals("%")){ // si es un operador
                    while (!pila.isEmpty() && (importancia(pila.peek())>=importancia(E))){ // si la importancia de la sima de la pila es mayor o igual al operador entrante          
                        String aux=pila.pop(); // inserto el operador de la pila en la salida
                        salida[posicion]=aux;
                        posicion++;
                        }
                    pila.push(E); // inserto el nuevo operador en la pila
                    }
    
                else{// si es un numeor lo inserto directamente en la salida
                        
                        salida[posicion]=E;
                        posicion++;
                    }
    
                }
            } 
            while (!pila.isEmpty()){ // vacio la pila al final y la inserto en la lista 
                salida[posicion]=pila.pop();
                posicion++;
            }
            return salida;  

    }
}

