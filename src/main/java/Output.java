public class Output {
    public static void checkOutput(double sumToCheck) {
        String outputTemplate = "Сумма к оплате (на каждого человека): %.2f %s.";
        double round = Math.floor(sumToCheck);
        String printRUB;
        if ((round == 1) || ((round % 10 == 1) && ((round != 11) && (round % 100 != 11)))) {
            printRUB = "рубль";
        } else if ((1 < round && round < 5) || (round > 21 && ((round % 10 == 2 || round % 10 == 3 || round % 10 == 4) && (round % 100 != 12 && round % 100 != 13 && round % 100 != 14)))){
            printRUB = "рубля";
        } else {
            printRUB = "рублей";
        }
        System.out.println(String.format(outputTemplate, sumToCheck, printRUB));
    }
}
