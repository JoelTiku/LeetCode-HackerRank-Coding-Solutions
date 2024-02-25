
class FolydsTriangle {
    // Floyd's triangle is a right-angled triangular array of natural numbers. 
       
    public static void folydstriangleNum() {
        
        int counter = 0;
        
        for(int row = 0; row < 5; row++){
            for(int col = 0; col < row; col++){
                System.out.print(++counter);
            }
            
            System.out.print("\n");
        }
    }
    
    public static void folydstriangleAsterisk() {
        
        for(int row = 0; row < 5; row++){
            for(int col = 0; col < row; col++){
                System.out.print("*");
            }
            
            System.out.print("\n");
        }
    }
    
    
    public static void main(String[] args) {
        folydstriangleNum();
        folydstriangleAsterisk();
        
    }
}

/*
1
23
456
78910

*
**
***
****
*/