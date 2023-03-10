/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.String.valueOf;
import java.sql.SQLException;
import java.util.List;
import Entities.Annonce;
import Services.ServiceAnnonce;
import Services.ServiceClassification;

/**
 *
 * @author DELL
 */
public class PDF {
 //   ServiceClassification serviceClassification = new ServiceClassification();

      public void GeneratePdf(String filename) throws FileNotFoundException, DocumentException, BadElementException, IOException, InterruptedException, SQLException
    {
        Document document=new  Document() {};
        PdfWriter.getInstance(document, new FileOutputStream(filename+".pdf"));
        document.open();
      
        ServiceAnnonce m=new ServiceAnnonce();
        List<Annonce> list=m.selectAll();    
        document.add(new Paragraph("La liste des annonces :"));
        document.add(new Paragraph("     "));
         for(Annonce u:list)
        {
            ServiceClassification scv=new ServiceClassification();
        String idClassification = Integer.toString(u.getId_c());
            System.out.println("Titre :"+u.getTitre());
        String nomClassification = scv.afficherById(u.getId_c());
        document.add(new Paragraph("Titre :"+u.getTitre()));
        document.add(new Paragraph("Nom_client :"+u.getNom_client()));
         System.out.println("Nom_client :"+u.getNom_client());
        document.add(new Paragraph("Date :"+u.getDate()));
         System.out.println("Date :"+u.getDate());
   
     
        document.add(new Paragraph("Classification : " + nomClassification));
        
   //    document.add(new Paragraph("Classification :"+u.ge;
    


        document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------- "));
        }
        document.close();
        Process pro=Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+filename+".pdf");
    }
    
}
