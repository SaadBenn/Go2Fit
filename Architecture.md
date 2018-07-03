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

In the presentation layer, we have 11 main files, 5 of which are the core focus of the app, the rest are side pages accessible through the hamburger menu. 

From the fragments:

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

The forth is called HomepageFragments. It is the first page the user sees after they login, and it displays all of their current stats. It makes
use of the UserManager class.

The fifth and final fragment is the achievements fragment. When a user first starts, their achivements page will be blank because they have not yet unlocked any achievements.
Once achievements are unlocked, they will be displayed in the achievements page in list form. The first achievement is simple walking 5 steps, so start a challenge and take 5 steps!
This class makes use of the user manager class.

The other UI classes are a login/sign up screen, which makes use of the UserManager, UserService and PasswordService classes, and also a redeem prize and leaderboard page, which make use
of logic and DB classes of the same names.


Our persistence layer has 6 stub databases/HSQLDB and 6 database interfaces. The stub databases/HSQLDB are ChallengePersistence which stores all 
available challenges, SetGoalPersistence which stores the goals for a user, TrackProgressPersistence which tracks the progress 
for a users current challenge, UserPersistence which stores users, PrizePersistence which stores the available prizes, and AchievePersistence, which stores 
The available achievements. Each has a respective interface.

Our Business layer has 6 classes that stricltly deal with managing the database. They pass our model objects to it and retrieve model objects from it. We also have 7 more classes that deal
with logic, and all the logic in those classes are related. For example, our TrackProgressService class has logic related to tracking a challenge. We also have 5 exception classes that throw custom exceptions.

Finally, our Models package contails classes that represent the domain specific information we need. We need information for challenges, the current progress, the user, the users goals, prizes and achievements so we have
models for each of those.

![](arcbjtecture0.png)
![](arcbjtecture1.png)

## Current Fucntionality of the App
The app currently has 10 pages, namely Login, Sign up, Home, Challenges, Current Challenge, Set Goals, Achivements, Leader Board, About Go2Fit, Redeem Points.The login page gets the username and password from the user  
and the Sign in buttton signs in the user to the app, there is a sign up link on the bottom of the login page which takes the new user to sign up page to create a new account.The menu button on the top of the screen shows three options 
first one is the Leader Board which opens up the Leader Board page,which has three buttons namely PointsLeaderBoard,ChallengeLeaderBoard,DistanceLeaderBoard .When the PointsLeaderBoard button is pressed it shows a page with the list of users with the highest points.
When the ChallengeLeaderBoard button is pressed it shows a page with the list of users with the highest challenge completed.When the DistanceLeaderBoard button is pressed it shows a page with the list of users with the highest Distance covered.
The Second option in the menu is the About Go2Fit, which gives information about the app.
The Third option in the menu button is Redeem Points which opens up the Redeem Points page which has a list of options to redeem users points for.Each offer has a Redeem button,when clicked asks the user for confirmation to redeem their points.
The Home page displays the User details like its username,number of achivements,points,user ranking in the leader board.
board and total calories burned and distance covered by the user.The challenges page displays a list of currently avaialble challenges, which can be clicked on to see more details.
The details page is fully functional, but will later get some TLC to improve its looks a bit more. The details page allows users to then start a challenge, and once its started it cannot be undone, 
and another challenge cannot be started until this one is finished. If you go back to the challenges page, there is a create challenge button that opens a dialog window, where you can create a custom
challenge. That challenge will be added to the list of challenges and can be completed. The Current Challenge page initially shows nothing but an empty progress bar and 0 values. This is because no challenge
has been started. Once you start a challenge, go back to the Current Progress page, which will start tracking your steps(just move the phone around), showing you the distance youve travelled, calories burned, 
and the time remaining. The set goals page allows you to set your own personal goals. This page currently just takes the user input and stores the goal in the database when the button is pressed. **This page will
be worked on more in iteration 3.**The Achivements page gets update with the details of the challenge or a goal each time a challenge or a goal is compeleted by the user.