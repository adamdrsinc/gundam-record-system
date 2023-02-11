import java.util.Comparator;

public class NameComparator implements Comparator<GundamModel> {

    public int compare(GundamModel model1, GundamModel model2){
        return model1.getModelName().compareTo(model2.getModelName());
    }
}
