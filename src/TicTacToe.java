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
            botones[i].setFont(new Font("Bradley Hand ITC", Font.ITALIC, 100));
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
        //checkear si gana X:
        //Condiciones horizontales
        if (
                (botones[0].getText() == "X") &&
                        (botones[1].getText() == "X") &&
                        (botones[2].getText() == "X")
        ) {
            xGana(0, 1, 2);
        }

        if (
                (botones[3].getText() == "X") &&
                        (botones[4].getText() == "X") &&
                        (botones[5].getText() == "X")
        ) {
            xGana(3, 4, 5);
        }

        if (
                (botones[6].getText() == "X") &&
                        (botones[7].getText() == "X") &&
                        (botones[8].getText() == "X")
        ) {
            xGana(6, 7, 8);
        }

        // Condiciones verticales.
        if (
                (botones[0].getText() == "X") &&
                        (botones[3].getText() == "X") &&
                        (botones[6].getText() == "X")
        ) {
            xGana(0, 3, 6);
        }

        if (
                (botones[1].getText() == "X") &&
                        (botones[4].getText() == "X") &&
                        (botones[7].getText() == "X")
        ) {
            xGana(1, 4, 7);
        }

        if (
                (botones[2].getText() == "X") &&
                        (botones[5].getText() == "X") &&
                        (botones[8].getText() == "X")
        ) {
            xGana(2, 5, 8);
        }

        //Condiciones Diagonales
        if (
                (botones[0].getText() == "X") &&
                        (botones[4].getText() == "X") &&
                        (botones[8].getText() == "X")
        ) {
            xGana(0, 4, 8);
        }

        if (
                (botones[2].getText() == "X") &&
                        (botones[4].getText() == "X") &&
                        (botones[6].getText() == "X")
        ) {
            xGana(2, 4, 6);
        }

        //Checkear si gana O:
        //Condiciones horizontales
        if (
                (botones[0].getText() == "O") &&
                        (botones[1].getText() == "O") &&
                        (botones[2].getText() == "O")
        ) {
            oGana(0, 1, 2);
        }

        if (
                (botones[3].getText() == "O") &&
                        (botones[4].getText() == "O") &&
                        (botones[5].getText() == "O")
        ) {
            oGana(3, 4, 5);
        }

        if (
                (botones[6].getText() == "O") &&
                        (botones[7].getText() == "O") &&
                        (botones[8].getText() == "O")
        ) {
            oGana(6, 7, 8);
        }

        //Condiciones verticales
        if (
                (botones[0].getText() == "O") &&
                        (botones[3].getText() == "O") &&
                        (botones[6].getText() == "O")
        ) {
            oGana(0, 3, 6);
        }

        if (
                (botones[1].getText() == "O") &&
                        (botones[4].getText() == "O") &&
                        (botones[7].getText() == "O")
        ) {
            oGana(1, 4, 7);
        }

        if (
                (botones[2].getText() == "O") &&
                        (botones[5].getText() == "O") &&
                        (botones[8].getText() == "O")
        ) {
            oGana(2, 5, 8);
        }

        //Condiciones diagonales
        if (
                (botones[0].getText() == "O") &&
                        (botones[4].getText() == "O") &&
                        (botones[8].getText() == "O")
        ) {
            oGana(0, 4, 8);
        }

        if (
                (botones[2].getText() == "O") &&
                        (botones[4].getText() == "O") &&
                        (botones[6].getText() == "O")
        ) {
            oGana(2, 4, 6);
        }
        // Condiciones de empate, si todos los botones tienen texto y el area de texto es distinto de cualquiera de los dos "ganó" llama al metodo empatar.
        if(
                (botones[0].getText() !="") &&
                        (botones[1].getText() !="") &&
                        (botones[2].getText() !="") &&
                        (botones[3].getText() !="") &&
                        (botones[4].getText() !="") &&
                        (botones[5].getText() !="") &&
                        (botones[6].getText() !="") &&
                        (botones[7].getText() !="") &&
                        (botones[8].getText() !="") &&
                        (area_de_texto_turno.getText() != "Gano X!") &&
                        (area_de_texto_turno.getText() != "Gano O!")
        ) {
            empate();
        }
    }
    public void xGana(int x, int y, int z){
        botones[x].setBackground(Color.GREEN);
        botones[y].setBackground(Color.GREEN);
        botones[z].setBackground(Color.GREEN);

        for (int i = 0 ; i<9 ; i++){
            botones[i].setEnabled(false); //Hacemos que los botones estén deshabilitados para que no se pueda presionar más.
        }
        area_de_texto_turno.setText("Gano X!");
    }
    public void oGana(int x, int y, int z){
        botones[x].setBackground(Color.GREEN);
        botones[y].setBackground(Color.GREEN);
        botones[z].setBackground(Color.GREEN);

        for (int i = 0 ; i<9 ; i++){
            botones[i].setEnabled(false); //Hacemos que los botones estén deshabilitados para que no se pueda presionar más
        }
        area_de_texto_turno.setText("Gano O!");
    }
    public void empate(){
        for (int i = 0 ; i<9 ; i++){
            botones[i].setEnabled(false);//Hacemos que los botones estén deshabilitados para que no se pueda presionar más
            botones[i].setBackground(Color.RED); // Hacemos toda la grilla roja porque ninguno ganó
        }
        area_de_texto_turno.setText("Empate :(");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //En este for evaluamos boton por boton y vamos cambiando de turno, al terminar de cambiar de turno checkeamos si alguno de los dos gana.
        for (int i = 0 ; i<9 ; i++){
            if(e.getSource() == botones[i]){ //Si se presiona el boton entonces va preguntando si esta vacio ese boton y demás cosas.
                if(turno1){
                    if(botones[i].getText() == ""){ //Solo si no hay ningún texto pone la X
                        botones[i].setForeground(new Color(255,0,0));
                        botones[i].setText("X");
                        turno1 = false;
                        area_de_texto_turno.setText("Turno de O");
                        Revisar();
                    }
                }
                else{
                    if(botones[i].getText() == ""){ //Solo si no hay ningún texto pone la O
                        botones[i].setForeground(new Color(0,0,255));
                        botones[i].setText("O");
                        turno1 = true;
                        area_de_texto_turno.setText("Turno de X");
                        Revisar();
                    }
                }
            }
        }
    }
}