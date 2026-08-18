package model;

public class StudentAccount extends Account {
    private String studentId; 
    public StudentAccount(int accountNumber,String accountHolderName ,
                         double balance , String accountStatus,String studentId){
              super(accountNumber,accountHolderName,balance,accountStatus);
              this.studentId = studentId ; 
    } 
 public String getStudentId() {
    return studentId ;
 } 
}
