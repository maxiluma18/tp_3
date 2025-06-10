package logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class Archivo {

	public static TableroElectronico cargarDesdeArchivo(String rutaArchivo) {
		TableroElectronico tablero = null;
		 int x = 0, y = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
			String linea = br.readLine();
		
			if (linea != null) {
				String[] partes = linea.split(";");
						 x = Integer.parseInt(partes[0].trim());
						 y = Integer.parseInt(partes[1].trim());
						
			}
			 tablero = new TableroElectronico(x,y);

			
			int fila = 0;
			linea = br.readLine();
			while (fila < x) {
			    String[] valores = linea.trim().split(";");
			    for (int columna = 0; columna < valores.length && columna<y; columna++) {
			        int valor = Integer.parseInt(valores[columna].trim());
			        tablero.setearValorTablero(fila,columna, valor);
			    }
			    fila++;
			
			}
		} catch (IOException | NumberFormatException e) {
			System.err.println("Error leyendo el archivo: " + e.getMessage());
		}

		return tablero;
	}
	public static String elegirArchivoDesdeCarpeta(String carpeta) {
		JFileChooser chooser = new JFileChooser(new File(carpeta));
		chooser.setDialogTitle("Seleccionar archivo de grilla");
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setAcceptAllFileFilterUsed(true);

		int resultado = chooser.showOpenDialog(null);
		if (resultado == JFileChooser.APPROVE_OPTION) {
			File archivoSeleccionado = chooser.getSelectedFile();
			return archivoSeleccionado.getAbsolutePath();
		}
		return null;
	}
}
