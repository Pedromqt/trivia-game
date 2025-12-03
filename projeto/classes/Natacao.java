/**
 * Classe das perguntas de Natação que herda de Desporto
 */
public class Natacao extends Desporto{
    /**
     * Pontuação da pergunta de Natação
     */
    private int pontuacaoNatacao;
    /**
     * Construtor para criar uma pergunta de Natação
     * @param perg Pergunta
     * @param opcoes Opções da Pergunta
     * @param resp Resposta Correta à pergunta
     */
    public Natacao(String perg, String opcoes, String resp) {
        super(perg, opcoes, resp);
        this.pontuacaoNatacao=10;
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
        return(super.selecionaOpcoesPergunta(p,level));
    }
    /**
     * Método para aumentar a pontuação da pergunta de natação
     * @return Pontuação final da pergunta
     */
    protected int aumentaPontos() {
        setPontuacaoDesporto(super.aumentaPontos()+pontuacaoNatacao);
        return getPontuacaoTotalDesporto();
    }
    /**
     * Método para aceder à pontuação da pergunta de natação
     * @return Pontuação de natação
     */
    public int getPontuacaoNatacao() {
        return pontuacaoNatacao;
    }
    /**
     * Método para aceder mudar pontuação da pergunta de natação
     */
    public void setPontuacaoNatacao(int pontuacaoNatacao) {
        this.pontuacaoNatacao = pontuacaoNatacao;
    }
    /**
     * Método para imprimir uma string com o tipo da pergunta,pergunta e opções
     * @return Natação, pergunta e opções
     */
    public String toString() {
        return "Natação -> " +getPerg()+" "+getOpcoes();
    }
}
