public interface GymManager {
    public abstract void addStudentMember(StudentMember studentMember);
    public abstract void addOver60Member(Over60Member over60Member);
    public abstract void deleteVehicle(String memberID,String type);
    public void printListOfStudentMembers();
    public void printListOfOver60Members();
    public void viewMemberCount();
    public void sortStudentMembers();
    public void sortOver60Members();
    public void saveData();

}
