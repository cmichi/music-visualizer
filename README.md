# music-visualizer

It seems to me, as if there are so many overloaded, colorful music
visualizers crammed with effects out there, that the actual difficulty 
is to write a reduced, simple one. 

Project status: It works, but you will probably need to adjust the 
java class path within the `Makefile`. I aim to update this readme with 
a *.jar, which can easily be started independent of platforms and stuff.

The audio input is taken from you Line In. This will usually be your
microphone input. In order to use the system sound or sound by a certain 
program as an input for the visualization, you will need to redirect your 
sound to Line In. On Linux this can e.g. be done using PulseAudio.

Currently still requires Processing 2.0.

	make compile
	make run


## Eye Candy

[![Screenshot](https://github.com/cmichi/music-visualizer/raw/master/gallery/screenshot.png)](https://github.com/cmichi/music-visualizer/raw/master/gallery/screenshot.png)


# License

The code is licensed under the MIT license:

	Copyright (c) 2014

		Michael Mueller <http://micha.elmueller.net/>

	Permission is hereby granted, free of charge, to any person obtaining
	a copy of this software and associated documentation files (the
	"Software"), to deal in the Software without restriction, including
	without limitation the rights to use, copy, modify, merge, publish,
	distribute, sublicense, and/or sell copies of the Software, and to
	permit persons to whom the Software is furnished to do so, subject to
	the following conditions:

	The above copyright notice and this permission notice shall be
	included in all copies or substantial portions of the Software.

	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
	EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
	MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
	NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
	LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
	OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
	WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
