import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckAccessorsAndMutators {

    GundamModel getModel(){
        GundamModel testModel = new GundamModel(
                "Gundam",
                "29.99",
                GundamModel.Grade.EASY,
                GundamModel.Series.MSG_UNICORN
        );

        return testModel;
    }

    @Test
    void checkModelNameAccessor(){
        GundamModel model1 = getModel();
        Assertions.assertEquals("Gundam", model1.getModelName());
    }

    @Test
    void checkModelPriceAccessor(){
        GundamModel model1 = getModel();
        Assertions.assertEquals("29.99", model1.getReleasePrice());
    }

    @Test
    void checkModelGradeAccessor(){
        GundamModel model1 = getModel();
        Assertions.assertEquals(GundamModel.Grade.EASY, model1.getGrade());
    }

    @Test
    void checkModelSeriesAccessor(){
        GundamModel model1 = getModel();
        Assertions.assertEquals(GundamModel.Series.MSG_UNICORN, model1.getSeries());
    }

    @Test
    void checkModelNameMutator(){
        GundamModel model1 = getModel();
        model1.setModelName("NewName");
        Assertions.assertEquals("NewName", model1.getModelName());
    }

    @Test
    void checkModelPriceMutator(){
        GundamModel model1 = getModel();
        model1.setReleasePrice("19.99");
        Assertions.assertEquals("19.99", model1.getReleasePrice());
    }

    @Test
    void checkModelGradeMutator(){
        GundamModel model1 = getModel();
        model1.setGrade(GundamModel.Grade.HARD);
        Assertions.assertEquals(GundamModel.Grade.HARD, model1.getGrade());
    }

    @Test
    void checkModelSeriesMutator(){
        GundamModel model1 = getModel();
        model1.setSeries(GundamModel.Series.MOBILE_SUIT_GUNDAM);
        Assertions.assertEquals(GundamModel.Series.MOBILE_SUIT_GUNDAM, model1.getSeries());
    }

}
