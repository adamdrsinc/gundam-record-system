import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GundamModel implements Serializable, Comparable<GundamModel>{
    private String modelName;
    private String releasePrice;
    private Grade grade;
    private Series series;



    @Override
    public int compareTo(GundamModel o) {
        return grade.compareTo(o.grade);
    }

    List<String> gradesAsStrings = new ArrayList<>(Arrays.asList("High Grade", "Real Grade", "Master Grade", "Perfect Grade"));
    List<String> seriesAsStrings = new ArrayList<>(Arrays.asList("Mobile Suit Gundam", "Mobile Suit Gundam: Thunderbolt",
            "Mobile Suit Gundam: Unicorn", "Mobile Suit Gundam: Witch From Mercury"));

    public enum Grade{
        HIGH, REAL, MASTER, PERFECT
    }

    public enum Series{
        MOBILE_SUIT_GUNDAM, MSG_THUNDERBOLT, MSG_UNICORN, MSG_WitchFromMercury
    }

    public GundamModel(String newModelName, String newReleasePrice, Grade newGrade, Series newSeries){
        this.modelName = newModelName;
        this.releasePrice = newReleasePrice;
        this.grade = newGrade;
        this.series = newSeries;
    }

    // -- Accessors -- //
    public String getModelName(){return modelName;}
    public String getReleasePrice() {return releasePrice;}
    public Grade getGrade() {return grade;}
    public Series getSeries() {return series;}

    // -- Mutators -- //
    public void setModelName(String modelName) {this.modelName = modelName;}
    public void setReleasePrice(String releasePrice) {this.releasePrice = releasePrice;}
    public void setGrade(Grade grade) {this.grade = grade;}
    public void setSeries(Series series) {this.series = series;}

    @Override
    public String toString() {
        return  "Model: " + modelName + '\n' +
                "Price: " + releasePrice + '\n' +
                "Grade: " + gradesAsStrings.get(grade.ordinal()) + "\n" +
                "Series: " + seriesAsStrings.get(grade.ordinal());
    }
}

