/**
 * Classe das perguntas de Desporto que herda da Pergunta
 */
public class Desporto extends Pergunta {
    /**
     * Pontuação da pergunta de Desporto
     */
    private int pontuacaoDesporto;
    /**
     * Pontução total da pergunta de Desporto
     */
    private int pontuacaoTotalDesporto;
    /**
     * Construtor para criar uma pergunta de Desporto
     * @param perg Pergunta
     * @param opcoes Opções da Pergunta
     * @param resp Resposta Correta à pergunta
     */
    public Desporto(String perg, String opcoes, String resp) {
        super(perg, opcoes, resp);
        this.pontuacaoDesporto = 3;
    }
    /**
     * Método para selecionar a resposta correta
     * @param p String com a pergunta,opcoes e resposta certa
     * @param level Nível da pergunta
     * @return String com a resposta correta
     */
    protected String selecionaRespostaPergunta(Pergunta p, int level){
        return getResp();
    }
    /**
     * Método para selecionar as opções da pergunta
     * @param p String com a pergunta,opcoes e resposta certa
     * @param level Nível da pergunta
     * @return Array de Strings com as opcoes da pergunta
     */
    protected String[] selecionaOpcoesPergunta(Pergunta p, int level){
        return p.getOpcoes().split(",");
    }
    /**
     * Método para aumentar a pontuação da pergunta de desporto
     * @return Pontuação final da pergunta
     */
    protected int aumentaPontos() {
        setPontuacaoTotalDesporto(getPontPergunta()+pontuacaoDesporto);
        return getPontuacaoTotalDesporto();
    }
    /**
     * Método para aceder à pontuação da pergunta de desporto
     * @return Pontuação total de desporto
     */
    public int getPontuacaoDesporto() {
        return pontuacaoDesporto;
    }
    /**
     * Método para mudar a pontuação da pergunta de desporto
     */
    public void setPontuacaoDesporto(int pontuacaoDesporto) {
        this.pontuacaoDesporto = pontuacaoDesporto;
    }
    /**
     * Método para aceder à pontuação total de desporto
     * @return Pontuação de desporto
     */
    public int getPontuacaoTotalDesporto() {
        return pontuacaoTotalDesporto;
    }
    /**
     * Método para mudar a pontuação total de desporto
     */
    public void setPontuacaoTotalDesporto(int pontuacaoTotalDesporto) {
        this.pontuacaoTotalDesporto = pontuacaoTotalDesporto;
    }
    /**
     * Método para imprimir uma string com o tipo da pergunta,pergunta e opções
     * @return Desporto, pergunta e opções
     */
    public String toString() {
        return "Desporto -> " +getPerg()+" "+getOpcoes();
    }
}
