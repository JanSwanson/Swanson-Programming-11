package sample;

public class Friend {

    private String name;
    private int age;
    private int kindness;
    private int craziness;
    private int creativity;

    Friend (String name, int age, int kindness, int craziness, int creativity) {
        this.name = name;
        this.age = age;
        this.kindness = kindness;
        this.craziness = craziness;
        this.creativity = creativity;
    }

    //Requires: fields != ""
    //Effects: returns encrypted friend for writing to txt file
    public String getTxtString(){
        String txt = "&$/1$&" + name + "&$/2$&" + age + "&$/3$&" + kindness + "&$/4$&" + craziness + "&$/5$&" + creativity + "&$/6$&" + "\r";
        return txt;
    }

    public String toString(){
        return name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getKindness() {
        return kindness;
    }

    public int getCraziness() {
        return craziness;
    }

    public int getCreativity() {
        return creativity;
    }

}