# Compiler-Design-Project-First-Follow
The objctive of this project is to implement the algorithms computing the functions First and Follow, for the variables of a given context-free grammar.   
A CFG is a quadruple (V, Σ, R, S):
* where V and Σ are disjoint alphabets (respectively,containing variables and terminals)
* R ⊆ V × (V ∪ Σ)∗is a set of rules
* S ∈ V is the start variable  
* This project is implmented using Java
•  Assumptions:  
a) The set V of variables consists of upper-case English symbols.  
b) The start variable is the symbol S.  
c) The set Σ of terminals consists of lower-case English symbols other than “e”.  
d) The letter “e” represents ε.  
• A string encoding a CFG is a semi-colon-separated sequence of items. Each item represents
a largest set of rules with the same left-hand side and is a comma-separated sequence of
strings. The first string of each item is a member of V, representing the common left-hand
side. The first string of the first item is S.  
• For example, consider the CFG ({S, T, L}, {i,a,b,c,d}, R, S), where R is given by the
following productions.  
S −→ ScT | T  
T −→ aSb | iaLb | ε  
L −→ SdL | S  
This CFG will have the following string encoding.  
**S,ScT,T;T,aSb,iaLb,e;L,SdL,S**  
• The output of each of First and Follow is, similar to the input, a semi-colon-separated
sequence of items, where each item is a comma-separated pair. The first element of each
pair is a variable of the grammar and the second element is a string representing the First
or, respectively, the Follow set of that variable. The symbols in these strings should appear
in alphabetical order. ($ always appears last.) For example, the result of calling First on
the above CFG may have the following form  
**S,acei;T,aei;L,acdei**    
Similarly, the result of calling Follow may be as follows  
**S,bcd$;T,bcd$;L,b**  

