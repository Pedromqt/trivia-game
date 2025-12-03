/**
 * Classe das perguntas de Ciências que herda da Pergunta
 */
public class Ciencias extends Pergunta{
    /**
     * Pontuação da pergunta de Ciências
     */
    private int pontuacaoCiencias;
    /**
     * String com as opções fáceis
     */
    private String opFaceis;
    /**
     * String com as opções dificeis
     */
    private String opDificeis;
    /**
     * String com a resposta fácil
     */
    private String respFacil;
    /**
     * String com a resposta dificil
     */
    private String respDificil;
    /**
     * Pontução total da pergunta de Ciências
     */
    private int pontuacaoTotalCiencias;
    /**
     * Construtor para criar uma pergunta de ciências
     * @param perg Pergunta
     * @param opcoes Opções da Pergunta
     * @param resp Resposta Correta à pergunta
     */
    public Ciencias(String perg, String opcoes, String resp) {
        super(perg, opcoes, resp);
        this.opFaceis = opcoes.split(":")[0];
        this.opDificeis = opcoes.split(":")[1];
        this.respFacil = resp.split(":")[0];
        this.respDificil = resp.split(":")[1];
        this.pontuacaoCiencias = 5;
    }
    /**
     * Método para selecionar a resposta correta da pergunta consoante o nivel
     * @param p String com a pergunta,opcoes e resposta certa
     * @param level Nível da pergunta
     * @return String com a resposta correta
     */
    protected String selecionaRespostaPergunta(Pergunta p, int level){
        if(level>3){
            return respDificil;
        }else{
            return respFacil;
        }
    }
    /**
     * Método para selecionar as opções da pergunta consoante o nivel
     * @param p String com a pergunta,opcoes e resposta certa
     * @param level Nível da pergunta
     * @return Array de Strings com as opcoes da pergunta
     */
    protected String[] selecionaOpcoesPergunta(Pergunta p, int level){
        if(level>3){
            return opDificeis.split(",");
        }else{
            return opFaceis.split(",");
        }
    }
    /**
     * Método para aumentar a pontuação da pergunta de ciências
     * @return Pontuação final da pergunta
     */
    protected int aumentaPontos() {
        setPontuacaoTotalCiencias(getPontPergunta()+pontuacaoCiencias);
        return getPontuacaoTotalCiencias();
    }
    /**
     * Método para aceder à pontuação da pergunta de ciências
     * @return Pontuação de ciências
     */
    public int getPontuacaoCiencias() {
        return pontuacaoCiencias;
    }

    /**
     * Método para mudar a pontuação da pergunta de ciências
     */
    public void setPontuacaoCiencias(int pontuacaoCiencias) {
        this.pontuacaoCiencias = pontuacaoCiencias;
    }
    /**
     * Método para aceder à resposta dificil
     * @return resposta dificil
     */
    public String getRespDificil() {
        return respDificil;
    }
    /**
     * Método para mudar a resposta dificil
     */
    public void setRespDificil(String respDificil) {
        this.respDificil = respDificil;
    }
    /**
     * Método para aceder à resposta fácil
     * @return resposta fácil
     */
    public String getRespFacil() {
        return respFacil;
    }
    /**
     * Método para mudar a resposta fácil
     */
    public void setRespFacil(String respFacil) {
        this.respFacil = respFacil;
    }
    /**
     * Método para aceder às opções fáceis
     * @return opções fáceis
     */
    public String getOpFaceis() {
        return opFaceis;
    }
    /**
     * Método para mudar as opções fáceis
     */
    public void setOpFaceis(String opFaceis) {
        this.opFaceis = opFaceis;
    }
    /**
     * Método para aceder às opções dificeis
     * @return opções dificeis
     */
    public String getOpDificeis() {
        return opDificeis;
    }
    /**
     * Método para mudar as opções dificeis
     */
    public void setOpDificeis(String opDificeis) {
        this.opDificeis = opDificeis;
    }
    /**
     * Método para aceder à pontuação total de ciências
     * @return Pontuação total de ciências
     */
    public int getPontuacaoTotalCiencias() {
        return pontuacaoTotalCiencias;
    }
    /**
     * Método para mudar a pontuação total de ciências
     */
    public void setPontuacaoTotalCiencias(int pontuacaoTotalCiencias) {
        this.pontuacaoTotalCiencias = pontuacaoTotalCiencias;
    }
    /**
     * Método para imprimir uma string com o tipo da pergunta,pergunta e opções
     * @return Ciencias,pergunta e opções
     */
    public String toString() {
        return "Ciências -> " +getPerg()+" "+getOpcoes();
    }
}
