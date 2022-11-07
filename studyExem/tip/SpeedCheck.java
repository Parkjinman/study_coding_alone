package studyExem.tip;

public class SpeedCheck {
    public static void main(String[] args) {
        String checkText = "";

        int loopCount = 99999999;

        long startTime, endTime, elapsedTime1, elapsedTime2 , elapsedTime3, elapsedTime4, elapsedTime5;

        startTime = System.nanoTime();
        for (int i = 0; i < loopCount; i++) {
            if (checkText == null || checkText.equals(""))
            {
            }
        }
        endTime = System.nanoTime();
        elapsedTime1 = endTime - startTime;
        System.out.println(".equals(\"\") \t" +": " + elapsedTime1);

        startTime = System.nanoTime();
        for (int i = 0; i < loopCount; i++) {
            if (checkText == null || checkText.isEmpty())
            {
            }
        }
        endTime = System.nanoTime();
        elapsedTime2 = endTime - startTime;
        System.out.println(".isEmpty() \t"+": " + elapsedTime2);


        startTime = System.nanoTime();
        for (int i = 0; i < loopCount; i++) {
            if (checkText == null || checkText.length()==0)
            {
            }
        }

        endTime = System.nanoTime();
        elapsedTime3 = endTime - startTime;
        System.out.println(".length() \t"+": " + elapsedTime3);

        startTime = System.nanoTime();
        for (int i = 0; i < loopCount; i++) {
            if (checkText == null || checkText.isBlank())
            {
            }
        }

        endTime = System.nanoTime();
        elapsedTime4 = endTime - startTime;
        System.out.println(".isBlank() \t"+": " + elapsedTime4);

        startTime = System.nanoTime();
        for (int i = 0; i < loopCount; i++) {
            if (checkText == null || checkText != "")
            {
            }
        }

        endTime = System.nanoTime();
        elapsedTime5 = endTime - startTime;
        System.out.println("!= \"\" \t"+": " + elapsedTime5);
    }
}
