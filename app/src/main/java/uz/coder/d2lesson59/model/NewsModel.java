package uz.coder.d2lesson59.model;

public class NewsModel {
    private String title;
    private String date;
    private String img;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }





    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public NewsModel(String title, String date, String img) {
        this.title = title;
        this.date = date;
        this.img = img;
    }
}
