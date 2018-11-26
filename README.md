# MTSIProgrammingAssignment
For this programming assignment my job was to read in a text file through the command line and output:
-The number of individual words that are in the text (this means that your code is not counting duplicate words)
-The number of words that have more than 5 letters
-The number of words that have less than 5 letters
-The amount of words that have an even amount of letters
-The amount of words that have an odd amount of letters.

The first thing that my program does is prompt the user to enter in a file to be parsed. Once the file is entered into the
command line, my program begins to parse through the data. I created a hash map for this assignment becasue I was able
to keep track of what words were new and unique and which words were repeated. A hash map made it easy for me to keep track
because of its contain() method. Once I found out that a word was unique, I would increment my word counter and then find the
length() of the new word so that I could increment my other counters accordingly.

Also, to make sure that examples such as "army" and "army," were treated as repeated words, I used a trim() method to 
truncate the string once a special chracter had appeared. This also heped deal with the citations and periods at the end 
of some sentences. Another small detail that this program accounts for are accents in words. I created a helper method that
simply converts every accented letter into a standard english letter, so that those letters are not treated as special characters. 
