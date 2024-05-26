# JavaExercises

1. Write a program that takes a number (n) from a user (positive or negative) and prints the sum of 1/-1 to n (Solution: for and while loops and recursion)
2. Write a program that takes a number (n) from a user and prints the sum of all the numbers that are multiple of 3 and 5 between 1 and n
3. Write a program that takes two numbers from a user, then asks the user to choose between sum, substraction, multiplication, product, or all and prints the results
4. Write a program that takes a number (n) from a user and prints the multiplication table from 0 to n
5. Write a program that prints all prime numbers between 1 and 100
6. Write a guessing game where the user has to guess a secret number. After every guess the program tells the user whether their number was too large or too small. At the end the number of tries needed should be printed. It counts only as one try if they input the same number multiple times consecutively.
7. Write a program that prints the next 20 leap years
8. Write a function that returns the largest element in a list.
9. Write function that reverses a list, preferably in place (without using classes by manipulating the array directly)
10. Write a function that checks whether an element occurs in a list
11. Write a function that returns the position(s) where an element occurs in a list
12. Write a function that returns the elements in odd positions in the list
13. Write a function that tests if a string is palindrome
14. Write three functions that compute the sum of the numbers in a list: using a for-loop, a while-loop and recursion
15. Write a function on_all that applies a function to every element of a list. Use it to print the first twenty perfect squares. The perfect squares can be found by multiplying each natural number with itself. The first few perfect squares are 1*1= 1, 2*2=4, 3*3=9, 4*4=16. Twelve for example is not a perfect square because there is no natural number m so that m\*m=12.
16. Write a function that concatenates two lists. [a,b,c], [1,2,3] â†’ [a,b,c,1,2,3] (without using any classes)
17. Write a function that combines two lists by alternatingly taking elements, e.g. [a,b,c], [1,2,3] â†’ [a,1,b,2,c,3].
18. Write a function that rotates a list by k elements. For example [1,2,3,4,5,6] rotated by two becomes [3,4,5,6,1,2]. Try solving this without creating a copy of the list.
19. Write a function that computes the list of the first 100 Fibonacci numbers. The first two Fibonacci numbers are 1 and 1. The n+1-st Fibonacci number can be computed by adding the n-th and the n-1-th Fibonacci number. The first few are therefore 1, 1, 1+1=2, 1+2=3, 2+3=5, 3+5=8.
20. Write a function that takes a number and returns a list of its digits. So for 2342 it should return [2,3,4,2].
21. Write functions that add, subtract, and multiply two numbers in their digit-list representation (and return a new digit list).
22. Implement the following sorting algorithms: Selection sort, Insertion sort, Merge sort, Quick sort, Stooge Sort.
23. Implement binary search
24. Write a function that takes a list of strings an prints them, one per line, in a rectangular frame. For example the list ["Hello", "World", "in", "a", "frame"] gets printed as:

\*\*\*\*\*\*\*\*\*\*<br> \* Hello &nbsp;&nbsp;\*<br> \* World &nbsp;\*<br> \* in &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\*<br> \* a &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\*<br> \* frame &nbsp;\*<br>
\*\*\*\*\*\*\*\*\*\*

25. Write function that translates a text to Pig Latin and back. English is translated to Pig Latin by taking the first letter of every word, moving it to the end of the word and adding â€˜ayâ€™. â€œThe quick brown foxâ€ becomes â€œHetay uickqay rownbay oxfayâ€ .
26. Write a program that automatically converts English text to Morse code and vice versa.
27. Write a program that finds the longest palindromic substring of a given string. Try to be as efficient as possible!
28. Given two strings, write a program that efficiently finds the longest common subsequence.
29. Given an array with numbers, write a program that efficiently answers queries of the form: â€œWhich is the nearest larger value for the number at position i?â€ , where distance is the difference in array indices. For example in the array [1,4,3,2,5,7], the nearest larger value for 4 is 5. After linear time preprocessing you should be able to answer queries in constant time.
30. Given two strings, write a program that outputs the shortest sequence of character insertions and deletions that turn one string into the other.
31. Write a function that multiplies two matrices together.
32. Write a program to search for the "saddle points" in a 5 by 5 array of integers. A saddle point is a cell whose value is greater than or equal to any in its row, and less than or equal to any in its column. There may be more than one saddle point in the array. Print out the coordinates of any saddle points your program finds. Print out "No saddle points" if there are none.
33. The results from the mayor's race have been reported by each precinct as follows:

              Candidate  Candidate  Candidate  Candidate

    Precinct A B C D
    1 192 48 206 37
    2 147 90 312 21
    3 186 12 121 38
    4 114 21 408 39
    5 267 13 382 29

33.Write a program to do the following:

a. Read the raw vote totals from a data file that contains one row for each precinct.

b. Display the table with appropriate headings for the rows and columns.

c. Compute and display the total number of votes received by each candidate and
the percent of the total votes cast.

d. If any one candidate received over 50% of the votes, the program should print
a message declaring that candidate the winner.

e. If no candidate received 50% of the votes, the program should print a message
declaring a run-off between the two candidates receiving the highest number of
votes; the two candidates should be identified by their letter names.

f. For testing, run the program with the above data, and also with another
data file where Candidate C receives only 108 votes in precinct 34. Write a function that takes 2 numbers from user, then returns the total number of steps required to transform the digits from num1 to num2
For example num1 = 4351; num2 = 6029 â†’ number of steps required: 16 35. Write a program that validates if a number is Harshad or not. An Harshad number is when the number modulo sum of the numbers's digits is = 0

Projects (GUI/Console)

1. Write a program that plays Hangman as good as possible. For example you can use a large dictionary like this and select the letter that excludes most words that are still possible solutions. Try to make the program as efficient as possible, i.e. don't scan the whole dictionary in every turn.
2. Develop a system that manages a library's inventory, tracks book borrowing, and provides features for library staff and patrons.
3. Develop a quizzing game. Use these as databases (text/Json/SQL)
