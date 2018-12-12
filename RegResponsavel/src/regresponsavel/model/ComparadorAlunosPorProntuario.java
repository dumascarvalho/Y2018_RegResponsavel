package regresponsavel.model;

import java.util.Comparator;

public class ComparadorAlunosPorProntuario implements Comparator<AlunoModel> {

    @Override
    public int compare(AlunoModel t, AlunoModel t1) {
        //  0 - Objetos Iguais
        // -1 - Precede
        //  1 - Sucede
        return t.getProntuario().compareTo(t1.getProntuario());
    }
}
