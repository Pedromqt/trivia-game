import javax.swing.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JFrame;
import java.io.Serializable;
import java.time.LocalDateTime;
/**
 * Classe da interface do jogo
 */
public class TriviaGUI extends JFrame implements Serializable {
    /**
     * Perguntas para serem jogadas
     */
    private ArrayList<Pergunta> perguntas;
    /**
     * Perguntas que acertou
     */
    private ArrayList<Pergunta> perguntasCertas;
    /**
     * Perguntas que errou
     */
    private ArrayList<Pergunta> perguntasErradas;
    /**
     * Pontuação total do jogo
     */
    private int pontTotal=0;    
    /**
     * Construtor para inicializar a interface, algumas variáveis e inicio do jogo
     * @param perguntas Array das 5 perguntas
     */
    public TriviaGUI(ArrayList<Pergunta> perguntas) {
        this.perguntas = perguntas;
        this.perguntasCertas = new ArrayList<>();
        this.perguntasErradas = new ArrayList<>();
        this.setTitle("TriviaPOO");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jogar();
        System.exit(1);
    }
    /**
     * Método para fazer o jogo e guardar em ficheiro de objetos cada informação de um jogo
     */
    protected void jogar() {
        int level=1;
        for (Pergunta p : perguntas) {
            String[] opcoes = p.selecionaOpcoesPergunta(p,level);
            String resp = p.selecionaRespostaPergunta(p,level);
            level++;
            while(!p.isResposta()) {
                int indexResp = JOptionPane.showOptionDialog(this, p.getPerg(), "POOTrivia", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
                p.setResposta(true);
                if (indexResp == -1) {
                    JOptionPane.showMessageDialog(this, "Jogo encerrado. Você não respondeu à pergunta!");
                    this.setVisible(false);
                    System.exit(0);
                }
                else {
                    if (opcoes[indexResp].equals(resp)) {
                        JOptionPane.showMessageDialog(this, "Resposta certa!");
                        setPontTotal(getPontTotal() + p.aumentaPontos());
                        perguntasCertas.add(p);
                    } else {
                        JOptionPane.showMessageDialog(this, "Resposta errada!");
                        perguntasErradas.add(p);
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(this, "Fez "+getPontTotal()+" pontos!");
        this.setVisible(false);
        String jogador = JOptionPane.showInputDialog(this, "Insira o seu nome", JOptionPane.QUESTION_MESSAGE);
        while (jogador.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Insira o seu nome!");
            jogador = JOptionPane.showInputDialog(this, "Insira o seu nome", "TriviaPOO",JOptionPane.QUESTION_MESSAGE);
        }
        String[] nomes = jogador.split(" ");
        String iniciais=new String("");
        for (String nome : nomes) {
            iniciais += nome.charAt(0);
        }

        LocalDateTime data = LocalDateTime.now();
        // Formatar a data
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmm");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        String dataFormatada = data.format(formatter);
        String dataFormatadaFicheiro = data.format(formatter2);

        String nomeFicheiroObjeto = "pootrivia_jogo_"+dataFormatada+"_"+iniciais+".dat";
        String informacaoJogador = jogador+" "+getPontTotal()+" Pontos Data: "+dataFormatadaFicheiro;

        Ficheiro.escreveFicheiroObjeto(informacaoJogador,nomeFicheiroObjeto,perguntasCertas,perguntasErradas);
        Ficheiro.leFicheiroObjeto(nomeFicheiroObjeto);
    }
    /**
     * Método para aceder às perguntas
     * @return Array de perguntas
     */
    public ArrayList<Pergunta> getPerguntas() {
        return perguntas;
    }
    /**
     * Método para mudar as perguntas
     */
    public void setPerguntas(ArrayList<Pergunta> perguntas) {
        this.perguntas = perguntas;
    }
    /**
     * Método para aceder às perguntas certas
     * @return Array de perguntas certas
     */
    public ArrayList<Pergunta> getPerguntasCertas() {
        return perguntasCertas;
    }
    /**
     * Método para mudar as perguntas certas
     */
    public void setPerguntasCertas(ArrayList<Pergunta> perguntasCertas) {
        this.perguntasCertas = perguntasCertas;
    }
    /**
     * Método para aceder às perguntas erradas
     * @return Array de perguntas erradas
     */
    public ArrayList<Pergunta> getPerguntasErradas() {
        return perguntasErradas;
    }
    /**
     * Método para mudar as perguntas erradas
     */
    public void setPerguntasErradas(ArrayList<Pergunta> perguntasErradas) {
        this.perguntasErradas = perguntasErradas;
    }
    /**
     * Método para aceder à pontuação total do jogo
     * @return Pontuação total de um jogo
     */
    public int getPontTotal() {
        return pontTotal;
    }
    /**
     * Método para mudar a pontuação total do jogo
     */
    public void setPontTotal(int pontTotal) {
        this.pontTotal = pontTotal;
    }
}
