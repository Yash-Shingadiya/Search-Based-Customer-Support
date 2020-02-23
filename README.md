# CSX42: Assignment 4
## Name: Yash Mukeshbhai Shingadiya 

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in troubleShootSearch/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile troubleShootSearch/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile troubleShootSearch/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile troubleShootSearch/src/build.xml run -Darg0="technicalInfo.txt" -Darg1="userInfo.txt" -Darg2="synonyms.txt" -Darg3="output.txt" -Darg4="0"  

Note: Arguments accept the absolute path of the files.
- The last argument can be any integer from 0-3

-----------------------------------------------------------------------
## Number of slack days used: 3

-----------------------------------------------------------------------
## Description:

From driver, the elements MyArrayList and MyTree are created by reading the input files using FileProcessor and then depending on the type of visitors different type of matches are done. Basically, there are 3 visitors ExactMatcher, NaiveBayesMatcher and Semantic Matcher. These visitors visit different elements depending on which element accepts the visitor.


Design of MyLogger:
DEBUG_VALUE=3 [Prints every line of different input files to stdout]
DEBUG_VALUE=2 [Prints different constructors that are being called to stdout]
DEBUG_VALUE=1 [Prints the results from file to stdout]
DEBUG_VALUE=0 [No output will be printed from the application to stdout. Only errors will be printed to stdout"]

-----------------------------------------------------------------------
## Data Structures used:

### Map and HashMap: Mainly used for storing the mapping of word and list of line numbers in which that word is present.
### ArrayList: Mainly used for storing the list of nodes(to connect different nodes) and also for storing the technicalInfo contents to create MyArrayList.

-----------------------------------------------------------------------
## References:

### https://www.geeksforgeeks.org/visitor-design-pattern/: Visitor Pattern
### https://stackoverflow.com: read/write operations

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Name:Yash Mukeshbhai Shingadiya
Date: November 20th 2019


