# List intersection generator

Assessment description:
Calculating the intersection of two collections, the smaller collection should be
put into a HashSet for better performance.

###Initial question
To compute the intersection of two collections A and B, the elements of one collection are put into a hash-set
while the other collection is iterated over to test for each element whether it’s contained in the HashSet. If
one collection is significantly larger than the other, which one would you put into the hash-set?
###Web Application
The application should provide a graphical user interface which can be used to enter the following
parameters:
 Size of collection A
* Size of collection B
* Choose which collection to put into the hash-set, which one to iterated over
* A Run-button to start the computation
* An output fields to show the size of the intersection
* A second output field to show the time it took to run the intersection algorithm

If the Run-button is pressed, the two collections are populated with random numbers (we don’t care about
duplicates). Based on the user input, one of the collections is put into a hash-set, the other one is iterated
over to test for each element if it is contained in the hash-set. Matching elements are put into the result set.

###In order to run this project you will need to do the following:
* Install Java 11 or newer version
* Install Gradle latest version
* Clone the project
* Open cmd and type ./gradlew bootRun
* Open localhost:8080 and test the application
