import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GundamModel implements Serializable, Comparable<GundamModel>{

    // INFORMATION ABOUT WHAT A GUNDAM IS FOR THE EXAMINER
    /*
    A Gundam Model is a Japanese model which can be built from a model kit.
    These model kits have specific grades, from easiest to most difficult.
    The ranking order from easiest to hardest are as follows:
    1. High Grade
    2. Real Grade
    3. Master Grade
    4. Perfect Grade

    These, for the purposes of this assignment, have been replaced with the following:
    Easy, Medium, Hard, Extreme,
    As it is unknwon if the examiner knows of what these model kits are.

    The "Series" tag refers to which series they come from, as there are many different series.
    */

    private String modelName;
    private String releasePrice;
    private Grade grade;
    private Series series;



    @Override
    public int compareTo(GundamModel o) {
        return grade.compareTo(o.grade);
    }

    public final List<String> GRADES_AS_STRINGS = new ArrayList<>(Arrays.asList("Easy", "Medium", "Hard", "Extreme"));
    public final List<String> SERIES_AS_STRINGS = new ArrayList<>(Arrays.asList("Mobile Suit Gundam", "Mobile Suit Gundam: Thunderbolt",
            "Mobile Suit Gundam: Unicorn", "Mobile Suit Gundam: Witch From Mercury"));

    public enum Grade{
        EASY, MEDIUM, HARD, EXTREME
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
                "Grade: " + GRADES_AS_STRINGS.get(grade.ordinal()) + "\n" +
                "Series: " + SERIES_AS_STRINGS.get(series.ordinal());
    }
}

