To run the game just double click on the .jar file and the game will launch.


To compile and run in Mac OS X and Linux from a terminal (ignore the $ it is there to show bash shell)

$ cd <path-name-to-directory-PLGame>
run command 

$ make

then command

$ java PLGame


For Windows if make is not available:

c: cd <path-name-to-directory>
run
c:\javac -g *.java
c:\java  PLGame

To play the game.

The prompt will appear:

Please select game type:
(1) Human vs Human
(2) Human vs AI
(3) AI vs Human
(4) Quit!

next you will see this text in the console

1
7	 	 	 	 	 	 	_	 	 	 	 	 	 	
6	 	 	 	 	 	_	_	_	 	 	 	 	 	
5	 	 	 	 	_	_	_	_	_	 	 	 	 	
4	 	 	 	_	_	_	_	_	_	_	 	 	 	
3	 	 	_	_	_	_	_	_	_	_	_	 	 	
2	 	_	_	_	_	_	_	_	_	_	_	_	 	
1	_	_	_	_	_	_	_	_	_	_	_	_	_	
 	A	B	C	D	E	F	G	H	I	J	K	L	M	
Please enter your next move Player One (ex. 5A):

You are ready to play the game!!

Any wrong input returns the player to the original prompt

example:

Please enter your next move Player One (ex. 5A):e1  //wrong order
Please enter your next move Player One (ex. 5A):1Z  //out of bounds
Please enter your next move Player One (ex. 5A):1e // right 




A winning game will display the winner and exit the game.


7	 	 	 	 	 	 	_	 	 	 	 	 	 	
6	 	 	 	 	 	_	_	_	 	 	 	 	 	
5	 	 	 	 	_	_	_	_	_	 	 	 	 	
4	 	 	 	_	_	_	o	_	_	_	 	 	 	
3	 	 	?	_	_	_	o	_	_	_	_	 	 	
2	 	?	?	_	_	o	o	_	_	_	_	_	 	
1	_	?	?	_	o	o	_	_	_	_	_	_	_	
 	A	B	C	D	E	F	G	H	I	J	K	L	M	
Player One Wins the Game! 
Game over!

