import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class globalUsage {
    private static List<String> validMMInputsAL = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "6"));
    private static List<String> valid4InputsAL = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));

    public static List<String> getValidMMInputsAL(){
        return validMMInputsAL;
    }

    public static List<String> getValid4InputsAL(){
        return valid4InputsAL;
    }
}
