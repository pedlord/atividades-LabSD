#include <stdio.h>
#include <stdlib.h>

int somar(int x, int y){
    return (x + y);
}

int subtrair(int x, int y){
    return (x - y);
}

int main(int argc, char *argv[]){
    int x,y;
    if(argc != 3){
        fprintf(stderr, "Uso: %s num1 num2\n", argv[0]);
        fprintf(stderr, "\tOnde num1 e num2 devem ser números inteiros.\n");
        exit(0);
    }

    x = atoi(argv[1]);
    y = atoi(argv[2]);

    printf("%d + %d = %d\n", x, y, somar(x,y));
    printf("%d + %d = %d\n", x, y, subtrair(x,y));
    return 0;
}