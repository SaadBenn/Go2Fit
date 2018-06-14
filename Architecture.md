# Package Structure
The package structure for our application is as follows: 

We have 5 main packages, which consist of 
1. **Application**, 
2. **BusinessLayer**, 
3. **Models**, 
4. **PersistenceLayer** and 
5. **PresentationLayer**. 

The application package contains source code that deals with android studio specific things, and also classes that manage other classes. 
For example the services class manages all of the database stubs we have.
The BusinessLayer Package contains all of the logic of our application. Any calculations, verification, and database calls happen in this package. 
We also have a sub package called DatabaseManagers. This package has classes that strictly query each stub database.
The Models package contains all of our domain specific classes. 
The PersistenceLayer package contains the stub databases and interfaces for the databases. 
Finally, the PresentationLayer contain all of our classes that strictly deal with presenting information to the screen. 


## Source Code 

In the presentation layer, we have 3 main files. 

The first is called TrackProgressUI. This class deals with presenting current progress 
to a user by showing them a progress bar, steps taken, calories burned and distance. This class makes use of the ProgressManager class for 
to query the database for a users current progress, the UserManager class to get the current users information, and the TrackProgressService class 
to do calculations.

The second is called ChallengesFragment. This class presents to the user a list of currently available challenges, as well as an option for the 
user to create new challenge. If a user clicks on a challenge in the list, and new page is opened (the file is CurrentChallenge) where they can then start the challenge, 
which then starts the TrackProgessUI page. If a user clicks on the Create Challenge button, a modal window is opened where they can specify 
the challenge, and see it added to the list. This class makes use of the ChallengesManager class in order to add and get the current challenges 
in the database, and the ChallengesService class in order to perform verification.

The third class is called SetGoalsUI, which allows a user to set a specific goal the want to achieve. It makes use of the SetGoalManager class which adds the goal to the stub database. 

Our persistence layer has 4 stub databases and 4 database interfaces. The stub databases are ChallengePersistenceStub which stores all 
available challenges, SetGoalPersistenceStub which stores the goals for a user, TrackProgressPersistenceStub which tracks the progress 
for a users current challenge, and UserPersistenceStub which stores users. Each has a respective interface.

![](https://code.cs.umanitoba.ca/comp3350-summer2018/Go2Fit/blob/master/ArchitctureDrawing.png)

