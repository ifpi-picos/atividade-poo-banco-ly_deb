package contabanco;

public class Email implements Notificacao {

    @Override
    public void enviarNotificacao(String operacao, double valor, String enderVirtual) {
        System.out.println("---------------------------------------");
        System.out.println("bancoMaut@email.com\nFoi realizada uma operação de:\n" + operacao + "\nNo valor de: " + valor+ "\n          " + enderVirtual);
        System.out.println("---------------------------------------");
    }
    
}
