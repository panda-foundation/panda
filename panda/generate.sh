alias antlr4='java -jar /usr/local/lib/antlr-4.7.1-complete.jar'
antlr4 PandaLexer.g4 PandaParser.g4 -o ../compiler -package compiler -Dlanguage=Go