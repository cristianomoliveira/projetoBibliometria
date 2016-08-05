
package testes;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.domain.Aresta;
import model.domain.Artigo;
import model.domain.Autor;
import model.domain.ManipuladorDeArquivos;
import model.domain.ManipuladorDeGrafos;
import model.domain.No;

/**
 *
 * @author cristiano
 */
public class TesteArestasCitacoes {
    
     public static void main (String args []){
         
        File arquivo = new File("C://testes//scopus(com 28).csv");
        
        
        ManipuladorDeArquivos ma = new ManipuladorDeArquivos();
        ManipuladorDeGrafos mg = new ManipuladorDeGrafos();
        ArrayList <Artigo> artigos = new ArrayList<Artigo>();
        ArrayList<Autor> autores = new ArrayList<Autor>();
        ArrayList<Autor> autoresCitadores = new ArrayList<Autor>();
        ArrayList <Artigo> artigosCitadores = new ArrayList<Artigo>();
        ArrayList <Artigo> artigosCitadores2 = new ArrayList<Artigo>();
        ArrayList <Artigo> artigosComCitacao = new ArrayList<Artigo>();
        ArrayList <Aresta> arestas = new ArrayList<Aresta>();
        ArrayList <Aresta> arestasTemp = new ArrayList<Aresta>();
        
        
        artigos = ma.getArtigosScopus(arquivo);
        
        //precisa gerar uma lista de nós antes de gerar as arestas
        
        
        //Artigo citado
        for(Artigo a:artigos){
            
            System.out.println("Artigo: "+a.getTitulo());
            System.out.println("Nº de citações: "+a.getnCitacoes());
            autores = a.getAutores();
            System.out.println("Autores: ");
            //Exibundo os autores do artigo Citado
            for(Autor autor:autores){
                System.out.println("--"+autor.getNome());
            }
            //Pegando os artigos citadores
            if (a.getnCitacoes() > 0){
                
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
                    System.out.println("---Artigos citadores");
                    for(Artigo artigoCitador: artigosCitadores){
                        System.out.println("----"+artigoCitador.getTitulo());
                        autoresCitadores = artigoCitador.getAutores();
                        System.out.println("----AUTORES:");
                        for(Autor autorCitador:autoresCitadores){
                            System.out.println("-----"+autorCitador.getNome());
                        }

                        //Gerando lista de arestas---
                        arestasTemp = mg.gerarArestasArtigosCitados(a, artigoCitador);
                        arestas = mg.addSubListaEmLista(arestasTemp, arestas);

                    }
                    artigosCitadores = new ArrayList<Artigo>();
                }
                
            }
            
        }
        
        
        
        
         //pegando somente artigos com citações
        for(Artigo artigo:artigos){
            if(artigo.getnCitacoes()>0){
                artigosComCitacao.add(artigo);
                
            }
        }
        
        
        //unindo as duas listas de artigos:
        artigos = ma.unirListaArtigos(artigosComCitacao, artigosCitadores2);
        autores = ma.lerAutoresDeArtigos(artigos);
        
        System.out.println("AUTORES");
        for(Autor autor:autores){
            System.out.println(autor.getId()+" ; "+autor.getNome());
            
        }
        
        
        ArrayList<No> nos = new ArrayList<No>();
        nos = ma.autoresEmNos(autores);
        
        
        for (Aresta aresta:arestas){
            System.out.println(aresta.getOrigem().getLabel()+"-"
                    + ""+aresta.getDestino().getLabel());
        }
         
        String texto = mg.gerarTextoCitacoes(arestas, nos);
        System.out.println(texto); 
     }
    
    
    
    
}
