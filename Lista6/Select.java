package Zadanie;

import java.util.Comparator;

public class Select<T> {
	
	public void selectSort(T[] tab, Comparator<T> comp) {  
		
        for (int i = 0; i < tab.length - 1; i++) {
        	
            int index = i;  
            
            for (int j = i + 1; j < tab.length; j++) {  
                if (comp.compare(tab[j], tab[index]) < 0) 
                    index = j; 
                
            }  
            
            T temp = tab[index];   
            tab[index] = tab[i];  
            tab[i] = temp;  
        }    
	}
	
}