import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.*;
import java.util.Random;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.lang.NullPointerException;

public class ClienteHilo extends Thread {
    Ventana ventana = new Ventana();//
    JButton dado = new JButton("Enviar ecuación");
    JTextArea txtTexto=new JTextArea();
    String numero;

    private DataInputStream in;
    private DataOutputStream out;

    public ClienteHilo(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
    }

    /**
     * Envía los mensajes al servidor Hilo 
     * y recibe los mensajes enviados por el servidor hilo
     */
    @Override
    public void run() {

        //Scanner sn = new Scanner(System.in);
        String mensaje;
        Float mensaje2;
        boolean salir = false;

        while (!salir) {

            try {
                ventana.setTitle("Cliente");
                ventana.setVisible(true);
                ventana.add(txtTexto);
                txtTexto.setColumns(1);
                txtTexto.setRows(1);
                ventana.add(dado);
                dado.addActionListener(new ActionListener() {
                @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                    numero=JOptionPane.showInputDialog(null, "Digite la ecuación: ");
                    try {
                        out.writeUTF(numero);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        Logger.getLogger(ClienteHilo.class.getName()).log(Level.SEVERE, null, e);
                    } catch (java.lang.NullPointerException e) {
                        
                    }
                    }
                });
                mensaje=in.readUTF();
                txtTexto.append(mensaje);
                txtTexto.append("\n");
                mensaje2=in.readFloat();
                String s=Float.toString(mensaje2); 
                txtTexto.append(s);
                txtTexto.append("\n");
                
                
                
            } catch (IOException ex) {
                Logger.getLogger(ClienteHilo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
    
}
