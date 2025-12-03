import java.io.*;
import java.util.ArrayList;

/**
 * Classe com todas as funções referentes a ficheiros
 */
public class Ficheiro {
    /**
     * Método para criar um ficheiro de objetos com toda a informação de um jogo
     * @param informacaoJogador Nome + Pontuacao do jogo + data
     * @param ficheiro Nome do ficheiro
     * @param perguntasCertas Array com as perguntas certas
     * @param perguntasErradas Array com as perguntas erradas
     */
    protected static void escreveFicheiroObjeto(String informacaoJogador,String ficheiro,ArrayList<Pergunta>perguntasCertas,ArrayList<Pergunta>perguntasErradas){
        File f = new File(ficheiro);
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(informacaoJogador);
            oos.writeObject("/");
            oos.writeObject("Perguntas certas:");
            for(Pergunta p:perguntasCertas) {
                oos.writeObject(p.getPerg());
            }
            oos.writeObject("/");
            oos.writeObject("Perguntas Erradas:");
            for(Pergunta p:perguntasErradas) {
                oos.writeObject(p.getPerg());
            }
            oos.writeObject("----------");
            oos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro a criar ficheiro.");
        } catch (IOException ex) {
            System.out.println("Erro a escrever para o ficheiro.");
        }
    }
    /**
     * Método para ler um ficheiro de objetos com toda a informação de um jogo
     * @param ficheiro Nome do ficheiro
     */
    protected static void leFicheiroObjeto(String ficheiro) {
        File f = new File(ficheiro);
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            for(int i=0;i<11;i++){
                System.out.println((String)ois.readObject());
            }
            ois.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro a abrir ficheiro.");
        } catch (IOException ex) {
            System.out.println("Erro a ler ficheiro.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro a converter objeto.");
        }
    }
    /**
     * Método para ler um ficheiro com todas as perguntas do jogo
     * @param ficheiro Nome do ficheiro
     * @return Array de perguntas com todas perguntas do jogo
     */
    protected static ArrayList<Pergunta> leFicheiro(String ficheiro){
        ArrayList<Pergunta>perguntas = new ArrayList<>();
        File f = new File(ficheiro);
        int cont=0;
        if(f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while((line = br.readLine()) != null) {
                    cont++;
                    String[] linha = line.split(";");
                    if(linha.length==4) {
                        if(!linha[0].isEmpty() && !linha[1].isEmpty() && !linha[2].isEmpty() && !linha[3].isEmpty()) {
                            if (linha[0].equalsIgnoreCase("Ski")) {
                                if (linha[2].split(",").length==2) {
                                    perguntas.add(new Ski(linha[1], linha[2], linha[3]));
                                }else{
                                    System.out.println("Ficheiro corrompido / apagou a separacao das opções ou respostas na pergunta de ciencias");
                                    System.exit(1);
                                }
                            } else if (linha[0].equalsIgnoreCase("Natacao")) {
                                if (linha[2].split(",").length==2) {
                                    perguntas.add(new Natacao(linha[1], linha[2], linha[3]));
                                }else{
                                    System.out.println("Ficheiro corrompido / apagou a separacao das opções ou respostas na pergunta de ciencias");
                                    System.exit(1);
                                }
                            } else if (linha[0].equalsIgnoreCase("Futebol")) {
                                perguntas.add(new Futebol(linha[1], linha[2], linha[3]));
                            } else if (linha[0].equalsIgnoreCase("Artes")) {
                                perguntas.add(new Artes(linha[1], linha[2], linha[3]));
                            } else if (linha[0].equalsIgnoreCase("Ciencias")) {
                                if(linha[3].split(":").length==2 && linha[2].split(":").length==2) {
                                    perguntas.add(new Ciencias(linha[1], linha[2], linha[3]));
                                }else{
                                    System.out.println("Ficheiro corrompido / apagou a separacao das opções ou respostas na pergunta de ciencias");
                                    System.exit(1);
                                }
                            } else if (linha[0].equalsIgnoreCase("Desporto")) {
                                if (linha[2].split(",").length==2) {
                                    perguntas.add(new Desporto(linha[1], linha[2], linha[3]));
                                }else{
                                    System.out.println("Ficheiro corrompido / apagou a separacao das opções ou respostas na pergunta de ciencias");
                                    System.exit(1);
                                }
                            } else {
                                System.out.println("Ficheiro corrompido");
                                System.exit(1);
                            }
                        }else{
                            System.out.println("Ficheiro corrompido / apagou algum dos campos essenciais ao jogo");
                            System.exit(1);
                        }
                    }else {
                        System.out.println("Ficheiro corrompido / apagou separadores");
                        System.exit(1);
                    }
                }
                br.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir ficheiro de texto.");
            } catch (IOException ex) {
                System.out.println("Erro a ler ficheiro de texto.");
            }
        } else {
            System.out.println("Ficheiro não existe.");
            System.exit(1);
        }
        if(cont<5){
            System.out.println("O Ficheiro não tem mais que 5 perguntas");
            System.exit(1);
        }
        return perguntas;
    }

}