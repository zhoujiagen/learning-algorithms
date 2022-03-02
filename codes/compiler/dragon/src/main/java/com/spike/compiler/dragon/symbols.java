package com.spike.compiler.dragon;

import java.util.HashMap;
import java.util.Map;

public interface symbols {
    class Symbol {
    }

    class Env {
        private Map<String, Symbol> table;
        protected Env prev; // outer scope

        public Env(Env prev) {
            table = new HashMap<String, Symbol>();
            this.prev = prev;
        }

        public void put(String s, Symbol symbol) {
            table.put(s, symbol);
        }

        public Symbol get(String s) {
            for (Env env = this; env != null; env = env.prev) {
                Symbol found = table.get(s);
                if (found != null) return found;
            }
            return null;
        }
    }
}
