/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lectorbiometricodigital;

/**
 *
 * @author ivanb
 */
public class AppTest {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        // Prueba con Microsoft
        System.out.println("Prueba con Microsoft:");
        Biometrico microsoft = new Microsoft();
        microsoft.onHuella();
        microsoft.onMuestra();
        try {
            microsoft.outHuella();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        // Prueba con DigitalPersona
        System.out.println("Prueba con DigitalPersona:");
        Biometrico digitalPersona = new DigitalPersona();
        digitalPersona.onHuella();
        digitalPersona.onMuestra();
        try {
            digitalPersona.outHuella();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
