import java.util.ArrayList;
import java.util.Random;
/**
 * Classe das Perguntas
 */
public abstract class Pergunta{
    /**
     * Pontuação da pergunta
     */
    private int pontPergunta;
    /**
     * Verificador para saber se respondeu ou não à pergunta
     */
    private boolean resposta=false;
    /**
     * Pergunta
     */
    private String perg;
    /**
     * Opções da pergunta
     */
    private String opcoes;
    /**
     * Opção correta da pergunta
     */
    private String resp;

    /**
     * Construtor para criar uma pergunta
     * @param perg Pergunta
     * @param opcoes Opções da Pergunta
     * @param resp Resposta Correta à pergunta
     */
    public Pergunta(String perg,String opcoes,String resp){
        this.perg=perg;
        this.opcoes=opcoes;
        this.resp=resp;
        this.pontPergunta=5;
    }
    /**
     * Método para selecionar a resposta correta da pergunta consoante o nivel
     * @param p String com a pergunta,opcoes e resposta certa
     * @param level Nível da pergunta
     * @return String com a resposta correta
     */
    protected abstract String selecionaRespostaPergunta(Pergunta p, int level);
    /**
     * Método para selecionar as opções da pergunta consoante o nivel
     * @param p String com a pergunta,opcoes e resposta certa
     * @param level Nível da pergunta
     * @return Array de Strings com as opcoes da pergunta
     */
    protected abstract String[] selecionaOpcoesPergunta(Pergunta p, int level);
    /**
     * Método para selecionar 5 perguntas random
     * @param perguntas Array com todas as perguntas que se encontram no ficheiro
     * @return Array com 5 perguntas
     */
    protected static ArrayList<Pergunta> perguntasUtilizador(ArrayList<Pergunta>perguntas){
        int cont=0;
        ArrayList<Pergunta>perguntasUtilizador=new ArrayList<>();
        Random random = new Random();
        double numeroAleatorio = random.nextDouble();
        if(perguntas.size()>=5) {
            while (cont < 5) {
                int i = (int) (numeroAleatorio* perguntas.size());
                Pergunta p = perguntas.get(i);
                numeroAleatorio = random.nextDouble();
                if (!perguntasUtilizador.contains(p)) {
                    perguntasUtilizador.add(p);
                    cont++;
                }
            }
        }else{
            System.out.println("Poucas perguntas para começar o jogo");
        }
        return perguntasUtilizador;
    }
    /**
     * Método para imprimir um array de perguntas
     * @param perguntas Array das perguntas
     */
    protected static void imprimeArray(ArrayList<Pergunta> perguntas){
        for(Pergunta p:perguntas){
            System.out.println(p);
        }
    }
    /**
     * Método para aumentar a pontuação da pergunta
     * @return Pontuação final da pergunta
     */
    protected abstract int aumentaPontos();
    /**
     * Método para aceder à Pergunta
     * @return Pergunta
     */
    public String getPerg() {
        return perg;
    }
    /**
     * Método para mudar a Pergunta
     */
    public void setPerg(String perg) {
        this.perg = perg;
    }
    /**
     * Método para aceder às opções da pergunta
     * @return Opções
     */
    public String getOpcoes() {
        return opcoes;
    }
    /**
     * Método para mudar as opções
     */
    public void setOpcoes(String opcoes) {
        this.opcoes = opcoes;
    }
    /**
     * Método para aceder à opção correta da pergunta
     * @return Opção correta
     */
    public String getResp() {
        return resp;
    }
    /**
     * Método para mudar a opção correta da pergunta
     */
    public void setResp(String resp) {
        this.resp = resp;
    }
    /**
     * Método para aceder à pontuação da pergunta
     * @return Pontuação da pergunta
     */
    public int getPontPergunta() {
        return pontPergunta;
    }
    /**
     * Método para mudar a pontuação da pergunta
     */
    public void setPontPergunta(int pontPergunta) {
        this.pontPergunta = pontPergunta;
    }
    /**
     * Método para aceder à verificação de resposta
     * @return Estado da verificação
     */
    public boolean isResposta() {
        return resposta;
    }
    /**
     * Método para mudar a verificação de resposta
     */
    public void setResposta(boolean resposta) {
        this.resposta = resposta;
    }
    /**
     * Método para imprimir uma string com a pergunta,pontuação,opções e opção correta
     * @return pergunta,pontuação,opções e opção correta
     */
    public String toString() {
        return "Pergunta{" +
                ", perg='" + perg + '\'' +
                "pontPergunta=" + pontPergunta +
                ", opcoes='" + opcoes + '\'' +
                ", resp='" + resp + '\''+"}";
    }
}
