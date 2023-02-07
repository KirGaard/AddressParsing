package kirgaard.addressparsing.Model;

import java.util.Map;

public class CharToInt {
    private static final Map<Character, Integer> MAP = Map.ofEntries(
            Map.entry('a', 0),
            Map.entry('b', 1),
            Map.entry('c', 2),
            Map.entry('d', 3),
            Map.entry('e', 4),
            Map.entry('f', 5),
            Map.entry('g', 6),
            Map.entry('h', 7),
            Map.entry('i', 8),
            Map.entry('j', 9),
            Map.entry('k', 10),
            Map.entry('l', 11),
            Map.entry('m', 12),
            Map.entry('n', 13),
            Map.entry('o', 14),
            Map.entry('p', 15),
            Map.entry('q', 16),
            Map.entry('r', 17),
            Map.entry('s', 18),
            Map.entry('t', 19),
            Map.entry('u', 20),
            Map.entry('v', 21),
            Map.entry('w', 22),
            Map.entry('x', 23),
            Map.entry('y', 24),
            Map.entry('z', 25),
            Map.entry('æ', 26),
            Map.entry('ø', 27),
            Map.entry('å', 28),
            Map.entry('0', 29),
            Map.entry('1', 30),
            Map.entry('2', 31),
            Map.entry('3', 32),
            Map.entry('4', 33),
            Map.entry('5', 34),
            Map.entry('6', 35),
            Map.entry('7', 36),
            Map.entry('8', 37),
            Map.entry('9', 38),
            Map.entry('.', 39),
            Map.entry(' ', 40));

    public static int eval(char chr){
        return MAP.get(chr);
    }




}
