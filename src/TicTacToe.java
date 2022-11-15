import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe extends JFrame implements ActionListener {
    JPanel panel1 = new JPanel();
    JFrame frame = new JFrame(); //La ventana donde luego agregamos los paneles
    JPanel panel_titulo = new JPanel(); //Iremos separando en paneles segun el contenido de cada uno de ellos, a este luego le agregaremos el área de texto.
    JLabel area_de_texto = new JLabel(); //Nos dirá quien gana y el título del juego
    JLabel area_de_texto_turno = new JLabel(); //El texto donde nos dice de quien es el turno.
    JPanel panel_botones = new JPanel(); //Lo mismo que panel_titulo, pero para separar el texto de los botones.
    JButton[] botones = new JButton[9]; //Sabiendo que si o si tenemos 9 botones podemos hacer un arreglo de 9 botones y luego agregarlo al panel_botones.
    boolean turno1; //Al ser un booleano solo con un turno ya tenemos dos posibilidades.
    Random rdm = new Random(); //Para determinar de quien va a ser el turno, ya que nada condiciona que ninguno sea primero que el otro.


    //Constructor.
    public TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.setTitle("Tres en raya! by Zimmerman y Kennedy");

        panel_titulo.setLayout(new BorderLayout());
        panel_titulo.setBounds(0,0,800,100);

        area_de_texto.setBackground(new Color(37, 37, 37));
        area_de_texto.setForeground(new Color(18, 213, 2, 255));
        area_de_texto.setFont(new Font("04b", Font.BOLD,40));
        area_de_texto.setHorizontalAlignment(JLabel.CENTER);
        area_de_texto.setText("Tres en Raya!!");
        area_de_texto.setOpaque(true);

        area_de_texto_turno.setBackground(new Color(37, 37, 37));
        area_de_texto_turno.setForeground(new Color(144, 236, 139, 255));
        area_de_texto_turno.setFont(new Font("04b", Font.BOLD,40));
        area_de_texto_turno.setHorizontalAlignment(JLabel.CENTER);
        area_de_texto_turno.setOpaque(true);

        panel_botones.setLayout(new GridLayout(3,3)); //Hacemos que administre con grid layout para que se distribuya mejor
        panel_botones.setBackground(new Color(37,37,37));

        for (int i = 0; i<9; i++){
            botones[i] = new JButton();
            panel_botones.add(botones[i]);
            botones[i].setFont(new Font("OCR-A BT", Font.ITALIC, 100));
            botones[i].setFocusable(false);
            botones[i].addActionListener(this);
        }

        panel_titulo.add(area_de_texto, BorderLayout.NORTH);
        panel_titulo.add(area_de_texto_turno, BorderLayout.SOUTH);
        frame.add(panel_titulo, BorderLayout.SOUTH);
        frame.add(panel_botones);

        primerTurno();
    }

    //Métodos para la lógica del juego.
    public void primerTurno(){
        // Establece con un límite de 2 valores posibles y si ese valor generado es
        // igual a O entonces es el turno de X si no, el turno de O.
        if(rdm.nextInt(2) == 0){
            turno1 = true;
            area_de_texto_turno.setText("Turno de X");
        }else {
            turno1= false;
            area_de_texto_turno.setText("Turno de O");
        }
    }
    public void Revisar(){
    }
    public void ganoX(int x, int y, int z){
        botones[x].setBackground(Color.GREEN);
        botones[y].setBackground(Color.GREEN);
        botones[z].setBackground(Color.GREEN);

        for (int i = 0 ; i<9 ; i++){
            botones[i].setEnabled(false); //Hacemos que los botones estén deshabilitados para que no se pueda presionar más.
        }
        area_de_texto_turno.setText("Gano X!");
    }
    public void ganoO(int x, int y, int z){
        botones[x].setBackground(Color.GREEN);
        botones[y].setBackground(Color.GREEN);
        botones[z].setBackground(Color.GREEN);

        for (int i = 0 ; i<9 ; i++){
            botones[i].setEnabled(false); //Hacemos que los botones estén deshabilitados para que no se pueda presionar más
        }
        area_de_texto_turno.setText("Gano O!");
    }
    public void empate(){
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
