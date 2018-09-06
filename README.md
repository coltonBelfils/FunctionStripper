# FunctionStripper #

## FunctionParser ##

#### Function parser is composed of three main functions: ####

- ```tokenize()```
	- This goes through the input string and splits it up into tokens. One for numbers, +, -, *, %, ...
- ```shuntingYard()```
	- This converts the list if tokens from infix notation to postfix notation(reverse polish notation)
- ```evaluate()```
	- This actually evaluates the function

## FunctionParts (and children) ##

#### These classes are what the input function is tokenized into ####

Children:

- ```ValuePart()```
	- For numbers
- ```ParenPart()```
	- For parenthesis
	- Has a child for head and tail parenthesis
- ```OpperationPart()```
	- For all the operators

Stuff done here:

- precedence is handled here
- Each function has a action
	- eg: 
```java 
action(double a, double b) {
	return a + b;
}
```
- 