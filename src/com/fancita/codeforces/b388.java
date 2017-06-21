package com.fancita.codeforces;

/**
 * Created by ashutosh on 19/12/16.
 */
public class b388 extends FastIO {
    public static void main(String[] args) {
        Coordinates a = new Coordinates();
        Coordinates b = new Coordinates();
        Coordinates c = new Coordinates();

        a.x = reader.readInt();
        a.y = reader.readInt();

        b.x = reader.readInt();
        b.y = reader.readInt();

        c.x = reader.readInt();
        c.y = reader.readInt();

        Coordinates swapper = new Coordinates();

        // case 1
        Coordinates ret1 = new Coordinates();
        ret1.x = c.x + (a.x - b.x);
        ret1.y = c.y + (a.y - b.y);

        // case 2
        swap(b, c, swapper);
        Coordinates ret2 = new Coordinates();
        ret2.x = c.x + (a.x - b.x);
        ret2.y = c.y + (a.y - b.y);


        // case 2
        swap(a, b, swapper);
        Coordinates ret3 = new Coordinates();
        ret3.x = c.x + (a.x - b.x);
        ret3.y = c.y + (a.y - b.y);

        writer.printLine("3");
        writer.printLine(ret1.x + " " + ret1.y);
        writer.printLine(ret2.x + " " + ret2.y);
        writer.printLine(ret3.x + " " + ret3.y);

        writer.flush();
        writer.close();
    }

    public static void swap(Coordinates a, Coordinates b, Coordinates swapper) {
        swapper.x = a.x;
        swapper.y = a.y;
        a.x = b.x;
        a.y = b.y;
        b.x = swapper.x;
        b.y = swapper.y;
    }
}

class Coordinates {
    public int x, y;
}


