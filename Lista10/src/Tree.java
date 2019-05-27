public class Tree {

    private Element start;
    private int iloscLisci;
    private int iloscWezlow;
    private int wysokoscDrzewa;
    private int klucz;
    private boolean czyZnaleziony;

    public Tree() {
        this.start = null;
    }

    public Element getRoot() {
        return this.start;
    }

    public void add(int key) {

        if(this.start == null) {
            this.start = new Element(key);
            return;
        }

        Element temp = this.start;
        while(temp != null) {

            if(temp.getKey() == key)
                return;

            if(key < temp.getKey()) {

                if(temp.getLeft() == null) {
                    temp.setLeft(new Element(key));
                }

                temp = temp.getLeft();
            } else {
                
                if(temp.getRight() == null) {
                    temp.setRight(new Element(key));
                    return;
                }

                temp = temp.getRight();
            }               
        }
    }
        /*
            Metoda IN-ORDER do wyświetlania drzewa
        */

    public void inOrder() {
        this.inOrder(this.start);
    }

    private void inOrder(Element element) {

        if(element == null) {
            return;
        }

        inOrder(element.getLeft());
        System.out.println(element.toString());
        inOrder(element.getRight());

    }
        /*
            Metoda PRE-ORDER do wyświetlnia drzewa
        */

    public void preOrder() {
        this.preOrder(this.start);
    }

    private void preOrder(Element element) {
        if (element == null) {
            return;
        }

        System.out.println(element.toString());
        this.preOrder(element.getLeft());
        this.preOrder(element.getRight());
    }
        /*
            Metoda POST-ORDER do wyświetlania drzewa
        */

    public void postOrder() {
        this.postOrder(this.start);
    }

    private void postOrder(Element element) {
        if (element == null) {
            return;
        }

        this.postOrder(element.getLeft());
        this.postOrder(element.getRight());
        System.out.println(element.toString());
    }

        /*
            Metoda wyszukiwania najmniejszego elementu drzewa
        */
    
    public int minElement() {
        
        Element temp = this.start;

        while(temp.getLeft() != null) {
            temp = temp.getLeft();
        }

        return temp.getKey();
    }

        /*
            Metoda wyszukiwania największego elementu drzewa
        */

    public int maxElement() {
        Element temp = this.start;

        while(temp.getRight() != null) {
            temp = temp.getRight();
        }

        return temp.getKey();
    }

        /* 
            Metoda wyszukanie klucza w drzewie
        */

    public int findKey(int key) {
        
        Element temp = this.start;
        while(true) {
            if(temp == null || (temp.getLeft() == null && temp.getRight() == null))
                return -1;

            if(temp.getKey() == key) {
                return temp.getKey();
            }

            if(key < temp.getKey()) {
                temp = temp.getLeft();
            } else {
                temp = temp.getRight();
            }
        }
    }

        /*
            Metoda zliczająca ilość liści
        */

    public int iloscLisci() {
        this.iloscLisci = 0;
        this.iloscLisci(this.start);
        return this.iloscLisci;
    }

    private void iloscLisci(Element element) {
        if (element == null) {
            return;
        }

        if (element.getLeft() == null && element.getRight() == null) {
            this.iloscLisci++;
        }

        this.iloscLisci(element.getLeft());
        this.iloscLisci(element.getRight());
    }

        /*
            Metoda zliczająca ilość wezlow
        */

    public int iloscWezlow() {
        this.iloscWezlow = 0;
        this.iloscWezlow(this.start);
        return this.iloscWezlow;
    }

    private void iloscWezlow(Element element) {
        if (element == null) {
            return;
        }

        if (element.getLeft() != null || element.getRight() != null) {
            this.iloscWezlow++;
        }

        this.iloscWezlow(element.getLeft());
        this.iloscWezlow(element.getRight());
    }

        /*
            Metoda obliczająca wysokość drzewa
        */

    public int getWysokoscDrzewa() {
        this.wysokoscDrzewa = 0;
        this.obliczWysokoscDrzewa(this.start, 0);
        return this.wysokoscDrzewa;
    }

    private void obliczWysokoscDrzewa(Element element, int wysokosc) {
        if (element == null) {
            if (wysokosc-1 > this.wysokoscDrzewa) {
                this.wysokoscDrzewa = wysokosc-1;
            }
            return;
        }

        this.obliczWysokoscDrzewa(element.getLeft(), wysokosc+1);
        this.obliczWysokoscDrzewa(element.getRight(), wysokosc+1);

    }

        /*
            Metoda wyświetlająca graficznie drzewo
        */

    public void printTree() {
        this.printTree(this.start, 0);
    }

    private void printTree(Element element, int wysokosc) {
        if (element == null) {
            return;
        }
        
        this.printTree(element.getRight(), wysokosc+1);

        for(int i = 0; i < wysokosc; i++) {
            System.out.print("  ");
        }

        System.out.println(element.getKey());

        this.printTree(element.getLeft(), wysokosc+1);
    }

        /*
            Metoda wyszukująca następnik 
        */
    
        public int znajdzNastepnik(int klucz) {

            this.czyZnaleziony = false;
            this.klucz= -1;
            this.znajdzNastepnik(this.start, klucz);

            if (this.czyZnaleziony)
                return this.klucz;
            return -1;
        }

        private void znajdzNastepnik(Element element, int klucz) {
            if (element == null) {
                return;
            }

            znajdzNastepnik(element.getLeft(), klucz);

            if (this.klucz == klucz && !this.czyZnaleziony) {
                this.czyZnaleziony = true;
                this.klucz = element.getKey();
                return;
            }
    
            if (!this.czyZnaleziony)
                this.klucz = element.getKey();

            znajdzNastepnik(element.getRight(), klucz);
        }

            /* 
                metoda wyszukująca poprzednik
            */

        public int znajdzPoprzednik(int klucz) {
            this.czyZnaleziony = false;
            this.klucz= -1;
            this.znajdzPoprzednik(this.start, klucz);

            if (this.czyZnaleziony)
                return this.klucz;
            return -1;
        }

        private void znajdzPoprzednik(Element element, int klucz) {
            if (element == null) {
                return;
            }

            znajdzPoprzednik(element.getLeft(), klucz);

            if (element.getKey() == klucz && !this.czyZnaleziony) {
                this.czyZnaleziony = true;
                return;
            }
    
            if (!this.czyZnaleziony)
                this.klucz = element.getKey();

            znajdzPoprzednik(element.getRight(), klucz);
        }

            /*
                metoda usuwająca element z drzewa 
            */
        
        public boolean delete(int klucz) {
            Element temp = this.start;
            Element parent = this.start;

            while(temp.getKey() != klucz && temp != null) {

                if (temp.getKey() < klucz) {
                    parent = temp;
                    temp = temp.getRight();
                } else {
                    parent = temp;
                    temp = temp.getLeft();
                }
            }

            if (temp == null) {
                return false;
            }

            this.deleteElement(temp, parent);
            return true;
        }

        private void deleteElement(Element element, Element parent) {

            if(element == this.start) {
                if(element.getLeft() == null && element.getRight() == null) {
                    this.start = null;
                } else if (element.getLeft() == null) {
                    this.start = this.start.getRight();
                } else if (element.getRight() == null) {
                    this.start = this.start.getLeft();
                } else {
                    this.start = zamienMin(element, element.getRight());
                }
                return;
            }

            if(element.getLeft() == null && element.getRight() == null) {
                if (parent.getLeft() == element) {
                    parent.setLeft(null);
                } else {
                    parent.setRight(null);
                }
            } else if (element.getLeft() == null) {
                if (parent.getLeft() == element) {
                    parent.setLeft(element.getRight());
                } else {
                    parent.setRight(element.getRight());
                }              
            } else if (element.getRight() == null) {
                if (parent.getLeft() == element) {
                    parent.setLeft(element.getLeft());
                } else {
                    parent.setRight(element.getLeft());
                }
            } else {
                element = zamienMin(element, element.getRight());
            }

        }

        private Element zamienMin(Element delete, Element element) {
            if (element.getLeft() != null) {
                element.setLeft(zamienMin(delete, element.getLeft()));
            } else {
                delete.setKey(element.getKey());
                element = element.getRight();
            }

            return element;
        }

}