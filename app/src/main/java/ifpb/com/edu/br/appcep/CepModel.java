package ifpb.com.edu.br.appcep;

import java.io.Serializable;

public class CepModel implements Serializable {

    private String logradouro;
    private String complemento;
    private String  uf;
    private  String localidade;
    private String  bairro;

    public CepModel() {
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.uf = uf;
        this.localidade = localidade;
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return "CepModel{" +
                "logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", uf='" + uf + '\'' +
                ", localidade='" + localidade + '\'' +
                ", bairro='" + bairro + '\'' +
                '}';
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}



