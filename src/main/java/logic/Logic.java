package logic;

import maze.Maze;
import maze.Position;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Logic {
    private static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public List<String> solve(Maze maze) throws Exception {
        LinkedList<Position> nextToVisit = new LinkedList<>();
        List<String> output = new ArrayList<>();
        Position start = maze.getEntry();
        nextToVisit.add(start);

        while (!nextToVisit.isEmpty()) {
            Position cur = nextToVisit.remove();

            if (!maze.isValidLocation(cur.getX(), cur.getY()) || maze.isExplored(cur.getX(), cur.getY())) {
                continue;
            }

            if (maze.isWall(cur.getX(), cur.getY())) {
                maze.setVisited(cur.getX(), cur.getY(), true);
                continue;
            }

            if (maze.isExit(cur.getX(), cur.getY())) {
                return backtrackPath(cur, output, maze.getEnd());
    //
            }

            for (int[] direction : DIRECTIONS) {
                Position coordinate = new Position(cur.getX() + direction[0], cur.getY() + direction[1], cur);
                nextToVisit.add(coordinate);
                maze.setVisited(cur.getX(), cur.getY(), true);
            }
        }
        throw new Exception("Cannot reach END !!!");
    }

        private List<String> backtrackPath(Position cur, List<String> output, Position end) {
            Position iter = cur;
            output.add(resolveDirection(end.getX() - iter.getPosition().getX(), end.getY() - iter.getPosition().getY()));

            while (iter != null) {
                if(iter.getPosition() != null) {
                    output.add(resolveDirection(iter.getX() - iter.getPosition().getX(), iter.getY() - iter.getPosition().getY()));
                }
                iter = iter.getPosition();
            }
            return output;
        }

        private String resolveDirection(int direction1, int direction2) {
            if(direction1 == 0 && direction2 == 1) return "r";
            if(direction1 == 1 && direction2 == 0) return "d";
            if(direction1 == 0 && direction2 == -1) return "l";
            if(direction1 == -1 && direction2 == 0) return "u";
            return null;
        }
}

