package regresponsavel.model;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "codigoPessoa")
@Table(name = "aluno")
public class AlunoModel extends PessoaModel {

    @Column(unique = true)
    private String prontuario;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "aluno")
    private List<ResponsavelModel> responsavel = new ArrayList();
    
    public AlunoModel() {
        super();
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public List<ResponsavelModel> getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(List<ResponsavelModel> responsavel) {
        this.responsavel = responsavel;
    }

    public void adicionarResponsavel(ResponsavelModel r) {
        responsavel.add(r);
        r.setAluno(this);
        this.setChanged();
        this.notifyObservers();
    }
}
