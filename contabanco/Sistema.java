package contabanco;
import java.util.Scanner;

public class Sistema {
    
    static Scanner scan = new Scanner(System.in);
        
    
        public static void operacoes(){
    
            System.out.println("-----------------------------------------");
            System.out.println("-------------------mesagem---------------");
            System.out.println("-----------------------------------------");
            System.out.println("Selecione uma operação que deseja realisar");
            System.out.println("-----------------------------------------");
            System.out.println("|      Opção 1 - Criar Conta     |");
            System.out.println("|      Opção 2 - Depositar       |");
            System.out.println("|      Opção 3 - Sacar           |");
            System.out.println("|      Opção 4 - Transferir      |");
            System.out.println("|      Opção 5 - Consultar Saldo |");
            System.out.println("|      Opção 6 - Sair            |");
            System.out.println("-----------------------------------------");
            
            int operacao = scan.nextInt();
    
            switch(operacao){
                case 1:
                    criarConta();
                    break;
                case 2:
                    //deposita(); 
                    break;
                case 3:
                    //sacar();
                    break;
                case 4:
                    //transferir(); 
                    break;
                case 5:
                    //consultarsaldo();
                    break;
                case 6:
                    //sair(); 
                    System.out.println("Obrigado por usar nossa agencia");
                    System.exit(0);
                default:
                    System.out.println("Opção invalida!");
                    operacoes();
                    break; 
    
            }
    
        }
        public static void criarConta(){
            System.out.println("\nNome: ");
            String nomeCliente = scan.next();
    
            System.out.println("\nCPF: ");
            String cpf = scan.next();
    
    
            operacoes();
        } 
    
}
