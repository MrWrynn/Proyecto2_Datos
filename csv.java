import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class csv {
    String direccion="C:\\Users\\User\\Documents\\DatosI\\Proyecto2\\Proyecto2\\src\\datos.csv";
     
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
    
    public void leer() {
        BufferedReader br;
        String linea;
        String [] partes;
        try {
            br=new BufferedReader(new FileReader(direccion));
            while((linea=br.readLine())!=null){
                partes=linea.split(";");
                for(int i=0; i<partes.length;i++){
                    System.out.print(partes[i]+" | ");
                }
                System.out.println();
                
            }
            br.close();
        } catch (Exception e) {
            
        }
}


