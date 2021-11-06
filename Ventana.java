package ejercicio_sockets_ddr_8;
import javax.swing.JFrame;


import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;




/**
 * Crea la clase ventana.
 * Esta clase permite crear la ventana del cliente
 */

public class Ventana extends JFrame{

    public Ventana(){
        this.setSize(650,650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2,2,0,0));
        //jScrollPane1.setViewportView(txtTexto);
    }
    
}
