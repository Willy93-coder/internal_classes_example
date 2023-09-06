import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class InternalLocalClass {

    public static void main(String[] args) {
        Reloj2 miReloj2 = new Reloj2();

        miReloj2.ejecutarTemporizador(3000, true);

        JOptionPane.showMessageDialog(null, "Pulsa aceptar para terminar");
    }

}

class Reloj2 {

    public void ejecutarTemporizador(int intervalo, boolean sonido) {

        // Clase interna local
        // No pueden llevar modificador de acceso
        class DameLaHora implements ActionListener {

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

        ActionListener oyente = new DameLaHora();

        Timer miTemporizador = new Timer(intervalo, oyente);

        miTemporizador.start();

    }
}
