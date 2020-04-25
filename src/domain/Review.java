package domain;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Review implements Serializable{

    private static final long serialVersionUID = 1L;
    private User user;//Usuario info basica
    private int scoreProduct; //entre 0 y 10
    private int scoreReview; //normalizada (puntuacion maxima)
    private Date date;
    private String comment;
    private String commentTitle;

    public Review(User user, int scoreProduct,
                  int scoreReview, String comentario,
                  String comentarioTitle,String date) throws ParseException {

        this.user=user;
        this.scoreProduct=scoreProduct;
        this.scoreReview=scoreReview;
        this.comment=comentario;
        this.commentTitle=comentarioTitle;
        this.setDate(date);
    }

    private void setDate(String date) throws ParseException {
        this.date = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(date));
    }

    public String getComment() {
        return comment;
    }
    public String getCommentTitle() {
        return commentTitle;
    }
    public User getUser() {
        return user;
    }
    public int getProductScore() {
        return scoreProduct;
    }
    public int gerScoreResto(){
        return 5-scoreProduct;
    }

    public Date getDate() {
        return date;
    }

    public int getScoreReview() {
        return scoreReview;
    }
    public String date2string(){
        String og = date.toString().replace("00:00:00 CEST ", "");

        return og;
    }
}