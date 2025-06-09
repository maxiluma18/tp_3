package logica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
			while (fila < x) {
				
				linea = br.readLine();
			    String[] valores = linea.trim().split(";");
			    for (int columna = 0; columna < valores.length && columna<y; columna++) {
			        int valor = Integer.parseInt(valores[columna].trim());
			        System.out.println(valor +" VALOR " + "COLUMNA " + columna + " FILA " + fila);
			        tablero.setearValorTablero(columna, fila, valor);
			    }
			    
			    fila++;
			    
			
			}
		} catch (IOException | NumberFormatException e) {
			System.err.println("Error leyendo el archivo: " + e.getMessage());
		}

		return tablero;
	}
}
