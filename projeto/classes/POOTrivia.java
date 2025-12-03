import java.util.ArrayList;
/**
 * Classe onde é inicializado o programa
 */
public class POOTrivia {
    public static void main(String[] args){
        ArrayList<Pergunta>perguntas = Ficheiro.leFicheiro("perguntas.txt");
        ArrayList<Pergunta>perguntasUtilizador = Pergunta.perguntasUtilizador(perguntas);
        new TriviaGUI(perguntasUtilizador);
    }
}