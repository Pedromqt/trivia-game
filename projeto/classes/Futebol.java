/**
 * Classe das perguntas de Futebol que herda de Desporto
 */
public class Futebol extends Desporto{
    /**
     * Pontuação da pergunta de Futebol
     */
    private int pontuacaoFutebol;
    /**
     * Construtor para criar uma pergunta de Futebol
     * @param perg Pergunta
     * @param opcoes Opções da Pergunta
     * @param resp Resposta Correta à pergunta
     */
    public Futebol(String perg, String opcoes, String resp) {
        super(perg, opcoes, resp);
        this.pontuacaoFutebol = 3;
    }
    /**
     * Método para selecionar a resposta correta
     * @param p String com a pergunta,opcoes e resposta certa
     * @param level Nível da pergunta
     * @return String com a resposta correta
     */
    protected String selecionaRespostaPergunta(Pergunta p, int level){
        return super.selecionaRespostaPergunta(p,level);
    }
    /**
     * Método para selecionar as opções da pergunta
     * @param p String com a pergunta,opcoes e resposta certa
     * @param level Nível da pergunta
     * @return Array de Strings com as opcoes da pergunta
     */
    protected String[] selecionaOpcoesPergunta(Pergunta p, int level){
        return super.selecionaOpcoesPergunta(p,level);
    }
    /**
     * Método para aumentar a pontuação da pergunta de futebol
     * @return Pontuação final da pergunta
     */
    protected int aumentaPontos() {
        setPontuacaoFutebol(super.aumentaPontos()+pontuacaoFutebol);
        return getPontuacaoTotalDesporto();
    }
    /**
     * Método para aceder à pontuação da pergunta de futebol
     * @return Pontuação de futebol
     */
    public int getPontuacaoFutebol() {
        return pontuacaoFutebol;
    }
    /**
     * Método para mudar a pontuação da pergunta de futebol
     */
    public void setPontuacaoFutebol(int pontuacaoFutebol) {
        this.pontuacaoFutebol = pontuacaoFutebol;
    }
    /**
     * Método para imprimir uma string com o tipo da pergunta,pergunta e opções
     * @return Futebol, pergunta e opções
     */
    public String toString() {
        return "Futebol -> "+getPerg()+ " "+getOpcoes();
    }

}
