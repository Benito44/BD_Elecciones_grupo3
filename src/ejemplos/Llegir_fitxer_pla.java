package ejemplos;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
public class Llegir_fitxer_pla {
    public static void main(String[] args) {


        BufferedReader bfLector = null;
        try {
            //Directori on llegir les dades
            Path pathFitxer = Paths.get("C:", "02201606_MESA", "03021911.DAT");

            //objReader = new BufferedReader(new FileReader(pathFitxer.toString()));

            bfLector = Files.newBufferedReader(pathFitxer, StandardCharsets.ISO_8859_1);
            String strLinia;
            while ((strLinia = bfLector.readLine()) != null) {
                System.out.println(strLinia);
            }

        } catch (IOException e) {
            e.printStackTrace();
            /*
            El finally se ejecutará sí o sí, tanto de error como no.
            Si no hubo errores se ejecutará la parte del try. Si hay errores se ejecutará después del catch.
            Asegura el cierre de los recursos.Sin esto, aunque haya un error en el try los recursos seguiran activos.
             */
        } finally {
            try {
                if (bfLector != null)
                    bfLector.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
