public class Publication {
    String name;
    String doi;
    String date;

//    public Publication(String name, String doi, String date) {
//        this.name = name;
//        this.doi = doi;
//        this.date = date;
//    }

    @Override
    public String toString() {
        return "Publication{" +
                "name='" + name + '\'' +
                ", doi='" + doi + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
