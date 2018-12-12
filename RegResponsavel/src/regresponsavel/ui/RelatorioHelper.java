package regresponsavel.ui;

import java.util.*;
import java.io.*;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import regresponsavel.controller.AlunoController;
import regresponsavel.controller.ResponsavelController;
import regresponsavel.model.AlunoModel;
import regresponsavel.model.ResponsavelModel;

public class RelatorioHelper {
    
    public void gerarRelatorioAlunos() {
        try {
            AlunoController ac = new AlunoController();
            List<AlunoModel> contatos = ac.recuperar();
            HashMap<String, Object> params = 
                    new HashMap<>();
            JRBeanCollectionDataSource dt = 
                new JRBeanCollectionDataSource(contatos);       
            InputStream in = this.getClass().getClassLoader()
                    .getResourceAsStream("relatorioAlunos.jrxml");
            JasperReport jasperReport = JasperCompileManager
                    .compileReport(in);
            JasperPrint jasperPrint = JasperFillManager
                    .fillReport(jasperReport, params, dt);
            JasperViewer.viewReport(jasperPrint, false);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void gerarRelatorioResponsaveis() {
        try {
            ResponsavelController rc = new ResponsavelController();
            List<ResponsavelModel> contatos = rc.recuperar();
            HashMap<String, Object> params = 
                    new HashMap<>();
            JRBeanCollectionDataSource dt = 
                new JRBeanCollectionDataSource(contatos);       
            InputStream in = this.getClass().getClassLoader()
                    .getResourceAsStream("relatorioResponsaveis.jrxml");
            JasperReport jasperReport = JasperCompileManager
                    .compileReport(in);
            JasperPrint jasperPrint = JasperFillManager
                    .fillReport(jasperReport, params, dt);
            JasperViewer.viewReport(jasperPrint, false);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
