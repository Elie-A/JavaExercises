package projects.quizzingGame.controller.miscUtilities;

import projects.quizzingGame.model.Choice;

public class MiscUtilities {
    public static Choice[] addToChoiceArray(int len, Choice[] oldArr, Choice choice) {
        int index;
        Choice[] newArr = new Choice[len + 1];
        for(index = 0; index < len; index++) {
            newArr[index] = oldArr[index];
        }
        newArr[len] = choice;
        return newArr;
    }

    public static Choice[] clearChoiceArray(Choice[] choices) {
        Choice[] newArr = new Choice[0];
        return newArr;
    }
}
