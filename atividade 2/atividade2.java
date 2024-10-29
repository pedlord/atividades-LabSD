import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Aluno: Pedro Inácio de Carvalho Junior
 * Matrícula: 202004940011
 */
public class atividade2 {
    public static void main(String[] args) {
        while (true) {
            BufferedReader cadeia = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader ordem = new BufferedReader(new InputStreamReader(System.in));
            try {
                System.out.println("\nEscreva a cadeia: ");
                Integer valor = Integer.parseInt(cadeia.readLine());
                
                System.out.println("Deseja que as Threads, com exceção da 5ª, executem em ordem? (y/n)");
                String emOrdem = ordem.readLine().toLowerCase();
    
                int valorDividido = (int) Math.ceil(valor / 4.0);
    
                EscreveCadeia thread1 = new EscreveCadeia("thread_1", 1, valorDividido);
                EscreveCadeia thread2 = new EscreveCadeia("thread_2", valorDividido + 1, valorDividido * 2);
                EscreveCadeia thread3 = new EscreveCadeia("thread_3", valorDividido * 2 + 1, valorDividido * 3);
                EscreveCadeia thread4 = new EscreveCadeia("thread_4", valorDividido * 3 + 1, valor);
                
                thread1.setPriority(Thread.MAX_PRIORITY);
                thread1.start();
    
                if(emOrdem.contains("y")){
                    try {
                        thread1.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
    
                thread2.setPriority(Thread.MAX_PRIORITY);
                thread2.start();
    
                if(emOrdem.contains("y")){
                    try {
                        thread2.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
    
                thread3.setPriority(Thread.MAX_PRIORITY);
                thread3.start();
    
                if(emOrdem.contains("y")){
                    try {
                        thread3.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
    
                thread4.setPriority(Thread.MAX_PRIORITY);
                thread4.start();
    
    
                try {
                    thread1.join();
                    thread2.join();
                    thread3.join();
                    thread4.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
    
                EscreveCadeia thread5 = new EscreveCadeia("thread_5", 1, valor);
                thread5.setPriority(Thread.MIN_PRIORITY);
                thread5.start();
    
                try {
                    thread5.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
    
            } catch (Exception e) {
                System.out.println("Erro: digite um número inteiro para a cadeia");
            }
            
        }

    }
}