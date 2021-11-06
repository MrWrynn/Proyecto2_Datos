package ejercicio_sockets_ddr_8;

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

public class ClienteHilo extends Thread {
    Ventana ventana = new Ventana();//
    JButton dado = new JButton("Dado");
    JButton cosa = new JButton("cosa");
    JTextArea txtTexto=new JTextArea();
    String numero;

    private DataInputStream in;
    private DataOutputStream out;

    public ClienteHilo(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {

        Scanner sn = new Scanner(System.in);
        
        String mensaje;
        Float mensaje2;
        int opcion = 0;
        boolean salir = false;

        while (!salir) {

            try {
                ventana.setTitle("Cliente");
                ventana.setVisible(true);
                ventana.add(dado);
                ventana.add(cosa);
                ventana.add(txtTexto);
                txtTexto.setColumns(1);
                txtTexto.setRows(1);
                
                dado.addActionListener(new ActionListener() {
                @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                    numero=JOptionPane.showInputDialog(null, "Digite la ecuación: ");
                    try {
                        out.writeUTF(numero);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    }
                });
                mensaje=in.readUTF();
                System.out.println(mensaje+" el supuesto mensaje");
                txtTexto.append(mensaje);
                txtTexto.append("\n");
                mensaje2=in.readFloat();
                String s=Float.toString(mensaje2); 
                System.out.println(mensaje2+" el supuesto mensaje 2");
                txtTexto.append(s);
                txtTexto.append("\n");
                
                
                
            } catch (IOException ex) {
                Logger.getLogger(ClienteHilo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
    
    public int generaNumeroAleatorio(int minimo,int maximo){
       int num=(int)Math.floor(Math.random()*(maximo-minimo+1)+(minimo));
       return num;
   }
}
