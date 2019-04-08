package src.ordenacao.bubble_sort;

import java.util.Scanner;
import java.text.CollationKey;
import src.Keys;

/*
	- Uso: java src.ordenacao.BubbleSort
	
	Entrada:
		tamanhoDoVetor
		palavra1
		palavra2
		...
		palavraN
		
	Saída:
		Vetor ordenado
*/

public class BubbleSort{
	private static CollationKey[] keys;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int tam = sc.nextInt();
		sc.nextLine();
		String[] v = new String[tam];
		for(int i = 0; i < tam; i++){
			v[i] = sc.nextLine();
		}
		
		BubbleSort.ordena(v);
		Keys.print(keys);
	}
	
	public static void ordena(String[] v){
		keys = Keys.createCollationKeys(v);
		
		for(int i = 0; i < v.length-1; i++){
			for(int j = 0; j < v.length-1; j++){
				if(keys[j].compareTo(keys[j+1]) > 0)
					Keys.swap(keys, j, j+1);
			}
		}
	}
}