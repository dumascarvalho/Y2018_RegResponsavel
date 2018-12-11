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
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@PrimaryKeyJoinColumn(name = "codigoPessoa")
@Table(name = "aluno")

public class AlunoModel extends PessoaModel {

    @Column(unique = true)
    private String prontuario;
    // Alterado o atributo Cascade em razão dos seguintes erros: 
    // PersistentObjectException: detached entity passed to persist - fonte: https://stackoverflow.com/questions/13370221/jpa-hibernate-detached-entity-passed-to-persist
    // Exception:cannot delete or update a parent row: a foreign key constraint fails - fonte: https://stackoverflow.com/questions/42969783/hibernate-errorcannot-delete-or-update-a-parent-row-a-foreign-key-constraint-f
    @OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, CascadeType.REMOVE }, mappedBy = "aluno")
    // Adicionada esta anotação nativa do Hibernate como alternativa para o seguinte erro: 
    // EntityNotFoundException: unable to find - fonte: https://developer.jboss.org/thread/108899?_sscc=t
    @NotFound(action = NotFoundAction.IGNORE)
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
    }
}
