# FunctionStripper #

### FunctionParser ###

The idea will be to have the parser crall the string passed in
It will then sent each part of the function it finds to a constructor for each part, EX:

- ```public Paren(FuncPart a, FuncPart b, FuncPart c) {}```
- ```public Add(FuncPart a, FuncPart b) {}```
- ```public Value(FuncPart a) {}```
- ...

all these would be a child of ```FuncPart``` or something
