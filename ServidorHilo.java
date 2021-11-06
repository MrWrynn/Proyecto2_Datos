/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_sockets_ddr_8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando
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
    
    @Override
    public void run() {
        
        int opcion;
        File f = new File("numeros.txt");
        
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
                System.out.println(prueba+" este es el mensaje");
                out.writeUTF(prueba);
                out.writeFloat(resultado);
                
                
            } catch (IOException ex) {
                Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
    
    public void escribirNumeroAleatorio(File f,int numeroAleatorio) throws IOException{
        
        FileWriter fw = new FileWriter(f, true);
        fw.write(nombreCliente + ":"+numeroAleatorio + "\r\n");
        fw.close();
        
    }
 
    
    
    
}
