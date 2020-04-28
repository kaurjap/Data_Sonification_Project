# STOCK MARKET DATA SONIFICATION

* The concept of data Sonification has recently become quite popular because of its uniqueness. It referes to the idea of converting any regular everyday trends that we see in any kind of numerical data to be represented by sound, by music, instead of just visualizing it on a graph. It is a new technique that can prove helpful in a lot of ways. Especially, for blind people and such, who cannot visualize trends in any data, can be able to feel it and perhaps interpret it better by hearing it. For my project, specifically, I looked at some historical stock market data and made an attempt at converting that into musical notes to sonify it. The library that I used for this is MIDI (Musical Instrument Digital Interface) which is included in Java and allows me to play certain sounds at certain pitches. Specifically, it takes in 127 different numbers as note numbers, which represent a pitch each, and plays them as commanded. What I did was I took this stock market data online, with a much larger range and values than 1 through 127, converted it to match the range of 30 through 127, because notes below 30 are very hard to hear (so the trend sort of seems like it has blocked ther even though it has not). Then, I passed them through the MIDI synthesizer to produce a sound to represent each point of that data. The data is first stored in an ArrayList from the CSV files that were downloaded from the internet for free representing different stock indexes. Then, it is passed into the MIDI synthesizer, mapped to its range and casted into integers, in a loop to produce the corresponding sounds.

* NOTE: This project uses Swing and Java FX packages to create a graphical user interface for interaction. Hence, it will not run on Tesla. Also, after the first screen pops up and the user makes selections, the graph is drawn but does not get clear until the end of the musical loop execution for some reason. I know that it has something to do with threads, but I do not understand threads in GUI properly yet, and so, did what I could. Initially, however, the GUI was not showing up till late in the end when the music was over. So, I did fix that. I used the SwingUtilities.invokeLater() method to queue the task of playing the music in the end so that the graph at least pops up as the data is being played. Even though it works, the graph doesn't become clear till the end.  
