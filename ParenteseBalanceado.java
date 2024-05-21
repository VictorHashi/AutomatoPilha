import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Stack;

public class ParenteseBalanceado {

    public static void main(String[] args) {
        String cadeia;
        char[] alphabet = new char[]{'(', ')'};
        Stack<Character> pilha = new Stack<Character>();


        System.out.println("Informar cadeia: ");
        Scanner scan = new Scanner(System.in);

        cadeia = scan.next();
        while (!checkAlphabet(alphabet,cadeia.toCharArray())) {
            System.out.println("Cadeia não corresponde ao alfabeto, informe novamente: ");
            cadeia = scan.next();
        }

        System.out.println("A cadeia de parêntese está "+ (verify(pilha,cadeia.toCharArray())?"balanceada":"desbalanceada"));

    }

    public static boolean checkAlphabet(char[] alphabet, char[] cadeia){
        boolean found;
        for (Character caractere: cadeia) {
            found = false;
            for (Character symbol: alphabet) {
                if (caractere==symbol){
                    found = true;
                    break;
                }
            }
            if (!found)
                return false;
        }
        return true;
    }

    public static boolean verify(Stack<Character> pilha, char[] cadeia){

        for (Character caractere: cadeia) {

            if (caractere == '('){
                pilha.push('(');
                continue;
            }

            if (caractere == ')'){
                if (!pilha.isEmpty())
                    if (pilha.peek() == '(')
                        pilha.pop();
                    else
                        pilha.push(')');
                else pilha.push(')');
            }

        }

        return pilha.isEmpty();
    }

}
