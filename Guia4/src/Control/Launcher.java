package Control;

import Control.Gestores.GestorBienvenida;

public class Launcher {

    public static void main(String[] args) {
         GestorBienvenida gestor = new GestorBienvenida();
        
        gestor.iniciar();
    }
    
}
