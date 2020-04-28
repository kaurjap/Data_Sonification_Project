Main.class: Main.java StockPrice.class ReadFile.class SoundPlayer.class MainFrame.class Graph.class
	javac -g Main.java

StockPrice.class: Stockprice.java
	javac -g StockPrice.java

ReadFile.class: ReadFile.java
	javac -g ReadFile.java

SoundPlayer.class: SoundPlayer.java
	javac -g SoundPlayer.java

MainFrame.class: MainFrame.java
	javac -g MainFrame.java

Graph.class: Graph.java
	javac -g Graph.java

run: Main.class
	java Main

clean:
	rm *.class

debug: Main.class
	jdb Main
