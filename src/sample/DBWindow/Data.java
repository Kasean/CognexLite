package sample.DBWindow;

public class Data {
    String Id, Cods;

    public Data(String id, String cods) {
        Id = id;
        Cods = cods;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCods() {
        return Cods;
    }

    public void setCods(String cods) {
        Cods = cods;
    }
}
