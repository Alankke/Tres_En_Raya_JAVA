import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe extends JFrame implements ActionListener {
    JFrame frame = new JFrame(); //La ventana donde luego agregamos los paneles
    JPanel panel_titulo = new JPanel(); // Iremos separando en paneles segun el contenido de cada uno de ellos, a este luego le agregaremos el área de texto
    JLabel area_de_texto = new JLabel(); //El texto donde nos dice de quien es el turno
    JPanel panel_botones = new JPanel(); //Lo mismo que panel_titulo, pero para separar el texto de los botones
    JButton[] botones = new JButton[9]; //Sabiendo que si o si tenemos 9 botones podemos hacer un arreglo de 9 botones y luego agregarlo al panel_botones
    boolean turno1; // Solo con un turno ya tenemos dos posibilidades al ser un booleano
    Random rdm = new Random(); // Para determinar de quien va a ser el turno, ya que nada condiciona que ninguno sea primero que el otro


    //Constructor
    public TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500); //Establece el tamaño de la ventana
        frame.setVisible(true); //Indispensable si no, no existe la ventana
        frame.setLocationRelativeTo(null); //Posiciona la ventana en el centro de la pantalla
        frame.setLayout(new BorderLayout()); //Usamos un border layout para organizar en puntos cardinales la ventana
        frame.setTitle("Tres en raya! by Zimmerman y Kennedy"); //El textito de la ventana

        panel_titulo.setBounds(0,0,800,100); //Limites del panel_titulo


    }

    //Métodos para la lógica del juego
    @Override
    public void actionPerformed(ActionEvent e) {
    }
    public void primerTurno(){
    }
    public void Revisar(){
    }
    public void ganoX(int x, int y, int z){
    }
    public void ganoO(int x, int y, int z){
    }
    public void empate(){
    }
}
