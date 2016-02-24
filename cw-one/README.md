##Assignment One
###Simple Machine Language (SML)

####The problem
You will write an interpreter for a simple machine language | SML. The general form of a machine language instruction is
    
    label instruction register-list


where:

`label` is the label for the line. Other instructions might \jump" to that label.

`instruction` is the actual instruction. In SML, there are instructions for adding, multiplying and so on, for storing and retrieving integers, and for conditionally branching to other labels (like an if statement).

`register-list` is the list of registers that the instruction manipulates. Registers are simple, integer, storage areas in computer memory, much like variables. In SML, there are 32 registers, numbered 0, 1, . . . , 31.


####SML has the following instructions:

|**Instruction** &nbsp;&nbsp;&nbsp; | **Action** |
|-----|-----|
| L1 add r s1 s2 | Add the contents of registers s1 and s2 and store the result in register r |
| L1 sub r s1 s2 | Subtract the contents of register s2 from the contents of s1 and store the result in register r |
| L1 mul r s1 s2 | Multiply the contents of registers s1 and s2 and store the result in register r |
| L1 div r s1 s2 | Divide (Java integer division) the contents of register s1 by the contents of register s2 and store the result in register r |
| L1 out s1 | Print the contents of register s1 on the Java console (using println) |
| L1 lin r x | Store integer x in register r |
| L1 bnz s1 L2 | If the contents of register s1 is not zero, then make the statement labeled L2 the next one to execute |


where:

- L1 is any identier - actually, any sequence of non-whitespace characters.
- Each statement of a program must be labeled with a dierent identier.
- Each of s1, s2, and r is an integer in the range 0. . . 31 and refers to one of the 32 registers in the machine that executes language SML.

Here is an example of an SML program to compute factorial 6.
```
f0 lin 20 6
f1 lin 21 1
f2 lin 22 1
f3 mul 21 21 20
f4 sub 20 20 22
f5 bnz 20 f3
f6 out 21
```

Note that adjacent fields of an instruction (label, opcode, and operands) are separated by whitespace. Instructions of a program are executed in order (starting with the first one), unless the order is changed by execution of a bnz instruction. Execution terminates when its last instruction has been executed (and doesn't change the order of execution).

Your interpreter will:

1. Read the the name of a file that contains the program from the command line (via String[] args),
2. Read the program from the file and translate it into an internal form,
3. Print the program,
4. Execute the program, and
5. Print the final value of the registers.


