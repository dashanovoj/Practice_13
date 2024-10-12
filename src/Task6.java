import java.io.IOException; // импортируем для обработки ошибок ввода-вывода
import java.nio.file.Files; // импортируем для работы с файлами
import java.nio.file.Paths; // импортируем для работы с файлами
import java.util.ArrayList; // импортируем для работы со списками
import java.util.List; // импортируем для работы со списками
import java.util.Scanner; // импортируем для ввода данных

public class Task6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя файла: ");
        String fileName = sc.nextLine();
        sc.close();

        try {
            // Через метод readAllLines в классе Files читаем все строки из файла и передаём их в список lines
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            if (!lines.isEmpty()) { // если список не пусток
                String result = getLine(lines.get(0).split("\\s+"));
                System.out.println(result);
            }
        } catch (IOException e) { // выдаём ошибку при некорректном вводе имени файла
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    public static String getLine(String[] words) {
        // если массив не был инициализирован или он пустой - возвращаем пустую строку
        if (words == null || words.length == 0) {
            return "";
        }

        // создаём список для хранения в нем слов
        List<String> wordList = new ArrayList<>();
        for (String word : words) {
            if (!word.isEmpty()) { // добавляем в массив только непустые строки
                wordList.add(word);
            }
        }

        // создаём экземпляр класса StringBuilder для построения результирующей строки
        StringBuilder result = new StringBuilder();
        // если wordList не пуст, добавляем первое слово из списка в result и удаляем его из wordList
        if (!wordList.isEmpty()) {
            result.append(wordList.removeFirst());
        }

        // Используем цикл do-while для добавления слов в result, пока возможно
        boolean wordAdded; // отслеживает, было ли добавлено слово в текущей итерации.
        do {
            wordAdded = false;
            // проверяем каждое слово
            for (int i = 0; i < wordList.size(); i++) {
                String currentWord = wordList.get(i);
                // Если последняя буква result совпадает с первой буквой currentWord, добавляем currentWord в конец result
                if (matches(result.charAt(result.length() - 1), currentWord.charAt(0))) {
                    result.append(" ").append(currentWord);
                    wordList.remove(i);
                    wordAdded = true;
                    break;

                }
                //Если первая буква result совпадает с последней буквой currentWord, добавляем currentWord в начало result
                else if (matches(result.charAt(0), currentWord.charAt(currentWord.length() - 1))) {
                    result.insert(0, currentWord + " ");
                    wordList.remove(i);
                    wordAdded = true;
                    break;
                }
            }
        } while (wordAdded);

        // Возвращаем результирующую строку, преобразованную из StringBuilder в String
        return result.toString();
    }

    // Объявляем вспомогательный булев метод matches, который сравнивает два символа без учета регистра.
    private static boolean matches(char a, char b) {
        return Character.toLowerCase(a) == Character.toLowerCase(b);
    }
}
