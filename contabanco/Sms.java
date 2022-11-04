package contabanco;

public class Sms implements Notificacao {

    @Override
    public void enviarNotificacao(String operacao, double valor, String endeVitual) {
        System.out.println("---------------------------------------");
        System.out.println("De: 3434\nFoi realizada uma operação de:\n" + operacao + "\nNo valor de: " + valor + "\n                    Para: " +endeVitual);
        System.out.println("---------------------------------------");
    }
    
}
