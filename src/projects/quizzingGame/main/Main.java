package projects.quizzingGame.main;

import projects.quizzingGame.controller.parser.Parser;
import projects.quizzingGame.model.Choice;
import projects.quizzingGame.model.Question;
import projects.quizzingGame.staticVariables.StaticVariables;
import projects.quizzingGame.staticVariables.DATA_SOURCE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;




public class Main {

    public static void main(String args[]) throws Exception {
        String firstName = "";
        String lastName = "";
        String dataSource = "";

        String datePattern = "YYYY-MM-dd hh:mm:ss";

        int score = 0;
        int desiredNumberOfQuestions = 0;
        int questionCounter = 0;

        List<Question> listOfQuestions = new ArrayList<>();
        List<String> choicesIds = new ArrayList<String>();
        int totalNumberOfQuestions = 0;

        String info = "";

        String moreQuestion = "";
        String answer = "";

        Parser parser = new Parser();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.println("Select a data source");
            DATA_SOURCE.printEnum();
            dataSource = bufferedReader.readLine().trim();
        } while (!DATA_SOURCE.validateIfInEnum(dataSource));

        switch (dataSource) {
            case "1":
                listOfQuestions = parser.getQuestionsFromTXT(StaticVariables.txtPath);
                totalNumberOfQuestions = parser.getTotalQuestions(listOfQuestions);
                break;
            case "2":
                listOfQuestions = parser.getQuestionsFromXML(StaticVariables.xmlPath);
                totalNumberOfQuestions = parser.getTotalQuestions(listOfQuestions);
                break;
            case "3":
                listOfQuestions = parser.getQuestionsFromCSV(StaticVariables.csvPath);
                totalNumberOfQuestions = parser.getTotalQuestions(listOfQuestions);
                break;
            case "4":
                listOfQuestions = parser.getQuestionsFromJSON(StaticVariables.jsonPath);
                totalNumberOfQuestions = parser.getTotalQuestions(listOfQuestions);
                break;
            default:
                System.err.println("Invalid data source type!");
                System.err.println("Terminating application...");
                System.err.println("Application terminated!");
                System.exit(0);
                break;
        }

        System.out.println("\nHello & Welcome to the java quiz game!");
        do {
            System.out.println("Enter your first name: ");
            firstName = bufferedReader.readLine().trim();
        } while (firstName.length() <= 0);

        do {
            System.out.println("Enter your last name: ");
            lastName = bufferedReader.readLine().trim();
        } while (lastName.length() <= 0);

        System.out.println("============================================================");

        do {
            System.out.println("\nEnter desired number of questions: ");
            desiredNumberOfQuestions = Integer.parseInt(bufferedReader.readLine().trim());
            System.out.println("\nMaximum number of questions is: " + totalNumberOfQuestions);
        } while (!String.valueOf(desiredNumberOfQuestions).matches("\\d") || desiredNumberOfQuestions <= 0
                || desiredNumberOfQuestions > totalNumberOfQuestions);
        System.out.println("============================================================");
        System.out.println();
        do {
            for (int i = 0; i <= desiredNumberOfQuestions - 1; i++) {
                questionCounter = i + 1;
                System.out.println(listOfQuestions.get(i).getId() + "- " + listOfQuestions.get(i).getValue());
                String correctAnswer = listOfQuestions.get(i).getAnswer();
                choicesIds.clear();
                for (Choice choice : listOfQuestions.get(i).getChoices()) {
                    System.out.println("\t" + choice.getId() + "- " + choice.getValue());
                    choicesIds.add(choice.getId());
                }
                System.out.println("Answer: ");
                answer = bufferedReader.readLine().trim();
                if (answer.equalsIgnoreCase(correctAnswer)) {
                    score += 10;
                    System.out.println("Correct!\t\t\t" + "Score: " + score);
                    System.out.println();
                    do {
                        System.out.println("Do you want to continue? (y/n)");
                        moreQuestion = bufferedReader.readLine().trim();
                    } while (!moreQuestion.equalsIgnoreCase("y") && !moreQuestion.equalsIgnoreCase("n"));
                    System.out.println();
                } else {
                    score -= 10;
                    System.out.println("Incorrect!\t\t\t" + "Score: " + score);
                    System.out.println();
                    do {
                        System.out.println("Do you want to continue? (y/n)");
                        moreQuestion = bufferedReader.readLine().trim();
                    } while (!moreQuestion.equalsIgnoreCase("y") && !moreQuestion.equalsIgnoreCase("n"));
                    System.out.println();
                }

                if (moreQuestion.equalsIgnoreCase("n") || questionCounter == desiredNumberOfQuestions) {
                    do {
                        System.out.println("Do you want to save your score? (y/n)");
                        answer = bufferedReader.readLine().trim();
                    } while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n"));
                    if (answer.equalsIgnoreCase("y")) {
                        Date date = new Date();
                        info = String.format(StaticVariables.infoToSave, new SimpleDateFormat(datePattern).format(date),
                                firstName, lastName, String.valueOf(score));
                        parser.saveToFile(String.format(StaticVariables.savePath, firstName + "_" + lastName), info);
                        break;
                    } else {
                        Date date = new Date();
                        info = String.format(StaticVariables.infoToSave, new SimpleDateFormat(datePattern).format(date),
                                firstName, lastName, score);
                        System.out.println(info);
                        break;
                    }
                }
            }
        } while (!choicesIds.contains(answer) && moreQuestion.equalsIgnoreCase("y"));
    }
}

