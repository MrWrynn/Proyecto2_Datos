import java.util.Stack;

public class postfija {
    String[] entrada;
    Stack<String>pila;

     postfija(String[] operacion){
         entrada=operacion;
         pila=new <String>Stack();
       
    }

    int importancia(String E) {
        if(E.equals("(")){
            return 0;
        }
        else if (E.equals("+") || E.equals("-")){
            return 1;

        } return 2;
    }

        
    
    public String[] convertir() {
        String[] salida=new String[entrada.length];
        int posicion=0;
        for (int i=0;i<entrada.length;i++){
           String E=entrada[i];
            //System.out.println(E);
            //System.out.println("*"+posicion);
            if(E!=null){
                if(E.equals("(")){
                    pila.push(E);
                }
    
                else if(E.equals(")")){
                    while (!pila.isEmpty() && !pila.peek().equals("(")){
                        String aux=pila.pop();
                        salida[posicion]=aux;
                        posicion++;
                    }
                    pila.pop();

                }
    
                else if (E.equals("+")|| E.equals("-")
                    || E.equals("*") || E.equals("/")
                    || E.equals("%")){
                    while (!pila.isEmpty() &&(importancia(pila.peek())>=importancia(E))){
                                            
                        String aux=pila.pop();
                        salida[posicion]=aux;
                        posicion++;
                        }
                    pila.push(E);
                    }
    
                else{
                        
                        salida[posicion]=E;
                        posicion++;
                        //System.out.println("aquí");
                    }
    
                }
            } 
            while (!pila.isEmpty()){
                salida[posicion]=pila.pop();
                posicion++;
            }
            return salida;  

    }
    public static void main(String[] args) {
        //postfija post=new postfija();
    }
}
//103213-*45++
//103213-*45++
