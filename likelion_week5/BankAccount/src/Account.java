import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Account {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String accNum;
    String memberName;
    double money;

    /* 생성자 */
    public Account(String memberName, String accNum, Double money) {
        this.accNum = accNum;
        this.memberName = memberName;
        this.money = money;
    }

    /* 생성된 계좌 객체들을 저장할 리스트와 계좌 추가 메서드 */

    //public static void addAccount(Account account) { accountList.add(account); }

    /* getter, setter */

    public String getAccNum() {
        return accNum;
    }

    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

   /* 멤버 함수
    public String makeAccountNum() throws Exception {
        while (true) {
            String inputAccNum = br.readLine();
            if (inputAccNum.length() == 8) {
                this.accNum = inputAccNum;
                return inputAccNum;
            } else {
                System.out.println("8자리 계좌번호를 정확히 입력해주세요.");
            }
        }
    }*/

    void successMakeAccount() throws Exception{
        System.out.println("계좌번호: "+ accNum);
        System.out.println("이름: " + memberName);
        System.out.println("예금: " +  money);
        System.out.println("## 계좌개설을 완료하였습니다. ##");
    }


}
