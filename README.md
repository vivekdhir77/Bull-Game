# Bull-Game

Download the apk [here](https://github.com/vivekdhir77/Bull-Game/files/6474795/app-debug.apk.zip)

>
##       How to play
        
   The ‘Guess the Bull weight’ game
   (or how we like to call it cow-bull-shit game)





-----------------------------------------------------------------------------------------------------------------------------------------------------------------         
>
##       (human v/s human) 

        1. This is a 2 player game.
        2. Each player thinks of a 3 digited number(KEY).
        3. The goal of the game is to figure out the KEY of the opposite player. 
        4. The game starts off with Player1 randomly guessing Player2 ‘s 
           KEY while Player2 gives him the appropriate clues.
        6. In the next round, Player2 will start guessing Player1’s KEY while Player1 gives clues. 
        7. We keep repeating the same pattern until one of the players guesses their opponent’s key.





-----------------------------------------------------------------------------------------------------------------------------------------------------------------    
>
##    (human v/s computer)

       1. This is a 1 player game.
       2. The player thinks of a 3 digited number(KEY).
       3. The goal of the game is to figure out the KEY of the computer.
       4. The game starts off with Player randomly guessing computer‘s 
          KEY while Computer gives him the appropriate clues.
       6. We keep repeating the same pattern until player guesses the key.
        
    
    
    
     
 ----------------------------------------------------------------------------------------------------------------------------------------------------------------- 
>
##     How the clues work: The clue format consists of 3 parts :
 
        1)number of correct digits in their respective places-(bull)
        2)number of correct digits but not in their correct place-(cow)
        3)all digits are wrong-(shit)
        
        
        
        
        
----------------------------------------------------------------------------------------------------------------------------------------------------------------- 
```diff
        Rules while setting a key:
        It should be a three digit number made up of numbers from 0 to 9.
        All three digits can have repetitions.
        For example:

+       079 - VALID.
+       911 - VALID 
-       2789-INVALID (since it is not a three digit number)
```
