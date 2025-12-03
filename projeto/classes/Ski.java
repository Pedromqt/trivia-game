/**
 * Classe das perguntas de Ski que herda de Desporto
 */
public class Ski extends Desporto{
    /**
     * Pontuação da pergunta de Ski
     */
    private int pontuacaoSki;
    /**
     * Construtor para criar uma pergunta de Ski
     * @param perg Pergunta
     * @param opcoes Opções da Pergunta
     * @param resp Resposta Correta à pergunta
     */
    protected Ski(String perg, String opcoes, String resp) {
        super(perg, opcoes, resp);
        this.pontuacaoSki = 2;
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
     * Método para aumentar a pontuação da pergunta de ski
     * @return Pontuação final da pergunta
     */
    protected int aumentaPontos() {
        setPontuacaoTotalDesporto(super.aumentaPontos()*pontuacaoSki);
        return getPontuacaoTotalDesporto();
    }
    /**
     * Método para selecionar as opções da pergunta
     * @param p String com a pergunta,opcoes e resposta certa
     * @param level Nível da pergunta
     * @return Array de Strings com as opcoes da pergunta
     */
    public String[] selecionaOpcoesPergunta(Pergunta p, int level){
        return(super.selecionaOpcoesPergunta(p,level));
    }
    /**
     * Método para aceder à pontuação da pergunta de ski
     * @return Pontuação de ski
     */
    public int getPontuacaoSki() {
        return pontuacaoSki;
    }
    /**
     * Método para mudar a pontuação da pergunta de ski
     */
    public void setPontuacaoSki(int pontuacaoSki) {
        this.pontuacaoSki = pontuacaoSki;
    }
    /**
     * Método para imprimir uma string com o tipo da pergunta,pergunta e opções
     * @return Ski, pergunta e opções
     */
    public String toString() {
        return "Ski -> "+getPerg()+" "+getResp();
    }
}
