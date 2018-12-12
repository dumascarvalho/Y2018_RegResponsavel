package regresponsavel.model;

import java.util.Comparator;

public class ComparadorResponsaveisPorQuantidade implements Comparator<AlunoModel> {

    @Override
    public int compare(AlunoModel t, AlunoModel t1) {
        int q = t.getResponsavel().size();
        int q1 = t1.getResponsavel().size();
        
        if (q == q1) {
            return 0;
        } else if (q < q1) {
            return 1;            
        } else return -1;
    }    
}
