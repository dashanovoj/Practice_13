public class Task4 {

    public static class Shirt {
        // Поля данных
        private String ID;
        private String name;
        private String colour;
        private String size;

        // Конструктор
        public Shirt(String ID, String name, String colour, String size) {
            this.ID = ID;
            this.name = name;
            this.colour = colour;
            this.size = size;
        }

        @Override
        public String toString() {
            return "ID: " + ID + '\n' +
                    "Name: " + name + '\n' +
                    "Colour: " + colour + '\n' +
                    "Size: " + size + "\n";
        }
    }

    public static void main(String[] args) {
        // Передаем строковый массив
        String[] shirts = {"S001,Black Polo Shirt,Black,XL",
                "S002,Black Polo Shirt,Black,L",
                "S003,Blue Polo Shirt,Blue,XL",
                "S004,Blue Polo Shirt,Blue,M",
                "S005,Tan Polo Shirt,Tan,XL",
                "S006,Black T-Shirt,Black,XL",
                "S007,White T-Shirt,White,XL",
                "S008,White T-Shirt,White,L",
                "S009,Green T-Shirt,Green,S",
                "S010,Orange T-Shirt,Orange,S",
                "S011,Maroon Polo Shirt,Maroon,S"
        };

        // Создаём пустой массив объектов класса Shirt длинной строкового массива shirts
        Shirt[] shirtsObjects = new Shirt[shirts.length];

        for (int i = 0; i < shirts.length; i++) {
            String[] shirtDetails = shirts[i].split(","); // создаём промежуточный массив подстрок (в изначальном массиве делим строки по запятым)
            shirtsObjects[i] = new Shirt(shirtDetails[0], shirtDetails[1], shirtDetails[2], shirtDetails[3]); // создаем экземпляр класса Shirt, передаём элемент в массив
        }

        // Выводим полученный массив класса Shirt
        for (Shirt shirt: shirtsObjects) {
            System.out.println(shirt.toString());
        }
    }
}
