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
   - Has multiple users from the beginning.
   - When you run the ChatRoom App, You can see All Users that are currently 
   in the ChatRoom, they are all inactives initially. If you want to make them 
   active, click on one of them and type a message in the message box and send it.   
   - ChatRoom App has the functionality of adding a new user, whenever the 
   user clicks the "Add" button, this new user will be added to the chat. (Lets
   say that if the person using chatRoom clicked on "Active" button before 
   adding the newUser (button), As soon as the user hits "Add" button, you can 
   see that listView changes to "All" users listView so you don't have to click  
   "All" button again. You can simply scroll the listView to see that newUser
   has been added).
   - The person using ChatRoom can click on "All" and "Active" button to see 
   how many users there are in the chatRoom and who's active.   
   - When a user is clicked from the listView of "All" users, that user becomes 
   active and can now type in message (make sure after you click the user 
   from "All" button, you should type in the message).
     - One thing to NOTE, the program is implemented in a way that once the 
     user clicks from "All" button ListView, he can click anywhere except 
     "Active" button (if he clicks "Active" button, then he has to reclick 
     himself from "All" button).
   
   - HOW TO USE CHATROOM APP? (Details regarding ChatRomm App Usage):
     - When the program runs, it shows "All" users listView automatically.
     - If you wish not to add new User, make sure to select an existing user 
     from "All" listView and type a message and send it. After sending a 
     message, you can see in "Active" listView that the user is 
     ACTIVE/LOGGEDIN, also can see on the blue button with the selected user's 
     Name shown.
     - To logOff, click the user's name in listView to log him off (once he's 
     actually logged in).
       - If you go to "Active" listView and click a user to logOff, the "Active"
       listView updates and now, you will not find the user you just clicked 
       in "Active" listView (he's logged off). The blue button will also not 
       have this user's name shown.
       - If you don't go to "Active" listView to     
   
         
 -Things need to do: 
   - Show only 10 recent messages not all the messages.
   - Figure out to logOff the user if he/she clicks themselves in "Active" list.