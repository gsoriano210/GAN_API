
This framework used API endpoints to simulate how to  interact with 1
or more decks of playing cards in the website http://deckofcardsapi.com/

For the described scenario we had to implement multiple classes and the following
functions:
1. shuffleCards(): Adding deck_count as a GET or POST parameter to define the number of
   Decks needs.
2. drawCard():  Used to draw cards from the deck. In this function deck_id as an 
   identifier, so we know who is playing with what deck.
3. reshuffleCards(): We use it to don't throw away a deck when all we want to do is shuffle
    and using the boolean remaining parameter as true only those cards remaining in the
   main stack are shuffled, leaving any piles or drawn cards alone.
4. returningCardsToDeck(): We use it to return cards which have been drawn or cards 
   from a pile back to the main deck to re-use.