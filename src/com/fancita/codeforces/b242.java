package com.fancita.codeforces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ashutosh on 25/12/16.
 */
public class b242 extends FastIO {
    public static void main(String[] args) {
        int n = reader.readInt();
        int s = reader.readInt();

        List<Location> locations = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            locations.add(new Location(reader.readInt(), reader.readInt(), reader.readInt()));
        }

        Collections.sort(locations);

        double rad = 0;
        int popTillNow = s;
        int i = 0;
        while (popTillNow < 1000000) {
            if (i == n) {
                rad = -1;
                break;
            }
            Location locationAtI = locations.get(i);
            popTillNow += locationAtI.population;
            rad = locationAtI.r;
            i++;
        }

        writer.printLine(rad == -1 ? "-1" : rad);

        writer.flush();
        writer.close();
    }
}

class Location implements Comparable<Location> {
    int x, y, population;
    double r;

    public Location(int x, int y, int population) {
        this.x = x;
        this.y = y;
        this.population = population;
        this.r = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    @Override
    public int compareTo(Location o) {
        return (this.r - o.r) < 0 ? -1 : (this.r - o.r) == 0 ? 0 : 1;
    }
}
