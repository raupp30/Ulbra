#include <stdio.h>
#include <math.h>
int main() {
int i,a,b,c,maior,menor,meio;

	printf("Digite o valor de I -");
    scanf("%d%*c", &i);
    
    printf("Digite o valor de A -");
    scanf("%d%*c", &a);
    
    printf("Digite o valor de B -");
    scanf("%d%*c", &b);
    
    printf("Digite o valor de C -");
    scanf("%d%*c", &c);
    
    
   
   if ((a>b) && (a>c)){
    	maior=a;
    	if(b>c){ 
		    menor=c;
    		meio=b;
		}else{
			meio=c;
			menor=b;
		}
		
		
		
	}else if ((b>a) && (b>c)){
    	maior=b;
    	if(a>c){ 
		    menor=c;
    		meio=a;
		}else{
			meio=c;
			menor=a;
		}
		
		
		}else{

    	maior=c;
    	if(a>b){ 
		    menor=b;
    		meio=a;
		}else{
			meio=b;
			menor=a;
		}
		}
		
   
   
    switch (i){
    	case 1:{
    		printf("%d %d %d",menor,meio,maior);
			break;
		}
		case 2:{
			printf("%d %d %d",maior,meio,menor);
			break;
		}
		case 3:{
			printf("%d %d %d", meio,maior,menor);
			break;
		}
	}
	
    return 0;
}