import java.util.Scanner;

public class Main {

    public static class ProductList { // список товаров
        public static String createProductList(String name, double price) {
            String listTemplate = "%s, цена %.2f\n";
            String productList = "";
            productList = productList + String.format(listTemplate, name, price);
            return productList;
        }
    }

    public static class Calculator { // расчет суммы для оплаты
        public static double countSumToPay(int number, double sum) {
            double sumToPay = sum / number;
            return sumToPay;
        }
    }

    public static class Output { // округление суммы и форматирование текста для вывода
        public static void checkOutput(double sumToCheck) {
            String sumToPrint = String.format("%.2f", sumToCheck);
            double round = Math.floor(sumToCheck);
            if ((round == 1) || ((round % 10 == 1) && ((round != 11) && (round % 100 != 11)))) {
                System.out.println("Сумма к оплате (на каждого человека): " + sumToPrint + " рубль.");
            } else if ((1 < round && round < 5) || (round > 21 && ((round % 10 == 2 || round % 10 == 3 || round % 10 == 4) && (round % 100 != 12 && round % 100 != 13 && round % 100 != 14)))){
                System.out.println("Сумма к оплате (на каждого человека): " + sumToPrint + " рубля.");
            } else {
                System.out.println("Сумма к оплате (на каждого человека): " + sumToPrint + " рублей.");
            }
        }
    }



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // ввод количества человек в счете и валидация ввода

        int userInputNumber = 0;
        boolean valid = false;

        while (!valid) {
                System.out.println("На скольких человек нужно разделить счет?");
                valid = scanner.hasNextInt();
                if (valid) {
                    userInputNumber = scanner.nextInt();
                    if (userInputNumber > 1) {
                        System.out.println("Счет будет разделен на " + userInputNumber + "-х человек.");
                        break;
                    } else {
                        System.out.println("Ошибка ввода. Количество человек должно быть больше 1.");
                        valid = false;
                    }
                } else {
                    System.out.println("Ошибка ввода. Введите целое число.");
                    scanner.nextLine();
                }
            }

        // ввод списка продуктов и валидация ввода стоимости

        String userInputProductName;
        double userInputProductPrice;
        double totalSum = 0;
        String list = "Добавленные товары:\n";
        System.out.println("Введите название товара:");
        while(true) {
                userInputProductName = scanner.next();
                if (userInputProductName.equalsIgnoreCase("завершить")) {
                    break;
                } else {
                    valid = false;
                    System.out.println("Введите стоимость товара в формате \"рубли,копейки:\"");
                    while (!valid) {
                        valid = scanner.hasNextDouble();
                        if (valid) {
                            userInputProductPrice = scanner.nextDouble();
                            if (userInputProductPrice > 0) {
                                list = list + ProductList.createProductList(userInputProductName, userInputProductPrice);
                                totalSum += userInputProductPrice;
                                System.out.println("Введите название следующего товара. Для завершения введите \"Завершить\".");
                                break;
                            } else {
                                System.out.println("Некорректный ввод: стоимость должна быть больше нуля. Повторите попытку.");
                                valid = false;
                            }
                        } else {
                            System.out.println("Ошибка ввода. Повторите попытку.");
                            scanner.nextLine();
                        }
                    }
                }
            }

        // вывод списка товаров и суммы для оплаты

        System.out.println(list);
        Output.checkOutput(Calculator.countSumToPay(userInputNumber, totalSum));









    }

}