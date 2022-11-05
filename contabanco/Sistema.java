 package contabanco;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Sistema {
    
    static Scanner scan = new Scanner(System.in);
    static Random random =  new Random();
    static Sms sms = new Sms();
    static Email email = new Email();
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
            System.out.println("|      Opção 1 - Criar Conta            |");
            System.out.println("|      Opção 2 - Depositar              |");
            System.out.println("|      Opção 3 - Sacar                  |");
            System.out.println("|      Opção 4 - Transferir             |");
            System.out.println("|      Opção 5 - Consultar Saldo        |");
            System.out.println("|      Opção 6 - Sair                   |");
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
            Cliente cliente = new Cliente();

            System.out.print("\nNome: ");
            String nomeCliente = scan.nextLine();
            if(cliente.checarString(nomeCliente) == false){
                System.out.println("Nome invalido.");
                operacoes();
            }
    
            System.out.print("\nCPF: ");
            String cpft = scan.nextLine();

            if (cliente.checaCPF(cpft).equals("V")){

            }else if(cliente.checaCPF(cpft).equals("Il")){
                System.out.println("CPF invalido.");
                operacoes();
            }else if(cliente.checaCPF(cpft).equals("In")){
                System.out.println("Quantidade de números invalido.");
                operacoes();
            }else{
                System.out.println("Quantidade de números invalida, não utilize simbolos!!");
                operacoes();
            }

            String cpf = cpft;

            System.out.println("\nData de nascimento(dd/mm/aaaa): ");
            LocalDate data = LocalDate.parse(scan.nextLine(), sdf);

            if(cliente.checaData(data).equals("Y")){

            }else if (cliente.checaData(data).equals("M")){
                System.out.println("Menor de idade!");
                operacoes();
            }else {
                System.out.println("Data de nascimento invalida!");
                operacoes();
            }

            LocalDate dataDeNasc = data;

            System.out.println("\nLogradouro: ");
            String logradouro = scan.nextLine();

            System.out.println("\nNúmero da casa: ");
            int numCasa = scan.nextInt();
            scan.nextLine();

            System.out.println("\nBairro: ");
            String bairro = scan.nextLine();
            if(cliente.checarString(bairro) == false){
                System.out.println("Nome invalido.");
                operacoes();
            }
            
            System.out.println("\nCidade: ");
            String cidade = scan.nextLine();
            if(cliente.checarString(cidade) == false){
                System.out.println("Nome invalido.");
                operacoes();
            }

            System.out.println("\nEstado: ");
            String uf = scan.nextLine();
            if(cliente.checarString(uf) == false){
                System.out.println("Nome invalido.");
                operacoes();
            }
            
            System.out.println("\nREceber notificação por:\n1 - Email  2 - SMS");
            int notifTipo = scan.nextInt();
            scan.nextLine();
            System.out.println("\nDigite o endereço virtual: ");
            String enderecoVitual = scan.nextLine();

            Endereco endereco = new Endereco(logradouro, numCasa, bairro, cidade, uf);
            Cliente clientes = new Cliente(nomeCliente, dataDeNasc, cpf, endereco);

            System.out.println("\nQual o tipo de Conta?");
            System.out.println("\n1- Poupança  2- Corrente");
            int tipo = scan.nextInt();

            int numConta = random.nextInt(99999)+10000;
            
            
            if(tipo == 1){

                int numAgencia = 3456;
                double saldo = 0.00f;
                String tipoNotif = notificacaoType(notifTipo);
                ContaPoupanca conta = new ContaPoupanca(numAgencia, numConta, saldo, clientes, tipoNotif, enderecoVitual);
            
                System.out.println(clientes.toString());
                System.out.println(endereco.toString());
                System.out.println(conta.toString());

                contaBacariaPoupancas.add(conta);
                operacoes();
            }else if(tipo == 2){
                int numAgencia = 3478;
                double saldo =  0.00f;
                String tipoNotif = notificacaoType(notifTipo);
                ContaCorrente conta = new ContaCorrente(0, 0.00, numAgencia, numConta, saldo, clientes, tipoNotif, enderecoVitual);
                
                System.out.println(clientes.toString());
                System.out.println(endereco.toString());
                System.out.println(conta.toString());
                            
                contaBacariaCorrentes.add(conta);
                System.out.println("Sua conta foi criada com sucesso!");
                operacoes();
            }else{
                System.out.println("Error");
                operacoes();
            }  
            System.out.println("Sua conta foi criada com sucesso!");
            operacoes();
        }
       
        public static void deposita(){
            System.out.println("\nDigite o número da agência: ");
            int numAgencia = scan.nextInt();

            if (numAgencia == 3456) {
                System.out.println("\nDigite o número da conta: ");
                int numConta = scan.nextInt();

                ContaPoupanca conta = encontraContaP(numConta);
                if(conta != null){
                    System.out.println("\nDigite o valor para deposito: ");
                    Double valor = scan.nextDouble();
                    conta.depositar(valor);
                    if(conta.getTipoNotif().equals("Email")){
                        email.enviarNotificacao("Deposito", valor, conta.getEnderecoVitual());
                    }else if(conta.getTipoNotif().equals("SMS")){
                        sms.enviarNotificacao("Deposito", valor, conta.getEnderecoVitual());
                    }else{}
                }else {
                    System.out.println("\nConta não encontrada!");
                }
            } else if (numAgencia == 3478){
                System.out.println("\nDigite o número da conta: ");
                int numConta = scan.nextInt();

                Conta conta = encontraContaC(numConta);
                if (conta != null) {
                    System.out.println("\nDigite o valor para deposito: ");
                    Double valor = scan.nextDouble();
                    conta.depositar(valor);
                    if(conta.getTipoNotif().equals("SMS")){
                        email.enviarNotificacao("Deposito", valor, conta.getEnderecoVitual());
                    }else if(conta.getTipoNotif().equals("Email")){
                        sms.enviarNotificacao("Deposito", valor, conta.getEnderecoVitual());
                    }else{}
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
            System.out.println("\nDigite o número da agência: ");
            int numAgencia = scan.nextInt();

            if(numAgencia == 3456){
                System.out.println("\nDigite o número da conta: ");
                int numConta = scan.nextInt();
                ContaPoupanca conta = encontraContaP(numConta);

                if(conta != null){

                    System.out.println("\nValor para saque: ");
                    double valorSaque = scan.nextDouble();
                    conta.sacar(valorSaque);
                    if(conta.getTipoNotif().equals("Email")){
                        email.enviarNotificacao("Saque", valorSaque, conta.getEnderecoVitual());
                    }else if(conta.getTipoNotif().equals("Sms")){
                        sms.enviarNotificacao("Saque", valorSaque, conta.getEnderecoVitual());
                    }else{}
                }else{
                    System.out.println("Conta não encontrada!");
                }
                operacoes();
            }else if(numAgencia == 3478){
                System.out.println("\nDigite o número da conta: ");
                int numConta = scan.nextInt();
                ContaCorrente conta = encontraContaC(numConta);
                
                if(conta != null){
                    System.out.println("\nValor para saque: ");
                    double valorSaque = scan.nextDouble();
                    conta.sacarCheque(valorSaque);
                    if(conta.getTipoNotif().equals("Email")){
                        email.enviarNotificacao("Saque", valorSaque, conta.getEnderecoVitual());
                    }else if(conta.getTipoNotif().equals("Sms")){
                        sms.enviarNotificacao("Saque", valorSaque, conta.getEnderecoVitual());
                    }else{}
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
                System.out.println("\nDigite o número da conta do remetente: ");
                int numContaRem = scan.nextInt();
            
                ContaPoupanca contaRem = encontraContaP(numContaRem);
                if(contaRem != null){
                    System.out.println("\nDigite o número da agência do destinatário:");
                    int numAgenciaDes = scan.nextInt();
                    
                    if(numAgenciaDes == 3456){
                        System.out.println("\nDigite o número da conta do destinatário: ");
                        int numContaDes = scan.nextInt();
                        
                        ContaPoupanca contaDes = encontraContaP(numContaDes);
                        if(contaDes != null){
                            System.out.println("\nDigite o valor da transfêrencia: ");
                            double valor = scan.nextDouble();
                            
                            contaRem.transferir(contaDes, valor);
                            contaRem.taxaDeTransferencia(contaRem, valor);

                            if(contaDes.getTipoNotif().equals("Email")){
                                email.enviarNotificacao("Transfêrencia", valor, contaDes.getEnderecoVitual());
                            }else if(contaDes.getTipoNotif().equals("Sms")){
                                sms.enviarNotificacao("Transfência", valor, contaDes.getEnderecoVitual());
                            }else{}

                        }
                    }else if(numAgenciaDes == 3478){ 
                        System.out.println("\nDigite o número da conta do destinatário: ");
                        int numContaDes = scan.nextInt();
    
                        ContaCorrente contaDes = encontraContaC(numContaDes);
                        if(contaDes != null){
                            System.out.println("\nDigite o valor da transfêrencia: ");
                            double valor = scan.nextDouble();
    
                            contaRem.transferirpC(contaDes, valor);
                            contaRem.taxaDeTransferencia(contaRem, valor);

                            if(contaDes.getTipoNotif().equals("SMS")){
                                email.enviarNotificacao("Transfêrencia", valor, contaDes.getEnderecoVitual());
                            }else if(contaDes.getTipoNotif().equals("Email")){
                                sms.enviarNotificacao("Transfêrencia", valor, contaDes.getEnderecoVitual());
                            }else{}
                            }
                        }else{
                            System.out.println("\nConta não encontrada!");
                        }
                    } else{
                        System.out.println("Conta não encontrada!");
                    }
            }else if(numAgenciaRem == 3478){
                System.out.println("\nDigite o número da conta do remetente: ");
                int numContaRem = scan.nextInt();

                ContaCorrente contaRem = encontraContaC(numContaRem);
                if(contaRem != null){
                    System.out.println("\nDigite a agência do destinatário: ");
                    int numAgenciaDes = scan.nextInt();

                    if(numAgenciaDes == 3456){
                        System.out.println("\nDigite o número da conta do destinatário: ");
                        int numContaDes = scan.nextInt();

                        ContaPoupanca contaDes = encontraContaP(numContaDes);
                        if(contaDes != null){
                            System.out.println("\nDigite o valor: ");
                            double valor = scan.nextDouble();

                            contaRem.transferirCP(contaDes, valor);
                            contaRem.contadorTransferencia(contaRem, valor);

                            if(contaDes.getTipoNotif().equals("Email")){
                                email.enviarNotificacao("Transfêrencia", valor, contaDes.getEnderecoVitual());
                            }else if(contaRem.getTipoNotif().equals("Sms")){
                                sms.enviarNotificacao("Transfêrencia", valor, contaDes.getEnderecoVitual());
                            }else{}
                        }
                    }else if(numAgenciaDes == 3478){
                        System.out.println("\nDigite o número da conta do destinátario: ");
                        int numContaDes = scan.nextInt();
                        
                        ContaCorrente contaDes = encontraContaC(numContaDes);
                        if(contaDes != null){
                            System.out.println("\nDigite o valor: ");
                            double valor = scan.nextDouble();
                            
                            contaRem.transferirCC(contaDes, valor);
                            contaRem.contadorTransferencia(contaRem, valor);

                            if(contaDes.getTipoNotif().equals("Email")){
                                email.enviarNotificacao("Transfêrencia", valor,contaDes.getEnderecoVitual());
                            }else if(contaDes.getTipoNotif().equals("Sms")){
                                sms.enviarNotificacao("Transfêrencia", valor, contaDes.getEnderecoVitual());
                            }else{}
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
                    double saldo = contaExtrato.getSaldo();
                    System.out.printf("\nExtrato da Conta: %.2f R$", saldo);
                    System.out.println();
                }else{
                    System.out.println("\nConta não Encontrada!");
                }
            }else if(numAgencia == 3478){
                System.out.println("\nDigite o número da Conta: ");
                int numConta = scan.nextInt();
                
                ContaCorrente contaExtrato = encontraContaC(numConta);
                if(contaExtrato != null){
                    double saldo = contaExtrato.getChequeSepecial();
                    System.out.printf("Extrato da Conta: %.2f R$", saldo);
                    System.out.println();

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
        private static String notificacaoType(int notifTipo){
            if(notifTipo == 1){
                return"Email"; 
                
            }else if(notifTipo == 2){
                return "Sms";

            }else {
                return "N";
                
            }

        }   
 }
