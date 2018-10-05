ChatRoom Application: 
 - TupleSpace:
   - There are two implementations of TupleSpace (interface):
     - Naive implementation using LinkedList data structure:
          - I have named my linked list implementation as "LinkedSpace" so its 
        easier to recognize which implementation of TupleSpace it is. 
          - Everything is shoved into a linkedlist without taking care of the 
        size of the each tuple. 
          - Linear search is done to look the pattern match which slows down 
        the efficiency at runtime. 
          - It doesn't add duplicates into the space (which is a requirement 
        for Set).
          - I have created a method isEqual() in Tuple.java specifically for 
        this space implementation, which checks for wildcards and pattern match.
           
     - Elegant implementation using Trie of HashMap data structure:
          - I have named my Trie implementation as "TrieSpace" so its easier to
         recognize which implementation of TupleSpace it is. 
          - Using Trie data structure with HashMap. 
          - It doesn't add duplicates, make sure  
         
   - Stress Testing:
     - write here
     - write here
     
 - ChatRoom App:
   - Has multiple users from the beginning, some are active and some are 
   inactive.
   - ChatRoom App has the functionality of adding a new user, whenever the 
   user clicks the "Add" button, this new user will be added to the chat. In
   order to SEE NEW ADDED USER, just click on the "All" button and the 
   new user will be shown at the end of the list).
   - Can click on "All" and "Active" button to see how many users there are 
   in the and chatRoom and who's active.
   
   - When a user is clicked from the listView of "All" users, that user becomes 
   active and can now type in message (make sure after you click the user 
   from "All" button, you should type in the message). <- ASK!!!!! 
     - One thing to NOTE, the program is implemented in a way that once the 
     user clicks from "All" button ListView, he can click anywhere except 
     "Active" button (if he clicks "Active" button, then he has to reclick 
     himself from "All" button). <<<--- ASK???
   
 - Instructions that can be followed:
   
 -Things need to do: 
   - Show only 10 recent messages not all the messages.
   - Figure out to logOff the user if he/she clicks themselves in "Active" list.