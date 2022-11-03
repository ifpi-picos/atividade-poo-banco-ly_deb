package contabanco;
public class Endereco {
    private String logradouro;
    private int numCasa;
    private String bairro;
    private String cidade;
    private String uf;
    public Endereco(String logradouro, int numCasa, String bairro, String cidade, String uf) {
        this.logradouro = logradouro;
        this.numCasa = numCasa;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getUf() {
        return uf;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
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
    @Override
    public String toString() {
        return "Endereco [logradouro=" + logradouro + ", numCasa=" + numCasa + ", bairro=" + bairro + ", cidade="
                + cidade + ", uf=" + uf + "]";
    }
    
}
