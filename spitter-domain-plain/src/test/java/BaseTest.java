/**
 * Created by wangyunjing on 2016/10/25.
 */
public class BaseTest {

    public static void main(String[] args) {
        String aa = "广东省广州市天河区元岗街道智慧园去888号";
        String bb = "智慧园去888号";
        Integer i = aa.length() - bb.length();
        String cc = aa.substring(0,i);
        System.out.printf("cc==>>" + cc);
    }
}
