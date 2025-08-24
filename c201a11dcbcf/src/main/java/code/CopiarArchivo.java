
package code;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopiarArchivo {
    public static void main(String[] args) {
        // Obtener la ruta absoluta de la raíz del proyecto
        String basePath = System.getProperty("user.dir") + "/target";

        String origen = basePath + "/message.dat";
        String destino = basePath + "/new.dat";

        try (FileInputStream fis = new FileInputStream(origen);
             FileOutputStream fos = new FileOutputStream(destino)) {

            int byteLeido;
            while ((byteLeido = fis.read()) != -1) {
                fos.write(byteLeido);
            }

            System.out.println("Archivo copiado exitosamente a " + destino);

        } catch (IOException e) {
            System.out.println("Error al copiar archivo: " + e.getMessage());
        }
    }
}
