public class StudentMember extends DefaultMember{
    private String schoolName;

    public StudentMember(String inputMemName, int inputMemHight, int inputMemWeight) {
    }

    public StudentMember(String memberID,String name, int hight, int weight, String nearestBranchName, int membershipNumber, int startMembershipDate,String schoolName) {
        super(memberID,name, hight, weight, nearestBranchName, membershipNumber, startMembershipDate);
        this.schoolName=schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "StudentMember{" +
                "schoolName='" + schoolName + '\'' +
                '}';
    }
}
