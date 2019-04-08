package src.ordenacao.merge_sort;

import java.util.Scanner;
import java.text.CollationKey;
import src.Keys;

public class MergeSort{
	private static CollationKey[] keys;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int tam = sc.nextInt();
		sc.nextLine();
		String[] v = new String[tam];
		for(int i = 0; i < tam; i++){
			v[i] = sc.nextLine();
		}
		
		keys = new CollationKey[tam];
		CollationKey[] vet = Keys.createCollationKeys(v);
		
		MergeSort.ordena(vet, 0, tam-1);
		Keys.print(vet);
	}
	
	public static void ordena(CollationKey[] v, int ini, int fim){
		if(ini == fim)
			return;
		
		int meio = (ini+fim)/2;
		ordena(v, ini, meio);
		ordena(v, meio+1, fim);
		merge(v, ini, fim, meio);
	}
	
	private static void merge(CollationKey[] v, int ini, int fim, int meio){
		copy(v, ini, fim);
		
		int j = ini;
		int k = meio+1;
		
		while(ini <= meio && k <= fim){
			if(keys[ini].compareTo(keys[k]) <= 0)
				v[j++] = keys[ini++];
			
			else
				v[j++] = keys[k++];
		}
		
		while(ini <= meio){
			v[j++] = keys[ini++];
		}
		
		while(k <= fim){
			v[j++] = keys[k++];
		}
	}
	
	private static void copy(CollationKey[] v, int ini, int fim){
		for(int i = ini; i <= fim; i++){
			keys[i] = v[i];
		}
	}
}