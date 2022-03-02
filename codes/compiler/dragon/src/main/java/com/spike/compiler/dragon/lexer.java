package com.spike.compiler.dragon;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public interface lexer {
    class Tag {
        public static final int NUM = 256,
                ID = 257,
                TRUE = 258,
                FALSE = 259;
    }

    class Token {
        public final int tag;

        public Token(int tag) {
            this.tag = tag;
        }
    }

    class Num extends Token {
        public final int value;

        public Num(int value) {
            super(Tag.NUM);
            this.value = value;
        }
    }

    class Word extends Token {
        public final String lexeme;

        public Word(int tag, String lexeme) {
            super(tag);
            this.lexeme = lexeme;
        }
    }

    class Lexer {
        public int line = 1;
        private char peek = ' ';
        private Map<String, Word> words = new HashMap<String, Word>();

        void reserve(Word word) {
            words.put(word.lexeme, word);
        }

        public Lexer() {
            // reserve words
            reserve(new Word(Tag.TRUE, "true"));
            reserve(new Word(Tag.FALSE, "false"));
        }

        public Token scan() throws IOException {
            // skip whitespace
            for (; ; peek = (char) System.in.read()) {
                if (peek == ' ' | peek == '\t') continue;
                else if (peek == '\n') line++;
                else break;
            }

            // num
            if (Character.isDigit(peek)) {
                int v = 0;
                do {
                    v = 10 * v + Character.digit(peek, 10);
                    peek = (char) System.in.read();
                } while (Character.isDigit(peek));
                return new Num(v);
            }

            // id
            if (Character.isLetter(peek)) {
                StringBuilder sb = new StringBuilder();
                do {
                    sb.append(peek);
                    peek = (char) System.in.read();
                } while (Character.isDigit(peek));
                String s = sb.toString();
                Word word = words.get(s);
                if (word != null) return word;

                word = new Word(Tag.ID, s);
                words.put(s, word);
                return word;
            }

            Token t = new Token(peek);
            peek = ' ';
            return t;
        }
    }
}
