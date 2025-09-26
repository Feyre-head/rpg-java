import java.util.Random;
import java.util.Scanner;

public class jogoFuncoesComplexo {
    static int pocao = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int vidaHeroi = 60;
        int vidaMonstro = 50;
        int xp = 0;
        boolean especialDisponivel = true;

        // História inicial
        System.out.println("Era uma vez em um reino distante...");
        System.out.println("Um jovem herói chamado Taffeson foi escolhido para enfrentar um terrível monstro.");
        System.out.println("O destino do vilarejo depende de sua coragem e de suas escolhas!");
        System.out.println("Prepare-se para a batalha! \n");

        System.out.println("Bem-vindo ao RPG das Funções!");
        System.out.println("Ajude Taffeson a derrotar o monstro para salvar o vilarejo.\n");

        while (vidaHeroi > 0 && vidaMonstro > 0) {
            System.out.println("\n ❤️ Vida de Taffeson: " + vidaHeroi + " | 🐉 Vida do Monstro: " + vidaMonstro);
            System.out.println("🎒 Poções restantes: " + pocao);
            System.out.println("Escolha sua ação:");
            System.out.println("1 - Atacar");
            System.out.println("2 - Usar Poção");
            System.out.println("3 - Defender");
            System.out.println("4 - Poder Especial");
            System.out.println("5 - Fugir");
            System.out.println("O que deseja fazer? ->  ");

            int escolha = sc.nextInt();

            if (escolha == 1) {
                vidaMonstro = atacar(vidaMonstro, rand);

            } else if (escolha == 2) {

                vidaHeroi = usarPocao(vidaHeroi);

            } else if (escolha == 3) {
                // TODO: chamar a função defender()
                // Essa função deve:
                // 1. Apenas imprimir uma mensagem avisando que Taffeson está defendendo.
                // 2. Reduzir dano em 50%.
                // defender();
            } else if (escolha == 4) {
                // TODO: chamar a função poderEspecial()
                // Essa função deve:
                // 1. Só poder ser usada UMA vez no jogo.
                // 2. Causar 25 de dano fixo no monstro.
                // 3. Mostrar mensagens ("Taffeson usou o poder especial!").
                // if (especialDisponivel) {
                //     vidaMonstro = poderEspecial(vidaMonstro);
                //     especialDisponivel = false;
                // } else {
                //     System.out.println("❌ O poder especial já foi usado!");
                // }
            } else if (escolha == 5) {
                // TODO: chamar a função fugir()
                // Essa função deve:
                // 1. Mostrar mensagem de que Taffeson fugiu da batalha.
                // 2. Encerrar o jogo imediatamente.
                // fugir();
                return;
            } else {
                System.out.println("Opção inválida!");
                continue;
            }

            // Turno do monstro
            //TODO leve essa logica para uma função chamada Ataque de Mostro()
            int ataqueMonstro = rand.nextInt(10) + 5; // dano entre 5 e 15
            boolean critico = rand.nextInt(100) < 15; // 15% de chance crítico
            if (critico) {
                ataqueMonstro *= 2;
                System.out.println("💥 O monstro acertou um CRÍTICO!");
            }
            vidaHeroi -= ataqueMonstro;
            System.out.println("🐉 O monstro atacou e causou " + ataqueMonstro + " de dano!");
        }

        if (vidaMonstro <= 0) {
            // TODO: chamar a função ganharXP()
            // Essa função deve:
            // 1. Gerar um número aleatório entre 10 e 30.
            // 2. Retornar esse valor como experiência (XP).
            // 3. Mostrar mensagem de vitória com o XP ganho.
            // xp = ganharXP();
            System.out.println("🎉 Taffeson derrotou o monstro e ganhou " + xp + " XP!");
            System.out.println("🏆 O vilarejo foi salvo graças à bravura de Taffeson!");
        } else {
            System.out.println("💀 Taffeson foi derrotado... o vilarejo está em perigo!");
        }
    }

    // =============================
    //        Funções/Métodos
    // =============================

    public static int atacar(int vidaMonstro, Random rand) {

        int ataqueHeroi = rand.nextInt(4) + 8;
        boolean critico = rand.nextInt(100) < 20; // 20% de chance crítico

        if (critico) {
            ataqueHeroi *= 2;
            System.out.println("💥 Taffeson atacou!  'Crítico!'");
            System.out.println(" Taffeson Causou " + ataqueHeroi + " de dano!");
        } else {
            System.out.println("💥 Taffeson atacou! e causou " + ataqueHeroi + " de dano!");
        }

        vidaMonstro -= ataqueHeroi;
        return vidaMonstro;


        // 2. Ter 20% de chance de ataque crítico (dano dobrado).
        // 3. Mostrar mensagens no console ("Taffeson atacou...", "Crítico!" etc).
        // 4. Retornar a nova vida do monstro após o ataque.
        //
    }


    public static int usarPocao(int vidaHeroi) {
        if (pocao > 0) {
            vidaHeroi += 15;
            pocao--;
            System.out.println("\uD83C\uDF75 Você usou uma poção! +15 ");
            System.out.println("❤️ Vida Atual:" + vidaHeroi);
        }
        if (pocao == 0) {
            System.out.println("❌ Você não tem mais Poções! \uD83C\uDF75");
        }
        return vidaHeroi;
    }
    // public static void defender() { ... }

    // public static int poderEspecial(int vidaMonstro) { ... }


    //FUGIR
    public static void fugir() {
        System.out.println("\uD83D\uDCA8 Taffeson fugiu da batalha");

    }

}
