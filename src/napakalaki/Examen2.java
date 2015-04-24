// EXAMEN
package napakalaki;
import java.util.ArrayList;

public class Examen2 {
    
    // Inicializacion previa, no supone un gasto considerable de memoria
    private static Examen2[] instance = new Examen2[3];
    private Examen2() {}
    
    public static Examen2 getInstance(int i) {
        return instance[i];
    }
    
    public void run () {}
}
// FIN EXAMEN
