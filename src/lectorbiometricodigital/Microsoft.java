/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lectorbiometricodigital;

import java.util.Random;

/**
 *
 * @author ivanb
 */
public class Microsoft extends Biometrico {
    private boolean errorLectura = false;
    private String data = "";

    @Override
    public void onHuella() {
        System.out.println("Microsoft: La huella es colocada en el sensor, se apaga la luz.");
        System.out.println("Microsoft: Se enciende el lector.");
        
        Random random = new Random();
        errorLectura = random.nextBoolean(); // Simula un error aleatorio en la lectura

        if (errorLectura) {
            System.out.println("Microsoft: Error en la lectura.");
        } else {
            System.out.println("Microsoft: Lectura exitosa.");
        }
    }

    @Override
    public void onMuestra() {
        if (!errorLectura) {
            data = "Datos de la huella en formato String";
            System.out.println("Microsoft: Lectura extraída - " + data);
        } else {
            System.out.println("Microsoft: No se pudo extraer la lectura debido a un error.");
        }
    }

    @Override
    public void outHuella() {
        if (errorLectura) {
            System.out.println("Microsoft: No se puede procesar la huella debido a un error de lectura.");
        } else {
            if (data.isEmpty()) {
                throw new RuntimeException("Microsoft: No hay datos para procesar.");
            } else {
                System.out.println("Microsoft: Procesando datos de la huella.");
            }
        }
        System.out.println("Microsoft: El led del sensor está encendido y el lector está apagado.");
    }
}
