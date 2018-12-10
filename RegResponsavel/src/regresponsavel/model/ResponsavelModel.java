package regresponsavel.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "codigoPessoa")
@Table(name = "responsavel")
public class ResponsavelModel extends PessoaModel {
    
    @OneToOne
    @JoinColumn(name = "codigoAluno")
    private AlunoModel aluno;

    public ResponsavelModel() {
        super();    
    }

    public AlunoModel getAluno() {
        return aluno;
    }

    public void setAluno(AlunoModel aluno) {
        this.aluno = aluno;
    }   
}
