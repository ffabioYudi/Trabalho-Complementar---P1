package src.ordenacao.quick_sort;

import java.util.Scanner;
import java.text.CollationKey;
import src.Keys;

/*
	- Uso: java src.ordenacao.QuickSort
	
	Entrada:
		tamanhoDoVetor
		palavra1
		palavra2
		...
		palavraN
		
	Saída:
		Vetor ordenado
*/

public class QuickSort{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int tam = sc.nextInt();
		sc.nextLine();
		String[] v = new String[tam];
		for(int i = 0; i < tam; i++){
			v[i] = sc.nextLine();
		}
		
		CollationKey[] vet = Keys.createCollationKeys(v);
		
		QuickSort.ordena(vet, 0, tam-1);
		Keys.print(vet);
	}
	
	public static void ordena(CollationKey[] v, int ini, int fim){
		if(ini >= fim)
			return;
		
		int pivo = partition(v, ini, fim);
		ordena(v, ini, pivo-1);
		ordena(v, pivo+1, fim);
	}
	
	private static int partition(CollationKey[] v, int ini, int fim){
		int indexP = fim;
		CollationKey valueP = v[indexP];
		int j = ini;
		int k = ini;
		
		while(j < fim && k < fim){
			if(v[j].compareTo(valueP) <= 0){
				j++;
				k++;
			}
			
			if(v[k].compareTo(valueP) > 0)
				k++;
		
			if(j == fim || k == fim){
				break;
			}else{
				if(v[j].compareTo(valueP) > 0 && v[k].compareTo(valueP) <= 0)
					Keys.swap(v, j, k);
			}
		}
		
		Keys.swap(v, j, indexP);
		return j;
	}
}
