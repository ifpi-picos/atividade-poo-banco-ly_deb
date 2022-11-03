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
    static ArrayList<ContaCorrente> contaBacariaCorrentes;
    static ArrayList<ContaPoupanca> contaBacariaPoupancas;
        
    public static void main(String[] args){

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
                System.out.println("Data de nascimento invalida!");
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

            int numConta = random.nextInt(99999)+10000;
            
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
                ContaCorrente conta = new ContaCorrente(0, 6000.00, numAgencia, numConta, saldo, cliente);

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
       
        public static void deposita(){
            System.out.println("\nDigite o número da agência:");
            int numAgencia = scan.nextInt();

            if (numAgencia == 3456) {
                System.out.println("\nDigite o número da conta para depositar: ");
                int numConta = scan.nextInt();

                ContaPoupanca conta = encontraContaP(numConta);
                if(conta != null){
                    System.out.println("\nDigite o valor para deposito: ");
                    Double valor = scan.nextDouble();
                    conta.depositar(valor);
                }else {
                    System.out.println("\nConta não encontrada!");
                }
            } else if (numAgencia == 3478){
                System.out.println("\nDigite o número da conta para depositar: ");
                int numConta = scan.nextInt();

                Conta conta = encontraContaC(numConta);
                if (conta != null) {
                    System.out.println("\nDigite o valor para deposito: ");
                    Double valor = scan.nextDouble();
                    conta.depositar(valor);
                }else {
                    System.out.println("\nConta não encontrada!");
                }
            }else {
                System.out.println("Error");
                deposita();
            }
            operacoes();
        }

        public static void sacar(){
            System.out.println("\nDigite o número da agencia: ");
            int numAgencia = scan.nextInt();

            if(numAgencia == 3456){
                System.out.println("\nDigite o número da conta: ");
                int numConta = scan.nextInt();
                ContaPoupanca conta = encontraContaP(numConta);

                if(conta != null){

                    System.out.println("\nValor para saque: ");
                    double valorSaque = scan.nextDouble();
                    conta.sacar(valorSaque);
                }else{
                    System.out.println("Conta não encontrada!");
                }
                operacoes();
            }else if(numAgencia == 3478){
                System.out.println("\nDigite o número da conta: ");
                int numConta = scan.nextInt();
                ContaCorrente conta = encontraContaC(numConta);

                if(conta != null){
                    System.out.println("\nQual o tipo do Saque?");
                    System.out.println("\n 1 | Cheque Especial \n2 | Saldo da Conta");
                    int resp = scan.nextInt();

                    System.out.println("\nValor para saque: ");
                    double valorSaque = scan.nextDouble();
                    if(resp == 1){
                        conta.sacarCheque(valorSaque);
                    }else if(resp == 2){
                        conta.sacar(valorSaque);
                    }
                    System.out.println("Saque Realizado com sucessor!");
                }else{
                    System.out.println("\nConta não encontrda");
                }
                operacoes();
            }else{
                System.out.println("\nAgência não encontrada!");
                sacar();
            }
        }

        public static void transferir(){
            System.out.println("\nDigite o número da agência do rementente: ");
            int numAgenciaRem = scan.nextInt();

            if(numAgenciaRem == 3456){
                System.out.println("\nDigite o número da conta do Remetente: ");
                int numContaRem = scan.nextInt();
            
                ContaPoupanca contaRem = encontraContaP(numContaRem);
                if(contaRem != null){
                    System.out.println("\nDigite o número da agencia do Destinatario:");
                    int numAgenciaDes = scan.nextInt();
                    
                    if(numAgenciaDes == 3456){
                        System.out.println("\nDigite o número da conta do Destinatario: ");
                        int numContaDes = scan.nextInt();
                        
                        ContaPoupanca contaDes = encontraContaP(numContaDes);
                        if(contaDes != null){
                            System.out.println("\nDigite o valor da transfêrencia: ");
                            double valor = scan.nextDouble();
                            
                            contaRem.transferir(contaDes, valor);
                            contaRem.taxaDeTransferencia(contaRem, valor);
                        }
                    }else if(numAgenciaDes == 3478){
                        System.out.println("\nDigite o número da conta do Destinatario: ");
                        int numContaDes = scan.nextInt();
    
                        ContaCorrente contaDes = encontraContaC(numContaDes);
                        if(contaDes != null){
                            System.out.println("\nDigite o valor da transfêrencia: ");
                            double valor = scan.nextDouble();
    
                            contaRem.transferir(contaDes, valor);
                            contaRem.taxaDeTransferencia(contaRem, valor);
                            }
                        }else{
                            System.out.println("\nConta não encontrada!");
                        }
                    } else{
                        System.out.println("Conta não encontrada!");
                    }
            }else if(numAgenciaRem == 3478){
                System.out.println("\nDigite o número da conta do Remetente: ");
                int numContaRem = scan.nextInt();

                ContaCorrente contaRem = encontraContaC(numContaRem);
                if(contaRem != null){
                    System.out.println("\nDigite a agência do Destinatario: ");
                    int numAgenciaDes = scan.nextInt();

                    if(numAgenciaDes == 3456){
                        System.out.println("\nDigite o número da conta do Destinatario: ");
                        int numContaDes = scan.nextInt();

                        ContaPoupanca contaDes = encontraContaP(numContaDes);
                        if(contaDes != null){
                            System.out.println("\nDigite o valor: ");
                            double valor = scan.nextDouble();

                            contaRem.transferir(contaDes, valor);
                            contaRem.contadorTransferencia(contaRem, valor);
                        }
                    }else if(numAgenciaDes == 3478){
                        System.out.println("\nDigite o número da conta do Destinatario: ");
                        int numContaDes = scan.nextInt();
                        
                        ContaCorrente contaDes = encontraContaC(numContaDes);
                        if(contaDes != null){
                            System.out.println("\nDigite o valor: ");
                            double valor = scan.nextDouble();
                            
                            contaRem.transferir(contaDes, valor);
                            contaRem.contadorTransferencia(contaRem, valor);
                        } 
                    }
                }else{
                    System.out.println("\nConta não encontrada!");
                    transferir();
                }
            }else{
                System.out.println("Agência não encontrada!");
                operacoes();
            }
            operacoes();
        }
        public static void consultarsaldo(){
           System.out.println("\nDigite o número da Agência: ");
           int numAgencia = scan.nextInt();

           if(numAgencia == 3456){
                System.out.println("\nDigite o número da Conta: ");
                int numConta = scan.nextInt();

                ContaPoupanca contaExtrato = encontraContaP(numConta);
                if(contaExtrato != null){
                    System.out.println("\nSeu saldo é de: ");
                    System.out.println(contaExtrato.getSaldo());
                }else{
                    System.out.println("\nConta não Encontrada!");
                }
           }else if(numAgencia == 3478){
                System.out.println("\nDigite o número da Conta: ");
                int numConta = scan.nextInt();

                ContaCorrente contaExtrato = encontraContaC(numConta);
                if(contaExtrato != null){
                    System.out.println("\nSeu saldo é de: ");
                    System.out.println(contaExtrato.getSaldo());
                }else{
                    System.out.println("\nConta não encontrada!");
                }
           }else{
            System.out.println("\nAgência não encontrada!");
            operacoes();
           }
           operacoes();
        }
          
        private static ContaPoupanca encontraContaP(int numConta){
            ContaPoupanca conta = null;
            if(contaBacariaPoupancas.size() > 0 ){
                for(ContaPoupanca c : contaBacariaPoupancas){
                    if(c.getNumConta() == numConta){
                        conta = c;
                    }
                }
            }
            return conta;
        }
        
        private static ContaCorrente encontraContaC(int numConta){
            ContaCorrente conta = null;
            if(contaBacariaCorrentes.size() > 0 ){
                for(ContaCorrente c : contaBacariaCorrentes){
                    if(c.getNumConta() == numConta){
                        conta = c;
                    }
                }
            }
            return conta;
        }
   
 }
