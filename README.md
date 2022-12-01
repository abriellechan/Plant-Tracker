# My Personal Project
## Plant Tracker - Abrielle Chan

My project is an application that helps a user track data about their plants such as:
- name of the plant
- when it was bought (birthday!)
- how often it should be watered
- what sorts of environments it needs to thrive in (direct sunlight, indirect sunlight etc)

it can be used by anyone who has plants they would like to keep track of, or even people who want to grow plants
and would like to see data about them and what the watering schedule for the plants would look like.

this project is of interest to me because I have grown plants in the past but have had trouble remembering
when they need to be watered, how long it was since I had last watered them, and other important information.
I have tried to write down the info by hand, but I think an application like this would be much more useful and organized :)


## User Stories
- as a user, I want to be able to add a new plant to a list of plants
- as a user, I want to view my list of plants
- as a user, I want to be able to select a plant and view data about them
- as a user, I want to be able to edit some fields of my plants
- as a user, I want to be able to name my plants :) 
- as a user, I want to be able to save my list of plants (garden)
- as a user, I want to be able to load up my list of plants

# Instructions for Grader

- You can generate the first required event (adding Xs to a Y) by clicking the 'new plant' button, filling out the plant information and then clicking 'plant!'
- You can generate the second required event (deleting X from Y) by clicking the 'delete' button, and then clicking the plant button that you would like to delete.
- You can locate my visual component by clicking the 'plant it!' button when creating a new plant. A gif will pop up if this plant was successful.
- You can save the state of my application by clicking the save button at the bottom of the main menu
- You can reload the state of my application by clicking the load button at the bottom of the main menu

# Phase 4: Task 2
- Wed Nov 30 21:24:59 PST 2022
- bob the monstera was added!
- Wed Nov 30 21:25:03 PST 2022
- lob the string of pearls was added!
- Wed Nov 30 21:25:08 PST 2022
- oopsie the succulent was added!
- Wed Nov 30 21:25:10 PST 2022
- oopsie the succulent was removed.

This sample is printed to the console after:
- adding a monstera named bob
- adding a string of pearls named lob
- adding a succulent named oopsie
- deleting oopsie
- quitting the program

# Phase 4: Task 3
The main thing I would change if I had more time is to split up my GPLantApp gui class into multiple classes. 
In comparison to the SmartHome example early in the term, my code was hard to read, trace through and debug since everything 
was in one class. I would refactor it so that each window, (ie. the new plant window) was a seperate class, and perhaps
split up the code so that all of the methods relating to creating the visuals of the gui were seperate from the methods
that introduced functionality. 

Another thing that I could change is my plant subclasses. Perhaps I could have come up with a different way to represent
the plants, since they are nearly identical in structure (except for some string fields). If there was a way I could change
it so that I didn't have 4 seperate classes for the types of plants, it could reduce some repetition (like the switch cases)
I have in my gui. 