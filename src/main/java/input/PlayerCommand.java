package input;

import common.Constant;
import controller.RichController;
import player.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerCommand {


    public static void main(String[] args) {
        System.out.println("欢迎进入大富翁");
        explain();
        System.out.println("游戏结束，谢谢参与");
    }

    public static void explain() {
        Scanner commandConsole = new Scanner(System.in);
        System.out.println("请选择2~4位不重复玩家，输入编号即可。(1.钱夫人; 2.阿土伯; 3.孙小美; 4.金贝贝):");
        String playerChoose = commandConsole.next();
        ArrayList<Player> players = new ArrayList<Player>();
        for (int i = 0; i < playerChoose.length(); i++) {
            Player player = null;
            switch (playerChoose.charAt(i)) {
                case '1':
                    player = new Player("钱夫人", 0, Constant.INIT_MONEY);
                    break;
                case '2':
                    player = new Player("阿土伯", 0, Constant.INIT_MONEY);
                    break;
                case '3':
                    player = new Player("孙小美", 0, Constant.INIT_MONEY);
                    break;
                case '4':
                    player = new Player("金贝贝", 0, Constant.INIT_MONEY);
                    break;
                default:
                    System.out.println("输入出错");
                    return;
            }
            players.add(player);
        }
        RichController controller = new RichController(players);
        controller.initLands();
        System.out.print(controller.getCurrentPlayer().getName() + ">");
        System.out.flush();
        String command = commandConsole.next();
        while (!command.equals("quit")) {
            if (command.equals("roll")) {
                controller.rollAndMove();
                if (controller.changePlayer()) {
                    System.out.println(controller.getCurrentPlayer().getName() + "胜利");
                    break;
                }
            }
            System.out.print(controller.getCurrentPlayer().getName() + ">");
            System.out.flush();
            command = commandConsole.next();
        }
    }
}
