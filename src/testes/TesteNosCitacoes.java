 
package testes;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.domain.Artigo;
import model.domain.Autor;
import model.domain.ManipuladorDeArquivos;
import model.domain.ManipuladorDeGrafos;
import model.domain.No;

/**
 *
 * @author cristiano
 */
public class TesteNosCitacoes {
    
    
    public static void main (String args []){
        
         File arquivo = new File("C://testes//scopus(com 4teste).csv");
        
        
        ManipuladorDeArquivos ma = new ManipuladorDeArquivos();
        ManipuladorDeGrafos mg = new ManipuladorDeGrafos();
        ArrayList <Artigo> artigos = new ArrayList<Artigo>();
        ArrayList <Artigo> artigosCitadores = new ArrayList<Artigo>();
        ArrayList <Artigo> artigosCitadores2 = new ArrayList<Artigo>();
        ArrayList<Autor> autores = new ArrayList<Autor>();
        artigos = ma.getArtigosScopus(arquivo);
        
        //lendo os artigos dos arquivos em que foram citados
        
        for(Artigo a:artigos){
            
            System.out.println("Artigo: "+a.getTitulo());
            System.out.println("Nº de citações: "+a.getnCitacoes());
            autores = a.getAutores();
            System.out.println("Autores: ");
            for(Autor autor:autores){
                System.out.println("--"+autor.getNome());
            }
            if (a.getnCitacoes() > 0){
                System.out.println("---Tem autores que citaram");
                //tipos de arquivos a serem escolhidos:
                FileNameExtensionFilter filtro = new FileNameExtensionFilter("CSV", "csv");

                //Usando o JfileChooser
                JFileChooser fc = new JFileChooser();

                //adicionando tipos de arquivos que podem ser escolhidos
                fc.setFileFilter(filtro);

                //título da tela
                fc.setDialogTitle("Abrindo: "+a.getTitulo());

                //escolhendo somente arquivos
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int resposta = fc.showOpenDialog(null);
                if(resposta == JFileChooser.APPROVE_OPTION){
                    File arquivo2 = fc.getSelectedFile();
                    artigosCitadores = ma.getArtigosScopus(arquivo2);
                    artigosCitadores2 = ma.unirListaArtigos(artigosCitadores2, artigosCitadores);
                }
                
            }
        }
        //unindo as duas listas de artigos:
        artigos = ma.unirListaArtigos(artigos, artigosCitadores2);


        //lendo os autores dos artigos
        autores = ma.lerAutoresDeArtigos(artigos);
        ArrayList<No> nos = new ArrayList<No>();
        nos = ma.autoresEmNos(autores);
        String textoEscrita = mg.gerarTextoNosArrayList("", nos);
        System.out.println("Autores dos Artigos");
        System.out.println(textoEscrita);
        
    }
    
}
