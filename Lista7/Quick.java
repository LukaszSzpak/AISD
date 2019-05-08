package Zadanie;

public class Quick {
	
	private Analiza analiza;
	
	public Quick(Analiza analiza) {
		this.analiza = analiza;
	}
	
	public int partition(int tab[], int low, int high) { 
		
        int pivot = tab[high];  
        int i = (low-1);

        for (int j = low; j < high; j++) { 
        	
            if (tab[j] <= pivot) {
                i++;        
                this.swap(tab, i, j);
            } 
            
            this.analiza.zwiekszPorownanie(1);
        } 
        
        this.swap(tab, i+1, high);	
  
        return i+1; 
    } 
  

    public void sort(int tab[], int low, int high) { 
        if (low < high) { 
            int pi = partition(tab, low, high); 
            
            sort(tab, low, pi-1); 
            sort(tab, pi+1, high); 
        } 
    } 
	/*
	public void sort(int tab[], int lewy, int prawy) {
		if(prawy <= lewy) 
			return;
		
		int i = lewy;
		int j = prawy;
		int pivot = tab[(lewy+prawy)/2];
		
		while(true) {
			while(pivot>tab[i]) {
				i++;
			}
			
			while(pivot<tab[j]) {
				j--;
			}
				
			this.analiza.zwiekszPorownanie(1);
			if( i <= j)
				swap(tab, i, j);
			else
				break;
		}

		if(j > lewy)
			this.sort(tab, lewy, j);
		if(i < prawy)
			this.sort(tab, i, prawy);
		
	}
	*/
    public void swap(int tab[], int a, int b) {
    	int temp = tab[a];
    	tab[a] = tab[b];
    	tab[b] = temp;
    	
    	this.analiza.zwiekszPrzepisanie(3);
    }
}