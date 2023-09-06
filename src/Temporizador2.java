import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Temporizador2 {
    public static void main(String[] args) {
        Reloj miReloj = new Reloj(3000, true);

        miReloj.ejecutarTemporizador();

        JOptionPane.showMessageDialog(null, "Pulsa aceptar para terminar");
    }

}

class Reloj {

    private int intervalo;
    private boolean sonido;

    public Reloj(int intervalo, boolean sonido) {
        this.intervalo = intervalo;
        this.sonido = sonido;

    }

    public void ejecutarTemporizador() {

        ActionListener oyente = new DameLaHora();

        Timer miTemporizador = new Timer(intervalo, oyente);

        miTemporizador.start();

    }

    // Clase interna
    // El modificador private solo se puede poner a una clase si es interna
    private class DameLaHora implements ActionListener {

        public DameLaHora() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Date ahora = new Date();

            System.out.println("Te pongo la hora cada 3 segundos: " + ahora);
            // Podemos acceder a la variable privada sonido que pertenece a la clase reloj porque las clases internas
            // tienen acceso a todas las variables y metodos del ambito de clase en el que estan, en este caso dentro
            // de la clase reloj.
            if (sonido) Toolkit.getDefaultToolkit().beep();
        }
    }

}
