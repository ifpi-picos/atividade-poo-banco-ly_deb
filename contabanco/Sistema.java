package contabanco;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Sistema {
    
    static Scanner scan = new Scanner(System.in);
    static Random random =  new Random();
    static DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static ArrayList<Conta> contasBancarias;
    static ArrayList<ContaCorrente> contaBacariaCorrentes;
    static ArrayList<ContaPoupanca> contaBacariaPoupancas;
        
        public static void main(String[] args){
            contasBancarias = new ArrayList<>();
            contaBacariaCorrentes = new ArrayList<>();
            contaBacariaPoupancas = new ArrayList<>();
            operacoes();
        }

        public static void operacoes(){
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
            scan.nextLine();
    
            switch(operacao){
                case 1:
                    criarConta();
                    break;
                case 2:
                    deposita(); 
                    break;
                case 3:
                    sacar();
                    break;
                case 4:
                    transferir(); 
                    break;
                case 5:
                    consultarsaldo();
                    break;
                case 6:
                    System.out.println("Obrigado por usar nossa agencia");
                    System.exit(0);
                default:
                    System.out.println("Opção invalida!");
                    operacoes();
                    break; 
            }
        }

        public static void criarConta(){
            Cliente man = new Cliente();
            System.out.print("\nNome: ");
            String nomeCliente = scan.nextLine();
    
            System.out.print("\nCPF: ");
            String cpft = scan.nextLine();

            if (man.checaCPF(cpft).equals("V")){

            }else if(man.checaCPF(cpft).equals("Il")){
                System.out.println("CPF invalido.");
                operacoes();
            }else if(man.checaCPF(cpft).equals("In")){
                System.out.println("Quantidade de números invalido.");
                operacoes();
            }else{
                System.out.println("Quantidade de números invalida, não utilize simbolos!!");
                operacoes();
            }

            String cpf = cpft;

            System.out.println("\nData de nascimento: ");
            LocalDate data = LocalDate.parse(scan.nextLine(), sdf);

            if(man.checaData(data).equals("Y")){

            }else if (man.checaData(data).equals("M")){
                System.out.println("Menor de idade!");
                operacoes();
            }else {
                System.out.println("Dara de nascimento invalida!");
                operacoes();
            }

            LocalDate dataDeNasc = data;

            System.out.println("\nNome da Rua: ");
            String rua = scan.nextLine();

            System.out.println("\nNome do bairro: ");
            String bairro = scan.nextLine();

            System.out.println("\nNúmero da casa: ");
            int numCasa = scan.nextInt();
            scan.nextLine();

            System.out.println("Qual o tipo de Conta?");
            System.out.println("\n1- Poupança  2- Corrente");
            int tipo = scan.nextInt();

            System.out.println("\nO numero da Conta: ");
            int numConta = random.nextInt(99999)+10000;
            System.out.println(numConta);
            
            Endereco endereco = new Endereco(rua, numCasa, bairro);
            Cliente cliente = new Cliente(nomeCliente, dataDeNasc, cpf, endereco);
            if(tipo == 1){
                int numAgencia = 3456;
                double saldo = 0.00f;
                ContaPoupanca conta = new ContaPoupanca(numAgencia, numConta, saldo, cliente);

                System.out.println(cliente.toString());
                System.out.println(conta.toString());

                contaBacariaPoupancas.add(conta);

                operacoes();
            }else if(tipo == 2){
                int numAgencia = 3478;
                double saldo =  0.00f;
                ContaCorrente conta = new ContaCorrente(numAgencia, numConta, saldo, cliente);

                System.out.println(cliente.toString());
                System.out.println(conta.toString());
                
                contaBacariaCorrentes.add(conta);

                operacoes();
            }else{
                System.out.println("Error");
                criarConta();
            }  
            System.out.println("Sua conta foi Criada com Sucesso!");
            operacoes();
        }
      

        private static Conta encotraConta(int numConta){
            Conta conta = null;
            if(contasBancarias.size() > 0 ){
                for(Conta c : contasBancarias){
                    if(c.getNumConta() == numConta){
                        conta = c;
                    }
                }
            }
            return conta;
        }

        public static void deposita(){

            System.out.println("Numero da Conta para Deposito: ");
            int numConta = scan.nextInt();
            scan.nextLine();
            Conta conta = encotraConta(numConta);

            if(conta != null){
                System.out.println("Valor do Deposito: ");
                double valorDeposito = scan.nextDouble();
                conta.depositar(valorDeposito);
                System.out.println("Valor depositado com sucesso!");
            } else {
                System.out.println("Conta não encontrada!");
            } 
            operacoes();
        } 

        public static void sacar(){

            System.out.println("Digite o Numero da conta: ");
            int numConta = scan.nextInt();

            Conta conta = encotraConta(numConta);

            if(conta != null){

                System.out.println("Valor para saque: ");
                double valorSaque = scan.nextDouble();
                conta.sacar(valorSaque);

                System.out.println("Saque Realizado com sucessor!");
            }else{
                System.out.println("Saque Realizado com sucessor!");
            }
            operacoes();
        }

        public static void transferir(){
            System.out.println("Numero da conta do remetente:");
            int numContaRem = scan.nextInt();

            Conta contaRem = encotraConta(numContaRem);

            if(contaRem != null){
                System.out.println("Numero da conta do destinatariio: ");
                int numContaDes = scan.nextInt();

                Conta contaDes = encotraConta(numContaDes);

                if(contaDes != null){
                    System.out.println("Valor da transferencia: ");
                    double valor = scan.nextDouble();

                    System.out.println("\nTransferindo de: " + contaRem.toStringpub());
                    System.out.println("\npara: " + contaDes.toStringpub());

                    System.out.println("\nContirma a Transferencia aperte[1] ou sair[0]? ");
                    int resp = scan.nextInt();

                    if(resp == 1){
                        contaRem.transferir(contaDes, valor);
                    } else {
                        operacoes();
                    }
                }
            }
            operacoes();  
        }

        public static void consultarsaldo(){
            System.out.println("Digite o numero da Conta: ");
            int numConta = scan.nextInt();
          
            Conta contaExtrato = encotraConta(numConta);

            if(contaExtrato != null){
                System.out.println("\nSaldo da Conta: ");
                System.out.println(contaExtrato.getSaldo());
            } else {
                System.out.println("Conta não encontrada! ");
            }
            operacoes();
        }
    
}