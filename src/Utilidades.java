import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilidades {

    public static int lerInteiro() {

        Scanner scanner = new Scanner(System.in);
        int flag = 1, var = 0;

        do {
            try {
                var = scanner.nextInt();
                flag = 0;
            }catch (InputMismatchException err) {
                System.out.println("Digite um valor inteiro válido");
                scanner.nextLine();
            }
        } while(flag == 1) ;

        return var;

    }

    public static double lerDouble() {

        Scanner scanner = new Scanner(System.in);
        int flag = 1;
        double var = 0;

        do {
            try {
                var = scanner.nextDouble();
                flag = 0;
            }catch (InputMismatchException err) {
                System.out.println("Digite um valor válido");
                scanner.nextLine();
            }
        } while(flag == 1) ;

        return var;

    }

}
