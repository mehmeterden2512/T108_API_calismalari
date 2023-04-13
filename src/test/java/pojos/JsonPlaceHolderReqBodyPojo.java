package pojos;

public class JsonPlaceHolderReqBodyPojo {

    //1- Tum key degerlerini Class levelda aldıkları data turune gore private variable olarak olusturalım
    /*
     Request Body
    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
     */
    private String title;
    private String body;
    private int userId;
    private int id;

    //2 -Tumvariable lar icin gether() ve sether() olustur.


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //3- Tum variablalari iceren parametreli bir constructor olusturuyoruz

    public JsonPlaceHolderReqBodyPojo(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }

    //4 -Parametreli cons. olusturdugum icin parametresiz cons olusturuyoruz


    public JsonPlaceHolderReqBodyPojo() {
    }
    // 5- toString() methodu olusturuyoruz


    @Override
    public String toString() {
        return "JsonPlaceHolderReqBodyPojo{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}
