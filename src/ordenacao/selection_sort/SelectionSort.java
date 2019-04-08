package src.ordenacao.selection_sort;

import java.util.Scanner;
import java.text.CollationKey;
import src.Keys;

/*
	- Uso: java src.ordenacao.SelectionSort
	
	Entrada:
		tamanhoDoVetor
		palavra1
		palavra2
		...
		palavraN
		
	Saída:
		Vetor ordenado
*/

public class SelectionSort{
	private static CollationKey[] keys;
	private static int menor;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int tam = sc.nextInt();
		sc.nextLine();
		String[] v = new String[tam];
		for(int i = 0; i < tam; i++){
			v[i] = sc.nextLine();
		}
		
		SelectionSort.ordenar(v);
		Keys.print(keys);
	}
	
	public static void ordenar(String[] v){
		keys = Keys.createCollationKeys(v);
		
		for(int i = 0; i < keys.length; i++){
			menor = i;
			for(int j = i+1; j < keys.length; j++){
				if(keys[menor].compareTo(keys[j]) > 0)
					menor = j;
			}
			Keys.swap(keys, menor, i);
		}
	}
}
