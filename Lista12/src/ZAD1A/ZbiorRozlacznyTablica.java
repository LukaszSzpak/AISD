package ZAD1A;

public class ZbiorRozlacznyTablica {

    private int[] Tab;

    public ZbiorRozlacznyTablica(int wielkosc) {
        this.Tab = new int[wielkosc];
    }

    public void insert(int value) {
        this.Tab[value] = value;
    }

    public void union(int val1, int val2) {
        this.Tab[val1] = val2;
    }

    public int find(int val) {
        if(this.Tab[val] == 0) 
            return -1;

        int temp = val;

        while(this.Tab[temp] != temp) {
            temp = this.Tab[temp];
        }

        this.Tab[val] = temp;

        return val;
    }

    public void print() {
        System.out.println("\nWyswietlam drzewo: ");

        for (int i = 1; i < this.Tab.length; i++) {
            if (this.Tab[i] == 0)
                continue;

            int temp = i;
            String s = "";

            while(this.Tab[temp] != temp) {
                s += temp + " -> ";

                temp = this.Tab[temp];
            }
            s += temp + " -> ";

            System.out.println(s);
        }
    }
}