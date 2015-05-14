A small project demonstrating an performance issue when using Kioo.
 
In order, the steps I took to create the project were:

-  Generated the project via `lein new reagent kiooform`
-  Deleted the standard cljs file and requires
-  Added the problem html file as minform.html in the cljs source directory, and Kioo to the require list (Kioo 0.4.1-SNAPSHOT)
-  Included a standard reagent test component to ensure the project setup was good.
-  Added a straight kioo template definition (with no transforms) and render call.  
