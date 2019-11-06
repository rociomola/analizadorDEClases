import java.util.Arrays;

public class Analizador {
	private static final int NUM_TAMANOS = 10;
	private static final int NUM_PRUEBA_TAMANOS = 10;
	/*
	 * NOTA IMPORTANTE
	 * 
	 * Esta clase se proporciona solamente para ilustrar el formato de salida que
	 * deberia tener la solucion a este ejericio. Esta clase debe modificarse
	 * completamente para cumplir m√≠nimamente los requisitos de esta practica.
	 * Notese que ni siquiera esta completa......
	 */

	public static String masCercano(double ratio) {// estos ratios estan sacados de hacer la division de el doble de
													// entrada y la entrada normal
		if (ratio < 1.5) { // aprox 1.0
			return "1";
		} else if (1 <= ratio && ratio < 3.0) { // aprox 2.0
			return "N";
		} else if (3 <= ratio && ratio < 6.0) { // aprox 4.0
			return "N2";
		} else if (6 <= ratio && ratio < 10.0) { // aprox 8.0
			return "N3";
		} else { // otras
			return "NF";
		}
	}

	public static void main(String arg[]) {
		int[] tamanos = new int[NUM_TAMANOS];
		long[] tiempos1 = new long[NUM_TAMANOS];// tiempos de n1
		long[] tiempos2 = new long[NUM_TAMANOS];// tiempos de n2
		double[] ratio = new double[NUM_TAMANOS];// division
		for (int i = 0; i < NUM_TAMANOS; i++) {// con esto eleginos el tamaÒo de las pruebas
			tamanos[i] = (i + 1) * 1000;
		}
		Temporizador t = new Temporizador();
		for (int i = 0; i < NUM_TAMANOS; i++) {
			int n1 = tamanos[i];
			int n2 = 2 * n1;
			long minimo1 = Long.MAX_VALUE;
			long minimo2 = Long.MAX_VALUE;
			for (int j = 0; i < NUM_PRUEBA_TAMANOS; i++) {
				t.reiniciar();
				t.iniciar();
				Algoritmo.f(n1);
				t.parar();
				if (t.tiempoPasado() < minimo1)
					minimo1 = t.tiempoPasado();
				t.reiniciar();
				t.iniciar();
				Algoritmo.f(n2);
				t.parar();

				minimo2 = Math.min(minimo2, t.tiempoPasado());
				tiempos1[i] = minimo1;
				tiempos2[i] = minimo2;
				ratio[i] = (double) tiempos1[i] / tiempos2[i];
			}
		} // solo dejar el tipo para el analizador
		System.out.println("entrada1;" + Arrays.toString(tamanos));
		System.out.println("Tiempo de entrada1;" + Arrays.toString(tiempos1));
		System.out.println("Tiempo de entrada2;" + Arrays.toString(tiempos2));
		System.out.println("Tiempo de ratios;" + Arrays.toString(ratio));
		 System.out.println(masCercano(ratio[NUM_TAMANOS-1]));

	}
}
