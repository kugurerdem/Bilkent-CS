g1A - Droneer

Group Members:
Baykam Say, Alp Üneri, Zübeyir Bodur, Uður Erdem Seyfi Küçük, Ege Kaan Gürkan, Agil Aliyev
-------------------------------------------------------------------------------------------------------------------
Description:
Our project aims to create a programming game which will provide a more fun and engaging
alternative to old ways of learning programming. In this game, players will program a
space drone to engage other drones in combat. They will write the code beforehand in a
separate ide-like part of the game and then complete different combat challenges slowly increasing in difficulty.

It will feature a story mode where the player will slowly learn basic concepts of programming,
an arena mode where they can test their skills against pre-written drones,
and an online mode where they can test their skills against other players.
It will also feature an extensive help page where the user can look up 
basic questions related to the game or programming in general.
--------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------
Current Status:
Working inside the ide. Some of the parts promised on the detailed design are not available.
--------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------
Contributions:

Baykam Say: 

- Worked on the Drones package.
	-- Created the classes within the Drone package.
	-- Worked on the core logic of the drones.
	-- Fixed bugs regarding drone detection and lasers.
	-- Used threads and timers to get the game working.

- Helped with several bug fixes.

- Made most of the example drones.


Alp Üneri:

- Created the DroneerMaster class to integrate the components of the Project
	-- Worked on using the core logic Ege came up with to allow for transitions between screens with button presses

- Worked on the Menus package
	-- Worked on the CreditsMenu class
	-- Worked on the DesignMenu class
	-- Worked on the EscapeMenu class
	-- Worked on the WinMenu class
	-- Worked on the LoseMenu class


Zübeyir Bodur: 

- InteractionsPanel and rest of the ide package that Uğur made.
	-- Bug fixes, simplification of the code.
	-- More user friendly features,
		--- Undo-Redo feature to the Editor.
		--- Hot-keys (e.g Ctrl + S for saving, F5 for compiling, Ctrl + O for opening, Ctrl + Z for undo, Ctrl + Y for redo )
		--- Warning message when user tries to compile the file without saving. User can choose whether or not to see the message.
		--- Improvements to menu UI design.

- Font sizes and styles in the UI, made all of them bold, and bigger.
	-- Worked on EscapeMenu, win-lose screens, MainMenu and buttons much more better (e.g. BoxLayout instead of GridLayout, upper case buttons).
	-- Worked DroneSelectMenu class.

Uğur Erdem Seyfi:

- Editor in ide package, core of the editor (open, save, compile, save as features). In other words, the compile feature.

- DroneCompiler class, that makes compiling much more easier to compile a .java file. This class is used in several places of the project, such as ide.Editor,
drones.UpdatableBoard, drones.BoardUpdater.

- Written two classes calles UpdatableBoard and BoardUpdater in order to solve the problem that comes when simulating a drone (Which is actually a .java file).
However, after finding a simpler solution, these classes excluded from the project.  
 
- Other contributions to drones package. 
	-- Contributed the scan part of the Drone class, in other words, fixed the bug that occures in collision detection between radar and target drone.
	-- Written a code that allows to simulate Drones, that creates instance of the Drone class by taking a string (classname).


Ege Kaan Gürkan:

- Worked on the Menus package
	-- Worked on the HelpMenu class
	-- Worked on the DroneSelectMenu class
	-- Worked on the DroneerMenuButton class
	-- Worked on the MainMenu class
	-- Worked on the DroneerMaster class
	-- Came up with the core logic used to transition between the screens through toggling multiple JFrames’ visibility


Agil Aliyev:

- Wrote some of the text used within the HelpMenu class

- Worked on the looks of the Settings screen (which was not implemented on the final version of the code due to time constraints).
--------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------
NOTE : To run the project, extract the files and open the project in Eclipse (file -> open projects from file system). 
In project properties, select "java build path" -> "add library" -> "JRE System Library" -> "Alternate JRE" and then
the JDK. Click finish and then run DroneerMaster.
--------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------
Misc: In the project, default Java libraries are used. Multi-Threading and Swing is used. JDK version 1.8 is used when 
compiling files in Editor. Storing little datas were done by saving them as .txt files.