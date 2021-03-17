import java.util.Arrays;

import static javax.swing.JOptionPane.*;

public class JogoDaForca {

    public static void main(String[] args) {
        JogoDaForca jogoDaForca = new JogoDaForca();
        jogoDaForca.mostrarMenu();
    }

 void iniciarJogo(){
    String palavra, tema;
    int opt;
    String letraTentativa = "";
    int numTentativas = 6, numVezes = 0;


    tema = showInputDialog(null, "Insira o tema da palavra", "Inserção de contexto", QUESTION_MESSAGE);
    palavra = showInputDialog(null, "Insira a palavra para começar o jogo", "Tema: " + tema, PLAIN_MESSAGE);
    int numLetrasPalavra = palavra.length();
    char[] palavraCopia = palavra.toCharArray();

    for(int i = 0; i < palavra.length(); i++){
       palavraCopia[i] = '_';
    }


    showMessageDialog(null, "A palavra contém " + palavra.length() + " letras!", "Tema: " + tema, PLAIN_MESSAGE);


    do{

        if(numLetrasPalavra <= (palavra.length() / 2)){

            do {
                opt = Integer.parseInt(showInputDialog(null, Arrays.toString(palavraCopia).toUpperCase() + "\n\nVocê já acertou mais da metade da frase!\n1 - Chutar a palavra\n2 - Continuar adivinhando\n", "Tema: " + tema, PLAIN_MESSAGE));
                if (opt != 1 && opt != 2){
                    showMessageDialog(null, "Opção inválida!\nInsira novamente!", "Erro!", ERROR_MESSAGE);
                }
            }while (opt != 1 && opt != 2);

                switch (opt){
                    case 1: showMessageDialog(null, "Se você errar a palavra, perderá o jogo!", "Tema: " + tema, WARNING_MESSAGE);
                    String tentativaFinal = showInputDialog(null, Arrays.toString(palavraCopia).toUpperCase() + "\n\nQual a palavra?", "Tema: " + tema, QUESTION_MESSAGE);

                        if (String.valueOf(tentativaFinal).equalsIgnoreCase(palavra)){
                            showMessageDialog(null, "Parabéns!! Você acertou!\nA palavra é " + palavra.toUpperCase(), "Tema: " + tema, PLAIN_MESSAGE);
                            System.exit(1);
                        }
                        else {
                        showMessageDialog(null, "Ixi! Você errou =(\nA palavra era " + palavra.toUpperCase(), "Tema: " + tema, ERROR_MESSAGE);
                        System.exit(1);
                        }
                        break;

                    case 2: letraTentativa = showInputDialog(null, Arrays.toString(palavraCopia).toUpperCase() + "\n\nAdivinhe uma letra da palavra", "Tema: " + tema, PLAIN_MESSAGE);
                        break;

                        default: showMessageDialog(null, "Opção inexistente!", "Entrada inválida!", ERROR_MESSAGE);
                }

        }
        else{
            letraTentativa = showInputDialog(null, Arrays.toString(palavraCopia).toUpperCase() + "\n\nAdivinhe uma letra da palavra", "Tema: " + tema, PLAIN_MESSAGE);
        }
            letraTentativa = String.valueOf(letraTentativa.charAt(0));

        for (int i = 0; i < palavra.length(); i++) {
            if (String.valueOf(palavra.charAt(i)).equalsIgnoreCase(letraTentativa)) {
                palavraCopia[i] = letraTentativa.charAt(0);
                numVezes++;
                numLetrasPalavra--;
            }
        }

        if(palavra.contains(letraTentativa.toLowerCase()) || palavra.contains(letraTentativa.toUpperCase())){
            showMessageDialog(null, "A letra " + letraTentativa.toUpperCase() + " está presente " + numVezes + " vez(es)!", "Tema: " + tema, PLAIN_MESSAGE);
            numVezes = 0;

        }
        else{
            showMessageDialog(null, "Letra " + letraTentativa + " não existente na palavra!" + "\n\nRestam " + --numTentativas + " tentativas!", "Tema: " + tema, ERROR_MESSAGE);

        }
        if(numTentativas == 0){
            showMessageDialog(null, "Tentativas esgotadas...\nVocê perdeu.\nA palavra era " + palavra, "Tema: " + tema, ERROR_MESSAGE);
        }
    }while(numTentativas > 0);

}

void mostrarCréditos(){
    showMessageDialog(null, "Desenvolvido por Wilson Rodrigues\n14/03/2021");
}


void mostrarMenu(){
    int n;
    do{
        n = Integer.parseInt(showInputDialog(null, "Bem-vindo ao jogo da forca!\n\n" +
                "Opções:\n" +
                "1 - Jogar\n" +
                "2 - Créditos\n" +
                "3 - Sair\n", "Saudações!", PLAIN_MESSAGE));

        switch (n){
            case 1: iniciarJogo();
            break;

            case 2: mostrarCréditos();
            break;

            case 3:
                showMessageDialog(null, "Obrigado!");
                System.exit(1);
                break;

            default: showMessageDialog(null, "Opção inválida!", "Erro", ERROR_MESSAGE);

        }
    }while(true);
}
}
