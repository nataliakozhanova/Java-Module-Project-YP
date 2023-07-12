import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // ввод количества человек в счете и валидация ввода

        int userInputNumber;
        boolean valid;

        while (true) {
                System.out.println("На скольких человек нужно разделить счет?");
                valid = scanner.hasNextInt();
                if (valid) {
                    userInputNumber = scanner.nextInt();
                    if (userInputNumber > 1) {
                        System.out.println("Счет будет разделен на " + userInputNumber + "-х человек.");
                        break;
                    } else {
                        System.out.println("Ошибка ввода. Количество человек должно быть больше 1.");

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
                    //valid = false;
                    System.out.println("Введите стоимость товара в формате \"рубли,копейки:\"");
                    while (true) {
                        valid = scanner.hasNextDouble();
                        if (valid) {
                            userInputProductPrice = scanner.nextDouble();
                            if (userInputProductPrice > 0) {
                                list += ProductList.createProductList(userInputProductName, userInputProductPrice);
                                totalSum += userInputProductPrice;
                                System.out.println("Введите название следующего товара. Для завершения введите \"Завершить\".");
                                break;
                            } else {
                                System.out.println("Некорректный ввод: стоимость должна быть больше нуля. Повторите попытку.");
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
        Calculator newSum = new Calculator();
        Output.checkOutput(newSum.countSumToPay(userInputNumber, totalSum));









    }

}