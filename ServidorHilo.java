import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class ServidorHilo extends Thread {
    
    private DataInputStream in;
    private DataOutputStream out;
    private String nombreCliente;

    String prueba;
    
    public ServidorHilo(DataInputStream in, DataOutputStream out, String nombreCliente) {
        this.in = in;
        this.out = out;
        this.nombreCliente = nombreCliente;
    }
    /**
     * Envía los mensajes al cliente Hilo 
     * y recibe los mensajes enviados por el cliente
     */
    @Override
    public void run() {
        
        while (true) {
            
            try {
                prueba=in.readUTF();
                ExpressionTree et = new ExpressionTree();
                csv csv=new csv();
                String operacion=prueba;
                Tolist tolist=new Tolist(operacion); 
                postfija post=new postfija(tolist.create());
                Node root = et.constructTree(post.convertir());
                Float resultado=et.resolver(root);
                System.out.println(resultado);
                csv.escribir(operacion,Float.toString(resultado));
                out.writeUTF(prueba);
                out.writeFloat(resultado);
                
                
            } catch (IOException ex) {
                Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
}
