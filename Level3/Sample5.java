public class Sample5 {
    public static void main(String[] args) {

        String day = "Monday";
        switch (day) {
            case "Monday":
                System.out.println("Start of the week");
                break;
            default:
                System.out.println("Other day");
        }

        //Fun fact
        if ("Monday".equals(day)) {
            System.out.println("Start of the week");
        }
        else {
            System.out.println("Other day");
        }
    }
}