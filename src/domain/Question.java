package domain;

import java.io.Serializable;

public class Question implements Serializable{
    private static final long serialVersionUID = 1L;
    private int idQuestion;
    private String questionText;

    public Question (int idQuestion, String questionText) {
        this.idQuestion=idQuestion;
        this.questionText=questionText;
    }

    public int getIdQuestion() {
        return this.idQuestion;
    }

    public String getQuestionText() {
        return this.questionText;
    }

    @Override
    public int hashCode() {
        return idQuestion;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Question && idQuestion==((Question) o).getIdQuestion()) {
            return true;
        }else{
            return false;
        }
    }
}
