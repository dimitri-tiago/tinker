JFLAGS = -g
JC = javac



.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java
	

SOURCE = \
	Board.java \
	Player.java \
	WinPatternStrategy.java \
	PLGame.java


CLASSES = \
	Board.java \
	Player.java \
	WinPatternStrategy.java \
	PLGame.java



default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class