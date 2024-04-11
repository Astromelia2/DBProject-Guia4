package Control.Gestores;

import Vista.VistaBienvenida;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestorBienvenida implements ActionListener {

    private VistaBienvenida vista;
    private GestorInstructor gestorInstructor = new GestorInstructor();
    private GestorMonitor gestorMonitor = new GestorMonitor();

    public GestorBienvenida() {
        this.vista = new VistaBienvenida();
        this.vista.btnAdmin.addActionListener(this);
        this.vista.btnUsuario.addActionListener(this);
    }

    public void iniciar() {
        // Centra la vistaBienvenida en el centro de la pantalla
        this.vista.setLocationRelativeTo(null);

        this.vista.setResizable(false);
        // Hace visible la vistaBienvenida
        this.vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.btnAdmin) {
            this.vista.setVisible(false);
            gestorInstructor.iniciar(this);
        }
        if (e.getSource() == this.vista.btnUsuario) {
            this.vista.setVisible(false);
            gestorMonitor.iniciar(this);
        }

    }

}
