import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;


 /**
  * escribi y lee un archivo .csv
  * @author Jose Cruz
  */
public class csv {
    String direccion="Direccio aquí\\datos.csv";
     /**
      * escribi la fecha, operacion y resultado 
      * @param operacion operacion matematica que se introdujo en la calculadora
      * @param resultado resultado de la operacion introducida
      */
    public void escribir(String operacion, String resultado){
        FileWriter fw=null;
        BufferedWriter bw=null;
        LocalDateTime fechahora;

        try {
            fw=new FileWriter(direccion,true);
            bw=new BufferedWriter(fw);
            fechahora=LocalDateTime.now();
            String linea=fechahora+";"+operacion+";"+resultado+"\n";
            bw.write(linea);
            bw.flush();
            bw.close();
            fw.close();
        } catch (Exception e){}
    }
    /**
     * lee el archivo .csv y lo muestra 
     */
    public void leer() {
        BufferedReader br;
        String linea;
        String [] partes;
        try {
            br=new BufferedReader(new FileReader(direccion));
            while((linea=br.readLine())!=null){
                partes=linea.split(";");
                for(int i=0; i<partes.length;i++){
                    System.out.print(partes[i]+"\t");
                }
                System.out.println();
                
            }
            br.close();
        } catch (Exception e) {
            
        }

        
    }
        
    
}

