==========================================================================================
Why you used ArrayList instead of array
--> Array comes with fixed size. and ArrayList can grow. items can be dynamically iterated or added or deleted with built in methods. 

==========================================================================================
Where you used static members and why
--> all Services in side Main class as because. In Java static methods can not access instance directly.

IN IdGenerator class as it holding shared counter for student, course and enrollment. 


==========================================================================================
Where you used inheritance and what you gained from it
--> Person class created with common attributes and extended for Student and trainer.
   benifits: no code duplication
   method overriding for displayInfo();
   reuse of constructor
      