# Sudoku Solver

## Intention behind it

The main idea was to create an algorithm, which solves a Sudoku puzzle.  
I decide to go for the obvious one, to test every possible option until the puzzle is solved. 


## Behind the scenes

The solver starts in the left upper corner of the field and moves from left to the right. He stops when there is a `0` in a field of the matrix. Now it tests which numbers are allowed here (returns an array of these elements). After that it puts the first option in the field and goes further till it finds a field with a `0` and he tests again. And so on and so on. If there are no allowed elements for a field, the solver goes back to the last field an test the next number. This processed is continued till all fields are filled up with the right numbers.


## License

```
 MIT License
 
 Copyright (c) 2019 Fload
 
 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:
 
 The above copyright notice and this permission notice shall be included in all
 copies or substantial portions of the Software.
 
 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 SOFTWARE.

```