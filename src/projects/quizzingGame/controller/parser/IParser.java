package projects.quizzingGame.controller.parser;

import projects.quizzingGame.model.Question;

import java.util.List;

public interface IParser {

    List<Question> getQuestionsFromJSON(String filePath) throws Exception;

    List<Question> getQuestionsFromCSV(String filePath) throws Exception;

    List<Question> getQuestionsFromXML(String filePath) throws Exception;

    List<Question> getQuestionsFromTXT(String filePath) throws Exception;

    int getTotalQuestions(List<Question> listOfQuestions) throws Exception;

    void saveToFile(String filePath, String info) throws Exception;
}
