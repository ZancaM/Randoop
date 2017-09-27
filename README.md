# Randoop
Randoop example for Software analysis and testing

the .java files are some libraries I used for testing the tool.
Randoop pulled up over 600 errors on them and I manually fix them (most of them are overlapping issues i.e. you solve 1 and you might solve 100). What you see are the already fixed files so randoop might not find any new Unit tests that fail, I put the not fixed files in the FilesWithErrors folder.

## Steps to run the example:

1. Compile the files `javac Line.java Parabola.java Vector.java Point.java`
2. Run randoop (make sure you are within this folder when you run it) 
``` java -ea -classpath .:<path to this folder>/randoop-all-3.1.5.jar randoop.main.Main gentests --classlist=myclasses.txt --no-regression-tests=true --npe-on-null-input=ERROR --unchecked-exception=ERROR --oom-exception=EXPECTED --sof-exception=EXPECTED --timelimit=60 ```

*Note* The above `.:` it is adding the current folder to the classpath in order to find the files listed in the myclasses.txt and the myclasses.txt file itself.

3. Randoop should have been created two error files ErrorTest*.java which contain our Junit testing (note the above command is not producing regression testing)
4. Let's use Junit to compile these tests , first set up the JUnit env variables `export JUNITPATH=<path to this folder>/junit-4.12.jar:<path to this folder>/hamcrest-core-1.3.jar`

5. Now we compile the Junit `javac -classpath .:$JUNITPATH ErrorTest*.java` 
6. Run the tests : `java -classpath .:$JUNITPATH org.junit.runner.JUnitCore ErrorTest`

Hope this helps ;)
