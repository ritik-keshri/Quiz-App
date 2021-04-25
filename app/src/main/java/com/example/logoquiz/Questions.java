package com.example.logoquiz;

public class Questions {
    private String mQuestions[] = {

            "Guess The Logo...?",
            "Guess The Logo...?",
            "Guess The Logo...?",
            "Guess The Logo...?",
            "Guess The Logo...?",
            "Guess The Logo...?",
            "Guess The Logo...?",
            "Guess The Logo...?",
            "Guess The Logo...?",
            "Guess The Logo...?"
    };

    private String mChoice[] [] = {
            {"AMD","CMD","KMD"},
            {"Linux","Andriod","IOS"},
            {"App Store","Play Store","Chrome"},
            {"Safari","Edge","Chrome"},
            {"Dell","HP","Lenovo"},
            {"Aim box","Drop Box","Mail Box"},
            {"Edge","Brave","Chrome"},
            {"Instagram","Snapchat","Facebook"},
            {"Flutter","Snapseed","Lightroom"},
            {"AMD","Flutter","Github"}


    };


    private String mImages[] = {
            "q1",//AMD image
            "q2",//Andriod image
            "q3",//App Store image
            "q4",//Chrome image
            "q5",//Dell image
            "q6",//Drop Box image
            "q7",//Edge image
            "q8",//Facebook image
            "q9",//Flutter image
            "q10"//Github image
    };

    private String mQuestionsType[] = {
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton"
    };

    private String mCorrectAnswer [] = {

            "AMD",
            "Andriod",
            "App Store",
            "Chrome",
            "Dell",
            "Drop Box",
            "Edge",
            "Facebook",
            "Flutter",
            "Github"
    };

    public String getQuestions(int q) {
        String questions = mQuestions[q];
        return questions;
    }

    public String[] getChoice(int q) {
        String [] choice = mChoice[q];
        return choice;
    }

    public String getImages(int q) {
        String img = mImages[q];
        return img;
    }

    public String getType(int q) {
        String  type = mQuestionsType[q];
        return type;
    }

    public int getlength(){
        return  mQuestions.length;
    };

    public String getCorrectAnswer(int q) {
        String correct = mCorrectAnswer[q];
        return correct;
    }
}
