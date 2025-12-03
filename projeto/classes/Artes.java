import java.util.Random;
/**
 * Classe das perguntas de Artes que herda da Pergunta
 */
public class Artes extends Pergunta{
    /**
     * Pontuação da pergunta de Artes
     */
    private int pontuacaoArtes;
    /**
     * Pontução total da pergunta de Artes
     */
    private int pontuacaoTotalArtes;
    /**
     * Construtor para criar uma pergunta de artes
     * @param perg Pergunta
     * @param opcoes Opções da Pergunta
     * @param resp Resposta Correta à pergunta
     */
    public Artes(String perg, String opcoes, String resp) {
        super(perg, opcoes, resp);
        this.pontuacaoArtes = 10;
    }
    /**
     * Construtor para selecionar as opções da pergunta consoante o nível
     * @param ops Opções da Pergunta
     * @param level Nível da pergunta
     * @param resp Resposta Correta à pergunta
     * @return Array de strings com as opções
     */
    protected String[] selecionaOpcoesArtes(String ops,int level,String resp){
        if(level>3){
            return ops.split(",");
        }else{
            String opEscolhida="";
            Random random = new Random();
            double numeroAleatorio = random.nextDouble();
            String[] ops2 = new String[3];
            String[] ops3 = ops.split(",");
            int posOpcaoCorreta = (int)(numeroAleatorio*3);
            for(int i=0;i<ops2.length;i++){
                numeroAleatorio = random.nextDouble();
                if(i==posOpcaoCorreta){
                    ops2[i]=resp;
                }else{
                    int posOpcaoRandom = (int)(numeroAleatorio*(ops3.length));
                    if(ops3[posOpcaoRandom].equals(resp) || ops3[posOpcaoRandom].equals(opEscolhida)){
                        while(ops3[posOpcaoRandom].equals(resp) || ops3[posOpcaoRandom].equals(opEscolhida)){
                            numeroAleatorio = random.nextDouble();
                            posOpcaoRandom = (int)(numeroAleatorio*(ops3.length));
                        }
                        opEscolhida=ops3[posOpcaoRandom];
                        ops2[i]=ops3[posOpcaoRandom];
                    }else{
                        opEscolhida=ops3[posOpcaoRandom];
                        ops2[i]=ops3[posOpcaoRandom];
                    }
                }
            }
            return ops2;
        }
    }
    /**
     * Método para selecionar a resposta correta da pergunta consoante o nivel
     * @param p String com a pergunta,opcoes e resposta certa
     * @param level Nível da pergunta
     * @return String com a resposta correta
     */
    protected String selecionaRespostaPergunta(Pergunta p, int level){
        return getResp();
    }
    /**
     * Método para selecionar as opções da pergunta consoante o nivel
     * @param p String com a pergunta,opcoes e resposta certa
     * @param level Nível da pergunta
     * @return Array de Strings com as opcoes da pergunta
     */
    protected String[] selecionaOpcoesPergunta(Pergunta p, int level){
        return selecionaOpcoesArtes(p.getOpcoes(),level,p.getResp());
    }
    /**
     * Método para aumentar a pontuação da pergunta de artes
     * @return Pontuação final da pergunta
     */
    protected int aumentaPontos() {
        setPontuacaoTotalArtes(getPontPergunta()*pontuacaoArtes);
        return getPontuacaoTotalArtes();
    }
    /**
     * Método para aceder à pontuação total de artes
     * @return Pontuação total de artes
     */
    public int getPontuacaoTotalArtes() {
        return pontuacaoTotalArtes;
    }
    /**
     * Método para mudar a pontuação total de artes
     */
    public void setPontuacaoTotalArtes(int pontuacaoTotalArtes) {
        this.pontuacaoTotalArtes = pontuacaoTotalArtes;
    }
    /**
     * Método para aceder à pontuação da pergunta de artes
     * @return Pontuação de artes
     */
    public int getPontuacaoArtes() {
        return pontuacaoArtes;
    }
    /**
     * Método para mudar a pontuação da pergunta de artes
     */
    public void setPontuacaoArtes(int pontuacaoArtes) {
        this.pontuacaoArtes = pontuacaoArtes;
    }
    /**
     * Método para imprimir uma string com o tipo da pergunta,pergunta e opções
     * @return Artes, pergunta e opções
     */
    public String toString() {
        return "Artes -> " +getPerg()+" "+getOpcoes();
    }
}
