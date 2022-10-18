package contabanco;
public class Endereco {
    private String rua;
    private int numCasa;
    private String bairro;
    
    public Endereco(String rua, int numCasa, String bairro){
        this.rua = rua;
        this.numCasa = numCasa;
        this.bairro = bairro;
    }
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public int getNumCasa() {
        return numCasa;
    }
    public void setNumCasa(int numCasa) {
        this.numCasa = numCasa;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    
}
