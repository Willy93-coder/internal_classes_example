import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class InternalAnonymousClass {

}

class reloj3 {

    public void ejecutarTemporizador(int intervalo, boolean sonido) {

        Timer miTemporizador = new Timer(intervalo, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date ahora = new Date();

                System.out.println("Te pongo la hora cada 3 segundos: " + ahora);

                if (sonido) Toolkit.getDefaultToolkit().beep();
            }
        });

        miTemporizador.start();
    }

}
