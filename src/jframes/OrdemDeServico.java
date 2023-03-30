/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jframes;

import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import model.*;

public class OrdemDeServico {
    
    public static final String FONT = "resources/fonts/LiberationSans-Regular.ttf";
    
    public static void salvar(Atendimento atend, Cliente cliente, Funcionario funcionario){
        
        Document document = new Document();
        
        //FontFactory.register(FONT,"Greek-Regular");
        //Font f = FontFactory.getFont("Greek-Regular", "Cp1253", true);
        
          try {
              
            String caminho = ".\\OS\\OrdemDeServico" + atend.getIdAtendimento() + ".pdf";
            PdfWriter.getInstance(document, new FileOutputStream(caminho));
            
            document.open();
            
            document.setPageSize(PageSize.A4);
            
            document.addSubject("Ordem de cerviço"); 
            document.addKeywords("Ordem de serviço");
            document.addCreator("iText");
            document.addAuthor("EletroTech Solutions");
            
            document.add(new Paragraph("EletroTech Solution"));
            document.add(new Paragraph("Ordem de serviço"));
            document.add(new Paragraph(""));
            document.add(new Paragraph("Código da ordem de serviço: "+atend.getIdAtendimento()));
            document.add(new Paragraph("  "));
            document.add(new Paragraph("Nome do cliente: "+cliente.getNome()));
            document.add(new Paragraph("CPF/CNPJ do cliente: "+cliente.getCpf()));
            document.add(new Paragraph("Telefone do cliente: "+cliente.getContato()));
            document.add(new Paragraph("Endereço: "+atend.getEndereco()));
            document.add(new Paragraph("  "));
            document.add(new Paragraph("Nome do técnico: "+funcionario.getNome()));
            document.add(new Paragraph("Tipo de atendimento: "+atend.getTipo()));
            document.add(new Paragraph("Descrição: "+atend.getDescricao()));
            document.add(new Paragraph("Valor: R$"+atend.getValor()));
            document.add(new Paragraph("Assinatura do cliente: "));
            document.add(new Paragraph("  "));
            document.add(new Paragraph("  "));
            document.add(new Paragraph("  "));
            document.add(new Paragraph("Assinatura do tecnico: "));
    }
          catch(DocumentException de) {
              System.err.println(de.getMessage());
          }
          catch(IOException ioe) {
              System.err.println(ioe.getMessage());
          }
          document.close();
      }

    
}