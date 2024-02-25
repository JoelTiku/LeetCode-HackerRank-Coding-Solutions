class ValidPalindrome {
    /*
     * A palindrome is a word, phrase, or sequence 
     * that reads the same backwards as forwards. e.g. madam
     */

    // Approach 1: Compare with Reverse
    // Time complexity : O(n)
    // Space complexity : O(n)
    public boolean isPalindrome1(String s) {
        
        // The idea is to use the regular expression [^A-Za-z0-9] 
        // to retain only alphanumeric characters in the string.
        s = s.replaceAll("[^A-Za-z0-9]", "");
        s = s.toLowerCase();
        String rev = "";
        
        for(int i = s.length() - 1; i >= 0; i--){
            rev += s.charAt(i);
        }
        
        if(s.equals(rev)){
            return true;
        }
        
        return false;
    }



    // Approach 2: Compare with Reverse using StringBuilder
    // Time complexity : O(n)
    // Space complexity : O(n)
    public boolean isPalindrome2(String s) {

        StringBuilder builder = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                builder.append(Character.toLowerCase(ch));
            }
        }

        String filteredString = builder.toString();
        String reversedString = builder.reverse().toString();

        return filteredString.equals(reversedString);
    }



    // Approach 2: Two Pointers
    // Time complexity : O(n)
    // Space complexity : O(1)
    public boolean isPalindrome3(String s) {
      for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
        while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
          i++;
        }
        while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
          j--;
        }
  
        if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
          return false;
      }
  
      return true;
    }


    public static void main(String[]args){
        ValidPalindrome palindrome = new ValidPalindrome();

        System.out.println(palindrome.isPalindrome1("radar"));                            
        System.out.println(palindrome.isPalindrome2("Was It A Rat I Saw?"));              
        System.out.println(palindrome.isPalindrome3("pe  e  p"));                        
        System.out.println(palindrome.isPalindrome1("x"));                                 
        System.out.println(palindrome.isPalindrome2("12321"));                                
        System.out.println(palindrome.isPalindrome3("A man, a plan, a canal: Panama"));     
    }
}
  
  
  
  
  
  