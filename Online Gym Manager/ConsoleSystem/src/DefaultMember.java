public class DefaultMember {
    private String memberID;
    private String name;
    private int hight;
    private int weight;
    private String nearestBranchName;
    private int membershipNumber;
    private int startMembershipDate;


    public DefaultMember() {
    }



    public DefaultMember(String memberID, String name, int hight, int weight, String nearestBranchName, int membershipNumber, int startMembershipDate) {
        this.memberID = memberID;
        this.name = name;
        this.hight = hight;
        this.weight = weight;
        this.nearestBranchName = nearestBranchName;
        this.membershipNumber = membershipNumber;
        this.startMembershipDate = startMembershipDate;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHight() {
        return hight;
    }

    public void setHight(int hight) {
        this.hight = hight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getNearestBranchName() {
        return nearestBranchName;
    }

    public void setNearestBranchName(String nearestBranchName) {
        this.nearestBranchName = nearestBranchName;
    }

    public int getMembershipNumber() {
        return membershipNumber;
    }

    public void setMembershipNumber(int membershipNumber) {
        this.membershipNumber = membershipNumber;
    }

    public int getStartMembershipDate() {
        return startMembershipDate;
    }

    public void setStartMembershipDate(int startMembershipDate) {
        this.startMembershipDate = startMembershipDate;
    }

    @Override
    public String toString() {
        return "DefaultMember{" +
                "memberID='" + memberID + '\'' +
                ", name='" + name + '\'' +
                ", hight=" + hight +
                ", weight=" + weight +
                ", nearestBranchName='" + nearestBranchName + '\'' +
                ", membershipNumber=" + membershipNumber +
                ", startMembershipDate=" + startMembershipDate +
                '}';
    }

}
