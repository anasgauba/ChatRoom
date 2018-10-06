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
          - TrieSpace has access to Node object and it creates a member 
          variable root, which then calls methods in Node class.  
          - All the hard work is done is Node class. 
          - Recursively searching for tuples to add, search or remove from 
          the hashmap, adding no duplicates to the map.
          - Hashmap of trie is useful and quick also. Let's say I want to add 
          millions of tuples, it will considerably add them quickly than my 
          naive implementation [comparison done in TupleSpace design doc]. 
         
   - Stress Testing:
     - Stress Testing class adds 100000 tuples to the trie. Searches/remove 
     about 60000 tuples together.  
     - The tupleSpace can take any size tuples but in my stress test, I have 
     gone upto size 8 (can easily add any bigger size as well).
     - The elegant implementation is considerably way faster than the naive 
     implementation. (with this amount, it takes about a min for elegant 
     implementaion as compared to linkedList which takes hours). [Detailed 
     discussion in TupleSpace design doc].
     
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
      ACTIVE/LOGGEDIN (any user becomes active when it gets selected and it 
      types a message), also can see on the blue button with the 
      selected user's name shown.
   - To logOff, click the user's name in listView to log him off (once he's 
      actually logged in).
      - If you go to "Active" listView and click a user to logOff, the "Active"
        listView updates and now, you will not find the user you just clicked 
        in "Active" listView (he's logged off). The blue button will also not 
        have this user's name shown.
      - If you don't go to "Active" listView to logOff and want to logOff from 
        "All" listView (knowing you already typed a message and now know who you're),
        you can also select this loggedIn user from "All" listView as well to 
        make him logOff. Notice that if you select a loggedIn user from "All" 
        listView, it directs you to updated "Active" listView with that 
        selected user being inactive.
        - For example, you select user "Bob" and type a message to chat, 
          "Bob" is active (can actually go and see in "Active" listView, 
          "Bob" will be there). Now, you want him to logOff, there are two 
          ways you can log him off. ONE way is to select him from "Active" 
          listView and he will become offline (can also see the blue button 
          has no name now). SECOND way is to go to "All" listView and select 
          "Bob" there, notice that as soon as you click "Bob", it directs you 
          to "Active" listView with "Bob" not being there anymore (he's logged
           off!).
        - NOTE: Once you make the user logOff, sendButton disables. It will 
        only enable once you re-select a user from "All" listView. 
   - If you wish to add a new user, simply type user's name, and press 
      "Add" button, then if you want this newUser to type a message, select 
      him from "All" listView and send the message. 
   - NOTE: The program will not add a blank message into the chat, meaning 
      if the textField is empty, the user can't send a message.  
   - NOTE: In this chatRoom program, a user can type in as many messages he 
   wants until he/she wants to logOff (I implemented like that because in 
   real chatRoom, a user a luxury to type in as many messages he/she wants).
             
           
   
         
 - Things need to do: 
   - Show only 10 recent messages not all the messages.