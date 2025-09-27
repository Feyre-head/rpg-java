import java.util.Random;
import java.util.Scanner;

public class jogoFuncoesComplexo {
    // =============================
    //       VARIÁVEIS GLOBAIS
    // =============================
    static int pocao = 2;                 // 🎒 Poções disponíveis
    static int vidaHeroi = 60;            // ❤️ Vida do herói
    static int vidaMonstro = 50;          // 🐉 Vida do monstro
    static boolean defesa = false;        // 🛡️ Indica se o herói defendeu
    static boolean poderEspecial = true;  // ✨ Controle do poder especial
    static int xp = 0;                    // ⭐ Experiência acumulada
    static int turnos = 0;                // ⏳ Contador de turnos

    static Random rand = new Random();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        // =============================
        //         HISTÓRIA INICIAL
        // =============================
        System.out.println("\uD83D\uDCD6 Era uma vez em um reino distante...");
        System.out.println("\uD83D\uDC66 Um jovem herói chamado Taffeson foi escolhido para enfrentar um terrível monstro.");
        System.out.println("⚔️ O destino do vilarejo depende de sua coragem e de suas escolhas!");
        System.out.println("Prepare-se para a batalha! \n");

        System.out.println("\uD83C\uDFF0 Bem-vindo ao RPG das Funções!");
        System.out.println("Ajude Taffeson a derrotar o monstro para salvar o vilarejo.\n");

        while (vidaHeroi > 0 && vidaMonstro > 0) {
            System.out.println("\n ❤️ Vida de Taffeson: " + vidaHeroi + " | 🐉 Vida do Monstro: " + vidaMonstro);
            System.out.println("🎒 Poções restantes: " + pocao);
            System.out.println("""
                    ========================
                    Escolha sua ação:
                    1 - ⚔️ Atacar
                    2 - 🧪 Usar Poção
                    3 - 🛡️ Defender
                    4 - ✨ Poder Especial
                    5 - 🏃 Fugir
                    ========================
                    O que deseja fazer? ->
                    """);
            int escolha = sc.nextInt();

            // =============================
            //         AÇÕES DO HERÓI
            // =============================
            if (escolha == 1) {
                vidaMonstro = atacar(vidaMonstro, rand);
                turnos++;
            } else if (escolha == 2) {
                vidaHeroi = usarPocao(vidaHeroi);
                turnos++;
            } else if (escolha == 3) {
                defender();
                turnos++;
            } else if (escolha == 4) {
                vidaMonstro = poderEspecial(vidaMonstro);
                turnos++;
            } else if (escolha == 5) {
                fugir();
                break;
            } else {
                System.out.println("❌ Opção inválida!");
                continue;
            }


            // =============================
            //        TURNO DO MONSTRO
            // =============================
            vidaHeroi = monstro(vidaHeroi, rand);

        }

        // =============================
        //       RESULTADO DA BATALHA
        // =============================
        if (vidaMonstro <= 0) {
            ganharXP();
        } else {
            System.out.println("💀 Taffeson foi derrotado... o vilarejo está em perigo!");
        }
    }
    // =============================
    //        FUNCÕES/MÉTODOS
    // =============================

    // ⚔️ ATAQUE
    public static int atacar(int vidaMonstro, Random rand) {

        int ataqueHeroi = rand.nextInt(4) + 8;
        boolean critico = rand.nextInt(100) < 20; // 20% de chance crítico

        if (critico) {
            ataqueHeroi *= 2;
            System.out.println("⚔️ \uD83D\uDCA5 CRÍTICO! Taffeson causou " + ataqueHeroi + " de dano!");
        } else {
            System.out.println("⚔️ Taffeson atacou e causou " + ataqueHeroi + " de dano!");
        }

        return vidaMonstro - ataqueHeroi;
    }

    // 🧪 USAR POÇÃO
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

    // 🛡️ DEFENDER
    public static void defender() {
        defesa = true;
        System.out.println("Tafferson defendeu");
    }

    // ✨ PODER ESPECIAL
    public static int poderEspecial(int vidaMonstro) {
        int especial = 25;
        if (poderEspecial) {
            vidaMonstro -= 25;
            System.out.println("✨🔥 Taffeson usou seu PODER ESPECIAL e causou 25 de dano!");
            poderEspecial = false;
        } else {
            System.out.println("❌ O poder especial já foi usado!");
        }
        return vidaMonstro;
    }


    // 🏃 FUGIR
    public static void fugir() {

        System.out.println("💨 Taffeson fugiu da batalha!");

    }

    // 🐉 TURNO DO MONSTRO
    public static int monstro(int vidaHeroi, Random rand) {
        int ataqueMonstro = rand.nextInt(10) + 5; // dano entre 5 e 15
        boolean critico = rand.nextInt(100) < 15; // 15% de chance crítico
        if (critico) {
            ataqueMonstro *= 2;
            System.out.println("💥 O monstro acertou um CRÍTICO!");
        }
        if (defesa) {
            ataqueMonstro = ataqueMonstro / 2;
            System.out.println("O Dano sofrido foi reduzido pela metade.");
        }
        vidaHeroi -= ataqueMonstro;
        System.out.println("🐉 O monstro atacou e causou " + ataqueMonstro + " de dano!");
        return vidaHeroi;
    }

    // ⭐ GANHO DE XP
    public static void ganharXP() {
        xp = rand.nextInt(10, 30);

        if (turnos < 5) {
            //heroico  xp 100
            xp = 100;
            System.out.println("""
                    🏆 TAFFERSON derrotou o monstro no MODO HEROICO e recebeu o título:
                    
                                        "Campeão das Lendas Eternas!"
                    """);
        } else if (turnos < 8) {
            xp = 50;
            //Veterano xp 50
            System.out.println("""
                    🏆 TAFFERSON derrotou o monstro no MODO VETERANO e recebeu o título:
                    
                                    "Guardião das Batalhas Passadas!"
                    """);
        }

        //Aventureiro Explorador das Terras Selvagens xp aleatório entre 10 e 30
        System.out.println("=======================================================");
        System.out.println("🎉 Taffeson derrotou o monstro e ganhou " + xp + " XP!");
        System.out.println("🏆 O vilarejo foi salvo graças à bravura de Taffeson!");

    }

}