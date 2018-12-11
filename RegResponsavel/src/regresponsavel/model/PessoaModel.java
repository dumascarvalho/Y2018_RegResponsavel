package regresponsavel.model;

import java.io.Serializable;
import java.util.Observable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa")
public class PessoaModel extends Observable implements Serializable, Comparable<PessoaModel> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoPessoa;    
    private String nome;    
    private String dataNascimento;    
    private String telefone;
    
    public PessoaModel() {
    
    }       

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
        this.setChanged();
        this.notifyObservers();
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
        this.setChanged();
        this.notifyObservers();
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
        this.setChanged();
        this.notifyObservers();
    }  

    public int getCodigoPessoa() {
        return codigoPessoa;
    }

    public void setCodigoPessoa(int codigoPessoa) {
        this.codigoPessoa = codigoPessoa;
    }
    
    @Override
    public int compareTo(PessoaModel p) {
        return this.getNome().compareTo(p.getNome());
    }
}