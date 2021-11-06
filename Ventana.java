package ejercicio_sockets_ddr_8;
import javax.swing.JFrame;


import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;



import java.util.Random;


public class Ventana extends JFrame{
    JButton dado=new JButton("DADO");
    JTextArea txtTexto=new JTextArea();
    //javax.swing.JScrollPane jScrollPane1;
    
    Random generador=new Random();
    
    int moverse;

    public Ventana(){
        this.setSize(650,650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2,2,0,0));
        //jScrollPane1.setViewportView(txtTexto);
    }
    
}
