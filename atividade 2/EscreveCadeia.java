/*
 * Aluno: Pedro Inácio de Carvalho Junior
 * Matrícula: 202004940011
 */
public class EscreveCadeia extends Thread {
    private String nome;
    private int numInicial;
    private int numFinal;

    public EscreveCadeia(String nome, int numeroInicial, int numeroFinal) {
        super(nome);
        this.nome = nome;
        this.numInicial = numeroInicial;
        this.numFinal = numeroFinal;
        if (nome.contains("5")) {
            System.out.println(nome + " verificando primos na cadeia de " + numeroInicial + " à " + numeroFinal);
        } else {
            System.out.println(nome + " com cadeia de " + numeroInicial + " à " + numeroFinal);
        }
    }

    public boolean checkPrimo(int num) {
        if (num == 2) {
            return true;
        } else if (num <= 1 || num % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void escrevePrimos() {
        for (; numInicial <= numFinal; numInicial++) {
            if (checkPrimo(numInicial)) {
                System.out.println(numInicial + " é primo");
            }
        }
    }

    public void passarVez() {
        Thread.yield();
    }

    public void run() {
        while (numInicial <= numFinal) {
            if (nome.contains("5")) {
                escrevePrimos();
            } else {
                System.out.println(nome + " " + numInicial);
                numInicial++;
                passarVez();
            }
        }
    }
}
