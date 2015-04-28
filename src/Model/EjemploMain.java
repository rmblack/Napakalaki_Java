package Model;

import Test.GameTester;

public class EjemploMain {

    public static void main(String[] args) {
      final int NUM_PLAYERS = 2;
      Napakalaki game = Napakalaki.getInstance();
      GameTester test = GameTester.getInstance();
      
      // Poner el numero de jugadores con el que se quiera probar
      test.play(game, NUM_PLAYERS); 
              
    }
}