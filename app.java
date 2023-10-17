// Online IDE - Code Editor, Compiler, Interpreter
import java.util.*;

public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name;
        int gamemode = 0;
        int hand = 0;
        int [] handArray = new int[2];
        int cpu1 = 0;
        int cpu2 = 0;
        String [] cpuhand = {"グー", "チョキ", "パー"};
        Random rand = new Random();
        
        System.out.println("ゲームモードを選択: 1. CPU vs CPU 2. CPU vs USER 3. USER vs USER");
        gamemode = sc.nextInt();
        if(gamemode == 2){
            System.out.println("名前を入力してください");
            name = sc.nextLine();
        
            for(int i = 1; i <= 5; i++){
                System.out.println(i + "回戦目:何を出しますか？数字で入力してください。1.グー 2.チョキ 3.パー");
                hand = sc.nextInt();
                if(hand > 3 || hand < 1){
                    System.out.println("正しい手を入力してください");
                    System.exit(0);
                } else {
                    cpu1 = rand.nextInt(3) + 1;
                    if(cpu1 == hand){ //あいこ
                        System.out.println("あいこ");
                        i--;
                        System.out.println("あいこなのでもう一回");
                        continue;
                    } else if(hand == 1 && cpu1 == 2 || hand == 2 && cpu1 == 3 || hand == 3 && cpu1 == 1){ //プレイヤーが勝ち
                        System.out.println(name + "の勝ち");
                    } else {
                        System.out.println(name + "の負け");
                    }
                }
            }
        } else if(gamemode == 1){
            for(int i = 1; i <= 3; i++){
                System.out.println(i + "回戦目");
                cpu1 = rand.nextInt(3) + 1;
                cpu2 = rand.nextInt(3) + 1;
                System.out.println("CPU1:" + cpuhand[cpu1 - 1] + "CPU2:" + cpuhand[cpu2 - 1]);
                if(cpu1 == cpu2){ //あいこ
                    System.out.println("あいこ");
                    i--;
                    System.out.println("あいこなのでもう一回");
                    continue;
                } else if(cpu2 == 1 && cpu1 == 2 || cpu2 == 2 && cpu1 == 3 || cpu2 == 3 && cpu1 == 1){ //プレイヤーが勝ち
                    System.out.println("CPU1の勝ち");
                } else {
                    System.out.println("CPU2の勝ち");
                }
            }
        } else if(gamemode == 3){
            String [] nameArray = new String[2];
            for(int j = 0; j < 2; j++){
                System.out.println(j + "人目:名前を入力してください");
                nameArray[j] = sc.next();
            }
            for(int i = 1; i <= 2; i++){
                System.out.println(i + "回戦目");
                for(int j = 0; j < 2; j++){
                    System.out.println(nameArray[j] + "さん何を出しますか？数字で入力してください。1.グー 2.チョキ 3.パー");
                    handArray[j] = sc.nextInt();
                    if(handArray[0] > 3 || handArray[0] < 1){
                        System.out.println("正しい手を入力してください");
                        System.exit(0);
                    }
                }
                if(handArray[0] == handArray[1]){ //あいこ
                    System.out.println("あいこ");
                    i--;
                    System.out.println("あいこなのでもう一回");
                    continue;
                } else if(handArray[0] == 1 && handArray[1] == 2 || handArray[0] == 2 && handArray[1] == 3 || handArray[0] == 3 && handArray[1] == 1){ //プレイヤーが勝ち
                    System.out.println(nameArray[0] + "の勝ち");
                } else {
                    System.out.println(nameArray[1] + "の勝ち");
                }
            }
        } else {
            System.out.println("正しいゲームモードを選択してください");
            System.exit(0);
        }
    }
}
