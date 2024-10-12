public class Task1 {

    // 1. Напишите метод, который принимает в качестве параметра любую строку
    public static void performStringOperations(String input){

        // 2. Распечатать последний символ строки
        System.out.println("Последний символ строки: " + input.charAt(input.length() - 1));

        // 3. Проверить, заканчивается ли ваша строка подстрокой “!!!”.
        if (input.endsWith("!!!")) System.out.println("Строка заканчивается на '!!!'");
        else System.out.println("Строка не заканчивается на '!!!'");

        // 4. Проверить, начинается ли ваша строка подстрокой “I like”
        if (input.startsWith("I like")) System.out.println("Строка начинается с 'I like'");
        else System.out.println("Строка не начинается с 'I like'");

        // 5. Проверить, содержит ли ваша строка подстроку “Java”
        if (input.contains("Java")) System.out.println("Строка содержит подстроку 'Java'");
        else System.out.println("Строка не содержит подстроку 'Java'");

        // 6. Найти позицию подстроки “Java” в строке
        if (input.contains("Java")) System.out.println("Позиция подстроки “Java” в строке: " + (input.indexOf("Java")));
        else System.out.println("Подстрока 'Java' не найдена");

        // 7. Заменить все символы “а” на “о”.
        System.out.println("Замена всех символов 'a' на 'o': " + input.replace('a', 'o'));

        // 8. Преобразуйте строку к верхнему регистру.
        System.out.println("Преобразование строки к верхнему регистру: " + input.toUpperCase());

        // 9. Преобразуйте строку к нижнему регистру.
        System.out.println("Преобразование строки к нижнему регистру: " + input.toLowerCase());

        // 10. Вырезать строку Java
        if (input.contains("Java")) System.out.println("Строка с вырезанной подстрокой 'Java': " + input.substring(input.indexOf("Java"), input.indexOf("Java") + "Java".length()));
        else System.out.println("Подстрока 'Java' не найдена");
    }

    public static void main(String[] args) {
        String input = "I like Java!!!";
        performStringOperations(input);
    }
}