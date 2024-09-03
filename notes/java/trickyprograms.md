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