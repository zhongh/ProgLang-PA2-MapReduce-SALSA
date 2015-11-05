## Distributed Map-Reduce Framework for Word Count

### How to compile

1. Make sure the following items are in your current working directory:
  * the source code folder `mapreduce\`;
  * text file listing the naming server and theaters to be used, e.g. `theaters.txt`;
  * the input file, e.g. `exampleInput.txt`;
  * \*SALSA distribution, e.g. `salsa1.1.5.jar`. (This is optional since you can always identify your SALSA distribution location on your machine.)

2. Start the naming server and all the theaters which need to be used.
  * `java -cp salsa1.1.5.jar:. wwc.naming.WWCNamingServer`
  * `java -cp salsa1.1.5.jar:. wwc.messaging.Theater 4040`
  * `java -cp salsa1.1.5.jar:. wwc.messaging.Theater 4041`
  * `java -cp salsa1.1.5.jar:. wwc.messaging.Theater 4042`
  * ... 

3. Compile `.salsa` files to Java source files:
    `java -cp salsa1.1.5.jar:. salsac.SalsaCompiler mapreduce/*.salsa`

4. Compile Java:
    `javac -classpath salsa1.1.5.jar:. mapreduce/*.java`

5. Execute:
    `java -cp salsa1.1.5.jar:. mapreduce.MapReduceProblemDistributed [input file name] [output file name] [# of map actors] [# of shuffle actors] [# of reduce actors] [theaters info file]` 

(For more details in compiling please refer to [http://www.cs.rpi.edu/research/groups/wwc/salsa/tutorial/salsa112v.pdf].)

### Features

This submission successfully implements a distributed map-reduce framework for word count, as required by this assignment. Commom bugs have been purged by completion and the code works nicely in different setting.
  
