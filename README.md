# PaletteGenerator
[Version 1.0] <br/>
March 29, 2021

## DESCRIPTION

- PaletteGenerator is an application that creates a random color palette with 
a click of a button using Java Swing components.

- The application is composed of the following programs:
	- PaletteGenerator.java
	- Main.java	

## INSTALLATION

This program was created and tested on Windows 10.

### Installation Dependencies

The application should work with the most recent version of Java programming 
language updated to at least JDK 16.

No other supplementary libraries and testing file with modular dependencies 
are required to run this application.

## USAGE

### Program Compilation 

Open Command Prompt on Windows OS and navigate to the directory containing the 
.java files in the following order to generate the .class files.

<pre>
>>> javac PaletteGenerator.java
>>> javac Main.java
</pre>

To run the program in Command Prompt.

<pre>
>>> java Main
</pre>

### Application Architecture

<ol>
The PaletteGenerator will have three sections:
<li> Header: Contains only a label with a title.
<li> Body: Contains 8 JPanels with associated lock JButtons that will represent our generated colour palette. Each colour JPanel will have an associated lock button, that when clicked will lock that colour panel so that if the generate button is clicked again, it will not change. A lock button can be unclicked, so if generate is clicked the colour panel will once again change.
<li> Footer: A single JButton that we can click to generate a new palette.
</ol>

### Sample Display

![sc](https://user-images.githubusercontent.com/55768917/120088024-ccf52500-c0ba-11eb-92ef-443aa1b6e073.jpg)

## CREDITS

Thanks to the TAs and Instructor of my Object-Oriented Software Development 
course for the initial idea.
