package calclulate;

/**
 * @program: mongomanager
 * @description: 分割字符快速求和
 * @author: WangPengfei
 * @create: 2019-01-24 16:35
 **/
public class SumString {
    public static void main(String[] args) {
        long res = 0;
        String input = "14566183 191636 11708965 4592313579 527460 1198200 1624499 0 0 0";
        //String input = "14547915 191293 11692060 4588608840 526915 1196455 1622373 0 0 0";

        //String input = "14547915 191293 11692060 4588608840 526915 1196455 1622373 0 0 0";
        String[] inputs = input.split(" ");
        for (int i = 0; i < inputs.length; i++) {
            System.out.println(inputs[i]);
            res += Long.parseLong(inputs[i]);
        }
        System.out.println("result = " + res);
    }
}
