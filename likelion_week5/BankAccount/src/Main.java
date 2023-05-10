import javax.swing.plaf.nimbus.State;
import java.awt.image.PackedColorModel;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.spec.ECField;
import java.util.List;

import static java.lang.System.exit;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final static Account[] accounts = new Account[100];
    public static void main(String[] args) throws Exception {

        while(true) {
            new Main().menuPrint();
            String number = br.readLine();

            // 1. 계좌 개설
            if (number.equals("1")) {
                createAccount();
            //2. 입금하기
            } else if (number.equals("2")) {
                deposit();
            // 3. 출금하기
            } else if(number.equals("3")) {
                withdraw();
            // 4. 전체 조회
            } else if (number.equals("4")) {
                accountList();
            // 6. 종료
            } else if (number.equals("6")) {
                exit(0);
            }
        }
    }


    private void menuPrint() throws Exception {
        System.out.println("======Bank Menu=======");
        System.out.println("1. 계좌개설");
        System.out.println("2. 입금하기");
        System.out.println("3. 출금하기");
        System.out.println("4. 전체 조회");
        System.out.println("5. 계좌이체");
        System.out.println("6. 프로그램 종료");
        System.out.println("======Bank Menu======= \n 입력: ");
    }

    /* 계좌 생성 */
    private static void createAccount() throws Exception{
        int index = 0;
        String inputAccNum = null;
        // 이름 setting
        System.out.println("성함을 입력해주세요.");
        String name = br.readLine();

        //계좌 setting
        while (true) {
            System.out.println("원하는 계좌번호를 입력해주세요.");
            inputAccNum = br.readLine();
            if (inputAccNum.length() == 8) {
                break;
            }
            else { System.out.println("8자리 계좌번호를 정확히 입력해주세요.");}
        }

        System.out.println("예금액을 입력해주세요.");
        Double money = Double.parseDouble(br.readLine());

        Account account = new Account(name, inputAccNum, money);
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = account;
                break;
            }
        }
    }

    /* 계좌 입금 */
    private static  void deposit() throws Exception {
        System.out.println("입금하실 계좌번호를 입력해주세요.");
        String inputAccNum = br.readLine();

        System.out.println("입금하실 금액을 입력해주세요.");
        double amount = Double.parseDouble(br.readLine());

        Account ac = findAccount(inputAccNum);

        ac.setMoney(ac.getMoney() + amount);
        System.out.println("잔액: " + ac.getMoney());
        System.out.println("## 입금이 완료되었습니다. ##");

    }

    /* 계좌 출금 */
    private static  void withdraw() throws Exception {
        System.out.println("출금하실 계좌번호를 입력해주세요.");
        String inputAccNum = br.readLine();

        Account ac = findAccount(inputAccNum);
        if (ac == null) {
            System.out.println("잘못된 계좌입니다.");
            return;
        }
        System.out.println("출금하실 금액을 입력해주세요.");
        double amount = Double.parseDouble(br.readLine());

        if (ac.getMoney() < amount) {
            System.out.println("출금액이 예금보다 많습니다.");
        } else {
            ac.setMoney(ac.getMoney() - amount);
            System.out.println("계좌잔고: " + ac.getMoney());
            System.out.println("## 출금이 완료되었습니다. ##");
        }
    }

    /* 계좌 조회 */
    private static  void accountList() {
        System.out.println("=====전체 조회=====");
        for (int i = 0; i < accounts.length; i++) {
            if(accounts[i] != null) {
                System.out.println("계좌 번호: " + accounts[i].getAccNum() +
                        "\t" + "이름: " + accounts[i].getMemberName() +
                        "\t" + "잔액 : " + accounts[i].getMoney());
            }
        }
    }

    /* acc 객체 찾기 */
    private static Account findAccount(String accNum) {
        Account account = null;

        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null) {
                if (accounts[i].getAccNum().equals(accNum)) {
                    account = accounts[i];
                    break;
                }
            } else {
                account = null;
            }
        }
        return account;
    }
}

