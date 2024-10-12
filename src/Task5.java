public class Task5 {

    public static class PhoneNumber {
        // Отформатированный номер телефона
        private String formattedNumber;

        // Конструктор
        public PhoneNumber(String inputNumber) {
            this.formattedNumber = formatNumber(inputNumber); // применяем метод
        }

        // Метод форматирования номера телефона
        private String formatNumber(String inputNumber) {
            String countryCode = ""; // код страны
            String mainNumber = ""; // основной номер

            // 1. +<Код страны><Номер 10 цифр>
            if (inputNumber.startsWith("+")) {
                countryCode = inputNumber.substring(0, inputNumber.length() - 10); // + и первая цифра
                mainNumber = inputNumber.substring(inputNumber.length() - 10); // остальные цифры
            }
            // 2. 8<Номер 10 цифр> для России
            else if (inputNumber.startsWith("8") && inputNumber.length() == 11) {
                countryCode = "+7"; // код страны
                mainNumber = inputNumber.substring(1); // остальные цифры
            } else {
                throw new IllegalArgumentException("Неверный формат номера"); // выдаёт ошибку при некорректном вводе номера
            }

            // Возвращаем отформатированный номер телефона
            return String.format("%s%s-%s-%s", countryCode,
                    mainNumber.substring(0, 3),
                    mainNumber.substring(3, 6),
                    mainNumber.substring(6, 10));

        }

        @Override
        public String toString() {
            return formattedNumber;
        }
    }

    public static void main(String[] args) {
        String[] phoneNumbers = {
                "+79175655655",
                "+104289652211",
                "89175655655"
        };

        // Проходимся по всем номерам
        for (String number: phoneNumbers) {
            try {
                PhoneNumber phoneNumber = new PhoneNumber(number); // создаём экземпляр класса PhoneNumber
                System.out.println(phoneNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // при возникновении ошибки выдаем ошибку метода
            }
        }
    }
}
