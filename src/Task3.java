import java.util.StringTokenizer;

public class Task3 {

    public static class Address {
        // Поля данных
        private String country;
        private String region;
        private String city;
        private String street;
        private String house;
        private String building;
        private String apartment;

        // Метод передающий в поля данных значения, разделенные запятыми
        public void parseAddressWithComma(String address) {
            String[] parts = address.split(","); // через метод split делим значения и передаем их в массив
            if (parts.length != 7) { // если значений меньше 7, выдаём ошибку
                throw new IllegalArgumentException("Адрес введён некорректно");
            }
            // Передаём элементы массива в соответствующие поля. Метод trim() удаляет лишние пробелы (в начале и конце строки)
            this.country = parts[0].trim();
            this.region = parts[1].trim();
            this.city = parts[2].trim();
            this.street = parts[3].trim();
            this.house = parts[4].trim();
            this.building = parts[5].trim();
            this.apartment = parts[6].trim();
        }

        // Метод передающий в поля данных значения с разными разделителями
        public void parseAddressWithDiffSep(String address) {
            // Создаём экземпляр класса StringTokenizer и передаём разделители
            StringTokenizer tokenizer = new StringTokenizer(address, ",.;");
            if (tokenizer.countTokens() != 7) { // если значений меньше 7, выдаём ошибку
                throw new IllegalArgumentException("Адрес введён некорректно");
            }
            // Передаём полученные подстроки в соответствующие поля
            this.country = tokenizer.nextToken().trim();
            this.region = tokenizer.nextToken().trim();
            this.city = tokenizer.nextToken().trim();
            this.street = tokenizer.nextToken().trim();
            this.house = tokenizer.nextToken().trim();
            this.building = tokenizer.nextToken().trim();
            this.apartment = tokenizer.nextToken().trim();
        }

        @Override
        public String toString() {
            return "Address{" +
                    "country='" + country + '\'' +
                    ", region='" + region + '\'' +
                    ", city='" + city + '\'' +
                    ", street='" + street + '\'' +
                    ", house='" + house + '\'' +
                    ", building='" + building + '\'' +
                    ", apartment='" + apartment + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        // Создаём массив из 4 адресов (1 - через запятую, 2 - через точку, 3 - через точку с запятой, 4 - отсутствует номер квартиры)
        String[] addresses = {
                "Россия, Московская область, Москва, Тверская улица, 7, 1, 45",
                "США. Калифорния. Лос-Анджелес. Голливудский бульвар. 10. 2. 5",
                "Канада; Онтарио; Торонто; Бей-стрит; 50; 1; 10",
                "Германия, Бавария, Мюнхен, Карлплатц, 5, 3"
        };

        // Проходимся по всем адресам
        for (String address : addresses) {
            Address addr = new Address(); // создаём экземпляры класса Address
            try {
                addr.parseAddressWithComma(address);
                System.out.println("Адрес, переданный через запятые: " + addr);
            } catch (IllegalArgumentException e) { // если в методе ошибка - выдаём эту ошибку
                System.out.println("\nНе удалось разделить: " + e.getMessage());
            }

            try {
                addr.parseAddressWithDiffSep(address);
                System.out.println("Адрес, переданный через разные разделители: " + addr);
            } catch (IllegalArgumentException e) { // если в методе ошибка - выдаём эту ошибку
                System.out.println("\nНе удалось разделить: " + e.getMessage());
            }
        }

    }

}
