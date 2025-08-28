package com.github.gitnrg.javapractice.designpatterns.memento;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        var game = new Game();
        System.out.println("Initial game coordinates: " + Arrays.toString(game.getCoordinates()));

        game.move(10, 5);
        System.out.println("Game coordinates after 1st move: " + Arrays.toString(game.getCoordinates()));

        var memento = game.save();

        game.move(13, -2);
        System.out.println("Game coordinates after 2nd move: " + Arrays.toString(game.getCoordinates()));

        game.restore(memento);
        System.out.println("Restored game coordinates: " + Arrays.toString(game.getCoordinates()));
    }
}
