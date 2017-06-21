package com.fancita.codeforces;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ashutosh on 26/12/16.
 */
public class b199 extends FastIO {
    public static void main(String[] args) {
        int n = reader.readInt();
        int m = reader.readInt();
        int s = reader.readInt();
        int f = reader.readInt();

        Queue<DetectiveStep> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            queue.add(new DetectiveStep(reader.readInt(), reader.readInt(), reader.readInt()));
        }

        StringBuilder ret = new StringBuilder((f > s ? f - s : s - f) + m);
        char toInsert = f > s ? 'R' : 'L';
        char def =  'X';
        int presentStep = 1;
        int presentPosition = s;

        while (presentPosition != f) {
            DetectiveStep detectiveStep = null;
            if (!queue.isEmpty()) {
                 detectiveStep = queue.peek();
            }

            int nextPosition = f > s ? presentPosition + 1 : presentPosition - 1;

            if (detectiveStep != null && detectiveStep.step == presentStep) {
                 queue.remove();
                 if ((presentPosition >= detectiveStep.l && presentPosition <= detectiveStep.r)
                         || (nextPosition >= detectiveStep.l && nextPosition <= detectiveStep.r)) {
                     ret.append(def);
                     presentStep++;
                 } else {
                     ret.append(toInsert);
                     presentStep++;
                     presentPosition = nextPosition;
                 }
            } else {
                ret.append(toInsert);
                presentStep++;
                presentPosition = nextPosition;
            }
        }

        writer.printLine(ret.toString());

        writer.flush();
        writer.close();
    }
}

class DetectiveStep {
    int step, l, r;

    public DetectiveStep(int step, int l, int r) {
        this.step = step;
        this.l = l;
        this.r = r;
    }
}