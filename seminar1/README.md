## Task 01
[Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/)

Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

### Example 1:
>**Input**: `s = "the sky is blue"`<br>
>**Output**: `"blue is sky the"`<br>
### Example 2:
>**Input**: `s = "  hello world  "`<br>
>**Output**: `"world hello"`<br>
>**Explanation**: Your reversed string should not contain leading or trailing spaces.
### Example 3:

>**Input**: `s = "a good   example"`<br>
>**Output**: `"example good a"`<br>
>**Explanation**: You need to reduce multiple spaces between two words to a single space in the reversed string.
## Task 02

Дана последовательность целых чисел, оканчивающаяся нулем. Найти сумму положительных чисел, после которых следует отрицательное число.

> **Пример ввода**: `1 2 1 2 -1 1 3 1 3 -1 0`<br>
> **Логика расчета**:<br>
> `2 -1 переход -> 2 в сумму`<br>
> `3 -1 переход -> 3 в сумму`<br>
> **Пример вывода**: 5<br>