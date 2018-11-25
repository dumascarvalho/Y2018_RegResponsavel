package regresponsavel.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class UsuarioModel implements Serializable, Comparable<UsuarioModel> {
    
    @Id
    private String prontuario;    
    private String nome;    
    private String senha;

    public UsuarioModel() {
        
    }

    public UsuarioModel(String prontuario, String nome, String senha) {
        this.prontuario = prontuario;
        this.nome = nome;
        this.senha = senha;
    }
    
    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    @Override
    public int compareTo(UsuarioModel u) {
        return this.getNome().compareTo(u.getNome());
    }
}