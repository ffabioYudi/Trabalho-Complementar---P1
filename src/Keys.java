package src;

import java.util.Locale;
import java.text.Collator;
import java.text.CollationKey;

public abstract class Keys{
	private static Locale l = new Locale("pt", "BR");
	private static Collator c = Collator.getInstance(l);
	private static CollationKey[] keys;
	
	public static CollationKey[] createCollationKeys(String[] v){
		keys = new CollationKey[v.length];
		
		for(int i = 0; i < keys.length; i++)
			keys[i] = c.getCollationKey(v[i]);
		
		return keys;
	}
	
	public static void swap(CollationKey[] v, int a, int b){
		CollationKey aux = v[a];
		v[a] = v[b];
		v[b] = aux;
	}
	
	public static void print(CollationKey[] v){
		for(int i = 0; i < v.length; i++){
			if(i == v.length-1)
				System.out.print(v[i].getSourceString()+"\n");
			else
				System.out.print(v[i].getSourceString()+", ");
		}
	}
}