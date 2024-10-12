import java.util.Scanner;

public class Task2 {

    public static class Person {
        // Поля данных - фамилия, имя, отчество
        private String lastName;
        private String firstName;
        private String middleName;

        // Конструктор
        public Person(String lastName, String firstName, String middleNAme) {
            this.lastName = lastName;
            this.firstName = firstName;
            this.middleName = middleNAme;
        }

        // Getter'ы и Setter'ы
        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        // Определяем метод, возвращающий ФИО в формате "Фамилия И.О."
        public String getFullName() {
            // Используем StringBuilder для оптимизации производительности
            StringBuilder fullName = new StringBuilder();

            // Если получаем фамилию
            if (lastName != null && !lastName.isEmpty()) { // null - отсутствие объекта (не инициализирована), isEmpty - строка длиной 0 (инициализирована)
                fullName.append(lastName); // добавляем её в объект
            }

            // Если получаем имя
            if (firstName != null && !firstName.isEmpty()) {
                if (!fullName.isEmpty()) { // Если объект не пустой (добавлена фамилия)
                    fullName.append(" "); // Ставим пробел
                }
                fullName.append(firstName.charAt(0)).append("."); // Добавляем первый букву имени и точку
            }

            // Если получаем отчество
            if (middleName != null && !middleName.isEmpty()) {
                if (!fullName.isEmpty() && fullName.charAt(fullName.length() - 1) != '.') { // Если объект не пустой (добавлена фамилия и не добавлено имя)
                    fullName.append(" "); // Ставим пробел
                }
                fullName.append(middleName.charAt(0)).append("."); // Добавляем первую букву отчества и точку
            }

            return fullName.toString();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите фамилию: ");
        String lastName = sc.nextLine();
        System.out.println("Введите имя: ");
        String firstName = sc.nextLine();
        System.out.println("Введите отчество: ");
        String middleName = sc.nextLine();
        Person person = new Person(lastName, firstName, middleName);
        System.out.println(person.getFullName());
    }
}
