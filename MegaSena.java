package metodos;

import java.util.Random;
import java.util.Scanner;

public class MegaSena {

  public static void main(String[] args) {

    
    int[] aposta = new int[6];
    int sorteio[] = new int[6];

    leraposta(aposta);
    lersorteio(sorteio);
    imprimir(aposta);
  }

  public static void lersorteio(int sorteio[]) {
    Random gerador = new Random();
    for (int i = 0; i < sorteio.length;) {
      sorteio[i] = gerador.nextInt(60) + 1; // entre 1 e 60
      
      // verifica se tem repetição
      if (verificarDuplicacao(sorteio, i) == false) {
        i++;
      }
    }
  }

  public static void leraposta(int[] aposta) {
    Scanner teclado = new Scanner(System.in);
    for (int i = 0; i < aposta.length;) { // verificando repetição
      // faz a entrada de dados
      do { 
        System.out.print("Informe a aposta (1-60) --> ");
        aposta[i] = teclado.nextInt();
        if (aposta[i] > 60 || aposta[i] < 1) {
          System.out.print("Você digitou um valor que não foi atribuido, digite novamente entre 1 e 60 --> ");
          aposta[i] = teclado.nextInt();
        }
      } while (aposta[i] > 60 || aposta[i] < 1); // enquanto

      // verificar se tem alguma repetição
      if (verificarDuplicacao(aposta, i) == false) {
        i++;
      }
    }
  }

  public static boolean verificarDuplicacao(int[] aposta, int i) {
    boolean aux = false;
    for (int j = 0; j < i; j++) { 
      if (aposta[j] == aposta[i]) {
        aux = true;
      }
    }

    return aux;
  }

  public static void imprimir(int[] aposta) {
    System.out.println();
    for (int i = 0; i < aposta.length; i++) {
      System.out.print(aposta[i] + "\t");
    }
  }

}
