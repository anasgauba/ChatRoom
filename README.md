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
         
   - Stress Testing:
     - write here
     - write here
     
 - ChatRoom App (TODO):
   - Need to create users which shares the tupleSpace.
   - User should be able to SEND message.
   - Print the ACTIVE USERS.
   - Print ALL USERS.
