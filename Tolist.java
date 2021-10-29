public class Tolist {
    String operacion;
    String numero;

    public Tolist(String entrada){
        operacion=entrada;
        numero="";
    }
    public String[] create() {
        int posicion=0;
        String []arreglo=new String[operacion.length()];
        for (int i=0;i<operacion.length();i++){
            char E=operacion.charAt(i);
            if (E>='0' && '9'>=E || E=='─'){
                if (E=='─'){
                    numero=numero+"-";

                }else numero=numero+E;
            }
            
            else if( numero.equals("") && E == '-'){
                numero=numero+'-';
                
            }

            else if(E=='('){
                arreglo[posicion]=String.valueOf(E);
                posicion++;
                if( i+1<operacion.length() && operacion.charAt(i+1)=='-'){
                    numero=numero+'-';
                    i++;
                }
            }
            else if (E == '+' || E == '-'
            || E == '*' || E == '/'
            || E == '%' || E==')'){
                if (!numero.equals("")){
                    arreglo[posicion]=numero;
                    posicion++;
                    numero="";
                }
                
                if( i+1<operacion.length() && operacion.charAt(i+1)=='-'){
                    numero=numero+'-';
                    i++;
                }
                
                arreglo[posicion]=String.valueOf(E);
                posicion++;
            }
        }
        if(numero!=""){
            arreglo[posicion]=numero;
        }
        return arreglo;
        
    }
    public static void main(String[] args) {
        Tolist tolist=new Tolist("5*3/8+(95%5-10)");
        String[] lista=tolist.create();
        postfija post=new postfija(lista);
        post.convertir();
        for (String i:lista){
            System.out.println(i);
        }
    }
}
