package Zadanie;

public class Merge {
	
	public Analiza analiza;
	
	public Merge(Analiza analiza) {
		this.analiza = analiza;
	}
	
	public void merge(int tab[], int l, int m, int r) { 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        for (int i = 0; i < n1; ++i) 
            L[i] = tab[l + i]; 
        for (int j = 0; j < n2; ++j) 
            R[j] = tab[m + 1+ j]; 

        int i = 0;
        int j = 0; 
        int k = l; 
        
        while (i < n1 && j < n2) { 
            if (L[i] <= R[j]) { 
                tab[k] = L[i]; 
                i++; 
            } 
            else { 
                tab[k] = R[j]; 
                j++; 
            } 
            k++; 
            
            this.analiza.zwiekszPrzepisanie(1);
            this.analiza.zwiekszPorownanie(1);
        } 
        
  
        while (i < n1) { 
            tab[k] = L[i]; 
            i++; 
            k++; 
            this.analiza.zwiekszPrzepisanie(1);
        } 
  
        while (j < n2) { 
            tab[k] = R[j]; 
            j++; 
            k++; 
            this.analiza.zwiekszPrzepisanie(1);
        } 
    } 
  

    public void sort(int tab[], int l, int r) { 
        if (l < r) 
        { 
            int m = (l+r)/2; 
  
            this.sort(tab, l, m); 
            this.sort(tab , m+1, r); 
  
            this.merge(tab, l, m, r); 
        } 
    } 
	
	
}