package proves;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class LecturaDades {
    public static void main(String[] args) {


        BufferedReader bfLector = null;
        try {
            //Concatenem el directori actual amb un subdirectori "dades" i afegim el fitxer "03021911.DAT"
            Path pathFitxer = Paths.get("C:", "M02", "02201606_MESA", "07021606.DAT");

            //objReader = new BufferedReader(new FileReader(pathFitxer.toString()));

            bfLector = Files.newBufferedReader(pathFitxer, StandardCharsets.ISO_8859_1);
            String strLinia;
            while ((strLinia = bfLector.readLine()) != null) {
                System.out.println(strLinia);
            }

        } catch (IOException e) {
            e.printStackTrace();
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
