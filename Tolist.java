/**
 * @author Jose Cruz
 * la clase convierte una opereacion matematica en cadena a una lista
 */

public class Tolist {
    String operacion;
    String numero;

    /**
     * 
     * @param entrada cadena de entrada con la operación a convertir a lista
     */

    public Tolist(String entrada){
        operacion=entrada;
        numero="";
    }

    /**
     * crea la lista
     * @return retorna un lista que separa los numeros, operaciones y parentesis
     */
    public String[] create() {
        int posicion=0; // posición en el arreglo donde va el nuevo digito
        String []arreglo=new String[operacion.length()]; //arreglo que se retorna
        for (int i=0;i<operacion.length();i++){
            char E=operacion.charAt(i); //obtiene cada caracter de la cadena
            if (E>='0' && '9'>=E){
               numero=numero+E; //si es un número lo agrega a una cadena
            }
            
            else if( numero.equals("") && E == '-'){ //excepcion en caso de que el primer caracter sea un menos
                numero=numero+'-';
                
            }

            else if(E=='('){
                arreglo[posicion]=String.valueOf(E);
                posicion++;
                if( i+1<operacion.length() && operacion.charAt(i+1)=='-'){ //caso numero negativo
                    numero=numero+'-';
                    i++;
                }
                
                
            }
            else if (E == '+' || E == '-'
            || E == '*' || E == '/'
            || E == '%' || E==')'){ // si son operaciones matematicas
                if (!numero.equals("")){ 
                    arreglo[posicion]=numero; //agrega el numero y lo limpia
                    posicion++;
                    numero="";
                }

                if( i+1<operacion.length() && operacion.charAt(i+1)=='-'){ //caso negativo
                    numero=numero+'-'; //agrega el negativo del número
                    i++;
                }
                arreglo[posicion]=String.valueOf(E); // agrega el operador
                posicion++;
            }
            
        }
        if(numero!=""){ // agrega el ultimo numero, ya que se agrega cada operador
            arreglo[posicion]=numero;
        }
        return arreglo;
        
    }
}

/*    public static void main(String[] args) {
        Tolist tolist=new Tolist("-3+(4-5)");
        String[] lista=tolist.create();
        postfija post=new postfija(lista);
        post.convertir();

        for (String i:lista){
            System.out.println(i);
        }
    }
}
*/