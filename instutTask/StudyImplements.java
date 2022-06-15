package instutTask;

public class StudyImplements implements studyInterface {

    @Override
    public void entrance() {
        System.out.println("입구입니다.");
    }

    @Override
    public void exit() {
        System.out.println("출구입니다.");
    }

}
