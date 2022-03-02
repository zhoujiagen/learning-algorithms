package com.spike.compiler.dragon;

import java.io.IOException;

class Parser {
    static int lookahead;

    public Parser() throws IOException {
        lookahead = System.in.read();
    }

    void expr() throws IOException {
        term();
        while (true) {
            if (lookahead == '+') {
                match('+');
                term();
                System.out.write('+');
            } else if (lookahead == '-') {
                match('-');
                term();
                System.out.write('-');
            } else return;
        }
    }

    void term() throws IOException {
        if (Character.isDigit((char) lookahead)) {
            System.out.write((char) lookahead);
            match(lookahead);
        } else throw new Error("syntax error");
    }

    void match(int t) throws IOException {
        if (lookahead == t) lookahead = System.in.read();
        else throw new Error("syntax error");
    }
}

// translate into postfix notation
//
//expr  -> expr + term  {print('+')}
//        | expr - term   {print('-')}
//        | term
//term  -> 0            {print('0')}
//        | 1             {print('1')}
//        | ...
//        | 9             {print('9')}

public class Postfix {
    public static void main(String[] args) throws IOException {
        Parser parser = new Parser();
        parser.expr();
        System.out.println();
    }
}

// outputs
//
// correct
//9-5+2
//95-2+
//
// only single digit support
//12-5+2
//1