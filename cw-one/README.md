##Assignment One
###Simple Machine Language (SML) in scala

###Tests
Tests are provided for each of the instructions, located in `sml/src/test/scala/TestSML.scala` and written using the [ScalaTest](http://www.scalatest.org/) package.

To run the tests in the terminal cd into the `sml` folder and run `sbt test`, you must have [SBT](http://www.scala-sbt.org/download.html) installed.

The test SML input files can be found in [sml/src/main/resources](sml/src/main/resources) and the test class which loads and runs these is here: [sml/src/test/scala/TestSML.scala](sml/src/test/scala/TestSML.scala)

Successful output of running the tests should resemble the following:
```
scala-SDP2016/cw-one/sml > sbt test

[info] Loading project definition from /Users/rossanthony/projects/scala-SDP2016/cw-one/sml/project
[info] Set current project to sml (in build file:/Users/rossanthony/projects/scala-SDP2016/cw-one/sml/)
[info] Compiling 3 Scala sources to /Users/rossanthony/projects/scala-SDP2016/cw-one/sml/target/scala-2.11/classes...
[info] TestSML:
[info] - addition
[info] - subtraction
[info] - division
[info] - multiplication
[info] - bnz/factoral
[info] - reflection/sqrt
[info] Run completed in 426 milliseconds.
[info] Total number of tests run: 6
[info] Suites: completed 1, aborted 0
[info] Tests: succeeded 6, failed 0, canceled 0, ignored 0, pending 0
[info] All tests passed.
[success] Total time: 5 s, completed 25-Mar-2016 15:03:35
```

###The problem
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

- L1 is any identifier - actually, any sequence of non-whitespace characters.
- Each statement of a program must be labeled with a different identifier.
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
