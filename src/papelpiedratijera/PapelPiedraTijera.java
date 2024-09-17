/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package papelpiedratijera;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Dell-UPN
 */
public class PapelPiedraTijera {

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        PapelPiedraTijera juego = new PapelPiedraTijera();
        boolean jugarDeNuevo = true;
        int pc = 0;
        int ps = 0;

        while (jugarDeNuevo) {
            String dc = juego.datoCliente();  // Obtener dato del cliente
            String dm = juego.papelPiedraTijera();  // Obtener dato del sistema
            
            System.out.println("Cliente: " + dc + " Sistema: " + dm);
            
            // Comparar opciones y mostrar resultado
            if (dc.equals(dm)) {
                System.out.println("Empate");
            } else if ((dc.equals("piedra") && dm.equals("tijera")) ||
                       (dc.equals("tijera") && dm.equals("papel")) ||
                       (dc.equals("papel") && dm.equals("piedra"))) {
                System.out.println("Ganaste");
                pc += 1;
            } else {
                System.out.println("Perdiste");
                ps += 1;
            }

            // Preguntar si el usuario quiere jugar de nuevo
            System.out.println("Punto Cliente: "+ pc + " Puntos sistema: "+ ps);
            jugarDeNuevo = juego.jugar();

        }
        System.out.println("Gracias por jugar!");
    };
    
    private boolean jugar(){
        System.out.println("¿Quieres jugar otra vez? (si/no):");
        String sn = scanner.nextLine();
        if (sn == "si") {
            scanner.close();
            return false;
            
        }else{
            return true;
        }
    }
    
    private String datoCliente(){
        // Solicitar y registrar los datos del cliente
        System.out.println("Ingrese dato (Piedra - Papel - Tijera)");
        String dato = scanner.nextLine().toLowerCase();  // Lee una cadena de texto
        return dato;
    };
    
    private String papelPiedraTijera(){
        Random random = new Random();
        String dato = "";
        int numero = random.nextInt(3);
        switch (numero){
            case 0:
                dato = "piedra";
                break;
            case 1:
                dato = "papel";
                break;
            case 2:
                dato = "tijera";
                break;
        }
        return dato;
    };
}
