/**
 * Player factory class
 * @author Ruth Yukhnovetsky
 */

public class PlayerFactory {

    /**
     * creates a player according to given type of player
     * @param typePlayer type of wanted player
     * @return type of player
     */
    public Player buildPlayer(String typePlayer){
        if (typePlayer.equals("human")){
            return new HumanPlayer();
        }
        if (typePlayer.equals("clever")){
            return new CleverPlayer();
        }
        if (typePlayer.equals("whatever")){
            return new WhateverPlayer();
        }
        if (typePlayer.equals("snartypamts")){
            return new SnartypamtsPlayer();
        }
        return null; //type of player given doesnt match the possible options
    }
}
