# 🎮 RPG Funções do Taffeson

Um mini-game em Java criado para demonstrar conceitos de **Funções, Vetores, Matrizes e Teste Unitário** de forma
prática e divertida.  
O herói **Taffeson** deve enfrentar um terrível monstro usando ataques, poções, defesa e poder especial para salvar o
vilarejo.

---

## 📖 1️⃣ Introdução do Projeto

O projeto simula uma **batalha de RPG em texto**.  
O jogador escolhe ações em turnos (atacar, defender, usar poção, etc.) enquanto enfrenta um monstro com vida e ataques
aleatórios.

Exemplo de tela do jogo:

```❤️ Vida de Taffeson: 60 | 🐉 Vida do Monstro: 50
🎒 Poções restantes: 2

Escolha sua ação:
1 - ⚔️ Atacar
2 - 🧪 Usar Poção
3 - 🛡️ Defender
4 - ✨ Poder Especial
5 - 🏃 Fugir
```

**Objetivo:** derrotar o monstro e receber **XP** de acordo com o desempenho.

---

## 🧩 2️⃣ Conceitos

### 🔹 1. Funções / Métodos

- **O que são?**  
  Blocos de código reutilizáveis que executam uma tarefa específica.
- **No jogo:**
    - `atacar()` → causa dano no monstro.
    - `usarPocao()` → recupera vida do herói.
    - `defender()` → reduz dano recebido.
    - `poderEspecial()` → golpe mais forte.
    - `ganharXP()` → define a recompensa ao vencer.

👉 **Exemplo simplificado:**

```java
public static int atacar(int vidaMonstro, Random rand) {
    int dano = rand.nextInt(4) + 8;       //dano = 4+8 
    return vidaMonstro - dano;           //retorna vida do monstro - dano
}
```

### 🔹 2. Vetores

- **O que são?**
    - Estruturas que armazenam vários valores do mesmo tipo em uma única variável.

👉 **Exemplo prático:**
Podemos armazenar um histórico de danos aplicados no monstro:

```java
     // índice 0   1   2   3
int[] danos = {10, 8, 15, 12};
System.out.

println("Primeiro ataque causou: "+danos[0]);  //dano no índex 0
// Primeiro ataque causou: 10
``` 

### 🔹 3. Matrizes

- **O que são?**
    - Vetores de duas dimensões (tabelas).

Exemplo prático:
Podemos simular o tabuleiro do RPG ou registrar vida em diferentes batalhas:

```java
int[][] batalhas = {
        //  0   1
        /*0*/{60, 50}, // Herói 60 | Monstro 50
        /*1*/{45, 30}, // Herói 45 | Monstro 30
};
System.out.

println("Vida do monstro na 2ª batalha: "+batalhas[1][1]);
//Vida do monstro na 2ª batalha: 30
```

### 🔹 4. Teste Unitário

- **O que é?**
  Técnica para garantir que cada função funciona corretamente de forma isolada.

**Por que usar?**

- Evita erros e garante a confiabilidade do código.

👉 **Exemplo com JUnit (função atacar e usarPocao):**

```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class JogoTest {
    @Test
    public void testAtacar() {
        int vidaMonstro = 50;
        int vidaRestante = JogoFuncoesComplexo.atacar(vidaMonstro, new Random(1));
        assertTrue(vidaRestante < 50, "O ataque deve reduzir a vida do monstro");
    }

    @Test
    public void testUsarPocao() {
        int vidaHeroi = 40;
        JogoFuncoesComplexo.pocao = 1;
        int novaVida = JogoFuncoesComplexo.usarPocao(vidaHeroi);
        assertTrue(novaVida > 40, "A poção deve aumentar a vida do herói");
    }
}
```

