# Tricky Java Programs

<br><br>
### What will the output be?
```java
public class A {  
    public static void main(String args[]) {  
        //\u000d System.out.println("hello");  
    }  
}  
```
1. Hello
2. hello
3. HELLO
4. Error
5. \u000dhello
<details> <summary>See the answer</summary>2. hello</details>  

<br><br>
### What will the output be?
```java
public class Test {  
    public static void main(String args[]) {  
        int i=20+ +9- -12+ +4- -13+ +19;  
        System.out.println(i);  
    }  
}  
```
1. 77
2. 33
3. 27
4. 76
5. 66
<details> <summary>See the answer</summary>1. 77</details>  

<br><br>
### What will the output be?
```java
String s1 = "Java";  
String s2 = "Java";  
StringBuilder sb1 = new StringBuilder();  
sb1.append("Ja").append("va");  
System.out.println(s1 == s2);  
System.out.println(s1.equals(s2));  
System.out.println(sb1.toString() == s1);  
System.out.println(sb1.toString().equals(s1));  
```
1. true is printed out exactly once.
2. true is printed out exactly twice.
3. true is printed out exactly three times.
4. true is printed out exactly four times.
5. The code does not compile.
<details> <summary>See the answer</summary>3. true is printed out exactly three times.</details>


<br><br>
### What will the output be?
```java
public class Demo {  
    public static void main(String args[]) {  
        System.out.print("a");  
        try {  
            System.out.print("b");  
            throw new IllegalArgumentException();
        }   
        catch (RuntimeException e) {  
            System.out.print("c");  
        }   
        finally {  
            System.out.print("d");
        }  
        System.out.print("e");  
    }  
}  
```
1. abe
2. abce
3. abde
4. abcde
5. An uncaught exception is thrown.
<details> <summary>See the answer</summary>4. abcde</details>




<br><br>
### What will the output be?
```java
public class _C {  
    private static int $;  
    public static void main(String main[]) {  
        String a_b;  
        System.out.print($);  
        System.out.print(a_b);  
    }   
}  
```
1. Compiler error at line 1.
2. Compiler error at line 2.
3. Compiler error at line 4.
4. Compiler error at line 5.
5. Compiler error at line 8.
<details> <summary>See the answer</summary>5. The local variables require assignment before referencing them. Option E is incorrect because class and instance variables have default values and allow referencing. a_b defaults to a null value. And identifiers may begin with a letter, underscore, or dollar sign</details>



<br><br>
### What will the output be?
```java
int[] array = {6,9,8};  
List<Integer> list = new ArrayList<>();  
list.add(array[0]);  
list.add(array[2]);  
list.set(1, array[1]);  
list.remove(0);  
System.out.println(list);
```
1. [8]
2. [9]
3. Something like [Ljava.lang.String;@160bc7c0
4. An exception is thrown.
5. The code does not compile.
<details> <summary>See the answer</summary>2. Option C is incorrect because arrays output something like that rather than an ArrayLis</details>


<br><br>
### What will the output be?
```java
public class Actors {  
    public static void main(String arg[]) {  
        char[] ca ={0x4e, \u004e, 78};  
        System.out.println((ca[0] = = ca[1]) + " "+ (ca[0] = = ca[2]));  
    }   
}  
```
1. true true
2. true false
3. false true
4. false false
5. Compilation fails
<details> <summary>See the answer</summary>5. The Unicode declaration must be enclosed in single quotes: '\u004e'.</details>



<br><br>
### What will the output be?
```java
switch(x) {    
    case x>70:    
        System.out.println("True");    
        break;    
    case 65<x<=70:    
        System.out.println("False");    
        break;    
}
```
1. Output of Memory Error
2. Stack Overflow Error
3. Orphaned Case Error
4. Assertion Error
5. IO Error
<details><summary>See the answer</summary>3. Because Java does not allow us to compare values in the case statements. An error occurred due to invalid switch statement is called Orphaned case error.</details>


<br><br>
### What will the output be?
```java
public static void main(String args[]) {  
    String str="ONE"+1+2+"TWO"+"THREE"+3+4+"FOUR"+"FIVE"+5;  
    System.out.println(str);  
}
```
1. ONE3TWOTHREE7FOURFIVE5
2. ONE12TWOTHREE7FOURFIVE5
3. ONE3TWOTHREE34FOURFIVE5
4. ONETWOTHREEFOURFIVE15
5. ONE12TWOTHREE34FOURFIVE5
<details> <summary>See the answer</summary>5</details>






<br><br>
### What will the output be?
```java
public class Demo {  
    public static void main(String args[]) {  
        System.out.println(Math.min(Double.MIN_VALUE, 0.0d));  
    }  
}  
```
1. 0
2. 0.0
3. Null
4. ArithmaticException
5. Compilation Error
<details> <summary>See the answer</summary>2</details>




<br><br>
### What will the output be?
```java
long longWithL = 1000*60*60*24*365L;  
long longWithoutL = 1000*60*60*34*365;  
```
1. 31536000000 and 1726327040
2. 3.1536e10 and 1.72632704e9
3. 31536000000L and 1726327040
4. Compile Time Error
5. Arithmetic Exception
<details> <summary>See the answer</summary>1</details>




<br><br>
### What will the output be?
```java
public class Demo {  
    static int x=1111;  
    static {  
        x=x-- - --x;   
    }  
    {  
        x=x++ + ++x;  
    }  
    public static void main(String args[]) {  
        System.out.println(x);  
    }  
}  
```
1. 1
2. 2
3. 1110
4. 1109
5. 11
<details> <summary>See the answer</summary>2. We know that the static block executed first. Therefore, the post decrement value of x will be 1111 and the pre decrement value will be 1109 and the difference between the values is 2 and the same will print on the console. Note that the block after the static block will never get executed.</details>




<br><br>
### What will the output be?
```java
public class Example {  
    public static void main(String args[]) {  
        String computerMove;  
        switch ( (int)(3*Math.random()) ) {  
            case 0:  
                computerMove = "Rock";  
                break;  
            case 1:  
                computerMove = "Scissors";  
                break;  
            case 2:  
                computerMove = "Paper";  
                break;  
        }  
        System.out.println("Computer's move is " + computerMove);
    }  
}  
```
1. Rock
2. Scissors
3. Paper
4. Syntax Error
5. Exception
<details> <summary>See the answer</summary>4. In the above program, the switch statement makes a random choice among three possible alternatives. Recall that the value of the expression (int)(3*Math.random()) is one of the integers 0, 1, or 2, selected at random with equal probability, so the switch statement below will assign one of the values "Rock", "Scissors", "Paper" to computerMove, with probability 1/3 for each case. Although the switch statement in this example is correct, this code segment as a whole illustrates a subtle syntax error.
We probably haven't spotted the error, since it's not an error from a human point of view. The computer reports the last line to be an error, because the variable computerMove might not have been assigned a value. In Java, it is only legal to use the value of a variable if a value has already been definitely assigned to that variable. It means that the computer must be able to prove, just from looking at the code when the program is compiled, that the variable must have been assigned a value. Unfortunately, the computer only has a few simple rules that it can apply to make the determination. In this case, it sees a switch statement in which the type of expression is int and in which the cases that are covered are 0, 1, and 2. For other values of the expression, computerMove is never assigned a value. So, the computer thinks computerMove might still be undefined after the switch statement. Now, in fact, this isn't true: 0, 1, and 2 are actually the only possible values of the expression (int)(3*Math.random()), but the computer is not smart enough to figure that out. The easiest way to fix the problem is to replace the case label case 2 with default.
The computer can see that a value is assigned to computerMove in all cases. More generally, we say that a value has been definitely assigned to a variable at a given point in a program if every execution path leading from the declaration of the variable to that point in the code includes an assignment to the variable. This rule takes into account loops and if statements as well as switch statements.</details>




<br><br>
### What will the output be?
```java
class Base{  
    public static void main(String[] args){  
        System.out.println("Hello");  
    }  
}  
public class Test extends Base{}  
```
1. It will fail to compile
2. Runtime error
3. Compiles and runs with no output
4. Compiles and runs printing Hello
5. Error at line at 6
<details> <summary>See the answer</summary>4. The program will compile and run successfully. Does not matter the Test class is empty.</details>


<br><br>
### What will the output be?
```java
public class TestHashMap {  
    public static void main(String[] args) {  
        HashMap<String,String> map = new HashMap<String,String>(){  
        {  
            put("1", "ONE");  
        }{  
            put("2", "TWO");  
        }{  
            put("3", "THREE");  
        }  
        };  
        Set<String> keySet = map.keySet();  
        for (String string : keySet) {  
            System.out.println(string+" ->"+map.get(string));  
        }  
    }  
}  
```
1. The first set of brace creates a new anonymous inner class and the second set of brace creates an instance initializer like static block in class.
2. The second set of brace creates a new anonymous inner class and the first set of brace creates an instance initializer like static block in class.
3. Neither first set of brace creates a new anonymous inner class nor the second set of brace creates an instance initializer like static block in class.
4. The use of double brace initialization is not allowed in Java.
5. None of the above
<details> <summary>See the answer</summary>1</details>





<br><br>
### Which of the following statements run infinitely?
```java
i. for( ; ; )
ii. for( ; true; )
iii. for( ; false; )
iv. for( ; 2==2; )
v. for(int i=1; i>=1; i++)
```
1. Only i
2. ii and v
3. i, ii, and iii
4. i, ii, iv, and v
5. i, ii, iii, iv, and v
<details> <summary>See the answer</summary>4</details>





<br><br>
### What will the output be?
```java
public class Block {    
    static {  
        System.out.println("Static Block-1");  
    }    
    public static void main(String args[]) {    
        System.out.println("Main Method");    
    }    
    static {  
        System.out.println("Static Block-2");  
    }   
}  
```
1. Static Block-1, Static Block-2, Main Method
2. Static Block-2, Static Block-1, Main Method
3. Main Method, Static Block-1, Static Block-2
4. Static Block-1, Main Method, Static Block-2
5. Main Method, Static Block-2, Static Block-1
<details> <summary>See the answer</summary>1. If a Java program have both static blocks and main() method, in such a case all the static block will execute first then the main() method. Therefore, option A is correct.</details>




<br><br>
### What will the output be?
```java
public class SplitString {  
    public static void main(String args[]) {  
        String str="Java|Python|Hadoop";  
        String[] array = str.split("\\|");  
        System.out.println(Arrays.toString(array));  
    }  
}  
```
1. [Java\\ Python\\ Hadoop]
2. [Java|Python|Hadoop]
3. [Java\\|Python\\|Hadoop]
4. [Java, Python, Hadoop]
<details> <summary>See the answer</summary>4</details>




<br><br>
### If we put System.exit(0) on try or catch block in such a case Will finally block execute or not? Also specify the reason.
1. It is an invalid situation.
2. It skips the finally block.
3. JVM exit with SecurityException and finally block will execute.
4. JVM exit without SecurityException Exception and finally block will not execute.
5. The finally block may or may not be executed.
<details> <summary>See the answer</summary>5. By Calling System.exit(0) in try or catch block, we can skip the finally block. System.exit(int) method can throw a SecurityException.
If System.exit(0) exits the JVM without throwing the exception then finally block will not execute. But, if System.exit(0) does throw SecurityException then finally block will be executed.</details>




<br><br>
### Which exception is thrown by the following Java program?
```java
public class ExceptionDemo {  
    public static void main(String args[]) {  
       Object x[] = new String[3];  
         x[0] = new Integer(0);  
    }  
}  
```
1. ArrayIndexOutOfBoundsException
2. ArrayStoreException
3. NegativeArraySizeException
4. NullPointerException
5. ClassCastException
<details> <summary>See the answer</summary>2. ArrayStoreException is a runtime exception. Array must contain the same data type elements. It exception is thrown to indicate that an attempt has been made to store the wrong type of object into an array of objects. In other words, if you want to store the integer Object in an Array of String you will get ArrayStoreException.</details>

