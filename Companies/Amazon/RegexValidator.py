# Given a list of strings made up of the characters 'a' and 'b', 
# create a regular expression that will match strings 
# that begin and end with the same letter.

# Example
# 'a', 'aa', and 'bababbb'match. 
# 'ab' and 'baba' do not match.


#  ^([ab]): Matches the start of the string followed by either 'a' or 'b'. 
#  The parentheses () capture the matched character for later reference.
#  .*: Matches any characters (zero or more times).
#  \1: Matches the same character as the one captured earlier by the parentheses ().
#  $: Matches the end of the string.


import re

regularExpression = r'^([ab]).*\1$|^[ab]$'
pattern = re.compile(regularExpression)

# Test the pattern
strings = ["abc", "aba", "abb", "a", "b", "c", "ab"]
for string in strings:
    match = pattern.match(string)
    if match:
        print(f"Matched: {string}")
    else:
        print(f"Not matched: {string}")


#--- Prints ---#
# Not matched: abc
# Matched: aba
# Not matched: abb
# Matched: a
# Matched: b
# Not matched: c
# Not matched: ab