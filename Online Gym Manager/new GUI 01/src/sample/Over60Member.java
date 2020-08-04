package sample;

public class Over60Member extends DefaultMember{
    private String age;

    public Over60Member() {
    }

    public Over60Member(String memberID, String name, int hight, int weight, String nearestBranchName, int membershipNumber, int startMembershipDate, String age) {
        super(memberID,name, hight, weight, nearestBranchName, membershipNumber, startMembershipDate);
        this.age=age;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Over60Member{" +
                "age='" + age + '\'' +
                '}';
    }
}
