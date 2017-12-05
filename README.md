# Java-ColorToy
Java based utility to generate a color palatte from a function.

![ColorToy Screenshot](screenshot.png "Program screenshot")

# Background
I came across a web article describing how to generate a color as a function of an input value [0.0-1.0] that would result in a continious color space.  The equation used is color(t) = a + b \* cos[2pi(c\*t+d)].  The original author's post is: http://iquilezles.org/www/articles/palettes/palettes.htm and he has a web based utility here: https://www.shadertoy.com/view/ll2GD3.  I wanted to create a Java based utility to experiment with values of the input function and see what the resulting palette would look like.

# How To Use This Program
Download all the project files.  They are:

o ColorToy.java (The main class for the project)

o MainPanel.java (Holds a ColorToyPanel and a ControlPanel)

o ColorToyPanel.java (Draws the color spectrum)

o ControlPanel.java (Holds input fields and buttons)

o Canvas.java (a drawable surface)

o Point.java (x-y point class for use with Canvas)


Compile the project with: `javac *.java`

Then run: `java ColorToy`

The Update button redraws the color bar.

The Print button outputs the function parameters to the system Console.
