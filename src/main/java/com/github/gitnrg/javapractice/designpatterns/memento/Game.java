package com.github.gitnrg.javapractice.designpatterns.memento;

import java.util.Arrays;

/**
 * This is originator
 */
public class Game {
    private int[] coordinates = new int[2];

    public void move(int deltaX, int deltaY) {
        coordinates[0] += deltaX;
        coordinates[1] += deltaY;
    }

    public int[] getCoordinates() {
        return Arrays.copyOf(coordinates, 2);
    }

    public Memento save() {
        return new GameMemento(Arrays.copyOf(coordinates, 2));
    }

    public void restore(Memento memento) {
        if (memento instanceof GameMemento gameMemento) {
            coordinates[0] = gameMemento.coordinates[0];
            coordinates[1] = gameMemento.coordinates[1];
        } else {
            throw new IllegalArgumentException("Unsupported memento type");
        }
    }

    private record GameMemento(int[] coordinates) implements Memento {
    }

}
