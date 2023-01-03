import java.util.Scanner;

class Main {

    public static int tax6(int earnings, int spendings) {
        int nalog = earnings/100*6;
        return nalog;
    }

    public static int tax15(int earnings, int spendings) {
        int nalog = (earnings-spendings)/100*15;
        if (nalog >= 0) {return nalog;} else {return 0;}
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int earnings = 0;
        int spendings = 0;
        while (true) {
            System.out.println("Выберите операцию и введите ее номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогооблажения");

            String input = scanner.nextLine();
            if ("end".equals(input)) {
                System.out.println("Программа завершена");
                break;
            }

            int operation = Integer.parseInt(input);

            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода");
                    String moneySrt = scanner.nextLine();
                    int money = Integer.parseInt(moneySrt);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода");
                    String costSrt = scanner.nextLine();
                    int cost = Integer.parseInt(costSrt);
                    spendings += cost;
                    break;
                case 3:
                    int nalog6 = tax6(earnings, spendings);
                    int nalog15 = tax15(earnings, spendings);
                    if (nalog6<nalog15) {
                        System.out.println("Мы советуем вам УСН Доходы");
                        System.out.println("Ваш налог составит " + nalog6);
                        System.out.println("Ваш налог на другой системе " + nalog15);
                        System.out.println("Экономия: " + (nalog15-nalog6)+ " рублей");
                    } else {
                        System.out.println("Мы советуем вам УСН Доходы минус расходы");
                        System.out.println("Ваш налог составит " + nalog15);
                        System.out.println("Ваш налог на другой системе " + nalog6);
                        System.out.println("Экономия: " + (nalog6-nalog15) + " рублей");
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
                    break;
            }
        }
    }
}