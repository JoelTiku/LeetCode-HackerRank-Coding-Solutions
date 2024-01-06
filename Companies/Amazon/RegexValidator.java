
/*
Given a list of strings made up of the characters 'a' and 'b', 
create a regular expression that will match strings 
that begin and end with the same letter.

Example
'a', 'aa', and 'bababbb'match. 
'ab' and 'baba' do not match.
 */

/* 
  ^([ab]): Matches the start of the string followed by either 'a' or 'b'. 
  The parentheses () capture the matched character for later reference.
  .*: Matches any characters (zero or more times).
  \1: Matches the same character as the one captured earlier by the parentheses ().
   $: Matches the end of the string.
*/


import java.util.regex.*;

public class RegexValidator {
    public static void main(String[] args) {
        
        String regularExpression = "^(a|b).*\\1$|^[a|b]$";

        String inputExpression = "aba";

        Pattern pattern = Pattern.compile(regularExpression);
        
        Matcher matcher = pattern.matcher(inputExpression);

        // matcher.matches() checks if the entire input string matches the regex pattern.
        boolean entireMatchFound = matcher.matches();

        if (entireMatchFound) {
            System.out.println("Entire Input Matches!");
        } else {
            System.out.println("Entire Input Does not Match!");
        }

        // Reset the matcher to check for partial matches
        matcher.reset();

        // matcher.find() finds partial matches within the input string,
        boolean partialMatchFound = matcher.find();

        if (partialMatchFound) {
            System.out.println("Match Found!");
        } else {
            System.out.println("Match Not Found!");
        }
    }
}






// Entire Input Matches!
// Match Found!