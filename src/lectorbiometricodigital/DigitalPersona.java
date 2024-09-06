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
public class DigitalPersona extends Biometrico {
     private boolean ledAzul = true;
    private boolean ledRojo = false;
    private boolean lectorEncendido = false;
    private boolean errorLectura = false;
    private String data = "";
    
    public DigitalPersona() {
        // Estado inicial
        System.out.println("DigitalPersona: ledAzul encendido, ledRojo apagado, lector apagado, errorLectura apagado.");
    }

    @Override
    public void onHuella() {
        // Apagar el ledAzul y encender el ledRojo
        ledAzul = false;
        ledRojo = true;
        System.out.println("DigitalPersona: ledAzul apagado, ledRojo encendido.");
    }

    @Override
    public void onMuestra() {
        // Simular si hubo error en la lectura
        Random random = new Random();
        errorLectura = random.nextBoolean();

        if (!errorLectura) {
            data = "Datos de la huella en formato String";
            System.out.println("DigitalPersona: Lectura exitosa - " + data);
        } else {
            System.out.println("DigitalPersona: Error en la lectura.");
        }
    }

    @Override
    public void outHuella() {
        if (errorLectura) {
            throw new RuntimeException("DigitalPersona: Error en la lectura, no se puede procesar.");
        }

        // Encender el ledAzul y apagar el ledRojo y el lector
        ledAzul = true;
        ledRojo = false;
        lectorEncendido = false;
        System.out.println("DigitalPersona: ledAzul encendido, ledRojo apagado, lector apagado.");
    }
}
