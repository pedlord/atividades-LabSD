//ATIVIDADE 1
//Aluno: Pedro Inácio de Carvalho Junior
//Matrícula: 202004940011

#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

int main()
{
    int p;
    int status;
    for(int i =1; i <= 5; i++){
        p = fork();
        pid_t cpid;

        if(p<0)
        {
            perror("O fork falhou");
            exit(1);
        }
        else if(p != 0){
            printf("Processo Pai: %d, em espera\n",getpid());
            cpid = waitpid(p, &status, 0); //usei waitpid ao invés do wait por ter o status e id do processo filho que será executado para mostrar no print
            printf("Processo Pai: %d, em execução\n\n",getpid());
        }
        else if ( p == 0){
            printf("Processo Filho: %d, pai: %d\n",getpid(), getppid());
            int c = i * 100;
            for(int j = (c - 100) + 1; j <= c; j++){
                printf("sequência: %d, valor: %d\n", i, j);
            }
            printf("Processo Filho %d finalizado\n",getpid());
            exit(0);
        }
        if (WIFEXITED(status)){
            printf("Filho %d terminou com status: %d\n\n", cpid, WEXITSTATUS(status));
        }
    }
    return 0;
}